package com.kamleshSpringBoot.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kamleshSpringBoot.controller.Library;

public class LibraryRepositoryImpl implements LibraryRepositoryCustom{

	@Autowired
	LibraryRepository libRepo;
	

	@Override
	public List<Library> findAllByAuthor(String author) {
		// TODO Auto-generated method stub
		List<Library> libraryList = libRepo.findAll();
		List<Library> libraryAuthorList = new ArrayList<Library>();

		for (Library library : libraryList) {
			if (library.getAuthor() != null && library.getAuthor().equalsIgnoreCase(author)) {
				libraryAuthorList.add(library);
			}
		}
		return libraryAuthorList;
	}

}
