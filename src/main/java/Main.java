import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет! Введите количество гостей:");
        int personCount;
        while (true) {

            if (scanner.hasNextInt()) {
               personCount = scanner.nextInt();
               if (personCount <= 1) {
                   System.out.println("Число гостей должно быть больше 1. Давайте еще раз");
               } else {
                   scanner.nextLine();
                   break;
               }
            } else {
                System.out.println("Нет, нужно число! Давайте еще раз! ");
                scanner.nextLine();
            }
        }

        String userResponce = "";
        Calculator calculator = new Calculator();

        while (!"Завершить".equalsIgnoreCase(userResponce)) {
            System.out.println("Введите название товара");
            String itemName = scanner.nextLine();
            double itemPrice;
            System.out.println("Введите цену товара, в формате хх,хх");
            while (true) {
                if (scanner.hasNextDouble()) {
                    itemPrice = scanner.nextDouble();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Нет, цена должна быть числом, в формате хх,хх." +
                            " Давайте еще раз!");
                    scanner.nextLine();
                }
            }
            Item item = new Item(itemName, itemPrice);
            calculator.addItem(item);
            System.out.println("Если желаете продолжить добавление товаров - введите любой символ. " +
                    "Если желаете закончить добавление - введите \"Завершить\". ");
            userResponce = scanner.nextLine();
        }

        System.out.println("Добавленные товары:");
        System.out.println(calculator.getItemList());

        System.out.println("Общая сумма товаров: " + Formatter.formatDoubleToString(calculator.getCurrentSum()) + "\n");

        System.out.println("Каждый  должен заплатить: " + Formatter.formatDoubleToString(calculator.getCurrentSum() / personCount));
    }
}
