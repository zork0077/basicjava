package Controller;

import Model.Human;
import Model.Sex;

public interface HumanCreatable<T extends Human> {
    T create(String firstName, String lastName, String middleName, Sex sex, String id);
}