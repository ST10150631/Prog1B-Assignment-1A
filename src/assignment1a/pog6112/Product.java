/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1a.pog6112;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author michael
 */
public class Product {

    //Declarations:
    public String aNumber;
    private static final Scanner sc = new Scanner(System.in);
    private static String PCode;
    private static String PName;
    private static String WarrantyOption;
    private static String PWarranty;
    private static Double ProdPrice;
    private static int PStock;
    private static String PSupplier;
    private static String PCategory;
    private static String CategoryNum;
    //Using an array list allows the user to enter elements without senting a finite number of elements 
    //ArrayList will also allow for ease of removal of elements
    private ArrayList<ReportData> productList;
    //End of Declarations


    //This Method will display the main menu
    public void DisplayMenu() {
        System.out.println("""
                                            EXTREME IT PRODUCTS 
                            ****************************************************************
                            Please select one of the following menu items:
                            (1) Capture a new product
                            (2) Search for a product
                            (3) Update a product
                            (4) Delete a product
                            (5) Print report
                            (6) Exit Application.""");

    }
    //This method will automatically Capture products as a test
    public void AutoCapture()
    {        
        productList = new ArrayList<>();
        String[] AutoCode = new String[]{"111","222","333"};
        String[] AutoName = new String[]{"G15","Xbox","ASUS Z"};
        String[] AutoCategoryNum = new String[]{"2","5","1"};
        String[] AutoWarrantyOption = new String[]{"2","1","2"};
        String[] AutoPrice = new String[]{"30000","7000","45000"};
        String[] AutoStock = new String[]{"12","20","5"};
        String[] AutoSupplier = new String[]{"Dell","Microsoft","Incredible connection"};
        for (int cnt =0 ; cnt<AutoCode.length;cnt++)
        {
        PCode = AutoCode[cnt];
        PName = AutoName[cnt];
        while (true) 
        {
            
            CategoryNum = AutoCategoryNum[cnt];
                if(Integer.parseInt(CategoryNum)>0 &&Integer.parseInt(CategoryNum)<7)
                        {
                            break;
                        }
        }
            switch (CategoryNum) 
            {
                case "1":
                    PCategory = "Desktop Computer";
                    break;
                case "2":
                    PCategory = "Laptop";
                    break;
                case "3":
                    PCategory = "Tablet";
                    break;
                case "4":
                    PCategory = "Printer";
                    break;
                case "5":
                    PCategory = "Gaming Console";
                    break;
                default:
                    System.out.println("Invalid Input...");
                    break;
            }
        WarrantyOption = AutoWarrantyOption[cnt];
        if (WarrantyOption.equals("1")) {
            PWarranty = "6 months";
        } else {
            PWarranty = "2 years";
        }
        PStock = Integer.parseInt(AutoStock[cnt]);
        ProdPrice = Double.parseDouble(AutoPrice[cnt]);
        PSupplier = AutoSupplier[cnt];
        SaveProduct(PCode, PName, PCategory, PWarranty, PStock, ProdPrice, PSupplier);
        }
    }

    //This method will capture all new products
    public void CaptureProduct() {
        System.out.println("""
                                                 CAPTURE A NEW PRODUCT 
                            ****************************************************************""");
        //Capturing products using scanner
        System.out.print("Enter the product Code: \n");
        PCode = sc.next();
        //Setting each variable to allow access to other classes
        System.out.print("Enter the product Name: \n");
        PName = sc.next();
        System.out.print("""
                           Select the number of the product Catagory :
                           Desktop Computer - 1
                           Laptop - 2
                           Tablet - 3
                           Printer - 4
                           Gaming Console - 5 """ + "\n >>>");
        //ProductCatNum = Scan.nextInt();
        //Category[ProductCatNum-1]
        while (true) 
        {
            
            CategoryNum = this.FormatExep(PName," Select the number of the product Catagory : ");
                if(Integer.parseInt(CategoryNum)>0 &&Integer.parseInt(CategoryNum)<7)
                        {
                            break;
                        }
        }
            //This categoryNum is used to assign the product category through a switch statement
            switch (CategoryNum) 
            {
                case "1":
                    PCategory = "Desktop Computer";
                    break;
                case "2":
                    PCategory = "Laptop";
                    break;
                case "3":
                    PCategory = "Tablet";
                    break;
                case "4":
                    PCategory = "Printer";
                    break;
                case "5":
                    PCategory = "Gaming Console";
                    break;
                default:
                    System.out.println("Invalid Input...");
                    break;
            }
        System.out.println("Indicate the product warranty. Enter (1) for 6 months or any key for 2 years. \n>>>");
        WarrantyOption = sc.next();
        if (WarrantyOption.equals("1")) 
        {
            PWarranty = "6 months";
        } else {
            PWarranty = "2 years";
        }
        //Uses the FormatExcep (Format Exception) method to ensure value is a number but only tries 1 additional time before crash
        PStock = Integer.parseInt(this.FormatExep(PName, "stock level for "));
        // Will do the same for price
        ProdPrice = Double.parseDouble(this.FormatExep(PName, "price for "));

        //will check for the supplier of the product
        System.out.println("Enter supplier for " + PName + ": ");
        PSupplier = sc.next();
        SaveProduct(PCode, PName, PCategory, PWarranty, PStock, ProdPrice, PSupplier);
        //String Code, String Name, String Category, String warranty, double price, String supplier

    }

    //This FormatExep Method will check for wether or not the input is a number for instances where this is nessecary
    public String FormatExep(String PName, String Field) 
    {
        try 
        {
            System.out.println("Enter the " + Field + PName + ": ");
            aNumber = sc.next();
            //Converting to a double covers more bases and makes this method more versitile
            Double.parseDouble(aNumber);
        } catch (NumberFormatException e) {
            System.out.println("Input must be a number...");
            System.out.println("Enter the " + Field + PName + ": ");
            aNumber = sc.next();
        }
        return aNumber;
    }

    //This SaveProduct Method will save all the products captured or updated
    public void SaveProduct(String Code, String Name, String Category, String warranty, int Stock, double price, String supplier) 
     {
        ReportData newProduct = new ReportData();

        newProduct.setCode(Code);
        newProduct.setName(Name);
        newProduct.setCategory(Category);
        newProduct.setWarranty(warranty);
        newProduct.setStockLvl(Stock);
        newProduct.setPrice(price);
        newProduct.setSupplier(supplier);
        productList.add(newProduct);
        System.out.println(newProduct.toString());
        System.out.println("Product saved successfully>>>>");
    }

    //This SearchProduct method 
    ReportData SearchProduct() 
    {
        System.out.println("""
                           PRODUCT SEARCH
                 **********************************
                Please eneter the product code: """);
        String SearchCode = sc.next();
        System.out.println("""
                           PRODUCT SEARCH RESULTS: 
                        **********************************""");
        for (int cnt = 0; cnt < productList.size(); cnt++) 
        {
            if (productList.get(cnt).getCode().equals(SearchCode)) {
                System.out.println(productList.get(cnt).toString());
                System.out.println("**********************************");
                System.out.println("Search Sccessful");
                System.out.println("Enter any key to continue");
                return productList.get(cnt);
            }
                
        }

        return null;
    }
    //This UpdateProduct will make changes to the product arrayList allowing the user to edit specific attributes of a products
    public void UpdateProduct() 
    {
        ReportData UpProd;
        UpProd = SearchProduct();
        String Update;
        if (UpProd != null) 
        {
            System.out.println("""
                                           UPDATE PRODUCT:
                               *************************************************
                               Would you like to update the product code: 
                               Enter ("Y") for Yes 
                               Enter ("N") or any other key for No""");
            Update = sc.next();
            if (Update.equalsIgnoreCase("y")) 
            {
                System.out.println("Enter the product Code: ");
                PCode = sc.next();
                UpProd.setCode(PCode);
            }
            System.out.print("""
                               Would you like to update the product Name: 
                               Enter ("Y") for Yes 
                               Enter ("N") or any other key for No
                             """);
            Update = sc.next();
            if (Update.equalsIgnoreCase("y")) 
            {
                System.out.print("Enter the product Name: ");
                PName = sc.next();
                UpProd.setName(PName);
            }
            System.out.println("""
                               Would you like to update the product Category: 
                               Enter ("Y") for Yes 
                               Enter ("N") or any other key for No""");
            Update = sc.next();
            if (Update.equalsIgnoreCase("y")) 
            {
                System.out.println("""
                                   Select the number of the product Catagory :
                                   Desktop Computer - 1
                                   Laptop - 2
                                   Tablet - 3
                                   Printer - 4
                                   Gaming Console - 5
                                    >>>""");
                CategoryNum = sc.next();
                switch (CategoryNum) 
                {
                    case "1" : PCategory = "Desktop Computer";
                    case "2" : PCategory = "Laptop";
                    case "3" : PCategory = "Tablet";
                    case "4" : PCategory = "Printer";
                    case "5" : PCategory = "Gaming Console";
                    default : System.out.println("Invalid Input...");
                }
                UpProd.setCategory(PCategory);

            }
            System.out.println("""
                               Would you like to update the product Warranty:
                               Enter ("Y") for Yes 
                               Enter ("N") or any other key for No""");
            Update = sc.next();
            if (Update.equalsIgnoreCase("y")) 
            {
                System.out.println("Indicate the product warranty. Enter (1) for 6 months or any key for 2 years. \n>>>");
                WarrantyOption = sc.next();
                if (WarrantyOption.equals("1")) 
                {
                    PWarranty = "6 months";
                    UpProd.setWarranty(PWarranty);
                } 
                else 
                {
                    PWarranty = "2 years";
                    UpProd.setWarranty(PWarranty);
                }
            }
            System.out.println("""
                               Would you like to update the product Price: 
                               Enter ("Y") for Yes 
                               Enter ("N") or any other key for No""");
            Update = sc.next();
            if (Update.equalsIgnoreCase("y")) 
            {
                ProdPrice = Double.parseDouble(this.FormatExep(PName, "Price for "));
                UpProd.setPrice(ProdPrice);
            }
            System.out.println("""
                               Would you like to update the product Stock: 
                               Enter ("Y") for Yes 
                               Enter ("N") or any other key for No""");
            Update = sc.next();
            if (Update.equalsIgnoreCase("y")) 
            {
                PStock = Integer.parseInt(this.FormatExep(PName, "stock level for "));
                UpProd.setStockLvl(PStock);
            }
            System.out.println("""
                               Would you like to update the product Supplier: 
                               Enter ("Y") for Yes 
                               Enter ("N") or any other key for No""");
            Update = sc.next();
            if (Update.equalsIgnoreCase("y")) 
            {
                System.out.println("Enter supplier for " + PName + ": ");
                PSupplier = sc.next();
                UpProd.setSupplier(PSupplier);
            }
        } else {
            System.out.println("No Products found by that code");
        }
        

    }
    
    //This DeleteProduct will remove products from the products arrayList
    public void DeleteProduct() 
    {
       ReportData DelProd;
       String Confirm;
        DelProd = SearchProduct();
        System.out.print("Are you sure youd like to DELETE this product:"+DelProd.getName()+"\n To confirm type 'Y' for yes \nType any other character for no \n");
        Confirm = sc.next();
        if (Confirm.equalsIgnoreCase("y"))
        {
        productList.remove(DelProd);
        System.out.print("A product has beeen removed...");
        }
    }
    //This PrintReport method will use to toString method within ReportData to print a report

    public void PrintReport() 
    {
        double TotalValue = 0;
        int NumProd = 0;
        System.out.println("""
                                                       PRODUCT REPORT           
                           *****************************************************************************""");
        //This for loop will print out all products saved within the products arrayList
        for (int cnt = 0; cnt < productList.size(); cnt++) 
        {
             NumProd=cnt+1;
             TotalValue = TotalValue +productList.get(cnt).getPrice();
            System.out.println("""
                               ---------------------------------------------------------------------------
                                                       PRODUCT: """+NumProd+"\n"
                             +productList.get(cnt).toString());
            
        }
        Double AverageValue = TotalValue/NumProd;
        System.out.println("Total product value: "+NumProd);
        System.out.println("Total product value: "+TotalValue);
        System.out.println("Average product value: R"+AverageValue.intValue());
        System.out.print("Type in any key to contine: ");
        sc.next();
    }

    public void ExitApplication() {
        System.out.println("*********************************************************"
                + "Thank you for using the EXTREME IT PRODUCTS application"
                + "*********************************************************");
    }


}
