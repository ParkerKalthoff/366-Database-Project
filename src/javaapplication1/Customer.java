package javaapplication1;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author deerh
 */
public class Customer extends Person {
    private int custID;
    private Date issueDate;
    private Date expireDate;
    private static Scanner scan = new Scanner(System.in);
    private static String jdbcurl = "jdbc:postgresql://localhost:5432/postgres";
    private static String user = "postgres";
    private static String pass = "ss6084ss";
    
    /**
     * @return the custID
     */
    public int getCustID() {
        return custID;
    }

    /**
     * @return the issueDate
     */
    public Date getIssueDate() {
        return issueDate;
    }

    /**
     * @param issueDate the issueDate to set
     */
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * @return the expireDate
     */
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     * @param expireDate the expireDate to set
     */
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
    
    /**
     *
     * @throws SQLException
     */
    public static void insert() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "insert into customer (customer_id, issue_date, expire_date) values (?,?,?)";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Customer Id: ");
        int select = scan.nextInt();
        System.out.println("Enter Issue Date as yyyy-mm-dd: ");
        String select2 = scan.next();
        Date selectDate2 = Date.valueOf(select2);
        System.out.println("Enter Expire Date as yyyy-mm-dd: ");
        String select3 = scan.next();
        Date selectDate3 = Date.valueOf(select3);
        pst.setInt(1,select);
        pst.setDate(2,selectDate2);
        pst.setDate(3,selectDate3);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    /**
     *
     * @throws SQLException
     */
    public static void selectOnCustomerId() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "select * from customer where customer_id = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Customer Id: ");
        int select = scan.nextInt();
        pst.setInt(1,select);
        ResultSet rs1 = pst.executeQuery();
        while(rs1.next())
        {
            System.out.println("Id: "+rs1.getInt("customer_id"));
            System.out.println("Issue Date: "+rs1.getDate("issue_date"));
            System.out.println("Expire Date: "+ rs1.getDate("expire_date"));
            System.out.println("\n");
            
        }
    }
    
    /**
     *
     * @throws SQLException
     */
    public static void selectOnIssueDate() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "select * from customer where issue_date = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Issue Date as yyyy-mm-dd: ");
        String select = scan.next();
        Date selectDate = Date.valueOf(select);
        pst.setDate(1,selectDate);
        ResultSet rs1 = pst.executeQuery();
        while(rs1.next())
        {
            System.out.println("Id: "+rs1.getInt("customer_id"));
            System.out.println("Issue Date: "+rs1.getDate("issue_date"));
            System.out.println("Expire Date: "+ rs1.getDate("expire_date"));
            System.out.println("\n");
            
        }
    }
    
    /**
     *
     * @throws SQLException
     */
    public static void selectOnExpireDate() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "select * from customer where expire_date = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Expire Date as yyyy-mm-dd: ");
        String select = scan.next();
        Date selectDate = Date.valueOf(select);
        pst.setDate(1,selectDate);
        ResultSet rs1 = pst.executeQuery();
        while(rs1.next())
        {
            System.out.println("Id: "+rs1.getInt("customer_id"));
            System.out.println("Issue Date: "+rs1.getDate("issue_date"));
            System.out.println("Expire Date: "+ rs1.getDate("expire_date"));
            System.out.println("\n");
            
        }
    }
    
    /**
     *
     * @throws SQLException
     */
    public static void deleteOnCustomerId() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "delete from customer where customer_id = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Customer Id: ");
        int delete = scan.nextInt();
        pst.setInt(1,delete);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    /**
     *
     * @throws SQLException
     */
    public static void deleteOnExpireDate() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "delete from customer where expire_date = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Expire Date as yyyy-mm-dd: ");
        String delete = scan.next();
        Date deleteDate = Date.valueOf(delete);
        pst.setDate(1,deleteDate);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    /**
     *
     * @throws SQLException
     */
    public static void updateOnCustomerId() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "update customer set issue_date = ?, expire_date = ? where customer_id = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Customer Id:");
        int select3 = scan.nextInt();
        System.out.println("Enter new Issue Date as yyyy-mm-dd: ");
        String select1 = scan.next();
        Date selectDate1 = Date.valueOf(select1);
        System.out.println("Enter new Expire Date as yyyy-mm-dd: ");
        String select2 = scan.next();
        Date selectDate2 = Date.valueOf(select2);
        pst.setDate(1,selectDate1);
        pst.setDate(2,selectDate2);
        pst.setInt(3, select3);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    /**
     *
     * @throws SQLException
     */
    public static void updateOnIssueDate() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "update customer set issue_date = ?, expire_date = ? where issue_date = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Issue Date as yyyy-mm-dd:");
        String select3 = scan.next();
        Date selectDate3 = Date.valueOf(select3);
        System.out.println("Enter new Issue Date as yyyy-mm-dd: ");
        String select1 = scan.next();
        Date selectDate1 = Date.valueOf(select1);
        System.out.println("Enter new Expire Date as yyyy-mm-dd: ");
        String select2 = scan.next();
        Date selectDate2 = Date.valueOf(select2);
        pst.setDate(1,selectDate1);
        pst.setDate(2,selectDate2);
        pst.setDate(3, selectDate3);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    /**
     *
     * @throws SQLException
     */
    public static void insertIntoCheckedOut() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "insert into checked_out (check_out_date, return_by_date, customer_id, dewey_decimal_number) values (?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Customer Id: ");
        int select3 = scan.nextInt();
        System.out.println("Enter Check Out Date as yyyy-mm-dd: ");
        String select1 = scan.next();
        Date selectDate1 = Date.valueOf(select1);
        System.out.println("Enter Return Date as yyyy-mm-dd: ");
        String select2 = scan.next();
        Date selectDate2 = Date.valueOf(select2);
        System.out.println("Enter Dewey Number: ");
        String select4 = scan.next();
        pst.setDate(1,selectDate1);
        pst.setDate(2,selectDate2);
        pst.setInt(3,select3);
        pst.setString(4,select4);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    /**
     *
     * @throws SQLException
     */
    public static void updateInCheckedOutOnCustomerId() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "update checked_out set check_out_date = ?, return_by_date = ?, customer_id = ?, dewey_decimal_number = ? where customer_id = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Customer Id:");
        int select5 = scan.nextInt();
        System.out.println("Enter new Check Out Date as yyyy-mm-dd: ");
        String select1 = scan.next();
        Date selectDate1 = Date.valueOf(select1);
        System.out.println("Enter new Return Date as yyyy-mm-dd: ");
        String select2 = scan.next();
        Date selectDate2 = Date.valueOf(select2);
        System.out.println("Enter new Customer Id: ");
        int select3 = scan.nextInt();
        System.out.println("Enter new Dewey Number: ");
        String select4 = scan.next();
        pst.setDate(1,selectDate1);
        pst.setDate(2,selectDate2);
        pst.setInt(3, select3);
        pst.setString(4,select4);
        pst.setInt(5,select5);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    /**
     *
     * @throws SQLException
     */
    public static void deleteFromCheckedOutOnCustomerId() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "delete from checked_out where customer_id = ? and dewey_decimal_number = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Customer Id: ");
        int delete = scan.nextInt();
        System.out.print("Enter dewey_decimal_number Id: ");
        String drinkthedew = scan.next();
        pst.setInt(1,delete);
        pst.setString(2,drinkthedew);
        pst.executeUpdate();
        System.out.println("Done!");
    }
    
    /**
     *
     * @throws SQLException
     */
    public static void selectFromCheckedOutOnCustomerId() throws SQLException
    {
        Connection connection = DriverManager.getConnection(jdbcurl,user,pass);
        String st = "select * from checked_out where customer_id = ?";
        PreparedStatement pst = connection.prepareStatement(st);
        System.out.print("Enter Customer Id: ");
        int select = scan.nextInt();
        pst.setInt(1,select);
        ResultSet rs1 = pst.executeQuery();
        while(rs1.next())
        {
            System.out.println("Check Out Date: "+rs1.getDate("check_out_date"));
            System.out.println("Return By Date: "+rs1.getDate("return_by_date"));
            System.out.println("Customer Id: "+rs1.getInt("customer_id"));
            System.out.println("Dewey Number: "+rs1.getString("dewey_decimal_number"));
            System.out.println("\n");
        }
    }
}
