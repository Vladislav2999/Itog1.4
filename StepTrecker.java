
import java.util.Scanner;

public class StepTrecker {
    int vinInDay = 10000;
    int[][] monthDayData = new int[12][30];
    Scanner scanner = new Scanner(System.in);
    Converter converter = new Converter(0.05, 0.00075);

    //метод ввода шагов за день/месяц\/
    public void saveSteps() {
        printMonth();
        int month = scanner.nextInt();
        while (month < 0 || month > 11) {
            System.out.println("Просьба повторить ввод");
            month = scanner.nextInt();
        }
        System.out.println("Выберете день за который хотите ввести данные: с 1 до 30");
        int day = scanner.nextInt();
        while (day < 1 || day > 30) {
            System.out.println("Просьба повторить ввод");
            day = scanner.nextInt();
        }
        System.out.println("Введите количество шагов!");
        int step = scanner.nextInt();
        monthDayData[month][day - 1] = step;
        System.out.println("Ваше значение сохранено!");
    }

    //метод отвечающий за вывод кол-ва шагов в месяц\/
    void stepInMonth() {
        printMonth();
        int m = scanner.nextInt();
        while (m < 0 || m > 11) {
            System.out.println("Просьба повторить ввод");
            m = scanner.nextInt();
        }
        final int[] month = monthDayData[m];
        for (int j = 0; j < monthDayData[m].length; j++) {
            System.out.println("День " + (j + 1) + ": " + month[j] + " шагов.");
        }
    }

    //   выбора вывода данных
    public void statickMenu() {
        printMenuStatick();
        int inputStatick = scanner.nextInt();
        if (inputStatick == 1) {
            stepInMonth();
        } else if (inputStatick == 2) {
            System.out.println("Общая сумма всех шагов за месяц равна: " + sumStepMonth(monthDayData));
        } else if (inputStatick == 3) {
            System.out.println("Самое большое число шагов в этом месяце составило  " + feendMaxStep(monthDayData));
        } else if (inputStatick == 4) {
            normalStepMonth(monthDayData);
        } else if (inputStatick == 5) {
            printMonth();
            int y = scanner.nextInt();
            while (y < 0 || y > 11) {
                System.out.println("Просьба повторить ввод");
                y = scanner.nextInt();
            }
            final int[] days = monthDayData[y];
            int summ = 0;
            for (int i = 0; i < days.length; i++) {
                summ = summ + days[i];
            }
            System.out.println("Выберете пункт:" +
                    "1 Пройденное расстояние в км" +
                    "2 Количество сожженных калорий");
            int vvodCon = scanner.nextInt();
            while (vvodCon < 0 || vvodCon > 11) {
                System.out.println("Просьба повторить ввод");
                vvodCon = scanner.nextInt();
            }
            converter.convert(summ, vvodCon);

        } else if (inputStatick == 6) {
            printMonth();
            bestSerias(vinInDay);
        } else {
            System.out.println("Извините. Такой команды пока нет. Необходимо выбрать из списка ");
        }
    }

    //метод на самое большое кол-во шагов за день
    public int feendMaxStep(int[][] monthDayData) {
        printMonth();
        int k = scanner.nextInt();
        while (k < 0 || k > 11) {
            System.out.println("Просьба повторить ввод");
            k = scanner.nextInt();
        }
        final int[] month1 = monthDayData[k];
        int maxStep = 0;
        for (int i = 0; i < month1.length; i++) {
            if (month1[i] > maxStep) {
                maxStep = month1[i];
            }
        }
        return maxStep;
    }

    // среднее количество шагов в месяц
    public void normalStepMonth(int[][] monthDayData) {
        printMonth();
        int n = scanner.nextInt();
        while (n < 0 || n > 11) {
            System.out.println("Просьба повторить ввод");
            n = scanner.nextInt();
        }
        final int[] monthr = monthDayData[n];
        int summ = 0;
        for (int i = 0; i < monthr.length; i++) {
            summ = summ + monthr[i];
        }
        System.out.println("Среднее количество шагов за месяц - " + summ / 30);
    }


    //метод на общее число шагов в месяц\/
    public int sumStepMonth(int monthDayData[][]) {
        printMonth(); //выберете месяц
        int x = scanner.nextInt();
        while (x < 0 || x > 11) {
            System.out.println("Просьба повторить ввод");
            x = scanner.nextInt();
        }
        final int[] days = monthDayData[x];
        int summ = 0;
        for (int i = 0; i < days.length; i++) {
            summ = summ + days[i];
        }
        return summ;
    }


    //метод за вывод меню статистики\/
    public static void printMenuStatick() {
        System.out.println("Выберете желаемую статистику:" +
                "1-Количество пройденных шагов по дням" +
                "2-Общее количество шагов за месяц;" +
                "3-Максимальное пройденное количество шагов в месяце;" +
                "4-Среднее количество шагов;" +
                "5-Пройденная дистанция (в км) и сгоревшие калории" +
                "6-Лучшая серия;");
    }

    //метод лучшей серии
    public int bestSerias(int vinInDay) {
        int x = scanner.nextInt();
        while (x < 0 || x > 11) {
            System.out.println("Просьба повторить ввод");
            x = scanner.nextInt();
        }
        final int[] monthr = monthDayData[x];
        int theBestSerias = 0;
        int allTheBestSerias = 0;
        for (int i = 0; i < monthr.length; i++) {
            if (monthr[i] >= vinInDay) {
                theBestSerias = theBestSerias + 1;
                if (allTheBestSerias < theBestSerias) {
                    allTheBestSerias = theBestSerias;
                    System.out.println("Лучшая серия " + allTheBestSerias);
                }
            } else {
                allTheBestSerias = 0;
            }
        }
        return theBestSerias;
    }

    //метод за изменение цели шагов за день\/
    public int vinDay() {
        System.out.println("Ваша цель - " + vinInDay);
        System.out.println("Изменить на:  ");
        int newVinInDay = scanner.nextInt();
        while (newVinInDay < 0 || newVinInDay > 11) {
            System.out.println("Просьба повторить ввод");
            newVinInDay = scanner.nextInt();
        }
        vinInDay = newVinInDay;
        System.out.println("Новая цель: " + newVinInDay);
        return newVinInDay;
    }

    //метод вывода выбора месяца \/
    public static void printMonth() {
        System.out.println("Выберете месяц  " +
                "0-январь" +
                "1-февраль" +
                "2-март" +
                "3-апрель" +
                "4-май" +
                "5-июнь" +
                "6-июль" +
                "7-август" +
                "8-сентябрь" +
                "9-октябрь" +
                "10-ноябрь" +
                "11-декабрь");
    }
}

