package OOPhw5.service;

import OOPhw5.model.Student;
import OOPhw5.model.StudyGroup;
import OOPhw5.model.Teacher;
import OOPhw5.model.User;
import OOPhw5.repository.StudentsRepository;
import OOPhw5.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

public class StudGroupService {

    private StudentsRepository students;
    private TeacherRepository teachers;
    private StudGroup group;

    List<User> StudList;


    public StudGroupService(StudGroup group, StudentsRepository students, TeacherRepository teachers) {
        this.students = students;
        this.teachers = teachers;
        this.group = group;
        StudList = new ArrayList<>();
    }

    public void addUsers(StudentsRepository students, TeacherRepository teachers){
        for (Student student : students.getAll()) {
            if (student.getGroupId().equals(group.getGroupId())){
                StudList.add(student);
            }

        }
        for (Teacher teacher: teachers.getAll()) {
            if (teacher.getGroupId().equals(group.getGroupId())){
                StudList.add(teacher);
                break;
            }
        }
    }

    public List<User> getAll(){
        return StudList;
    }
}