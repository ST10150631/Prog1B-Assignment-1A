/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1a.pog6112;

/**
 *
 * @author michael
 */
public class ReportData 
{
    //Declarations
    private String Code;
    private String Name;
    private String Category;
    private String warranty;
    private double price;
    private int StockLvl;
    private String supplier;
    //End of Declarations
    public ReportData()
    {
    
    }

    public ReportData(String Code, String Name, String Category, String warranty, double price, int StockLvl, String supplier) {
        this.Code = Code;
        this.Name = Name;
        this.Category = Category;
        this.warranty = warranty;
        this.price = price;
        this.StockLvl = StockLvl;
        this.supplier = supplier;
    }



    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockLvl() {
        return StockLvl;
    }

    public void setStockLvl(int StockLvl) {
        this.StockLvl = StockLvl;
    }
    

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
    @Override
    public String toString()
    {
        // public Product(String Code, String Name, String Category, String warranty, double price, String supplier) 
        String msg = String.format("---------------------------------------------------------------------------\n"
                + "Product Code: %S\nProduct Name: %S\nProduct Category: %S\nPrice: R%.2f\nWarranty: %S\nIn Stock: %d\nSupplier: %S\n"
                + "---------------------------------------------------------------------------",Code, Name ,Category ,price,warranty,StockLvl,supplier);
        return msg;
    }
    
}
