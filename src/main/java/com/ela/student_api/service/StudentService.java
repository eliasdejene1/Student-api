package com.ela.student_api.service;

import com.ela.student_api.dto.StudentDTO;
import com.ela.student_api.mapper.StudentMapper;
import com.ela.student_api.model.Student;
import com.ela.student_api.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class StudentService {
    private StudentMapper studentMapper;
    private StudentRepository studentRepository;

    public List<StudentDTO> getAllStudents(){
        return studentRepository.findAll().stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }
    public StudentDTO getStudentById(Long id){
        return studentMapper.toDTO(studentRepository.getOne(id));
    }
}
