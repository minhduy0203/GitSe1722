/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPrj.Classes.Com;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MinhDuy
 */
public class Menu {

    public <E> int int_getChoice(ArrayList<E> options) {
        int respone;
        int n = options.size();
        System.out.println("=========================");
        for (int i = 0; i < n; i++) {
            System.out.println("Option " + (i + 1) + ": " + options.get(i));
        }
        System.out.println("Please choose an option 1-" + n);
        respone = new Scanner(System.in).nextInt();
        return respone;
    }

    public <E> E ref_getChoice(ArrayList<E> options) {
        int respone;
        int n = options.size();
        do {
            respone = int_getChoice(options);
        } while (respone < 0 || respone > n);

        return options.get(respone - 1);
    }

}
