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
public class Car implements Comparable<Car> {

    private String carID, color, frameID, engineID;
    private Brand brand;

    public Car() {
    }

    public Car(String carID, Brand brand, String color, String frameID, String engineID) {
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public String getEngineID() {
        return engineID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    
    

    @Override
    public String toString() {
//        this.carID ", " + this.brand.getBrandID() + ", " + this.color + ", " + this.frameID + ", " + this.engineID
        return this.carID + ", " + this.brand.getBrandID() + ", " + this.color + ", " + this.frameID + ", " + this.engineID;
    }

    public String screenString() {
        return this.brand.toString() + "\n" + this.carID  + ", " + this.color + ", " + this.frameID + ", " + this.engineID;
    }

    @Override
    public int compareTo(Car o) {
        int d = this.brand.getBrandName().compareTo(o.brand.getBrandName());
        if (d != 0) {
            return d;
        }
        return this.brand.getBrandID().compareTo(o.brand.getBrandID());
    }

}
