package com.example.project.project_e;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.project.project_e.model.Member;
import com.example.project.project_e.repository.MemberRepo;

@SpringBootApplication
public class ProjectEApplication implements CommandLineRunner{

	private final MemberRepo memberRepo;

	
	public ProjectEApplication(MemberRepo memberRepo) {
		this.memberRepo = memberRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjectEApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		memberRepo.save(new Member("Surachart", "titlemy36@gmail.com", "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue", "testAddress", "9"));
	}
	


}
