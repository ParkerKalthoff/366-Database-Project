/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author deerh
 */
public class Person {
    private int ID;
    private String fname;
    private String lname;
    private String address;
    private int zipcode;
    private String state;

    private static Scanner scan = new Scanner(System.in);
    private static String jdbcurl = "jdbc:postgresql://localhost:5432/postgres";
    private static String user = "postgres";
    private static String pass = "ss6084ss";
    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the zipcode
     */
    public int getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
    
    
    public static void deleteOnFirstName() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "delete from person where fname = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter First Name: ");
        String delete = scan.next();
        pst.setString(1,delete);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    public static void deleteOnLastName() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "delete from person where lname = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Last Name: ");
        String delete = scan.next();
        pst.setString(1,delete);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    public static void deleteOnId() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "delete from person where person_id = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Person ID: ");
        int delete = scan.nextInt();
        pst.setInt(1,delete);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    public static void selectOnFirstName() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "select * from person where fname = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter First Name: ");
        String select = scan.next();
        pst.setString(1,select);
        ResultSet rs1 = pst.executeQuery();
        while(rs1.next())
        {
            System.out.println("ID: "+rs1.getInt("person_id"));
            System.out.println("First Name: "+rs1.getString("fname"));
            System.out.println("Last Name: "+rs1.getString("lname"));
            System.out.println("Address: " + rs1.getString("address"));
            System.out.println("Zipcode: " + rs1.getInt("zipcode"));
            System.out.println("State: "+ rs1.getString("state"));
            System.out.println("\n");
        }
    }
    
    public static void selectOnLastName() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "select * from person where lname = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Last Name: ");
        String select = scan.next();
        pst.setString(1,select);
        ResultSet rs1 = pst.executeQuery();
        while(rs1.next())
        {
            System.out.println("ID: "+rs1.getInt("person_id"));
            System.out.println("First Name: "+rs1.getString("fname"));
            System.out.println("Last Name: "+rs1.getString("lname"));
            System.out.println("Address: " + rs1.getString("address"));
            System.out.println("Zipcode: " + rs1.getInt("zipcode"));
            System.out.println("State: "+ rs1.getString("state"));
            System.out.println("\n");
        }
    }
    
    public static void selectOnPersonId() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "select * from person where person_id = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Person Id: ");
        int select = scan.nextInt();
        pst.setInt(1,select);
        ResultSet rs1 = pst.executeQuery();
        while(rs1.next())
        {
            System.out.println("ID: "+rs1.getInt("person_id"));
            System.out.println("First Name: "+rs1.getString("fname"));
            System.out.println("Last Name: "+rs1.getString("lname"));
            System.out.println("Address: " + rs1.getString("address"));
            System.out.println("Zipcode: " + rs1.getInt("zipcode"));
            System.out.println("State: "+ rs1.getString("state"));
            System.out.println("\n");
        }
    }
    
    public static void updateOnPersonId() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "update person set fname = ?, lname = ?, address = ?, zipcode = ?, state = ? where person_id = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Person Id: ");
        int selectcond = scan.nextInt();
        System.out.print("Enter New First Name: ");
        String select = scan.next();
        System.out.println("Enter New Last Name: ");
        String select2 = scan.next();
        System.out.println("Enter New Address: ");
        String select3 = scan.nextLine();
        System.out.println("Enter New Zipcode: ");
        int select4 = scan.nextInt();
        System.out.println("Enter New State Abbreviation: ");
        String select5 = scan.next();
        pst.setString(1,select);
        pst.setString(2,select2);
        pst.setString(3,select3);
        pst.setInt(4,select4);
        pst.setString(5,select5);
        pst.setInt(6,selectcond);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    public static void updateOnFirstName() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "update person set fname = ?, lname = ?, address = ?, zipcode = ?, state = ? where fname = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter First Name: ");
        String selectcond = scan.next();
        System.out.print("Enter New First Name: ");
        String select = scan.next();
        System.out.println("Enter New Last Name: ");
        String select2 = scan.next();
        System.out.println("Enter New Address: ");
        String select3 = scan.nextLine();
        System.out.println("Enter New Zipcode: ");
        int select4 = scan.nextInt();
        System.out.println("Enter New State Abbreviation: ");
        String select5 = scan.next();
        pst.setString(1,select);
        pst.setString(2,select2);
        pst.setString(3,select3);
        pst.setInt(4,select4);
        pst.setString(5,select5);
        pst.setString(6,selectcond);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    public static void updateOnLastName() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "update person set fname = ?, lname = ?, address = ?, zipcode = ?, state = ? where lname = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Last Name: ");
        String selectcond = scan.next();
        System.out.print("Enter New First Name: ");
        String select = scan.next();
        System.out.println("Enter New Last Name: ");
        String select2 = scan.next();
        System.out.println("Enter New Address: ");
        String select3 = scan.nextLine();
        System.out.println("Enter New Zipcode: ");
        int select4 = scan.nextInt();
        System.out.println("Enter New State Abbreviation: ");
        String select5 = scan.next();
        pst.setString(1,select);
        pst.setString(2,select2);
        pst.setString(3,select3);
        pst.setInt(4,select4);
        pst.setString(5,select5);
        pst.setString(6,selectcond);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    public static void insert() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "insert into person (fname, lname, address, zipcode, state) values (?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter First Name: ");
        String select = scan.next();
        System.out.println("Enter Last Name: ");
        String select2 = scan.next();
        scan.nextLine();
        System.out.println("Enter Address: ");
        String select3 = scan.nextLine();
        System.out.println("Enter Zipcode: ");
        int select4 = scan.nextInt();
        System.out.println("Enter State Abbreviation: ");
        String select5 = scan.next();
        pst.setString(1,select);
        pst.setString(2,select2);
        pst.setString(3,select3);
        pst.setInt(4,select4);
        pst.setString(5,select5);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
}
