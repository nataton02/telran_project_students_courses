package de.telran.telran_project_students_courses.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentCourseResponseDTO {

    private Long studentId;
    private Long courseId;
}
