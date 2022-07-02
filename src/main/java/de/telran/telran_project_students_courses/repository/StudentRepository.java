package de.telran.telran_project_students_courses.repository;

import de.telran.telran_project_students_courses.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
