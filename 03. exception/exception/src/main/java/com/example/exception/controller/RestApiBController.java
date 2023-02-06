package com.example.exception.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/b")
public class RestApiBController {

    // localhost:8080/api/b/hello
    @GetMapping("/hello")
    public void hello(){
        throw new NumberFormatException("number format exception");
    }


/*    @ExceptionHandler(value = { NumberFormatException.class })
    public ResponseEntity numberFormatException(
        NumberFormatException e
    ){
        log.error("RestApiBController", e);

        return ResponseEntity.ok().build();
    }*/

}
