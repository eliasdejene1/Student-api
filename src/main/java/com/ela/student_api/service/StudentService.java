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

    private final StudentRepository repository;
    private final StudentMapper mapper;

    public List<StudentDTO> getAllStudents() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentById(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return mapper.toDTO(student);
    }

    public StudentDTO createStudent(StudentDTO dto) {
        Student student = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(student));
    }

    public StudentDTO updateStudent(Long id, StudentDTO dto) {
        Student existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setEmail(dto.getEmail());
        existing.setDepartment(dto.getDepartment());
        return mapper.toDTO(repository.save(existing));
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
