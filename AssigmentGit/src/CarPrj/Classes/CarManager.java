/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPrj.Classes;

import CarPrj.Classes.Com.BrandList;
import CarPrj.Classes.Com.CarList;
import CarPrj.Classes.Com.Menu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author MinhDuy
 */
public class CarManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] opsMenu = {"List all brand", "Add a new brand", "Search a brand based on its ID", "Update a brand",
            "Save brand to file, name brands.txt", "List all cars in ascending order of brand names",
            "List cars based on a part of an input brand name", "Add a car", "Remove a car based on its ID", "Update a car based on its ID",
            "Save cars to file, named cars.txt"};
        ArrayList<String> ops = new ArrayList<>(Arrays.asList(opsMenu));

        BrandList brandList = new BrandList();
        brandList.loadFromFile("Brands.txt");
        CarList carList = new CarList(brandList);
        carList.loadFromFile("Cars.txt");

        Menu mnu = new Menu();

        int choice;
        do {
            choice = mnu.int_getChoice(ops);
            switch (choice) {
                case 1:
                    brandList.listBrand();
                    break;
                case 2:
                    brandList.addBrand();
                    break;
                case 3:
                    String bId = sc.nextLine();
                    int index = brandList.searchID(bId);
                    if (index != -1) {
                        System.out.println("Your index of Elements " + index);
                    }
                    break;
                case 4:
                    brandList.updateBrand();
                    break;
                case 5:
                    brandList.saveToFile("Brands.txt");
                    break;
                case 6:
                    carList.listCar();
                    break;
                case 7:
                    carList.printBasedBrandName();
                    break;
                case 8:
                    carList.addCar();
                    break;
                case 9:
                    carList.removeCar();
                    break;
                case 10:
                    carList.updateCar();
                    break;
                case 11:
                    carList.saveToFile("Cars.txt");
                    break;
            }
        } while (choice > 0 && choice <= ops.size());

    }
}
