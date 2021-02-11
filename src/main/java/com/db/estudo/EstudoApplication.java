package com.db.estudo;

import com.db.estudo.form.MinhaGUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.awt.EventQueue;

@SpringBootApplication
public class EstudoApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(EstudoApplication.class);

	@Autowired
	MinhaGUI minhaGUI;

	public static void main(String[] args) {
		new SpringApplicationBuilder(EstudoApplication.class)
				.headless(false)
				.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		EventQueue.invokeLater(() -> {
			log.info("EventQueue.invokeLater");
			minhaGUI.setVisible(true);
		});
	}
}
