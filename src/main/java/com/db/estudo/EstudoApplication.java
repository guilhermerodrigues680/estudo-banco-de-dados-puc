package com.db.estudo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class EstudoApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(EstudoApplication.class);

//	@Autowired
//	MyBean myBean;
//
	@Autowired
	MinhaGUI minhaGUI;

	public static void main(String[] args) {
		log.info("main1");
//		SpringApplication.run(EstudoApplication.class, args);
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(EstudoApplication.class)
				.headless(false).run(args);
		log.info("main2");
		EventQueue.invokeLater(() -> {
			log.info("invokeLater");
			MinhaGUI bean = ctx.getBean(MinhaGUI.class);
			bean.setVisible(true);
		});
//		JFrame frame = new MinhaGUI("Calculadora X2");
//		frame.setVisible(true);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("");
//		EventQueue.invokeLater(() -> {
//			log.info("invokeLater");
//			minhaGUI.setVisible(true);
//		});
//		minhaGUI.setVisible(true);
//		JFrame frame = new MinhaGUI("Calculadora X2");
//		frame.setVisible(true);
	}
}
