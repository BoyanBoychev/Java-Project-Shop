package Shop;

public class Main {
    public static void main(String[] args){

        Good banana = new Good("Banana",2.50,Category.FoodProduct,"25/06/2021");
        Good meatBalls = new Good("Meat Balls",7.80,Category.FoodProduct,"20/06/2021");
        Good chocoMilk = new Good("WaveChocoMilk", 1.50,Category.FoodProduct,"16/07/2021");
        Good laptop = new Good("HP 7ZHG12",1289,Category.NonFoodProduct,"none");
        Good iPhone = new Good("iPhoneXIII",2200,Category.NonFoodProduct,"none");

        Shop Lidl = new Shop("Lidl");
        Shop Technopolis = new Shop("Technopolis");


        Cashier cashier1 = new Cashier("Ivan",570);
        Cashier cashier2 = new Cashier("Elena",570);
        Cashier cashier3 = new Cashier("Dimitar",900);
        Cashier cashier4 = new Cashier("Victoria",900);

        Lidl.addCashier(cashier1);
        Lidl.addCashier(cashier2);
       // Technopolis.addCashier(cashier3);
       // Technopolis.addCashier(cashier4);

        Lidl.addGoods(banana,20);
        Lidl.addGoods(meatBalls,10);
       // Technopolis.addGoods(laptop,6);
       // Technopolis.addGoods(iPhone,4);

        CashDesk cashDesk1 = new CashDesk(cashier1, Lidl);
        CashDesk cashDesk2 = new CashDesk(cashier2,Lidl);
        CashDesk cashDesk3 = new CashDesk(cashier3,Technopolis);
        CashDesk cashDesk4 = new CashDesk(cashier4,Technopolis);



        Thread one = new Thread(cashDesk1,"First");
        Thread two = new Thread(cashDesk2,"Second");
        //Thread three = new Thread(cashDesk3,"Third");
        //Thread four = new Thread(cashDesk4,"Fourth");

        try{
            cashDesk1.sell(banana,5);
            cashDesk1.sell(meatBalls, 3);

            one.start();

            cashDesk2.sell(banana,10);
            cashDesk2.sell(meatBalls,3);

            two.start();

           // cashDesk3.sell(laptop,1);

            //three.start();

           // cashDesk4.sell(iPhone,1);

            //four.start();

        }catch (NotEnoughStock e){
            System.out.println("Error: "+e);
        }



        String FileName = "file1";
        Lidl.ReadFiles(FileName);

        String FileName2 = "file2";
        Lidl.ReadFiles(FileName2);

       // String FileName3 = "TechnopolisFile";
       // Technopolis.ReadFiles(FileName3);

       // String FileName4 = "TechnopolisFile2";
        //Technopolis.ReadFiles(FileName4);

    }
}
