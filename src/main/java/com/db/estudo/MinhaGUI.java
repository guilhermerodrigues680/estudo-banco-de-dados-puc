package com.db.estudo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@Component
public class MinhaGUI extends JFrame {
    private static final Logger log = LoggerFactory.getLogger(EstudoApplication.class);

    private JPanel meuJPanel;
    private JTextField xTextFild;
    private JTextField x2TextFild;
    private JButton calcButton;

    RepositorioSQLite repositorioSQLite;

    public MinhaGUI(@Qualifier("1") RepositorioSQLite repositorioSQLite/*String title*/) {
        repositorioSQLite.msg();
        log.info("MinhaGUI");
        //super(title);
        //super("Padrao");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(meuJPanel);
        this.pack();

        // Clique no botao calcular
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão clicado");
                log.info("Botão clicado");
                final int x = Integer.parseInt(xTextFild.getText());
                final int x2 = x * x;
                x2TextFild.setText(Integer.toString(x2));
            }
        });

        // Tecla presionada no xTextFild
        xTextFild.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                if(!Util.charIsNumber(e.getKeyChar())) {
                    System.out.println("O character " + e.getKeyChar() + " não é um número.");
                    e.consume();
                    return;
                }

                System.out.println("Character válido: " + e.getKeyChar());
            }
        });
    }

}
