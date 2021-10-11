package Shop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CashDesk implements Runnable{

    private Cashier cashier;
    private Shop shop;
    private CashReciept cashReciept;
    private ArrayList<Good> soldGoodsList;


    public CashDesk(Cashier cashier, Shop shop) {
        this.cashier = cashier;
        this.shop = shop;
        this.soldGoodsList = new ArrayList<>();
    }

    public void shopingCart(){
        for(Good good : soldGoodsList){
            System.out.println(soldGoodsList.toString());
        }
    }

    public void addGoodsToList(Good good, int number){
        for(int i=0;i<number;i++){
            soldGoodsList.add(good);
        }
    }

    public synchronized void sell(Good good,int requested) throws NotEnoughStock{
        if(shop.goodsInStock(good)<requested){
            throw new NotEnoughStock(requested,shop.goodsInStock(good),good);
        }
        else{
            shop.removeGoods(good,requested);
            addGoodsToList(good,requested);
        }
    }

    public synchronized CashReciept makeCashReciept(Date date){
        CashReciept cashReciept = new CashReciept(cashier,date);
        for(Good good : soldGoodsList){
            cashReciept.AddCashReciept(good);
        }
        shop.writeFiles(cashReciept);
        return cashReciept;
    }


    @Override
    public void run() {
        DateFormat dateF = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateObj = new Date();
        System.out.println(Thread.currentThread().getName()+"Started! ");
        System.out.println(dateF.format(dateObj));

        System.out.println(shop.getName()+"Cashier: "+cashier.getName() + "\n Total price: "
                + makeCashReciept(dateObj).totalProfit());
        soldGoodsList.removeAll(soldGoodsList);
        System.out.println(Thread.currentThread().getName()+" Finished!");

    }
}
