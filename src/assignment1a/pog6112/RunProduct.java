/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment1a.pog6112;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author michael
 */
public class RunProduct 
{
    //Declarations:
    private static Scanner sc = new Scanner(System.in);
    private static String launch;
    private static String choice;
    private static String NotFound;
    private static Product prod = new Product();
    //End of Declarations
    
    public static void main(String[] args) 
    {
        prod.AutoCapture();
                System.out.println("""
                                            EXTREME IT PRODUCTS 
                            ****************************************************************
                            1.Enter (1) to launch main menu 
                            2.Enter any other key to exit""");
        launch = sc.nextLine();
        if (!launch.equals("1")) {
            prod.ExitApplication();
        } else {
            while (true) {
                prod.DisplayMenu();
                choice = sc.nextLine();
                if (choice.equals("6")) 
                {
                    prod.ExitApplication();
                    break;
                }
                
                switch (choice) {
                    /*
                            (1) Capture a new product
                            (2) Search for a product
                            (3) Update a product
                            (4) Delete a product
                            (5) Print report
                            (6) Exit Application.
                    */
                    case "1":
                        prod.CaptureProduct();
                        break;
                    case "2":
                        prod.SearchProduct();
                        break;
                    case "3":
                        prod.UpdateProduct();
                        break;
                    case "4":
                        prod.DeleteProduct();
                        break;
                    case "5":
                        prod.PrintReport();
                        break;
                    case "6":
                        prod.ExitApplication();
                        break;

                    default:
                        break;
                }
            }
        }
    }
    
}
