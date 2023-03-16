package fpt.m2.FPT_DucNN19;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "User API", version = "1.0"))
public class FptDucNn19Application {

	public static void main(String[] args) {
		SpringApplication.run(FptDucNn19Application.class, args);
	}

}
