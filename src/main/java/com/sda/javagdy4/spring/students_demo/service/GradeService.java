package com.sda.javagdy4.spring.students_demo.service;

import com.sda.javagdy4.spring.students_demo.repository.GradeRepository;
import com.sda.javagdy4.spring.students_demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;



}
