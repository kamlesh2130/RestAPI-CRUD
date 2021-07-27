package com.kamleshSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kamleshSpringBoot.repository.LibraryRepository;
import com.kamleshSpringBoot.service.LibraryService;

@RestController
public class LibraryController {

	@Autowired
	LibraryRepository libRepo;
	@Autowired
	AddLibraryResponse response;
	@Autowired
	LibraryService service;
	
	@PostMapping("/addBook")
	public ResponseEntity<AddLibraryResponse> addBookImolementation(@RequestBody Library library) {
		// TODO Auto-generated method stub
		
		String id = service.buildLibraryID(library.getIsbn(), library.getAisle());
		boolean isBookAlreadyExist = service.checkBookExist(id);
		
		if (! isBookAlreadyExist) {

			library.setId(id);
			libRepo.save(library);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("UniqueID", id);
			response.setId(id);
			response.setMsg("Book successfully created !");
			
			return new ResponseEntity<AddLibraryResponse>(response,headers, HttpStatus.CREATED);
		} else {
			response.setId(id);
			response.setMsg("Oops! Book Already Exist");
			return new ResponseEntity<AddLibraryResponse>(response, HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/getBook/{id}")
	public Library getBookById(@PathVariable(value="id")String id) {
		
		try {
			Library lib = libRepo.findById(id).get();
			return lib;
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("getBooks/author")
	public List<Library> getAuthors(@RequestParam(name="authorName") String author) {
		List<Library> listofAuthors = libRepo.findAllByAuthor(author);
		if (listofAuthors.size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		} else {
			return listofAuthors;
		}
	}
}
