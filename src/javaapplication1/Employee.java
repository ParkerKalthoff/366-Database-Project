package javaapplication1;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author deerh
 */
public class Employee extends Person {
    private int empID;
    private Date startDate;
    private int homeLib;
    
    private static Scanner scan = new Scanner(System.in);
    private static String jdbcurl = "jdbc:postgresql://localhost:5432/postgres";
    private static String user = "postgres";
    private static String pass = "ss6084ss";

    /**
     * @return the empID
     */
    public int getEmpID() {
        return empID;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the homeLib
     */
    public int getHomeLib() {
        return homeLib;
    }

    /**
     * @param homeLib the homeLib to set
     */
    public void setHomeLib(int homeLib) {
        this.homeLib = homeLib;
    }
    
    public static void insert() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "insert into employee (employee_id, start_date, home_library) values (?,?,?)";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Id: ");
        int select = scan.nextInt();
        System.out.println("Enter Start Date as yyyy-mm-dd: ");
        String select1 = scan.next();
        Date selectDate = Date.valueOf(select1);
        System.out.println("Enter Home Library Number: ");
        int select3 = scan.nextInt();
        pst.setInt(1,select);
        pst.setDate(2,selectDate);
        pst.setInt(3,select3);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    public static void updateOnEmployeeId() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "update employee set start_date = ?, home_library = ? where employee_id = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Employee Id:");
        int select3 = scan.nextInt();
        System.out.println("Enter new Start Date as yyyy-mm-dd: ");
        String select1 = scan.next();
        Date selectDate = Date.valueOf(select1);
        System.out.println("Enter new Home Library Number: ");
        int select2 = scan.nextInt();
        pst.setDate(1,selectDate);
        pst.setInt(2,select2);
        pst.setInt(3, select3);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    public static void updateOnHomeLibrary() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "update employee set start_date = ?, home_library = ? where home_library = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Library Name:");
        String select3 = scan.next();
        System.out.println("Enter new Start Date as yyyy-mm-dd: ");
        String select1 = scan.next();
        Date selectDate1 = Date.valueOf(select1);
        System.out.println("Enter new Home Library: ");
        String select2 = scan.next();
        pst.setDate(1,selectDate1);
        pst.setString(2,select2);
        pst.setString(3, select3);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    
    
    public static void selectOnEmployeeId() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "select * from employee where employee_id = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Employee Id: ");
        int select = scan.nextInt();
        pst.setInt(1,select);
        ResultSet rs1 = pst.executeQuery();
        while(rs1.next())
        {
            System.out.println("Id: "+rs1.getInt("employee_id"));
            System.out.println("Start Date: "+rs1.getDate("start_date"));
            System.out.println("Home Library: "+rs1.getString("home_library"));
            System.out.println("\n");
        }
    }
    
    public static void selectOnStartDate() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "select * from employee where start_date = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Start Date as yyyy-mm-dd: ");
        String select1 = scan.next();
        Date selectDate1 = Date.valueOf(select1);
        pst.setDate(1,selectDate1);
        ResultSet rs1 = pst.executeQuery();
        while(rs1.next())
        {
            System.out.println("Id: "+rs1.getInt("employee_id"));
            System.out.println("Start Date: "+rs1.getDate("start_date"));
            System.out.println("Home Library: "+rs1.getString("home_library"));
            System.out.println("\n");
        }
    }
    
    public static void selectOnHomeLibrary() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "select * from employee where home_library = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Library Id: ");
        int select = scan.nextInt();
        pst.setInt(1,select);
        ResultSet rs1 = pst.executeQuery();
        while(rs1.next())
        {
            System.out.println("Id: "+rs1.getInt("employee_id"));
            System.out.println("Start Date: "+rs1.getDate("start_date"));
            System.out.println("Home Library: "+rs1.getInt("home_library"));
            System.out.println("\n");
        }
    }
    
    public static void deleteOnEmployeeId() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "delete from employee where employee_id = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Employee Id: ");
        int delete = scan.nextInt();
        pst.setInt(1,delete);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    public static void deleteOnHomeLibrary() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "delete from employee where home_library = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Library Name: ");
        String delete = scan.next();
        pst.setString(1,delete);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    
}
