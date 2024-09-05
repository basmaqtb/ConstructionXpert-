package com.alibou.ressouces;

public class RessourceNotFoundException extends RuntimeException{

    public RessourceNotFoundException(){
        super("ressource not found");
    }
}
