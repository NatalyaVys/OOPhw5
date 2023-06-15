package OOPhw5.controllers;

import OOPhw5.model.Student;
import OOPhw5.model.Teacher;
import OOPhw5.model.User;
import OOPhw5.repository.StudentsRepository;
import OOPhw5.repository.TeacherRepository;
import OOPhw5.service.StudyGroupService;

import java.util.ArrayList;
import java.util.List;

public class StudGroupController {

    private final StudGroupService groupService;

    public StudGroupController(StudGroupService groupService) {
        this.groupService = groupService;
    }

    public void addUsers(StudentsRepository students, TeacherRepository teachers) {
        groupService.addUsers(students, teachers);
    }

    public List<User> getAll() {
        return groupService.getAll();
    }

    public List<User> getStudent() {
        List<User> students = new ArrayList<>();
        for (User user : groupService.getAll()) {
            if (user.getClass().equals(Student.class)) {
                students.add(user);
            }

        }
        return students;

    }

    public List<User> getTeacher() {
        List<User> teachers = new ArrayList<>();
        for (User user : groupService.getAll()) {
            if (user.getClass().equals(Teacher.class)) {
                teachers.add(user);
            }

        }
        return teachers;
    }
}