package com.ela.student_api.mapper;
import com.ela.student_api.dto.StudentDTO;
import com.ela.student_api.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO toDTO(Student student);
    Student toEntity(StudentDTO studentDTO);
}
