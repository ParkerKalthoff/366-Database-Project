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
public class Book {
    private static String jdbcurl = "jdbc:postgresql://localhost:5432/postgres";
    private static String username = "postgres";
    private static String password = "ss6084ss";
    static Scanner scan = new Scanner(System.in);
   
    
    // [BOOK] Table has dewey_decimal_number, title, author (all string)
    private String deweyNumber;
    private String title;
    private String author;
    
    // [LIBRARY BOOK AMOUNT] Table has dewey_decimal_number, library_id, amount
    // deweyNumber variable is provided above
    private int library_id;
    private int amount;
    
    
    /** BOOK SETTERS AND GETTERS
     * @return the deweyNumber
     */
    
    /**
     * @param deweyNumber the deweyNumber to set
     */
    public void setDeweyNumber(String deweyNumber) {
        this.deweyNumber = deweyNumber;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public String getDeweyNumber() {
        return deweyNumber;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }
    
    public int getAmount() {
        return amount;
    }

    
    
    // BOOK table Deletes
    
    public static void deleteRecordFromBookOnDewey_Decimal_Number() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,username,password);
        String st = "DELETE FROM book WHERE dewey_decimal_number = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.println("Enter Dewey Number:");
        String deleteDeweyNumber = scan.next();
        pst.setString(1, deleteDeweyNumber);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    public static void deleteRecordFromBookOnTitle() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,username,password);
        String st = "DELETE FROM book WHERE title = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.println("Enter Title:");
        String deleteTitle = scan.nextLine();
        pst.setString(1, deleteTitle);
        pst.executeUpdate();
        System.out.println("Done!");
    }
  
    // BOOK TABLE Insert
    
    public static void insertOnBook() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,username,password);
        String st = "INSERT into book (dewey_decimal_number, title, author) VALUES (?,?,?);";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.println("Enter Dewey Number (String): ");
        String deweyNumber = scan.next();
        scan.nextLine();
        System.out.println("Enter Title: ");
        String title = scan.nextLine();
        System.out.println("Enter Author: ");
        String author = scan.nextLine();
        pst.setString(1,deweyNumber);
        pst.setString(2,title);
        pst.setString(3, author);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    // BOOK Table Selectors
    
  public static void selectFromBookOnDewey_Decimal_Number() throws SQLException{
      Connection connection = DriverManager.getConnection(jdbcurl,username,password);
      String st = "SELECT * FROM book WHERE dewey_decimal_number = ?";
      PreparedStatement pst = connection.prepareStatement(st);
      System.out.println("Enter Dewey Number:");
      String deweyNumber = scan.next();
      pst.setString(1, deweyNumber);
      ResultSet rs1 = pst.executeQuery();
      while(rs1.next())
      {
          System.out.println("Dewey Number: "+rs1.getString("dewey_decimal_number"));
          System.out.println("Title: "+rs1.getString("title"));
          System.out.println("Author: "+rs1.getString("author"));
          System.out.println("\n");
      }
  }
          // finds records using the author
    public static void selectFromBookOnAuthor() throws SQLException{
      Connection connection = DriverManager.getConnection(jdbcurl,username,password);
      String st = "SELECT * FROM book WHERE author = ?";
      PreparedStatement pst = connection.prepareStatement(st);
      System.out.println("Enter Author:");
      scan.nextLine();
      String author = scan.nextLine();
      pst.setString(1, author);
      ResultSet rs1 = pst.executeQuery();
      while(rs1.next())
      {
          System.out.println("Dewey Number: "+rs1.getString("dewey_decimal_number"));
          System.out.println("Title: "+rs1.getString("title"));
          System.out.println("Author: "+rs1.getString("author"));
          System.out.println("\n");
      }
  }
    
    // finds records using the title
   public static void selectFromBookOnTitle() throws SQLException{
      Connection connection = DriverManager.getConnection(jdbcurl,username,password);
      String st = "SELECT * FROM book WHERE title = ?";
      PreparedStatement pst = connection.prepareStatement(st);
      System.out.println("Enter Title:");
      String title = scan.nextLine();
      pst.setString(1, title);
      ResultSet rs1 = pst.executeQuery();
      while(rs1.next())
      {
          System.out.println("Dewey Number: "+rs1.getString("dewey_decimal_number"));
          System.out.println("Title: "+rs1.getString("title"));
          System.out.println("Author: "+rs1.getString("author"));
          System.out.println("\n");
      }
  }
   // LIBRARY BOOK AMOUNT Methods
   // LBA Insert
   
   public static void insertOnLibrary_Book_Amount() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,username,password);
        String st = "INSERT into library_book_amount (dewey_decimal_number, library_id, amount) VALUES (?,?,?);";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.println("Enter Dewey Number (String): ");
        String deweyNumber = scan.next();
        System.out.println("Enter Library ID: ");
        int library_id = scan.nextInt();
        System.out.println("Enter Amount: ");
        int amount = scan.nextInt();
        pst.setString(1,deweyNumber);
        pst.setInt(2,library_id);
        pst.setInt(3, amount);
        pst.executeUpdate();
        System.out.println("Done!");
    }
   
   // LBA Update

    public static void updateFromLibrary_Book_AmountOnDewey_Decimal_Number() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,username,password);
        String st = "UPDATE library_book_amount SET dewey_decimal_number = ?, library_id = ?, amount = ?  WHERE library_id = ? AND dewey_decimal_number=?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.println("Enter the Orginal Dewey Decimal Number:");
        String select2 = scan.next();
        System.out.println("Enter Original Library Id");
        int select1 = scan.nextInt();
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
   
   // LBA Delete
   
    public static void deleteRecordFromLibrary_Book_AmountOnDewey_Decimal_Number() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,username,password);
        String st = "DELETE FROM library_book_amount WHERE dewey_decimal_number = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.println("Enter Dewey Number (String):");
        String deleteDeweyNumber = scan.next();
        pst.setString(1, deleteDeweyNumber);
        pst.executeUpdate();
        System.out.println("Done!");
    }
   
   // LBA Select

    public static void selectFromLibrary_Book_AmountOnDewey_Decimal_Number() throws SQLException{
      Connection connection = DriverManager.getConnection(jdbcurl,username,password);
      String st = "SELECT * FROM library_book_amount WHERE dewey_decimal_number = ?";
      PreparedStatement pst = connection.prepareStatement(st);
      System.out.println("Enter Dewey Number (String):");
      String dewey = scan.next();
      pst.setString(1, dewey);
      ResultSet rs1 = pst.executeQuery();
      while(rs1.next())
      {
          System.out.println("Dewey Number: "+rs1.getString("dewey_decimal_number"));
          System.out.println("Library Id: "+rs1.getInt("library_id"));
          System.out.println("Amount: "+rs1.getInt("amount"));
          System.out.println("\n");
      }
  }

    
    
    
    
}
