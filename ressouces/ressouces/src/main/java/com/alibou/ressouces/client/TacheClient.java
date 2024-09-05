package com.alibou.ressouces.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "tache", url = "http://localhost:8070")
public interface TacheClient {
    @GetMapping("/taches/idTache")
    Object getTacheById(@RequestParam("idTache") Long idTache) ;
}
