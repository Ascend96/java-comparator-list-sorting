import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentListGUI extends JFrame {

    private final JTextField nameField;
    private final JTextField addressField;
    private final JTextArea outputArea;

    private final ArrayList<Student> students;
    private int rollCounter = 1; // making the design decision to just auto increment rollno because it makes more sense to not have to enter one every time

    public StudentListGUI() {
        students = new ArrayList<>();

        setTitle("Student Sorting");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ============================================================================== Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Address:"));
        addressField = new JTextField();
        inputPanel.add(addressField);

        JButton addButton = new JButton("Add Student");
        inputPanel.add(addButton);

        JButton clearButton = new JButton("Clear");
        inputPanel.add(clearButton);

        add(inputPanel, BorderLayout.NORTH);

        // ============================================= Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // ============================================= Button Panel
        JPanel buttonPanel = new JPanel();

        JButton sortByNameBtn = new JButton("Sort by Name");
        JButton sortByRollBtn = new JButton("Sort by Roll No");

        buttonPanel.add(sortByNameBtn);
        buttonPanel.add(sortByRollBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        // ============================================= Actions

        addButton.addActionListener(_ -> addStudent());

        clearButton.addActionListener(_ -> {
            nameField.setText("");
            addressField.setText("");
        });

        // adds an action for sorting by name using the custom selection sort I created as well as the custom comparator for comparing by name
        sortByNameBtn.addActionListener(_ -> {
            SelectionSort.selectionSort(students, new NameComparator());
            displayStudents();
        });

        // adds an action for sorting by rollno using the custom selection sort I created as well as the custom comparator for comparing by rollno
        sortByRollBtn.addActionListener(_ -> {
            SelectionSort.selectionSort(students, new RollNoComparator());
            displayStudents();
        });
    }

    // Method for adding a student to the list from the input fields
    private void addStudent() {
        String name = nameField.getText().trim();
        String address = addressField.getText().trim();

        if (name.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter both Name and Address",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        students.add(new Student(rollCounter++, name, address));
        displayStudents();

        nameField.setText("");
        addressField.setText("");
    }

    // Method for displaying the students in the output area so you can see the sorting
    private void displayStudents() {
        outputArea.setText("");
        for (Student s : students) {
            outputArea.append(s.toString() + "\n");
        }
    }
}