package OOPhw5.model;

import OOPhw5.repository.TeacherRepository;
import OOPhw5.service.StudentGroupIterator;
import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Data

public class StudGroup {

    private final String groupId;

    public StudGroup(String groupId) {
        this.groupId = groupId;
    }
}