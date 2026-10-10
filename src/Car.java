public abstract class Car {
    private String name;
    private int price;
    private String driverName;

    public Car(String driverName) {
        this.driverName = driverName;
    }
    
    public abstract int calculate(int hours);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}