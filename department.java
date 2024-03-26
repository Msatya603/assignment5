import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentDB {

    public static void main(String[] args) {
       
        String url = "jdbc:mysql:
        String username = "your_username";
        String password = "your_password";

        
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

           
            String createTableQuery = "CREATE TABLE IF NOT EXISTS department (id INT PRIMARY KEY, name VARCHAR(255))";
            statement.executeUpdate(createTableQuery);

            
            Department department = new Department(1, "IT");

            
            String insertQuery = String.format("INSERT INTO department (id, name) VALUES (%d, '%s')",
                    department.getId(), department.getName());
            statement.executeUpdate(insertQuery);

            System.out.println("Department inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class Department {
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
