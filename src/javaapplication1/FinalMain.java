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
public class FinalMain { public static void main(String[] args) throws SQLException {
    boolean done = false;
    Scanner scan = new Scanner(System.in);
    
    while(!done)
    {
    System.out.println("What Action Would You Like to Make?"
            + "\n Press 1 for Insert"
            + "\n Press 2 for Select"
            + "\n Press 3 for Update"
            + "\n Press 4 for Delete");
    int action = scan.nextInt();
            
    switch(action)
    {
        case 1: System.out.println("Which Table Would You Like to Insert Into?"
                + "\n Press 1 for Book"
                + "\n Press 2 for Library"
                + "\n Press 3 for Person"
                + "\n Press 4 for Employee"
                + "\n Press 5 for Customer"
                + "\n Press 6 for Book Amount"
                + "\n Press 7 for Checked Out");
        int table = scan.nextInt();
        
        switch(table)
        {
            case 1: Book.insertOnBook();
            break;
            case 2: Library.insertOnLibrary();
            break;
            case 3: Person.insert();
            break;
            case 4 : Employee.insert();
            break;
            case 5: Customer.insert();
            break;
            case 6: Book.insertOnLibrary_Book_Amount();
            break;
            case 7: Customer.insertIntoCheckedOut();
            break;
        }
        break;
        case 2: System.out.println("Which Table Would You Like To Select From?"
                + "\n Press 1 for Book"
                + "\n Press 2 for Library"
                + "\n Press 3 for Person"
                + "\n Press 4 for Employee"
                + "\n Press 5 for Customer"
                + "\n Press 6 for Book Amount"
                + "\n Press 7 for Checked Out");
        table = scan.nextInt();
            System.out.println("What Would You Like To Select On?");
        switch(table)
        {
            case 1: System.out.println(" Press 1 for Dewey Number"
                    + "\n Press 2 for Title"
                    + "\n Press 3 for Author");
            int select = scan.nextInt();
            
            switch(select)
            {
                case 1: Book.selectFromBookOnDewey_Decimal_Number();
                break;
                case 2: Book.selectFromBookOnTitle();
                break;
                case 3: Book.selectFromBookOnAuthor();
                break;
            }
            break;
            case 2: System.out.println(" Press 1 for ID"
                    + "\n Press 2 for Name"
                    + "\n Press 3 for Street Address");
            select = scan.nextInt();
            switch(select)
            {
                case 1: Library.selectFromLibaryOnLibrary_ID();
                break;
                case 2: Library.selectFromLibaryOnName();
                break;
                case 3: Library.selectFromLibaryOnLocation();
                break;
            }
            break;
            case 3: System.out.println(" Press 1 for ID"
                    + "\n Press 2 for First Name"
                    + "\n Press 3 for Last Name");
            select = scan.nextInt();
            switch(select)
            {
                case 1: Person.selectOnPersonId();
                break;
                case 2: Person.selectOnFirstName();
                break;
                case 3: Person.selectOnLastName();
                break;
            }
            break;
            case 4: System.out.println(" Press 1 for ID"
                    + "\n Press 2 for Start Date"
                    + "\n Press 3 for Home Library");
            select = scan.nextInt();
            switch(select)
            {
                case 1: Employee.selectOnEmployeeId();
                break;
                case 2: Employee.selectOnStartDate();
                break;
                case 3: Employee.selectOnHomeLibrary();
                break;
            }
            break;
            case 5: System.out.println(" Press 1 for ID"
                    + "\n Press 2 for Issue Date"
                    + "\n Press 3 for Expire Date");
            select = scan.nextInt();
            switch(select)
            {
                case 1: Customer.selectOnCustomerId();
                break;
                case 2: Customer.selectOnIssueDate();
                break;
                case 3: Customer.selectOnExpireDate();
                break;
            }
            break;
            case 6: System.out.println(" Press 1 for Library Id"
                    + "\n Press 2 for Dewey Number");
            select = scan.nextInt();
            switch(select)
            {
                case 1: Library.selectFromLibrary_Book_AmountOnLibrary_ID();
                break;
                case 2: Book.selectFromLibrary_Book_AmountOnDewey_Decimal_Number();
                break;
            }
            break;
            case 7: System.out.println("Selecting on Customer Id");
            Customer.selectFromCheckedOutOnCustomerId();
            break;
        }
        break;
        case 3: System.out.println("Which Table Would You Like to Update?"
                + "\n Press 1 for Library"
                + "\n Press 2 for Person"
                + "\n Press 3 for Employee"
                + "\n Press 4 for Customer"
                + "\n Press 5 for Book Amount"
                + "\n Press 6 for Checked Out");
        table = scan.nextInt();
            System.out.println("What Would you Like To Update On?");
        switch(table)
        {
            case 1: System.out.println(" Press 1 for Name"
                    + "\n Press 2 for Street Address"
                    + "\n Press 3 for Open Time"
                    + "\nPress 4 for Close Time");
            int select = scan.nextInt();
            switch(select)
            {
                case 1: Library.updateFromLibraryOnName();
                break;
                case 2: Library.updateFromLibraryOnLocation();
                break;
                case 3: Library.updateFromLibraryOnOpenTime();
                break;
                case 4: Library.updateFromLibraryOnCloseTime();
                break;
            }
            break;
            case 2: System.out.println(" Press 1 for Id"
                    + "\n Press 2 for First Name"
                    + "\n Press 3 for Last Name");
            select = scan.nextInt();
            switch(select)
            {
                case 1: Person.updateOnPersonId();
                break;
                case 2: Person.updateOnFirstName();
                break;
                case 3: Person.updateOnLastName();
                break;
            }
            break;
            case 3: System.out.println(" Press 1 for Id"
                    + "\n Press 2 for Home Library");
            select = scan.nextInt();
            switch(select)
            {
                case 1: Employee.updateOnEmployeeId();
                break;
                case 2: Employee.updateOnHomeLibrary();
                break;
            }
            break;
            case 4: System.out.println(" Press 1 for Id"
                    + "\nPress 2 for Issue Date");
            select = scan.nextInt();
            switch(select)
            {
                case 1: Customer.updateOnCustomerId();
                break;
                case 2: Customer.updateOnIssueDate();
                break;
            }
            break;
            case 5: System.out.println(" Press 1 for Library Id"
                    + "\n Press 2 for Dewey Number");
            select = scan.nextInt();
            switch(select)
            {
                case 1: Library.updateFromLibrary_Book_AmountOnLibrary_Id();
                break;
                case 2: Book.updateFromLibrary_Book_AmountOnDewey_Decimal_Number();
                break;
            }
            break;
            case 6: System.out.println("Updating on Customer Id");
            Customer.updateInCheckedOutOnCustomerId();
            break;
        }
        break;
        case 4:  System.out.println("Which Table Would You Like to Delete From?"
                + "\n Press 1 for Book"
                + "\n Press 2 for Library"
                + "\n Press 3 for Person"
                + "\n Press 4 for Employee"
                + "\n Press 5 for Customer"
                + "\n Press 6 for Book Amount"
                + "\n Press 7 for Checked Out");
        table = scan.nextInt();
            System.out.println("What Would You Like To Delete On?");
        switch(table)
        {
            case 1: System.out.println(" Press 1 for Dewey Number"
                    + "\n Press 2 for title");
            int select = scan.nextInt();
            switch(select)
            {
                case 1: Book.deleteRecordFromBookOnDewey_Decimal_Number();
                break;
                case 2: Book.deleteRecordFromBookOnTitle();
                break;
            }
            break;
            case 2: System.out.println(" Press 1 for Id"
                    + "\n Press 2 for Name");
            select = scan.nextInt();
            switch(select)
            {
                case 1: Library.deleteRecordFromLibraryOnLibrary_ID();
                break;
                case 2: Library.deleteRecordFromLibraryOnName();
                break;
            }
            break;
            case 3: System.out.println(" Press 1 for Id"
                    + "\n Press 2 for First Name"
                    + "\nPress 3 for Last Name");
            select = scan.nextInt();
            switch(select)
            {
                case 1: Person.deleteOnId();
                break;
                case 2: Person.deleteOnFirstName();
                break;
                case 3: Person.deleteOnLastName();
                break;
            }
            break;
            case 4: System.out.println(" Press 1 for Id"
                    + "\n Press 2 for Home Library");
            select = scan.nextInt();
            switch(select)
            {
                case 1: Employee.deleteOnEmployeeId();
                break;
                case 2: Employee.deleteOnHomeLibrary();
                break;
            }
            break;
            case 5: System.out.println(" Press 1 for Id"
                    + "\n Press 2 for Expire Date");
            select = scan.nextInt();
            switch(select)
            {
                case 1: Customer.deleteOnCustomerId();
                break;
                case 2: Customer.deleteOnExpireDate();
                break;
            }
            break;
            case 6: System.out.println(" Press 1 for Library Id"
                    + "\n Press 2 for Dewey Number");
            select = scan.nextInt();
            switch(select)
            {
                case 1: Library.deleteRecordFromLibrary_Book_AmountOnLibrary_ID();
                break;
                case 2: Book.deleteRecordFromLibrary_Book_AmountOnDewey_Decimal_Number();
                break;
            }
            break;
            case 7: System.out.println("Deleting on Customer Id");
            Customer.deleteFromCheckedOutOnCustomerId();
            break;
        }
        break;
    }
        System.out.println("Is There Anything Else You Wish To Do?"
                + "\n Press 1 for Yes"
                + "\n Press 2 for No");
        int select = scan.nextInt();
        if(select == 2)
            done = true;   
    }  
}
}
