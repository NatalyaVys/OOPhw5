package OOPhw5;

import OOPhw5.controllers.StudentController;
import OOPhw5.controllers.StudGroupController;
import OOPhw5.controllers.TeacherController;
import OOPhw5.model.Student;
import OOPhw5.model.StudGroup;
import OOPhw5.model.Teacher;
import OOPhw5.repository.StudentsRepository;
import OOPhw5.repository.TeacherRepository;
import OOPhw5.service.StudentService;
import OOPhw5.service.StudGroupService;
import OOPhw5.service.TeacherServise;
import OOPhw5.view.SortType;
import OOPhw5.view.StudentGroupView;
import OOPhw5.view.StudentView;
import OOPhw5.view.TeacherView;

public class main {
    public static void main (String[] args) {

        TeacherRepository repository = new TeacherRepository();
        TeacherServise service = new TeacherServise(repository);
        TeacherController controller = new TeacherController(service);
        TeacherView view = new TeacherView(controller);


        view.create("Anton Egorov", 55, "02", "5");
        view.create("Elena Prekrasnay", 45, "03", "5");
        view.create("Oleg Orlov", 20, "112", "2");
        view.sendOnConsole(SortType.NONE);

        StudentsRepository studentsRepository = new StudentsRepository();
        StudentService studentService = new StudentService(studentsRepository);
        StudentController studentController = new StudentController(studentService);
        StudentView studentView = new StudentView(studentController);


        studentView.create("Ivan Morozov", 18, "02", "2");
        studentView.create("Petr Vorobev", 19, "03", "5");
        studentView.create("Sidor Sidorov", 20, "112","5");
        studentView.sendOnConsole(SortType.NONE);

        StudGroup group = new StudGroup("5");
        StudGroupService groupService = new StudGroupService(group, studentsRepository, repository);
        StudGroupController groupController = new StudGroupController(groupService);
        StudentGroupView groupView = new StudentGroupView(groupController);

        groupView.addUsers(studentsRepository, repository);
        groupView.sendOnConsole(SortType.NONE);
        groupView.sendOnConsole(SortType.STUDENT);
        groupView.sendOnConsole(SortType.TEASHER);
    }
}
