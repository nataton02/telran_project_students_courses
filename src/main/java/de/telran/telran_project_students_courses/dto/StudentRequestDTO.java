package de.telran.telran_project_students_courses.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentRequestDTO {

    private String name;
    private List<CourseRequestDTO> courses;
}
