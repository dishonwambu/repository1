/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prime;

import java.util.Scanner;

public class Prime {

    public static void main(String[] args) {

        // TODO Auto-generated method stub

        int temp, num;

        boolean isPrime = true;

        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter the number to test");
        
        num = in.nextInt();

        in.close();

        for (int i = 2; i<= num/2; i++) {

            temp = num%i;

            if (temp == 0) {

                isPrime = false;

                break;

            }

        }
            if(isPrime)

            System.out.println(num + " number is prime");

            else

                System.out.println(num + " number is not a prime");

    }

}
