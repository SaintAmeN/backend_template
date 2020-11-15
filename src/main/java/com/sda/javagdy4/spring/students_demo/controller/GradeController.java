package com.sda.javagdy4.spring.students_demo.controller;

import com.sda.javagdy4.spring.students_demo.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/grade")
@RequiredArgsConstructor
public class GradeController {
    private final GradeService gradeService;


}
