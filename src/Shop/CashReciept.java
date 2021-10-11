package Shop;

import java.util.ArrayList;
import java.util.Date;

public class CashReciept implements Profit{

    private int idCnt;
    private int id;
    private Cashier cashier;
    private Date dateAndHour;
    private ArrayList<Good> soldGoods;

    public CashReciept(Cashier cashier, Date dateAndHour) {
        idCnt++;
        this.id = idCnt;
        this.cashier = cashier;
        this.dateAndHour = dateAndHour;
        this.soldGoods = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public Date getDateAndHour() {
        return dateAndHour;
    }

    public void AddCashReciept(Good good){
        soldGoods.add(good);
    }

    public ArrayList<Good> getSoldGoods() {
        return soldGoods;
    }

    public String idToString(){
        return String.valueOf(getId());
    }

    public double Profit(){
        double sum=0;
        for(Good good: soldGoods){
            sum += good.getPrice();
        }
        return sum;
    }



    @Override
    public String toString() {
        return "CashReciept{" +
                "\nid=" + id +
                ", \ncashier=" + cashier +
                ", \ndateAndHour=" + dateAndHour +
                ", \nList of goods you bought: " + soldGoods +
                "\nTotal price: " + Profit()+
                '}';
    }

    @Override
    public double totalProfit() {
        return Profit();
    }
}
