/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPrj.Classes.Com;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author MinhDuy
 */
public class BrandList extends ArrayList<Brand> {

    public BrandList() {

    }

    public boolean loadFromFile(String filename) {
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
                String[] temp = line.split(", |: ");
                String id = temp[0];
                String brandName = temp[1];
                String soundbrand = temp[2];
                double price = Double.parseDouble(temp[3]);
                Brand b = new Brand(id, brandName, soundbrand, price);
                this.add(b);
            }
            fr.close();
            br.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return true;

    }

    public boolean saveToFile(String filename) {
        try {
            File f = new File(filename);

            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Brand b : this) {
                pw.println(b);
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

    public int searchID(String bID) {
        if (this.isEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).getBrandID().compareTo(bID) == 0) {
                    return i;
                }
            }
            return -1;
        }
    }

    public Brand recevieBrand() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập brand ID");
        String id = MyLibs.inputBrandID(this);
        System.out.println("Nhập brand name");
        String brandName = MyLibs.inputNotBlank();
        System.out.println("Nhập sound bar");
        String soundBar = MyLibs.inputNotBlank();
        System.out.println("Nhập giá tiền");
        double price = MyLibs.inputNumber();
//        sc.nextLine();
        Brand newBrand = new Brand(id, brandName, soundBar, price);
        return newBrand;
    }

    public Brand getUserChoice() {
        Menu mnu = new Menu();
        return (Brand) mnu.ref_getChoice(this);
    }

    public void addBrand() {
        this.add(recevieBrand());
    }

    public void updateBrand() {
        String id = new Scanner(System.in).nextLine();
        int pos = searchID(id);
        if (pos < 0) {
            System.out.println("ID NOT FOUND");
        } else {
            this.set(pos, recevieBrand());
        }
    }

    public void listBrand() {
        if (!this.isEmpty()) {

            for (Brand brand : this) {
                System.out.println(brand);
            }
        } else {
            System.out.println("The list is empty!");
        }
    }

}
