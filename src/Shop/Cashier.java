package Shop;

public class Cashier {
    private String name;
    private int idCnt;
    private int id;
    private double salary;

    public Cashier(String name, double salary) {
        idCnt++;
        this.id = idCnt;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }



}
