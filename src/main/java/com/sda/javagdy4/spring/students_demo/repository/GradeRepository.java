package com.sda.javagdy4.spring.students_demo.repository;

import com.sda.javagdy4.spring.students_demo.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
}
