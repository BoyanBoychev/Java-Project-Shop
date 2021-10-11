package Shop;

public class Good {
    private int idCnt = 0; //broqch za ID
    private int id;
    private String name;
    private double price;
    private Category category;
    private String expirationData;

    public Good(String name, double price, Category category, String expirationData) {
        idCnt++;
        this.id = idCnt;
        this.name = name;
        this.price = price;
        this.category = category;
        this.expirationData = expirationData;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public String getExpirationData() {
        return expirationData;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setExpirationData(String expirationData) {
        this.expirationData = expirationData;
    }

    @Override
    public String toString() {
        return "Good{" +
                ", \nid=" + id +
                ", \nname='" + name + '\'' +
                ", \nprice=" + price +
                ", \ncategory=" + category +
                ", \nexpirationData='" + expirationData + '\'' +
                '}';
    }
}
