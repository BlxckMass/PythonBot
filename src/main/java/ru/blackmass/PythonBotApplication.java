package ru.blackmass;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import ru.blackmass.starter.Starter;

@SpringBootApplication
@Import(BotConfig.class)
public class PythonBotApplication {

	public static void main(String[] args) throws ClientException, ApiException {
		SpringApplication.run(PythonBotApplication.class, args);

		ApplicationContext context = new AnnotationConfigApplicationContext(PythonBotApplication.class);

		Starter starter = context.getBean(Starter.class);
		try {
			starter.start();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
