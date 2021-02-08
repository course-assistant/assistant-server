package cn.hncj.assistant.service;

public interface TeacherService {
    int insertTeacher(
            String id,
            String administrator_id,
            String name,
            Integer sex,
            String phone,
            String email
    );
}
