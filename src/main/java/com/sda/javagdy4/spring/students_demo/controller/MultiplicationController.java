package com.sda.javagdy4.spring.students_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

// RestController - jeśli wynikiem jest treść (json) (rest api)
// Controller - jeśli wynikiem jest widok (html, jsp,...)
@Controller // jest różnica między controller vs rest controller
@RequestMapping(path = "/")
public class MultiplicationController {
    // 1. request parameters
    // 2. attributes
    // 3. mappings

    // localhost:8080/
    // localhost:8080/?imie=baca -> Welcome baca!
//    @RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String indexPage(Model model, @RequestParam(name = "imie", required = false) String imie){
        model.addAttribute("moje_imie", imie);

        return "index";
    }
    
    
}
