package com.springboot.studentmanagement.controller;

import com.springboot.studentmanagement.dto.StudentDto;
import com.springboot.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("all")
    public String listStudents(Model model){
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("new")
    public String createStudent(Model model){
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "create_student";
    }

    @PostMapping("new")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto studentDto,
                                BindingResult result,
                              Model model){
        if (result.hasErrors()){
            model.addAttribute("student", studentDto);
            return "create_student";
        }

        studentService.createStudent(studentDto);
        return "redirect:/student/all";
    }
}
