package ru.blackmass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.blackmass.web.configs.BotConfig;
import ru.blackmass.bot.starter.Starter;

@SpringBootApplication
@Import(BotConfig.class)
public class PythonBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(PythonBotApplication.class, args);

		ApplicationContext context = new AnnotationConfigApplicationContext(PythonBotApplication.class);

		Starter starter = context.getBean(Starter.class);
		starter.start();

	}
}
