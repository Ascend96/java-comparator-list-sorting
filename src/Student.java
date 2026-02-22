public class Student {
    int rollno;
    String name;
    String address;

    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    // displays the student details in an easy to read format
    @Override
    public String toString() {
        return rollno + ": " + name + " " + address;
    }
}
