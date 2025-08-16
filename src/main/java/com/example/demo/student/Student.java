package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_secuence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Student_sequence"
    )

    private Long id;
    private String name;
    private String emails;
    private LocalDate dob;
    @Transient // Lo saco de la columna de la base de datos
    private Integer age;


    public Student() {
    }

    public Student(Long id, String nome, String emails, LocalDate dob) {
        this.id = id;
        this.name = nome;
        this.emails = emails;
        this.dob = dob;
    }

    public Student(String nome, String emails, LocalDate dob) {
        this.name = nome;
        this.emails = emails;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmails() {
        return emails;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Integer getAge() {

        return Period.between(this.dob, LocalDate.now()).getYears(); //funcion para obtener los años
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nome='" + name + '\'' +
                ", emails='" + emails + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
