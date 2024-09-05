package com.alibou.projet;

public class ProjetNotFoundException extends RuntimeException{

    public ProjetNotFoundException() {
        super("projet not found !");
    }
}
