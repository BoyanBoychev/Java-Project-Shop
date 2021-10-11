package Shop;

public class NotEnoughStock extends Exception{

    private int requested;
    private int available;
    private Good good;

    public NotEnoughStock(int requested, int available, Good good) {
        this.requested = requested;
        this.available = available;
        this.good = good;
    }

    public int getRequested() {
        return requested;
    }

    public int getAvailable() {
        return available;
    }

    public Good getGood() {
        return good;
    }

    @Override
    public String toString() {
        return "Not enough good of this: "+good.getName() + "ID: "+good.getId() +
                "available at the moment: "+available +"requested quantity: "+requested;
    }
}
