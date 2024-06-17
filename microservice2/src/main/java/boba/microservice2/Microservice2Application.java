package boba.microservice2;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Microservice2Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Microservice2Application.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

}
