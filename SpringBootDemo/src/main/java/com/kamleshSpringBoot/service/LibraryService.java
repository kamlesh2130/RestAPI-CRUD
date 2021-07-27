package com.kamleshSpringBoot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamleshSpringBoot.controller.Library;
import com.kamleshSpringBoot.repository.LibraryRepository;

@Service
public class LibraryService {
	
	@Autowired
	LibraryRepository libraryRepo;
	
	public String buildLibraryID(String isbn, int asile) {
		// TODO Auto-generated method stub
		String id = isbn + asile;
		return id;
	}
	
	public boolean checkBookExist(String bookId) {
		
		Optional<Library> lib = libraryRepo.findById(bookId);
		if (lib.isPresent()) {
			return true;
		} else {
			return false;
		}
	}
}
