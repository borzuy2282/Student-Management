package com.springboot.studentmanagement.service;

import com.springboot.studentmanagement.dto.StudentDto;
import com.springboot.studentmanagement.entity.Student;
import com.springboot.studentmanagement.mapper.StudentMapper;
import com.springboot.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentDto> getAllStudents(){
        return studentRepository
                .findAll()
                .stream()
                .map(studentMapper::toDto)
                .toList();
    }

    public void createStudent(StudentDto studentDto){
        Student student = studentMapper.toEntity(studentDto);
        studentRepository.save(student);
    }

    public StudentDto getStudentById(Long id){
        Student student = studentRepository.findById(id).get();
        return studentMapper.toDto(student);
    }

    public void updateStudent(StudentDto studentDto){
        studentRepository.save(studentMapper.toEntity(studentDto));

    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
