package com.db.estudo;

import org.springframework.stereotype.Component;

@Component("1")
public class MyBean implements RepositorioSQLite{

    public void msg() {
        System.out.println("ola");
    }

}
