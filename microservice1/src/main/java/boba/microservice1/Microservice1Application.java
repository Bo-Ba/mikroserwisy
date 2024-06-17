package boba.microservice1;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.client.RestTemplate;
@SpringBootApplication
public class Microservice1Application {

	public static void main(String[] args)  {
		SpringApplication app = new SpringApplication(Microservice1Application.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}



}
