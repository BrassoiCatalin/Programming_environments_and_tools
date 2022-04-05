import Models.Employee;
import Models.User;

import javax.management.Query;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;

public class Connect {

    private static Connection connection;

    private Connect() {

        String url = "jdbc:mysql://localhost:3306/mipdb?autoReconnect=true&useSSL=false";
        String username = "root";
        String password = "root";

        System.out.println("Connecting database...");

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public static Boolean verifyIfUserExists(User user) {
        if (connection == null)
            new Connect();

        Vector<User> users = getUsers();

        for (int index = 0; index < users.size(); index++) {
            if (Objects.equals(users.get(index).getUsername(), user.getUsername()) &&
                    Objects.equals(users.get(index).getPassword(), user.getPassword()))
                return true;
        }

        return false;
    }

    public static void insertUser(User user) {
        if (connection == null)
            new Connect();

        try {

            String query = " insert into user (username, password)"
                    + " values (?, ?)";

            PreparedStatement preparedStmt = connection.prepareStatement(query);

            preparedStmt.setString(1, user.getUsername());
            preparedStmt.setString(2, user.getPassword());

            preparedStmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static Vector<User> getUsers() {
        if (connection == null)
            new Connect();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");

            Vector<User> students = new Vector<>();

            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getString(2)
                        , rs.getString(3));
                students.add(user);
            }

            return students;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return new Vector<>();
    }

    public static void addEmployee(Employee employee) {
        if (connection == null)
            new Connect();

        try {
            String query = "INSERT INTO employee(name,fathers_name,age,dob,address,phone,email,education,post) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ? ,?)";

            PreparedStatement prep = connection.prepareStatement(query);

            prep.setString(1, employee.getName());
            prep.setString(2, employee.getFatherName());
            prep.setString(3, employee.getAge());
            prep.setString(4, employee.getDOB());
            prep.setString(5, employee.getAddress());
            prep.setString(6, employee.getPhone());
            prep.setString(7, employee.getEmail());
            prep.setString(8, employee.getEducation());
            prep.setString(9, employee.getPost());

            prep.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void employeeListForTable(DefaultTableModel model) {
        if (connection == null)
            new Connect();

        try {

            String query = "SELECT * FROM employee;";
            PreparedStatement statement = connection.prepareStatement(query);
            //statement.setString(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Object row[] = {rs.getString("name"), rs.getString("fathers_name"), rs.getInt("age"),
                        rs.getString("dob"), rs.getString("address"), rs.getString("phone"),
                        rs.getString("email"), rs.getString("education"), rs.getString("post")};

                model.addRow(row);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void removeEmployee(String name, Employee employee) {
        if (connection == null)
            new Connect();

        try {
            String query = "DELETE FROM employee WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updateEmployee(Employee employee) throws SQLException {
        if (connection == null)
            new Connect();

        try {
            String query = "UPDATE employee SET name = ?, fathers_name = ?, age = ?, dob = ?, " +
                    "address = ?, phone = ?, email = ?, education = ?, post = ? " +
                    "WHERE name = ?;";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getFatherName());
            statement.setString(3, employee.getAge());
            statement.setString(4, employee.getDOB());
            statement.setString(5, employee.getAddress());
            statement.setString(6, employee.getPhone());
            statement.setString(7, employee.getEmail());
            statement.setString(8, employee.getEducation());
            statement.setString(9, employee.getPost());
            statement.setString(10, employee.getName());

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw throwables;
        }
    }
}
