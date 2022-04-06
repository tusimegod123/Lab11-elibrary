package com.eLibrary.eLibrary.repository;

import com.eLibrary.eLibrary.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
