package Model;

public class Head extends Human {
    private String headId;

    public Head(String firstName, String lastName, String middleName, Sex sex, String headId) {
        super(firstName, lastName, middleName, sex);
        this.headId = headId;
    }

    public String getHeadId() {
        return headId;
    }

    public void setHeadId(String headId) {
        this.headId = headId;
    }

    @Override
    public String toString() {
        return "Head: " + getFullName() + ", ID: " + headId;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName() + " " + getMiddleName();
    }
}
