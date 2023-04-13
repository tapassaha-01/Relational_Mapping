package com.example.SpringBatch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBatch.Model.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {

}
