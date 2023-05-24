import java.util.ArrayList;     // Библиотека для работы со списками ArrayList.
import java.util.Scanner;       // Библиотека для ввода данных с консоли.
public class JavaStore {
    public static void main(String[] args) {
        // ИНИЦИАЛИЗАЦИЯ ПЕРЕМЕННЫХ
        int exit = 0;                               // Определяем переменную-флаг завершения главного цикла.
        int errorCount = 0;                         // Определяем начальное ззначение счетчика ошибок авторизации.
        String login = "null";                      // Инициализируем строковую переменную login.
        String password = "null";                   // Инициализируем строковую переменную password.
        Visitor guest = new Visitor();              // Инициализируем объект guest класса Visitor.
        ArrayList<String> ourVisitors =
                guest.defaultSettings();            // Создание дефолтной базы данных Пользователей.
        Administrator admin = new Administrator();  // Создание объекта admin класса Administrator.
        admin.defaultAdministrator();
        // ПРИВЕТСТВИЕ ПОСЕТИТЕЛЯ + ИНСТРУКЦИИ
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("*   *   *   *   *   *   *   *   *   *   *   *   *    *   *   *   *   *   *");
        System.out.println(" ");
        System.out.println("Привет, дорогой Посетитель! Мы рады приветствовать тебя!");
        System.out.println("Для регистрации нажми 1, для авторизации нажми 2.");
        // Ожидаем ввод Пользователя
        while (exit != 1) {
            Scanner console = new Scanner(System.in);
            int userAction = console.nextInt();
            if (userAction == 1) {
                exit = 1;
                System.out.println("Создаём новую учётную запись...");
                ourVisitors = guest.newVisitor();
                UserAutorization(login, password, ourVisitors);
            } else if (userAction == 2) {
                exit = 1;
                System.out.println("Вход в вашу учётную запись...");
                while (errorCount != 3) {
                    System.out.println("Введите логин или email: ");
                    Scanner console1 = new Scanner(System.in);
                    login = console1.nextLine();
                    System.out.println("Введите пароль: ");
                    Scanner console2 = new Scanner(System.in);
                    password = console2.nextLine();
                    // Проверка на Администратора
                    boolean adminCheck = admin.regAdministrator(login, password,
                            admin.defaultAdministrator(),guest.defaultSettings());
                    if (adminCheck == false) {
                        // Проверка на Админа окончена. Проверяем на Пользователя
                        guest.regVisitor(login, password, guest.defaultSettings());
                        errorCount++;
                    } // Конец ветвления if
                }  // Конец цикла while
                System.out.println("Подозрительная активность. Вам отказано в доступе и ваша учётная запись заблокирована. " +
                        "Для разблокирования учетной записи обратитесь к Администратору: admin@gmail.com");
            } else {
                System.out.println("Вы ввели неверные данные. Повторите ввод.");
            } // Конец оператора ветвления
        } // Конец цикла while
    } // Конец главного метода Main
    public static void UserAutorization(String login, String password, ArrayList<String> ourVisitors){
        int errorCount = 0;
        Visitor guest = new Visitor();
        //ourVisitors = guest.defaultSettings();
        System.out.println("Вход в вашу учётную запись...");
        while (errorCount != 3) {
            System.out.println("Введите логин или email: ");
            Scanner console1 = new Scanner(System.in);
            login = console1.nextLine();
            System.out.println("Введите пароль: ");
            Scanner console2 = new Scanner(System.in);
            password = console2.nextLine();
            guest.regVisitor(login, password, ourVisitors);
            errorCount++;
        } // Конец цикла while
    } // Конец метода UserAutorization
} // Конец главного класса JavaStore