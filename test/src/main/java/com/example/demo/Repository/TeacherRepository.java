package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
