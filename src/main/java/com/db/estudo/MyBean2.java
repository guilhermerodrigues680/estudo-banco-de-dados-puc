package com.db.estudo;

import org.springframework.stereotype.Component;

@Component("2")
public class MyBean2 implements RepositorioSQLite{

    public void msg() {
        System.out.println("ola");
    }

}
