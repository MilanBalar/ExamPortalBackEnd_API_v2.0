package com.boot.server.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamPortalServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalServerApplication.class, args);
		System.out.println("<<<  -----------  Exam Portal Server Started -------------  >>>");
	}

}
