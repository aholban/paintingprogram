package com.softwareinstitute;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("What is the height of the wall in metres?");
        float height = Float.parseFloat(input.nextLine());
        System.out.println("What is the width of the wall in metres?");
        float width = Float.parseFloat(input.nextLine());
        System.out.println("Are there any windows? (yes/no)");
        String windows = input.nextLine();
        float areaToPaint = height*width;
        while(windows.equals("yes")){
            System.out.println("What is the height of the window?");
            float windowheight = Float.parseFloat(input.nextLine());
            System.out.println("What is the width of the window?");
            float windowwidth = Float.parseFloat(input.nextLine());
            areaToPaint = areaToPaint - (windowwidth * windowheight);

            System.out.println("Are there any other windows? (yes/no)");
            windows = input.nextLine();
        }

        System.out.println("How much does a litre of paint cost in pounds?");
        float price = Float.parseFloat(input.nextLine());
        float paintNeeded = areaToPaint/6.0f;
        float cost = paintNeeded*price;
        System.out.println("Paint needed (in litres): " + paintNeeded);
        System.out.println("Total cost (in pounds): " + cost);
    }

}
