/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPrj.Classes.Com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author MinhDuy
 */
public class CarList extends ArrayList<Car> {

    BrandList brandList = new BrandList();

    public CarList(BrandList blist) {
        this.brandList = blist;
    }

    public BrandList getBrandList() {
        return brandList;
    }

    public void setBrandList(BrandList brandList) {
        this.brandList = brandList;
    }

    public boolean loadFromFile(String filename) {
//        try {
//            File f = new File(filename);
//            if (!f.exists()) {
//                System.out.println("File " + filename + " does not exixts");
//                return false;
//            }
//            FileReader fr = new FileReader(f);
//            BufferedReader br = new BufferedReader(fr);
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] temp = line.split(", ");
//                String carID = temp[0];
//                String brandID = temp[1];
//                String color = temp[2];
//                String frameID = temp[3];
//                String engineID = temp[4];
//                int pos = brandList.searchID(brandID);
//                Brand b = brandList.get(pos);
//                Car c = new Car(carID, b, color, frameID, engineID);
//                this.add(c);
//            }
//            fr.close();
//            br.close();
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        return true;

        try {
            File f = new File(filename);
            if (!f.exists()) {
                System.out.println("File " + filename + " doee not exixts");
                return false;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
//                StringTokenizer stk = new StringTokenizer(line, ", |: ");
//                String id = stk.nextElement().toString();
//                String brandName = stk.nextElement().toString();
//                String soundbrand = stk.nextElement().toString();
//                double price = Double.parseDouble(stk.nextElement().toString());
//                Brand b = new Brand(id, brandName, soundbrand, price);
                String[] temp = line.split(", ");
                String carID = temp[0];
                String brandID = temp[1];
                String color = temp[2];
                String frameID = temp[3];
                String engineID = temp[4];
                int pos = brandList.searchID(brandID);
                Brand b = brandList.get(pos);
                Car c = new Car(carID, b, color, frameID, engineID);
                this.add(c);
            }
            fr.close();
            br.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return true;
    }

    public boolean saveToFile(String filename) {
//        try {
//            File f = new File(filename);
//            if (!f.exists()) {
//                System.out.println("File " + filename + " does not exixts");
//                return false;
//            }
//
//            FileWriter fw = new FileWriter(f);
//            PrintWriter pw = new PrintWriter(fw);
//            for (Car c : this) {
//                pw.println(c);
//            }
//        } catch (Exception e) {
//            System.out.println("Error " + e.getMessage());
//        }
//        return true;

        try {
            File f = new File(filename);

            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Car c : this) {
                pw.println(c);
            }
            System.out.println("Write to file " + filename + " is completed");
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Cannot write to file " + filename);
            System.out.println("Error reason: " + e.getMessage());
            return false;
        }

        return true;
    }

    public Car getCarInformation(String carID) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Chọn brand");
        Menu mn = new Menu();
        if (this.brandList.isEmpty()) {
            System.out.println("Không có danh sách brand");
        }
        Brand b = (Brand) mn.ref_getChoice(brandList);
        System.out.println("Nhập màu xe: ");
        String carColor = MyLibs.inputNotBlank();
        System.out.println("Nhập frame: ");
        String framID = MyLibs.inputID("frame", this);
        System.out.println("Nhập mã engine: ");
        String engineID = MyLibs.inputID("engine", this);
        return new Car(carID, b, carColor, framID, engineID);
    }

    public int searchID(String id) {
        int n = this.size();
        if (this.isEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < n; i++) {
                if (this.get(i).getCarID().compareTo(id) == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int searchFrame(String frameID) {
        int n = this.size();
        if (this.isEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < n; i++) {
                if (this.get(i).getFrameID().compareTo(frameID) == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int searchEngine(String engineID) {
        int n = this.size();
        if (this.isEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < n; i++) {
                if (this.get(i).getEngineID().compareTo(engineID) == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void addCar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Car ID: ");
        String carID = MyLibs.inputCarID(this);
        System.out.println("Chọn brand");
        Menu mn = new Menu();
        if (this.brandList.isEmpty()) {
            System.out.println("Không có danh sách brand");
            return;
        }
        Brand b = (Brand) mn.ref_getChoice(brandList);
        System.out.println("Nhập màu xe: ");
        String carColor = MyLibs.inputNotBlank();
        System.out.println("Nhập frame: ");
        String framID = MyLibs.inputID("frame", this);
        System.out.println("Nhập mã engine: ");
        String engineID = MyLibs.inputID("engine", this);
        this.add(new Car(carID, b, carColor, framID, engineID));

    }

    public void printBasedBrandName() {
        System.out.println("Nhập brand name");
        String aPartOfBrandName = new Scanner(System.in).nextLine();
        int n = this.size();
        int count = 0;

        for (Car car : this) {
            if (car.getBrand().getBrandName().indexOf(aPartOfBrandName) >= 0) {
                System.out.println(car.screenString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No car is detected");
        }
    }

    public boolean removeCar() {
        System.out.println("Nhập vào car ID");
        String id = new Scanner(System.in).nextLine();
        int pos = searchID(id);
        if (pos < 0) {
            System.out.println("Not found");
            return false;
        } else {
            this.remove(pos);

        }

        return true;

    }

    public boolean updateCar() {
        System.out.println("Nhập vào car ID");
        String id = new Scanner(System.in).nextLine();
        int pos = searchID(id);
        if (pos < 0) {
            System.out.println("NOT FOUND");
            return false;
        } else {
            Car updateCar = getCarInformation(id);
            this.set(pos, updateCar);
        }
        return true;
    }

    public void listCar() {
        Collections.sort(this);
        if (!this.isEmpty()) {

            for (Car c : this) {
                System.out.println(c.screenString());
            }
        } else {
            System.out.println("The list is empty!");
        }
    }

}
