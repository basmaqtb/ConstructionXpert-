package com.alibou.tache;

public class TacheNotFoundException extends RuntimeException {

    public TacheNotFoundException() {
        super("tache not found !");
    }
}
