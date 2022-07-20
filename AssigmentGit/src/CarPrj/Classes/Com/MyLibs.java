/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPrj.Classes.Com;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author MinhDuy
 */
public class MyLibs {

    public static String inputID(String type, CarList list) {
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
        while (true) {
            try {
                if (!checkID(result, type, list)) {
                    System.out.println("Invalid ID");
                    throw new Exception("Invalid input");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter again: ");
                result = sc.nextLine();
            }
        }
        return result;

    }

    public static boolean checkID(String id, String type, CarList list) {

        Pattern colorPattern;
        if (type.equals("engine")) {
            for (Car car : list) {
                if (car.getFrameID().equals(id)) {
                    return false;
                }
            }

            colorPattern = Pattern.compile("E{1}[0-9]{6}");
        } else if (type.equals("frame")) {
            for (Car car : list) {
                if (car.getEngineID().equals(id)) {
                    return false;
                }
            }
            colorPattern = Pattern.compile("F{1}[0-9]{6}");
        } else {
//            colorPattern = null;
            return false;
        }

        Matcher m = colorPattern.matcher(id);
        return m.matches();

    }

    public static String inputNotBlank() {
        Scanner sc = new Scanner(System.in);
        String result;
        result = sc.nextLine();
        while (true) {
            try {
                if (result.isEmpty()) {
                    throw new InputMismatchException("Is blank");
                }
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter again");
                result = sc.nextLine();

            }
        }
        return result;
    }

    public static double inputNumber() {
        Scanner sc = new Scanner(System.in);
        String result;
        double number;
        result = sc.nextLine();
        while (true) {
            try {
                number = Double.parseDouble(result);
                if (number < 0) {
                    throw new InputMismatchException("Is it not positive number");
                }
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter again");
                result = sc.nextLine();

            }
        }
        return number;
    }

    public static String inputCarID(CarList carList) {
        Scanner sc  = new Scanner(System.in);
        String result;
        result = sc.nextLine();
        while (true) {
            try {

                for (Car car : carList) {
                    if (car.getCarID().equals(result)) {
                        throw new InputMismatchException("Your id is duplicated");
                    }
                }
                break;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter again: " );
                result = sc.nextLine();
            }
        }
        return result;
    }
    
    public static String inputBrandID(BrandList brandList) {
        Scanner sc  = new Scanner(System.in);
        String result;
        result = sc.nextLine();
        while (true) {
            try {

                for (Brand b : brandList) {
                    if (b.getBrandID().equals(result)) {
                        throw new InputMismatchException("Your id is duplicated");
                    }
                }
                break;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter again: " );
                result = sc.nextLine();
            }
        }
        return result;
    }

}
