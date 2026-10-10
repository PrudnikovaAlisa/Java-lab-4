import java.util.*;

public class TaxiService {
    private final List<Car> cars = new ArrayList<>();
    private final Random random = new Random();
    private static final int WORK_DAY_HOURS = 8;
    private static final int TOTAL_CARS = 16;

    public TaxiService() {
        for (int i = 1; i <= TOTAL_CARS; i++) {
            String driver = "Driver" + i;
            if (i % 2 == 0) {
                cars.add(new BusinessCar(driver));
            } else {
                cars.add(new EconomCar(driver));
            }
        }
    }

    public void calculateWeek() {
        int totalWeek = 0;

        for (int day = 1; day <= 5; day++) {
            int totalDay = 0;
            Map<Car, Integer> dayIncome = new HashMap<>();

            System.out.println("\n--- День " + day + " ---");
            for (Car car : cars) {
                int hours = random.nextInt(WORK_DAY_HOURS) + 1;
                int income = car.calculate(hours);

                totalDay += income;
                dayIncome.put(car, income);

                System.out.printf("%s (%s): часов=%d, доход=%d%n",
                        car.getDriverName(), car.getName(), hours, income);
            }

            totalWeek += totalDay;
            System.out.println("Итого за день " + day + ": " + totalDay);

        
            if (!cars.isEmpty()) {
                Car worstCar = Collections.min(
                        dayIncome.entrySet(),
                        Comparator.comparingInt(Map.Entry::getValue)
                ).getKey();

                System.out.println("Уволен таксист: " + worstCar.getDriverName()
                        + " (доход " + dayIncome.get(worstCar) + ")");
                cars.remove(worstCar);
            }
        }

        System.out.println("\nДоход таксопарка за рабочую неделю (5 дней): " + totalWeek);
    }
}