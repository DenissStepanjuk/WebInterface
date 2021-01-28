package com.visioneWEB.WebInterface;

import com.visioneWEB.WebInterface.controllers.MainController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

@SpringBootApplication
@ComponentScan({"com.visioneWEB.WebInterface", "com.visioneWEB.WebInterface.controllers"})
public class WebInterfaceApplication {

	public static void main(String[] args) {

		new File(MainController.uploadDirectory).mkdir();
		SpringApplication.run(WebInterfaceApplication.class, args);

	}

}
