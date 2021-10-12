package com.softwareinstitute;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("What is the height of the wall in metres?");
        int height = Integer.parseInt(input.nextLine());
        System.out.println("What is the width of the wall in metres?");
        int width = Integer.parseInt(input.nextLine());
        System.out.println("How much does a litre of paint cost in pounds?");
        float price = Float.parseFloat(input.nextLine());
        float areaToPaint = height*width;
        float paintNeeded = areaToPaint/6.0f;
        float cost = paintNeeded*price;
        System.out.println("Paint needed (in litres): " + paintNeeded);
        System.out.println("Total cost (in pounds): " + cost);
    }

}
