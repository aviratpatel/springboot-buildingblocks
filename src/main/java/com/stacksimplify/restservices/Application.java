/* 
 * Use one or more controller class along with GetMapping annotations
 * For testing JSON output, install JSON View plugin to Google Chrome browser
 * URLs are:
 * http://localhost:8897/	
 * http://localhost:8897/helloworld-bean
 * 	http://localhost:8897/helloworld
 * 
*/
package com.stacksimplify.restservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
