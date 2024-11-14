package com.springBoot.service;

import com.springBoot.entity.Emp;
import com.springBoot.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmpRepository empRepository;
     public List<Emp> getAlls(){
         return empRepository.findAll();
     }
     public Optional<Emp> getEmpById(Long id){
         return empRepository.findById(id);
     }
     public Emp addEmp(Emp emp){
         return empRepository.save(emp);

     }
     public Emp updateEmp(Long id, Emp empdetails){
         Emp emp = empRepository.findById(id).orElseThrow(()->
                 new RuntimeException("Emp not found"));
              emp.setName(empdetails.getName());
              emp.setEmail(empdetails.getEmail());
              emp.setSalary(empdetails.getSalary());
              return empRepository.save(emp);
     }
     public void deleteEmp(Long id){
         empRepository.deleteById(id);
     }
}
