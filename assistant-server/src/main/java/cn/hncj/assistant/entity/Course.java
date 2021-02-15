package cn.hncj.assistant.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Integer course_id;
    private String teacher_id;
    private String course_name;
    private String course_cover;
    private Date course_date;
    private Integer course_status;
}
