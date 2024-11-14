package com.springBoot.controller;

import com.springBoot.entity.Emp;
import com.springBoot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
     public List<Emp> getAll(){
         return empService.getAlls();
     }
     @GetMapping("/{id}")
     public ResponseEntity<Emp> getEmpById(@PathVariable Long id){
        return empService.getEmpById(id).map(emp -> ResponseEntity.ok().body(emp)).orElse(ResponseEntity.notFound().build());
     }
     @PostMapping
    public Emp addEmp(@RequestBody Emp emp){
        return empService.addEmp(emp);
     }
     @PutMapping("/{id}")
    public ResponseEntity<Emp> updateEmp(@PathVariable Long id, @RequestBody Emp empDetails){
      Emp updateEmp = empService.updateEmp(id, empDetails);
      return ResponseEntity.ok(updateEmp);
     }
     @DeleteMapping
    public ResponseEntity<Void> deleteEmp(@PathVariable Long id){
        empService.deleteEmp(id);
        return ResponseEntity.noContent().build();
     }
}
