package com.kamleshSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kamleshSpringBoot.controller.Library;

public interface LibraryRepository extends JpaRepository<Library, String>, LibraryRepositoryCustom{

}
