package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;

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
    private Integer age;


    public Student() {
    }

    public Student(Long id, String nome, String emails, LocalDate dob, Integer age) {
        this.id = id;
        this.name = nome;
        this.emails = emails;
        this.dob = dob;
        this.age = age;
    }

    public Student(String nome, String emails, LocalDate dob, Integer age) {
        this.name = nome;
        this.emails = emails;
        this.dob = dob;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return name;
    }

    public String getEmails() {
        return emails;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Integer getAge() {
        return age;
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
