/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author parke
 */
public class Library {
    private static String jdbcurl = "jdbc:postgresql://localhost:5432/postgres";
    private static String username = "postgres";
    private static String password = "ss6084ss";
    private static Scanner scan = new Scanner(System.in);
    
    // [ LIBRARY ] <Library_ID> (Provided, not set), name, street_address, open_time, close_time
    private String name;
    private String street_address;
    private String openTime;
    private String closeTime;
    private int library_id;
    
    // SETS AND GETS
    
       /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the street_address
     */
    public String getstreet_address() {
        return street_address;
    }

    /**
     * @param street_address the street_address to set
     */
    public void setstreet_address(String street_address) {
        this.street_address = street_address;
    }

    /**
     * @return the openTime
     */
    public String getOpenTime() {
        return openTime;
    }

    /**
     * @param openTime the openTime to set
     */
    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    /**
     * @return the closeTime
     */
    public String getCloseTime() {
        return closeTime;
    }

    /**
     * @param closeTime the closeTime to set
     */
    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    /**
     * @return the library_id
     */
    public int getLibrary_id() {
        return library_id;
    }

    /**
     * @param library_id the library_id to set
     */
    public void setLibrary_id(int library_id) {
        this.library_id = library_id;
    }
    
    // LIBRARY DELETES
    
    public static void deleteRecordFromLibraryOnLibrary_ID() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,username,password);
        String st = "DELETE FROM library WHERE library_id = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.println("Enter Library ID (Integer):");
        int deleteLibrary_ID = scan.nextInt();
        pst.setInt(1, deleteLibrary_ID);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    public static void deleteRecordFromLibraryOnName() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,username,password);
        String st = "DELETE FROM library WHERE name = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.println("Enter Library Name (String):");
        String deleteName = scan.nextLine();
        pst.setString(1, deleteName);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    // LIBRARY SELECTS
    
    public static void selectFromLibaryOnLibrary_ID() throws SQLException
    {
      Connection connection = DriverManager.getConnection(jdbcurl,username,password);
      String st = "SELECT * FROM library WHERE library_id = ?";
      PreparedStatement pst = connection.prepareStatement(st);
      System.out.println("Enter Library Id:");
      int library_id = scan.nextInt();
      pst.setInt(1, library_id);
      ResultSet rs1 = pst.executeQuery();
      while(rs1.next())
      {
          System.out.println("Id: "+rs1.getInt("library_id"));
          System.out.println("Name: "+rs1.getString("name"));
          System.out.println("Street Address: "+rs1.getString("street_address"));
          System.out.println("Open Time: "+rs1.getTime("open_time"));
          System.out.println("Close Time: "+rs1.getTime("close_time"));
          System.out.println("\n");
      }
    }
    
    public static void selectFromLibaryOnName() throws SQLException
    {
      Connection connection = DriverManager.getConnection(jdbcurl,username,password);
      String st = "SELECT * FROM library WHERE name = ?";
      PreparedStatement pst = connection.prepareStatement(st);
      System.out.println("Enter Name (String):");
      String name = scan.nextLine();
      pst.setString(1, name);
      ResultSet rs1 = pst.executeQuery();
      while(rs1.next())
      {
          System.out.println("Id: "+rs1.getInt("library_id"));
          System.out.println("Name: "+rs1.getString("name"));
          System.out.println("Street Address: "+rs1.getString("street_address"));
          System.out.println("Open Time: "+rs1.getTime("open_time"));
          System.out.println("Close Time: "+rs1.getTime("close_time"));
          System.out.println("\n");
      }
    }
   
    public static void selectFromLibaryOnLocation() throws SQLException
    {
      Connection connection = DriverManager.getConnection(jdbcurl,username,password);
      String st = "SELECT * FROM library WHERE street_address = ?";
      PreparedStatement pst = connection.prepareStatement(st);
      System.out.println("Enter Street Address (String):");
      String street_address = scan.nextLine();
      pst.setString(1, street_address);
      ResultSet rs1 = pst.executeQuery();
      while(rs1.next())
      {
          System.out.println("Id: "+rs1.getInt("library_id"));
          System.out.println("Name: "+rs1.getString("name"));
          System.out.println("Street Address: "+rs1.getString("street_address"));
          System.out.println("Open Time: "+rs1.getTime("open_time"));
          System.out.println("Close Time: "+rs1.getTime("close_time"));
          System.out.println("\n");
      }
    }
    
    // LIBRARY UPDATES
    
    public static void updateFromLibraryOnName() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,username,password);
        String st = "UPDATE library SET name = ?, street_address = ?, open_time = ?, close_time = ? where name = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.println("Enter the Libraries Name (String):");
        String select5 = scan.nextLine();
        System.out.println("Enter New Name(String):");
        String select1 = scan.nextLine();
        System.out.println("Enter the Street Address (String):");
        String select2 = scan.nextLine();
        System.out.println("Enter the Opening Time (String in 'hh:mm:ss')");
        String select3 = scan.next();
        Time selectTime3 = Time.valueOf(select3);
        System.out.println("Enter the Close Time (String in 'hh:mm:ss')");
        String select4= scan.next();
        Time selectTime4 = Time.valueOf(select4);
        pst.setString(1,select1);
        pst.setString(2,select2);
        pst.setTime(3, selectTime3);
        pst.setTime(4,selectTime4);
        pst.setString(5,select5);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    public static void updateFromLibraryOnLocation() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,username,password);
        String st = "UPDATE library SET street_address = ?, name = ? , open_time = ?, close_time = ? where street_address = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.println("Enter the Street Address (String):");
        String select5 = scan.nextLine();
        System.out.println("Enter New Street Address (String): ");
        String select1 = scan.nextLine();
        System.out.println("Enter the Libraries Name (String):");
        String select2 = scan.nextLine();
        System.out.println("Enter the Opening Time (String in 'hh:mm:ss')");
        String select3 = scan.next();
        Time selectTime3 = Time.valueOf(select3);
        System.out.println("Enter the Close Time (String in 'hh:mm:ss')");
        String select4= scan.next();
        Time selectTime4 = Time.valueOf(select4);
        pst.setString(1,select1);
        pst.setString(2,select2);
        pst.setTime(3, selectTime3);
        pst.setTime(4,selectTime4);
        pst.setString(5,select5);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    public static void updateFromLibraryOnOpenTime() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,username,password);
        String st = "UPDATE library SET open_time = ?,  close_time = ?, street_address = ?, name = ? where open_time = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.println("Enter Original Opening Time (String in 'hh:mm:ss')");
        String select5 = scan.next();
        Time selectTime5 = Time.valueOf(select5);
        System.out.println("Enter New Opening Time (String in 'hh:mm:ss')");
        String select1 = scan.next();
        Time selectTime1 = Time.valueOf(select1);
        System.out.println("Enter the Close Time (String in 'hh:mm:ss')");
        String select2= scan.next();
        Time selectTime2 = Time.valueOf(select2);
        scan.nextLine();
        System.out.println("Enter the Street Address (String):");
        String select3 = scan.nextLine();
        System.out.println("Enter the Libraries Name (String):");
        String select4 = scan.nextLine();
        pst.setTime(1, selectTime1);
        pst.setTime(2,selectTime2);
        pst.setString(3,select3);
        pst.setString(4,select4);
        pst.setTime(5,selectTime5);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    public static void updateFromLibraryOnCloseTime() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,username,password);
        String st = "UPDATE library SET close_time= ?, street_address = ?, open_time = ?, name = ? where close_time = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.println("Enter Original Close Time (String in 'hh:mm:ss')");
        String select5 = scan.next();
        Time selectTime5 = Time.valueOf(select5);
        System.out.println("Enter New Close Time (String in 'hh:mm:ss')");
        String select1 = scan.next();
        Time selectTime1 = Time.valueOf(select1);
        System.out.println("Enter the Street Address (String):");
        String select2 = scan.nextLine();
        System.out.println("Enter the Opening Time (String in 'hh:mm:ss')");
        String select3 = scan.next();
        Time selectTime3 = Time.valueOf(select3);
        System.out.println("Enter the Library's Name (String):");
        String select4 = scan.nextLine();
        pst.setTime(5,selectTime5);
        pst.setTime(1,selectTime1);
        pst.setString(2, select2);
        pst.setTime(3,selectTime3);
        pst.setString(4,select4);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    public static void insertOnLibrary() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,username,password);
        String st = "INSERT INTO library (name, street_address, open_time, close_time) VALUES (?,?,?,?);";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.println("Enter Name (String): ");
        String Select1 = scan.nextLine();
        System.out.println("Enter Street Address (String): ");
        String Select2 = scan.nextLine();
        System.out.println("Enter Opening Time (String in 'hh:mm:ss')");
        String Select3 = scan.next();
        Time selectTime3 = Time.valueOf(Select3);
        System.out.println("Enter Closing Time (String in 'hh:mm:ss')");
        String Select4 = scan.next();
        Time selectTime4 = Time.valueOf(Select4);
        pst.setString(1,Select1);
        pst.setString(2,Select2);
        pst.setTime(3, selectTime3);
        pst.setTime(4,selectTime4);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    // LIBRARY BOOK TABLE
    
    // LBA Delete
    
    public static void selectFromLibrary_Book_AmountOnLibrary_ID() throws SQLException{
      Connection connection = DriverManager.getConnection(jdbcurl,username,password);
      String st = "SELECT * FROM library_book_amount WHERE library_id = ?";
      PreparedStatement pst = connection.prepareStatement(st);
      System.out.println("Enter Library ID:");
      int library_id = scan.nextInt();
      pst.setInt(1, library_id);
      ResultSet rs1 = pst.executeQuery();
      while(rs1.next())
      {
          System.out.println("Dewey Number: "+rs1.getString("dewey_decimal_number"));
          System.out.println("Library Id: "+rs1.getInt("library_id"));
          System.out.println("Amount: "+rs1.getInt("amount"));
          System.out.println("\n");
      }
  }

    public static void deleteRecordFromLibrary_Book_AmountOnLibrary_ID() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,username,password);
        String st = "DELETE FROM library_book_amount WHERE library_id = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.println("Enter Library ID:");
        int library_id = scan.nextInt();
        pst.setInt(1, library_id);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    public static void updateFromLibrary_Book_AmountOnLibrary_Id() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,username,password);
        String st = "UPDATE library_book_amount SET dewey_decimal_number = ?, library_id = ?, amount = ?  WHERE library_id = ? AND dewey_decimal_number=?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.println("Enter Original Library Id");
        int select1 = scan.nextInt();
        System.out.println("Enter the Orginal Dewey Decimal Number:");
        String select2 = scan.next();
        System.out.println("Enter New Library ID");
        int select3 = scan.nextInt();
        System.out.println("Enter the Dewey Decimal Number:");
        String select4 = scan.next();
        System.out.println("Enter the Amount");
        int select5 = scan.nextInt();
        pst.setString(1,select4);
        pst.setInt(2,select3);
        pst.setInt(3, select5);
        pst.setInt(4, select1);
        pst.setString(5,select2);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
}