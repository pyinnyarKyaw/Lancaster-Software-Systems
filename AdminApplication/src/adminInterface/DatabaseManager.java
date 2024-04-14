package adminInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringJoiner;
//2

public class DatabaseManager {
    private static final String DATABASE_URL = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t12";

    private static final String DATABASE_USER = "in2033t12_d";
    private static final String DATABASE_PASSWORD = "Udn_F4qRkG4";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load the JDBC driver", e);
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }

    public void readData(String tableName, String[] columns) {
        StringJoiner columnJoiner = new StringJoiner(", ");

        for (String column : columns) {
            columnJoiner.add(column);
        }

        String sql = "SELECT " + columnJoiner.toString() + " FROM " + tableName;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {

                for (String column : columns) {
                    String value = rs.getString(column);
                    System.out.println(column + ": " + value);
                }
                System.out.println("---");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            }

    public ResultSet executeQuery(String sql) throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }








    public void writeData(String tableName, String[] columns, Object[] values) { // Modify parameters as needed
        if (columns.length != values.length) {
            throw new IllegalArgumentException("The number of columns and values must be the same.");
        }

        StringJoiner columnNames = new StringJoiner(", ");
        StringJoiner placeholders = new StringJoiner(", ");
        for (String column : columns) {
            columnNames.add(column);
            placeholders.add("?");
        }
        String sql = "INSERT INTO " + tableName + " (" + columnNames.toString() + ") VALUES (" + placeholders.toString() + ")";


        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < values.length; i++) {
                pstmt.setObject(i + 1, values[i]);  // Set each value to the corresponding placeholder
            }

            int affectedRows = pstmt.executeUpdate();


            if (affectedRows > 0) {
                System.out.println("A row has been inserted.");
            } else {
                System.out.println("No row was inserted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();


        String[] columns = {"StaffID", "StaffName"};
        dbManager.readData("Staff", columns);
//        dbManager.readData();


//        dbManager.writeData(1, "Peanuts");
        String tableName = "Allergen";
        String[] columns1 = {"DishID", "AllergenName"};
        Object[] values = {1, "Peanuts"};

        dbManager.writeData(tableName, columns1, values);
    }


}

