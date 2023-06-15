package OOPhw5.view;

import OOPhw5.controllers.StudyGroupController;
import OOPhw5.model.Student;
import OOPhw5.model.User;
import OOPhw5.repository.StudentsRepository;
import OOPhw5.repository.TeacherRepository;

import java.util.List;

public class StudentGroupView {

    private final StudGroupController groupController;

    public StudentGroupView(StudGroupController groupController) {
        this.groupController = groupController;

    }
    public void sendOnConsole(String sortType) {
        List<User> groupList = switch (sortType) {
            case SortType.NONE -> groupController.getAll();
            case SortType.STUDENT -> groupController.getStudent();
            case SortType.TEASHER -> groupController.getTeacher();
            default -> null;
        };
        if (groupList == null)  {
            System.out.println("group is null");
            return;
        }
        System.out.println("++++++++++++++++++");
        for (User user : groupList) {
            System.out.println(user);
        }
        System.out.println("++++++++++++++++++");
    }
    public void addUsers(StudentsRepository students, TeacherRepository teachers){
        groupController.addUsers(students, teachers);
    }
}