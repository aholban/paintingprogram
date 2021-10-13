package com.softwareinstitute;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("How many walls do you want to paint?");
        int nwalls = Integer.parseInt(input.nextLine());
        System.out.println("How much does a litre of paint cost in pounds?");
        float price = Float.parseFloat(input.nextLine());
        float totalPaintNeeded = 0;
        float totalCostPaint = 0;
        for(int i=1; i<=nwalls; i++) {

            System.out.println("What is the height of the wall " + i + " in metres?");
            float height = Float.parseFloat(input.nextLine());
            System.out.println("What is the width of the wall " + i + " in metres?");
            float width = Float.parseFloat(input.nextLine());
            System.out.println("Do you want this wall to be a mosaic? (yes/no)");
            String isMosaic = input.nextLine();
            if(isMosaic.equals("yes")){
                int heightMosaic = Math.round(height);
                int widthMosaic = Math.round(width);
                String mosaic[][] = new String[widthMosaic][heightMosaic];
                for(int k=0; k<widthMosaic; k++)
                    for(int j=0; j<heightMosaic; j++){
                        System.out.println("What color do you want tile " +k +" metres across and " + j +" metres down to be?");
                        mosaic[k][j] = input.nextLine();
                        System.out.println("Tile " + k + " " +j +" is " +mosaic[k][j]);
                    }
            }
            System.out.println("Are there any windows? (yes/no)");
            String windows = input.nextLine();
            float areaToPaint = height * width;
            while (windows.equals("yes")) {
                System.out.println("What is the height of the window?");
                float windowheight = Float.parseFloat(input.nextLine());
                System.out.println("What is the width of the window?");
                float windowwidth = Float.parseFloat(input.nextLine());
                areaToPaint = areaToPaint - (windowwidth * windowheight);

                System.out.println("Are there any other windows? (yes/no)");
                windows = input.nextLine();
            }

            float paintNeeded = areaToPaint / 6.0f;

            System.out.println("Do you want a second layer of paint? (yes/no)");
            String layers = input.nextLine();
            if (layers.equals("yes")) {
                paintNeeded = paintNeeded * 2;
            }

            float cost = paintNeeded * price;

            totalPaintNeeded = totalPaintNeeded + paintNeeded;
            totalCostPaint = totalCostPaint + cost;
        }
        String workers = "no";
        float totalArea = totalPaintNeeded * 6.0f;
        float timeNeeded = totalArea * 10;
        float costOfWorkers = 0;
        List<Float> rates = new ArrayList<Float>();
        do{
            System.out.println("What is the worker's hourly rate?");
            rates.add(Float.parseFloat(input.nextLine()));

            System.out.println("Do you require another worker?");
            workers = input.nextLine();
        }while(workers.equals("yes"));

        timeNeeded = timeNeeded/rates.size();
        for(float rate:rates){
            costOfWorkers += rate*timeNeeded/60;
        }
        float totalCost = totalCostPaint + costOfWorkers;
        System.out.println("Cost of workers(in pounds): " +costOfWorkers);
        System.out.println("Paint needed (in litres): " + totalPaintNeeded);
        System.out.println("Cost of paint (in pounds): " + totalCostPaint);
        System.out.println("Total cost (in pounds): " + totalCost);
    }

}
