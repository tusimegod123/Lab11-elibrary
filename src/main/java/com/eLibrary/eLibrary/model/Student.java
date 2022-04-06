package com.eLibrary.eLibrary.model;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
//@NotNull(message = "First Name can not be null")
    @NotNull(message ="First Name can not be null" )
    private String firstName;
    private String middleName;
    private String lastName;
    private String studentNumber;
    private  double gpa;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
    private  String isInternational;


//    studentId : (should be the primary key field)
//
//    studentNumber: e.g. 000-61-0001 (required)
//
//    FirstName: e.g. Anna (required)
//
//    MiddleName: (optional)
//
//    LastName: e.g. Smith (required)
//
//    cgpa: e.g. 3.78 (optional)
//
//    enrollmentDate: e.g. 2019-5-12 (required)
//
//    isInternational: (values: "Yes", "No") (required) - Hint: Implement/present this data in a drop-down list or Radio button

}
