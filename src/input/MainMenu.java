package input;
import java.util.Scanner;

public class MainMenu  {

    public void display() {
        int choice = 99;
        do {
            Scanner scanner = new Scanner(System.in);
//            System.out.println("Введите длину массива:");
//            if (!in.hasNextInt()) {
//                System.out.println("Введите натуральное число.");
//                in.nextLine();
//                continue;
//            }
//            length = in.nextInt();
//            if(length == 0){
//                //choice = 0;
//                //continue;
//                break;
//            } else if (length < 0) {
//                System.out.println("Введите положительное число.");
//                in.nextLine();
//                continue;
//            }
            System.out.println("Главное меню");
            System.out.println("1 - Animal");
            System.out.println("2 - Barrel");
            System.out.println("3 - Human");
            System.out.println("0 - Выход");
            System.out.print("Выберите пункт: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Некорректный ввод.");
                continue;
            }
            choice = scanner.nextInt();
            switch (choice) {
                case 1, 2, 3:
                    new ArrayCreatorMenu(choice).display();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Некорректный ввод.");
            }
        } while (choice != 0);
    }
}
