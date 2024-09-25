package com.qa.PersonProject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


// @Entity creates a table
    @Entity
    @Data //Generates getters, setters, toString, equals. and hashCode methods
    @NoArgsConstructor //Generates default constructor
    @AllArgsConstructor //Generates constructor with all fields as parameters
    public class Person {

    //        Sets Id as primary key and generates auto-inc values
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Min(18)
        @Max(75)
        private int age;

        @Size(min = 2, max = 30)
        @NotNull
        private String firstname;

        @Size(min = 2, max = 30)
        private String lastname;


        @Min(18)
        @Max(75)
        public int getAge() {
            return age;
        }

//        public void setAge(@Min(18) @Max(75) int age) {
//            this.age = age;
//        }
//
//        public @Size(min = 2, max = 30) @NotNull String getFirstname() {
//            return firstname;
//        }
//
//        public void setFirstname(@Size(min = 2, max = 30) @NotNull String firstname) {
//            this.firstname = firstname;
//        }
//
//        public @Size(min = 2, max = 30) String getLastname() {
//            return lastname;
//        }

//        public void setLastname(@Size(min = 2, max = 30) String lastname) {
//            this.lastname = lastname;
//        }






//        Create getters and setters - need public access to private field
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }
    }


