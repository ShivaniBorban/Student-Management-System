import java.sql.*;
import java.util.*;

public class StudentDAO {

    // 1. Add Student
    public void addStudent(Student s) {

        String sql = "INSERT INTO Students(name, email, course, marks) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            ps.setDouble(4, s.getMarks());

            ps.executeUpdate();

            System.out.println("Student Added Successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. View All Students
    public void viewStudents() {

        String sql = "SELECT * FROM Students";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("email") + " | " +
                    rs.getString("course") + " | " +
                    rs.getDouble("marks")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3. Search Student
    public void searchStudent(int id) {

        String sql = "SELECT * FROM Students WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("Marks: " + rs.getDouble("marks"));

            } else {
                System.out.println("Student Not Found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 4. Update Student
    public void updateStudent(Student s) {

        String sql = "UPDATE Students SET name=?, email=?, course=?, marks=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            ps.setDouble(4, s.getMarks());
            ps.setInt(5, s.getId());

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student Updated Successfully!");
            else
                System.out.println("Student Not Found!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 5. Delete Student
    public void deleteStudent(int id) {

        String sql = "DELETE FROM Students WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student Deleted Successfully!");
            else
                System.out.println("Student Not Found!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}