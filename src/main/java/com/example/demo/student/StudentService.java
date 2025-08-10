package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmails(student.getEmails());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("Ya existe el email");
        }
        studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudentByID(long id) {
        Optional<Student> studentById = studentRepository.findById(id);

        if (studentById.isPresent()) {
            studentRepository.delete(studentById.get()); // pasamos el Student, no el Optional
        } else {
            throw new IllegalStateException("Student with id " + id + " does not exist");
        }
    }

}
