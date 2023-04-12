package com.josamtechie.lookupInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class LookupInjectionApplication {

	@Autowired
	private UserService userService;

	@GetMapping("/scope")
	public List<String> getWheatherForcast() throws InterruptedException {
		String response1 = userService.getCurrentTempFromWeatherAPI();
		Thread.sleep(1000);
		String response2 = userService.getCurrentTempFromWeatherAPI();
		return Arrays.asList(response1, response2);
	}


	public static void main(String[] args) {
		SpringApplication.run(LookupInjectionApplication.class, args);
		System.out.println("Successful..........");

	}

}
