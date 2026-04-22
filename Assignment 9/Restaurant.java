package A9;

import java.sql.*;

public class Restaurant {

    // Updated to FoodDB as requested
    static final String URL = "jdbc:mysql://localhost:3306/FoodDB";
    static final String USER = "root";
    static final String PASS = "{user_password}";

    public static Connection getConnection() throws Exception {
        // Load Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Create FoodDB if it doesn't exist
        String serverUrl = "jdbc:mysql://localhost:3306/";
        try (Connection serverCon = DriverManager.getConnection(serverUrl, USER, PASS);
             Statement st = serverCon.createStatement()) {
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS FoodDB");
        }

        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void createTables(Connection con) throws Exception {
        try (Statement st = con.createStatement()) {
            // Drop existing tables to ensure a clean run
            st.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
            st.executeUpdate("DROP TABLE IF EXISTS MenuItem");
            st.executeUpdate("DROP TABLE IF EXISTS Restaurant");
            st.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");

            String createRestaurant = "CREATE TABLE Restaurant (" +
                    "Id INT PRIMARY KEY, " +
                    "Name VARCHAR(255), " +
                    "Address VARCHAR(255))";
            st.executeUpdate(createRestaurant);

            String createMenuItem = "CREATE TABLE MenuItem (" +
                    "Id INT PRIMARY KEY, " +
                    "Name VARCHAR(255), " +
                    "Price DOUBLE, " +
                    "ResId INT, " +
                    "FOREIGN KEY (ResId) REFERENCES Restaurant(Id))";
            st.executeUpdate(createMenuItem);
            System.out.println("Tables created successfully in FoodDB.");
        }
    }

    public static void insertData(Connection con) throws Exception {
        String insertRestaurant = "INSERT INTO Restaurant VALUES (?, ?, ?)";
        String insertMenu = "INSERT INTO MenuItem VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps1 = con.prepareStatement(insertRestaurant);
             PreparedStatement ps2 = con.prepareStatement(insertMenu)) {

            Object[][] restaurants = {
                {1, "Cafe Java", "101 Main St"}, {2, "Pizza Palace", "202 Oak Ave"},
                {3, "Burger Joint", "303 Pine Rd"}, {4, "The Pasta Place", "404 Elm St"},
                {5, "Taco Corner", "505 Maple Dr"}, {6, "Sub Shop", "606 Cedar Ln"},
                {7, "Sushi World", "707 Birch Blvd"}, {8, "Steakhouse", "808 Walnut St"},
                {9, "Vegan Bites", "909 Cherry Way"}, {10, "Breakfast Club", "1010 Ash Ct"}
            };

            for (Object[] r : restaurants) {
                ps1.setInt(1, (Integer) r[0]);
                ps1.setString(2, (String) r[1]);
                ps1.setString(3, (String) r[2]);
                ps1.executeUpdate();
            }

            Object[][] menuItems = {
                {101, "Coffee", 50.0, 1}, {102, "Tea", 40.0, 1},
                {103, "Pastry", 120.0, 1}, {104, "Pizza", 250.0, 2},
                {105, "Burger", 80.0, 3}, {106, "Pasta", 180.0, 4},
                {107, "Taco", 60.0, 5}, {108, "Pancake", 90.0, 10},
                {109, "Salad", 110.0, 9}, {110, "Steak", 500.0, 8}
            };

            for (Object[] m : menuItems) {
                ps2.setInt(1, (Integer) m[0]);
                ps2.setString(2, (String) m[1]);
                ps2.setDouble(3, (Double) m[2]);
                ps2.setInt(4, (Integer) m[3]);
                ps2.executeUpdate();
            }
            System.out.println("Inserted 10 records into Restaurant and MenuItem.");
        }
    }

    public static void selectPriceLessThan100(Connection con) throws Exception {
        String query = "SELECT * FROM MenuItem WHERE Price <= 100";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            System.out.println("\n--- Query: MenuItems where Price <= 100 ---");
            printMenu(rs);
        }
    }

    public static void selectCafeJavaItems(Connection con) throws Exception {
        String query = "SELECT m.* FROM MenuItem m " +
                       "JOIN Restaurant r ON m.ResId = r.Id " +
                       "WHERE r.Name = 'Cafe Java'";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            System.out.println("\n--- Query: Items available in 'Cafe Java' ---");
            printMenu(rs);
        }
    }

    public static void updatePrice(Connection con) throws Exception {
        String query = "UPDATE MenuItem SET Price = 200 WHERE Price <= 100";
        try (Statement st = con.createStatement()) {
            int rows = st.executeUpdate(query);
            System.out.println("\nUpdate: Price <= 100 set to 200. Rows affected: " + rows);
        }
    }

    public static void deleteItems(Connection con) throws Exception {
        String query = "DELETE FROM MenuItem WHERE Name LIKE 'P%'";
        try (Statement st = con.createStatement()) {
            int rows = st.executeUpdate(query);
            System.out.println("\nDelete: Items where name starts with 'P'. Rows affected: " + rows);
        }
    }

    public static void printMenu(ResultSet rs) throws Exception {
        System.out.printf("%-10s %-15s %-10s %-10s\n", "Id", "Name", "Price", "ResId");
        System.out.println("--------------------------------------------------");
        boolean hasData = false;
        while (rs.next()) {
            hasData = true;
            System.out.printf("%-10d %-15s %-10.2f %-10d\n",
                    rs.getInt("Id"), rs.getString("Name"), 
                    rs.getDouble("Price"), rs.getInt("ResId"));
        }
        if (!hasData) System.out.println("No records found.");
    }

    public static void main(String[] args) {
        System.out.println("Starting RestaurantJDBC Application...");
        try (Connection con = getConnection()) {
            System.out.println("Connected to FoodDB successfully!");

            createTables(con);
            insertData(con);
            
            // Perform operations
            selectPriceLessThan100(con);
            selectCafeJavaItems(con);
            updatePrice(con);
            deleteItems(con);

            // Final View to show results of Update and Delete
            System.out.println("\nFinal State of MenuItem Table:");
            try (Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM MenuItem")) {
                printMenu(rs);
            }

            System.out.println("\nProgram completed successfully!");

        } catch (Exception e) {
            System.err.println("ERROR: An unexpected error occurred!");
            e.printStackTrace();
        }
    }
}
