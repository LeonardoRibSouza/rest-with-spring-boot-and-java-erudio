package br.com.erudio.Controller;


import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;


@RestController
public class Teste {
    private Logger logger = LoggerFactory.getLogger(Teste.class.getName());
    @GetMapping("/test")
    public String teste(){
        logger.debug("this is an info DEBUG log");
        logger.info("this is an info INFO log");
        logger.warn("this is an info WARN log");
        logger.error("this is an ERRO  log");
        return "log gerado";
    }

}
