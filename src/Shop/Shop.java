package Shop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Shop implements Profit {

    public String name;
    private ArrayList<Good> goods;
    private ArrayList<Cashier> cashiers;
    private ArrayList<CashReciept> cashReciepts;

    public Shop(String name) {
        this.name = name;
        this.goods = new ArrayList<>();
        this.cashiers = new ArrayList<>();
        this.cashReciepts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCashier(Cashier cashier){
        cashiers.add(cashier);
    }

    public int goodsInStock(Good good){
        int cnt = 0;
        for(Good buyedGood : goods){
            if(buyedGood.getName().equals(good.getName())){
                cnt++;
            }
        }
        return cnt;
    }

    public void addGoods(Good good, int quantity){
        for(int i=0;i<quantity;i++){
            goods.add(good);
        }
    }

    public void removeGoods(Good good, int quantity){
        for(int i=0;i<quantity;i++){
            goods.remove(good);
        }
    }

    public void showTotalProfit(){
        System.out.println(totalProfit());
    }


    @Override
    public double totalProfit() {
        double sum = 0;
        for(CashReciept cashReciept : cashReciepts){
            sum += cashReciept.totalProfit();
        }

        return sum;
    }

    public synchronized void writeFiles(CashReciept cashReciept){
        String outpFilename = cashReciept.idToString();
        try (FileWriter fout = new FileWriter(new File(outpFilename),false)){

            if(this != null){
                fout.append(cashReciept.toString() + System.lineSeparator());
                fout.close();
            }
        } catch (IOException e) {
            System.out.println("IOException "+ e);
        }
    }

    public void ReadFiles(String name){
        try{
            File input = new File(name);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
            System.out.println();
        }catch (FileNotFoundException e){
            System.out.println("Error!!!");
        }
    }
}
