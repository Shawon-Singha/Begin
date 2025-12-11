package SHawon;


import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        float potato, onion,oil;  //if anyone buy 1.25 kg/liter
        float potatoTotal,onionTotal,oilTotal;

        //for 1

        System.out.print("Selling price of Potato: ");
        potato = sc.nextFloat();
        System.out.print("Total number of units potato selling  : ");
        potatoTotal = sc.nextFloat();

        System.out.print("Selling price od Onion : ");
        onion = sc.nextFloat();
        System.out.print("Total number of units onion Selling : ");
        onionTotal = sc.nextFloat();

        System.out.print("Selling price of Oil: ");
        oil = sc.nextFloat();
        System.out.print("Total number in liters oil Selling : ");
        oilTotal = sc.nextFloat();

        //for 2
        float potatoRevenue, onionRevenue,oilRevenue;

        potatoRevenue = potato * potatoTotal;
        onionRevenue = onion * onionTotal;
        oilRevenue = oil*oilTotal;

        float grossRevenue = potatoRevenue + onionRevenue + oilRevenue;


        System.out.println("\n----- Revenue Details -----");
        System.out.println("Revenue comes from potato :" +potatoRevenue);
        System.out.println("Revenue comes from Onion :" +onionRevenue);
        System.out.println("Revenue comes from oil :" +oilRevenue);

        System.out.println("Total sold price : " +grossRevenue);

        System.out.println("\n");



        // for 3
        float potato1,onion1,oil1;
        float potatoTotal1,onionTotal1,oilTotal1;

        System.out.print("Buying price of Potato: ");
        potato1 = sc.nextFloat();
        System.out.print("Total number of units potato Buying : ");
        potatoTotal1 = sc.nextFloat();

        System.out.print("Buying price of Onion : ");
        onion1 = sc.nextFloat();
        System.out.print("Total number of units onion Buying : ");
        onionTotal1 = sc.nextFloat();

        System.out.print("Buying price of Oil: ");
        oil1 = sc.nextFloat();
        System.out.print("Total number in liters oil Buying : ");
        oilTotal1 = sc.nextFloat();


        System.out.print("Enter the total transport cost : ");
        float transportCos = sc.nextFloat();


        float potatoCost1, onionCost1,oilCost1;

        potatoCost1 = potato1 * potatoTotal1;
        onionCost1 = onion1 * onionTotal1;
        oilCost1 = oil1 * oilTotal1;

        float purchaseCost = potatoCost1 + onionCost1 + oilCost1;


        System.out.println("\n----- Cost Details -----");
        System.out.println("Revenue comes from potato :" +potatoCost1);
        System.out.println("Revenue comes from Onion :" +onionCost1);
        System.out.println("Revenue comes from oil :" +oilCost1);

        System.out.println("Total sold price : " +purchaseCost);

        float netIncome = grossRevenue - (purchaseCost + transportCos);

        System.out.println("\n______Net Income Details________");
        System.out.println("Net Income : " +netIncome);


    }
}
