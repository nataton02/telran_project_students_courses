package de.telran.telran_project_students_courses.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CourseResponseDTO {

    private String courseName;
    private Long studentsCount;
}
