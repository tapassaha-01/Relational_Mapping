package com.techprimers.springbatchexample1.batch;

import com.techprimers.springbatchexample1.model.EmployeeEntity;
import com.techprimers.springbatchexample1.repository.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<EmployeeEntity> {

    private UserRepository userRepository;

    @Autowired
    public DBWriter (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void write(List<? extends EmployeeEntity> EmployeeEntity) throws Exception{
        System.out.println("Data Saved for Users: " + EmployeeEntity);
        userRepository.saveAll(EmployeeEntity);
    }
}
