package OOPhw5.view;

import OOPhw5.controllers.TeacherController;
import OOPhw5.controllers.UserController;
import OOPhw5.model.Student;
import OOPhw5.model.Teacher;
import lombok.Data;

import java.util.List;
@Data
public class TeacherView implements UserView<Teacher> {
    TeacherController controller;

    public TeacherView(TeacherController controller) {
        this.controller = controller;
    }

    @Override
    public void sendOnConsole(String sortType) {
        List<Teacher> teachers = switch (sortType) {
            case sortType.NONE -> controller.getAll();
            case sortType.NAME -> controller.getAllSortUsers();
            case sortType.FAMILY -> controller.getAllSortUsersByFamilyName();
            case sortType.AGE -> controller.getAllSortUsersByAge ();
            default -> null;
        };
        if (teachers == null)  {
            System.out.println("teachers is null");
            return;
        }
        System.out.println("++++++++++++++++++");
        for (Teacher teacher: teachers) {
            System.out.println(teacher);
        }
        System.out.println("++++++++++++++++++");
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber) {
        controller.create(fullName, age, phoneNumber);
    }

    @Override
    public void removeUser(String fullName) {
        controller.removeUser(fullName);
    }

    public boolean editTeacher(Long id){
        controller.editTeacher(id);
        return true;
    }
}