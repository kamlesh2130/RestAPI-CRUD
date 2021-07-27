package com.kamleshSpringBoot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kamleshSpringBoot.controller.Library;
import com.kamleshSpringBoot.repository.LibraryRepository;

@SpringBootApplication
public class SpringBootDemoApplication{

	@Autowired
	LibraryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		Library lib = repository.findById("fdsefr343").get();
//		System.out.println(lib.getAuthor());
//		
//		Library entity = new Library();
//		entity.setAisle(25);
//		entity.setAuthor("kamlesh");
//		entity.setBook_name("devops");
//		entity.setId("lkm125");
//		entity.setIsbn("lkm1");
//		repository.save(entity);
		
		
//		repository.delete(entity);
//		List<Library> list =  repository.findAll();
//	}

}
