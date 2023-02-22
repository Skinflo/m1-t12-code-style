import java.util.Scanner;

public class CalculateDeposit { // Класс лучше назвать DepositCalculator. Сейчас он начинается с глагола, как метод
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return countingParameters(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return countingParameters(amount + amount * yearRate * depositPeriod, 2);
    }

    double countingParameters(double value, int places) { // изначально метод называл rnd, подразумевая что это глагол round
        double scale = Math.pow(10, places);              // переводится как "округлить", что и делает метод
        return Math.round(value * scale) / scale;
    }

    void calculateDeposits() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt(); // объявить переменную amount лучше в блоке объявления, а здесь оставить инициализацию, как period и action
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double accumulation = 0; // эту тоже можно в блок объявления переменных выше
        if (action == 1) {
            accumulation = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            accumulation = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + accumulation);
    }

    public static void main(String[] args) {
        new CalculateDeposit().calculateDeposits();
    }
}

// в целом по коду все как учили:)
