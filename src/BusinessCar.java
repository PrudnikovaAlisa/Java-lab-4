import java.util.Random;

public class BusinessCar extends Car {
    private int min = 450;
    private int max = 600;

    public BusinessCar(String driverName) {
        super(driverName);
        generateCar();
    }

    private void generateCar() {
        Random random = new Random();
        int randomInRange = random.nextInt(max - min + 1) + min;
        setPrice(randomInRange);
        setName("BusinessCar" + randomInRange);
    }

    @Override
    public int calculate(int hours) {
        return getPrice() * hours;
    }
}