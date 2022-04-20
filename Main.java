import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTrecker stepTrecker = new StepTrecker();

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                stepTrecker.saveSteps();

            } else if (userInput == 2) {
                stepTrecker.statickMenu();

            } else if (userInput == 3) {
                stepTrecker.vinDay();
            } else if (userInput == 0) {
                System.out.println("Программа завершена.");
                break;
            } else {
                System.out.println("Извините. Такой команды пока нет. Необходимо выбрать из списка ");
            }

        }
    }

    private static void printMenu() {
        System.out.println("Выберете действие: ");
        System.out.println("1 - Ввести количество шагов за определённый день " +
                "2 - Напечатать статистику за определённый месяц " +
                "3 - Изменить цель по количеству шагов в день " +
                "0 - Выйти из приложения ");
    }

}