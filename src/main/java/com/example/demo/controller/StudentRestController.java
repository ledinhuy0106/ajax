package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentRestController {
    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("")
    public ResponseEntity<Iterable<Student>> findAll() {
        Iterable<Student> students = studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.findById(id);
        if (!student.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }

    @GetMapping("/orderByAgeDesc")
    public ResponseEntity<Iterable<Student>> findStudentSortByAge(String name) {
        Iterable<Student> students;
        if (name == null) {
            students = studentService.findAllByAgeDESC();
        } else {
            students = studentService.findByNameContaining(name);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Student>> findByName(@PathVariable String key) {
        List<Student> students;
        students = studentService.findByNameContaining(key);
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> student1 = studentService.findById(id);
        student.setId(student1.get().getId());
        studentService.save(student);
        return new ResponseEntity<>(student1.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> delete(@PathVariable Long id) {
        Optional<Student> student = studentService.findById(id);
        if (!student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.NOT_FOUND);
        }
        studentService.remove(id);
        return new ResponseEntity<>(student.get(), HttpStatus.NO_CONTENT);
    }
}