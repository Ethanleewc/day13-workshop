package com.example.day13workshop;

import java.util.List;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.day13workshop.util.IOUtil.*;

@SpringBootApplication
public class Day13WorkshopApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Day13WorkshopApplication.class);
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
		List<String> opsVal = appArgs.getOptionValues("dataDir");
		System.out.println("opsVal" + opsVal);
		if(null != opsVal){
			createDir((String)opsVal.get(0));
		} else {
			System.exit(1);
		}
		
		app.run(args);
	}

}
