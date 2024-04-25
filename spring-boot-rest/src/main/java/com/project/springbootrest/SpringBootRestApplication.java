package com.project.springbootrest;

import com.project.springbootrest.ropo.JobRepo;
import com.project.springbootrest.service.JobService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootRestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootRestApplication.class, args);

		JobService js = context.getBean(JobService.class);
		JobRepo repo = context.getBean(JobRepo.class);

	}

}
