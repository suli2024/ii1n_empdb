package lan.zold;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataSource {
    public ArrayList<Employee> getEmployees() {
        try {
            return tryGetEmployees();
        } catch (SQLException e) {
            System.err.println("Hiba! A dolgozók lekérdezése sikertelen!");
            System.err.println(e.getMessage());
            return null;
        }        
    }

    public ArrayList<Employee> tryGetEmployees() throws SQLException {
        Mariadb mariadb = new Mariadb();
        Connection connection = mariadb.connectDb();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM employees";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Employee> employeeList = new ArrayList<>();
        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setName(resultSet.getString("name"));
            employee.setCity(resultSet.getString("city"));
            employee.setSalary(resultSet.getDouble("salary"));
            employeeList.add(employee);
        }
        mariadb.closeDb(connection);
        return employeeList;
    }
}
