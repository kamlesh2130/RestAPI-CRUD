package com.kamleshSpringBoot.repository;

import java.util.List;

import com.kamleshSpringBoot.controller.Library;

public interface LibraryRepositoryCustom {
	
	public List<Library> findAllByAuthor(String author);
}
