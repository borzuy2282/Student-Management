package com.springboot.studentmanagement.mapper;

import com.springboot.studentmanagement.dto.StudentDto;
import com.springboot.studentmanagement.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toDto(Student student);
    Student toEntity(StudentDto studentDto);
}
