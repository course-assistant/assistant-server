package cn.hncj.assistant.dto;

import cn.hncj.assistant.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO implements Serializable {
    Integer total;
    List<Student> students;
}