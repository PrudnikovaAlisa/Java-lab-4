import java.util.Random;

public class EconomCar extends Car {
    private int min = 150;
    private int max = 300;

    public EconomCar(String driverName) {
        super(driverName);
        generateCar();
    }

    private void generateCar() {
        Random random = new Random();
        int randomInRange = random.nextInt(max - min + 1) + min;
        setPrice(randomInRange);
        setName("EconomCar" + randomInRange);
    }

    @Override
    public int calculate(int hours) {
        return getPrice() * hours;
    }
}