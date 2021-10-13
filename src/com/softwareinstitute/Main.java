package com.softwareinstitute;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("How many walls do you want to paint?");
        int nwalls = Integer.parseInt(input.nextLine());
        System.out.println("How much does a litre of paint cost in pounds?");
        float price = Float.parseFloat(input.nextLine());
        float totalPaintNeeded = 0;
        float totalCostPaint = 0;
        float totalArea = 0;
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
                for(int k=0; k<widthMosaic; k++) {
                    for (int j = 0; j < heightMosaic; j++) {
                        System.out.println("What color do you want tile " + k + " metres across and " + j + " metres down to be?");
                        mosaic[k][j] = input.nextLine();
                        //System.out.println("Tile " + k + " " + j + " is " + mosaic[k][j]);
                    }
                }

                printMosaic(heightMosaic, widthMosaic, mosaic);
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

            totalArea = totalArea + areaToPaint;
        }

        System.out.println("Do you want a second layer of paint? (yes/no)");
        String layers = input.nextLine();
        if(layers.equals("yes")){
            totalArea = totalArea *2;
        }
        float[] answer = paintCalculator(totalArea, price);
        totalPaintNeeded = answer[0];
        totalCostPaint = answer[1];

        String workers = "no";
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

    public static float[] paintCalculator(float totalArea, float paintPrice){
        float paintNeeded = totalArea/6.0f;
        float cost = paintNeeded*paintPrice;
        float answer[] = {paintNeeded, cost};
        return answer;

    }

    public static void printMosaic(int heightMosaic, int widthMosaic, String[][] mosaic){
        for( int j=0; j<heightMosaic; j++){
            for(int k=0; k<widthMosaic; k++){
                switch (mosaic[k][j]){
                    case "blue":
                        System.out.print(ANSI_BLUE + " tile " + ANSI_RESET);
                        break;
                    case "red":
                        System.out.print(ANSI_RED+ " tile " + ANSI_RESET);
                        break;
                    case "green":
                        System.out.print(ANSI_GREEN+ " tile " +ANSI_RESET);
                        break;
                    case "yellow":
                        System.out.print(ANSI_YELLOW + " tile " + ANSI_RESET);
                        break;
                    case "purple":
                        System.out.print(ANSI_PURPLE + " tile " + ANSI_RESET);
                        break;
                    default:
                        System.out.print(" tile ");
                        break;
                }

            }
            System.out.println();
        }
    }

}
