package Model;

import java.util.List;

public class University extends UniversityComponent<Faculty>{

    public University(String name, List<Faculty> subComponent, Head head) {
        super(name, subComponent, head);
    }
    public University(String name, Faculty subComponent, Head head) {
        super(name, subComponent, head);
    }


}
