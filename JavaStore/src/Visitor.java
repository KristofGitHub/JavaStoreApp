import java.util.Scanner;       // Библиотека для ввода данных с консоли
import java.util.*;             // Библиотека для работы со списками ArrayList
public class Visitor {
    public ArrayList<String> defaultSettings(){
        ArrayList<String> ourVisitors = new ArrayList<String>();
        String start = "User1";
        ourVisitors.add("1");
        ourVisitors.add(start);
        ourVisitors.add(start);
        String start2 = "VitЁk";
        ourVisitors.add(start2);
        ourVisitors.add("2");
        ourVisitors.add(start2);
        ourVisitors.add(start2);
        String start3 = "Stranger";
        ourVisitors.add(start3);
        ourVisitors.add("3");
        ourVisitors.add(start3);
        ourVisitors.add(start3);
        ourVisitors.add(start3);
        return ourVisitors;
    } // Конец метода defaultSettings создания дефолтной базы данных Пользователей
    public ArrayList<String> newVisitor(){
        // Инициализация начальных значений программы
        int visitorNumber = 0; // Начальное значение счётчика количества зарегистрированных Посетителей
        // Запрашиваем данные Пользователя, необходимые для создания учётной записи
        String userSurname = getUserInput("фамилию", "userSurname");
        String userName = getUserInput("имя", "userName");
        String userFatherName = getUserInput("отчество", "userFatherName");
        String userTelephoneNumber = getUserInput("номер своего телефона", "userTelephoneNumber");
        String userEmail = getUserInput("ваш email", "userEmail");
        String userLogin = getUserInput("ваш логин", "userLogin");
        String userPassword = getUserInput("ваш пароль", "userPassword");
        // Формируем массив данных Пользователя
        String[] userData = {userSurname, userName, userFatherName, userTelephoneNumber, userEmail, userLogin, userPassword};
        int userDataArrayLength = userData.length;
        // Загружаем данные Пользователя в Базу Данных Пользователей (на основе списков ArrayList)
        ArrayList<String> ourVisitors = new ArrayList<String>();
        visitorNumber++;
        String strVisitorNumber = Integer.toString(visitorNumber); // Конвертация целочисленной переменной в строковую
        ourVisitors.add(strVisitorNumber);
        for(int i = 0; i < userDataArrayLength; i++) ourVisitors.add(userData[i]);
        System.out.println("Поздравляем, " + ourVisitors.get(1) + " " + ourVisitors.get(2) +
                            ", ваша учётная запись успешно создана!");
        return ourVisitors;
    } // Конец метода newVisitor создания новой учетной записи Пользователя
    public void regVisitor(String login, String password, ArrayList<String> ourVisitors){
        int exitFlag = 0;
        if (ourVisitors.contains(login))
            if (ourVisitors.contains(password)) {
                System.out.println("Пароль и логин верны.");
                System.out.println("Вы находитесь в своей учётной записи.");
                System.out.println("Для просмотра каталога товаров нажмите 3. Для завершения введите любую другую цифру.");
                Scanner console = new Scanner(System.in);
                int userAction = console.nextInt();
                if (userAction == 3){
                    Product catalogue = new Product();
                    ArrayList<String> myCatalogue = catalogue.getCatalogue("Surprise!!!","$0.99");
                    catalogue.printCatalogue(myCatalogue);
                    System.out.println("Для осуществления покупки свяжитесь с нами: javastore@gmail.com");
                    System.out.println("");
                    while (exitFlag == 0){
                        System.out.println("Для выхода нажмите q");
                        Scanner consoleOut = new Scanner(System.in);
                        String outAction = consoleOut.nextLine();
                        if (outAction.equals("q")) exitFlag = 1;
                    }  // Конец цикла while
                }  // Конец оператора ветвления if
                else System.out.println("Просмотр закончен. До свидания! Ждём вас снова!");
            } else {System.out.println("Неверный пароль или логин.");}
        else {System.out.println("Неверный пароль или логин.");}
    } // Конец метода regVisitor
    public String getUserInput(String name, String parameter){
        System.out.println("Введите " + name + ": ");
        Scanner console = new Scanner(System.in);
        String userInput = console.nextLine();
        parameter = userInput;
        return parameter;
    } // Конец метода getUserInput запроса и получения ввода Пользователя
    public static ArrayList<String> getUsersCount(ArrayList<String> ourUsers){
        ArrayList<String> stat = ourUsers;
        return ourUsers;
    } // Конец метода getUsersCount
} // Конец класса Visitor
