/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPrj.Classes.Com;

/**
 *
 * @author MinhDuy
 */
public class Brand{

    private String brandID, brandName, soundBar;
    private double price;

    public Brand() {
    }

    public Brand(String brandID, String brandName, String soundBar, double price) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.soundBar = soundBar;
        this.price = price;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSoundBar() {
        return soundBar;
    }

    public void setSoundBar(String soundBar) {
        this.soundBar = soundBar;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.brandID + ", " + this.brandName + ", " + this.soundBar + ": " + this.price;
    }

   

}
