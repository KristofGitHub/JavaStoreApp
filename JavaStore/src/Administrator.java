import java.util.ArrayList;         // Библиотека для работы со списками ArrayList
import java.util.Scanner;           // Библиотека для ввода данных с консоли
public class Administrator {
    public ArrayList<String> defaultAdministrator() {
        int adminCount = 1;
        String strAdminCount = Integer.toString(adminCount); // Конвертация целочисленной переменной в строковую
        ArrayList<String> ourAdministrators = new ArrayList<String>();
        ourAdministrators.add(strAdminCount);
        //ourAdministrators.add("ADMIN_1");
        ourAdministrators.add("admin_login");
        ourAdministrators.add("admin_password");
        return ourAdministrators;
    } // Конец метода defaultAdministrator
    public boolean regAdministrator(String login, String password,
                                    ArrayList<String> ourAdministrators, ArrayList<String> ourUsers) {
        boolean outFlag = false;
        if (ourAdministrators.contains(login)) {     // Начало ветвления if-1.0
            if (ourAdministrators.contains(password)) {     // Начало ветвления if-1.1
                System.out.println("Пароль и логин Администратора верны.");
                System.out.println("Вы зашли как Администратор.");
                Product catalogue = new Product();     // Инициализируем Каталог
                ArrayList<String> myCatalogue = catalogue.getCatalogue("Surprise!!!", "$0.99");   // Получаем Каталог
                int exit1 = 0;
                while (exit1 == 0){
                    outFlag = true;
                    System.out.println("Чтобы:");
                    System.out.println("1 - Смотреть список товаров введите 1.");
                    System.out.println("2 - Смотреть информацию о Посетителях введите 2.");
                    System.out.println("3 - Удалить товар введите 3.");
                    System.out.println("4 - Добавить товар введите 4.");
                    System.out.println("5 - Изменить статус Пользователя введите 5.");
                    System.out.println("6 - Выйти введите q.");
                    // Ожидаем ввод Пользователя
                    Scanner adminAction = new Scanner(System.in);
                    String adminAct = adminAction.nextLine();
                    /////////////////////////////////////////////////////////////////////////////////////////////////
                    // 1 - Смотреть список товаров
                    if (adminAct.equals("1")) {     // Начало ветвления if-1.1.1
                        catalogue.printCatalogue(myCatalogue);
                        System.out.println("");
                        outFlag = false;
                        while (outFlag == false) {
                            System.out.println("Для выхода нажмите q");
                            Scanner consoleOut = new Scanner(System.in);
                            String outAction = consoleOut.nextLine();
                            if (outAction.equals("q")) outFlag = true;
                        }  // Конец цикла while
                    }  // Конец оператора ветвления if-1.1.1
                    /////////////////////////////////////////////////////////////////////////////////////////////////
                    // 2 - Смотреть информацию о Посетителях
                    if (adminAct.equals("2")) {      // Начало ветвления if-1.1.2
                        PrintUserList(ourAdministrators, "Администратор");
                        PrintUserList2(ourUsers, "Посетитель");
                    } // Конец оператора ветвления if-1.1.2
                    ////////////////////////////////////////////////////////////////////////////////////////////////
                    // 3 - Удалить товар
                    if (adminAct.equals("3")) {      // Начало ветвления if-1.1.3
                        // Печатаем каталог для удобства пользования
                        catalogue.printCatalogue(myCatalogue);
                        System.out.println("");
                        int exit = 0;
                        while (exit != 1) {        //    Начало цикла While
                            // Запрос о том, какой товар надо удалить
                            System.out.println("Введите номер удаляемого товара (для выхода - q)");
                            Scanner consoleDel = new Scanner(System.in);
                            String delNumber = consoleDel.nextLine();
                            System.out.println(delNumber);
                            // Проверяем условие выхода из цикла
                            String quit = "q";
                            if (delNumber.equals(quit)) {     // Начало ветвления if-1.1.3.1
                                exit = 1;
                                System.out.println("Вы выходите из меню удаления товаров");
                                break;
                            } // Конец ветвления if-1.1.3.1
                            int intDelNumber = Integer.parseInt(delNumber);
                            if (intDelNumber <= myCatalogue.size()) {     // Начало ветвления if-1.1.3.2
                                // Находим индексы удаляемого продукта в Каталоге
                                int index = myCatalogue.indexOf(delNumber);
                                // Удаляем продукт
                                myCatalogue.remove(index);
                                myCatalogue.remove(index);
                                myCatalogue.remove(index);
                                // Ещё раз печатаем Каталог
                                catalogue.printCatalogue(myCatalogue);
                                System.out.println("");
                            }  // Конец ветвления if-1.1.3.2
                        } // Конец цикла While
                    }  // Конец ветвления if-1.1.3
                    ////////////////////////////////////////////////////////////////////////////////////////
                    // 4 - Добавить товар
                    if (adminAct.equals("4")) {
                        System.out.println("Введите номер продукта: ");
                        Scanner consoleNum = new Scanner(System.in);
                        String index = consoleNum.nextLine();
                        myCatalogue.add(index);
                        System.out.println("Введите название продукта: ");
                        Scanner consoleName = new Scanner(System.in);
                        String name = consoleName.nextLine();
                        myCatalogue.add(name);
                        System.out.println("Введите стоимость продукта (формат: $1.54): ");
                        Scanner consoleCost = new Scanner(System.in);
                        String cost = consoleCost.nextLine();
                        myCatalogue.add(cost);
                        // Печатаем Каталог
                        catalogue.printCatalogue(myCatalogue);
                        System.out.println("");
                    } // Конец оператора ветвления if-1.5
                    ///////////////////////////////////////////////////////////////////////////////////////////
                    // 5 - Изменить статус Пользователя
                    if (adminAct.equals("5")) {
                        // Выведем на печать список Пользователей для удобства
                        PrintUserList(ourAdministrators, "Администратор");
                        System.out.println("Введите логин Пользователя, которого нужно сделать Администратором");
                        Scanner consoleLog = new Scanner(System.in);
                        String loginNewAdmin = consoleLog.nextLine();
                        ourAdministrators.add(loginNewAdmin);
                        System.out.println("Введите порядковый номер записи Пользователя");
                        Scanner consoleNum = new Scanner(System.in);
                        String numNewAdmin = consoleNum.nextLine();
                        ourAdministrators = ConvertToAdministrator(ourAdministrators, numNewAdmin, loginNewAdmin);
                        //ourAdministrators.add(passwordNewAdmin);
                        System.out.println("Пользователь " + loginNewAdmin + " сделан Администратором.");
                        while (outFlag == false) {
                            System.out.println("Для выхода нажмите q");
                            Scanner consoleOut = new Scanner(System.in);
                            String outAction = consoleOut.nextLine();
                            if (outAction.equals("q")) outFlag = true;
                        }  // Конец цикла while
                    } // Конец оператора ветвления if-1.6
                    ///////////////////////////////////////////////////////////////////////////////////////////
                    if (adminAct.equals("q")) {exit1 = 1;} // Конец оператора ветвления if-1.7
                } // Конец цикла while
            } // Конец оператора ветвления if-1.1
            else {System.out.println("Пароль и логин не верны.");}
        } // Конец ветвления if-1.0
        return outFlag;
    } // Конец метода regAdministrator
    public ArrayList<String> ConvertToAdministrator(ArrayList<String> currentAdministrators,
                                                    String numNewAdmin, String loginUser){
        currentAdministrators.add(numNewAdmin);
        currentAdministrators.add(loginUser);
        currentAdministrators.add("password");
        return currentAdministrators;
    } // Конец метода ConvertToAdministrator
    public void PrintUserList(ArrayList<String> currentUsers, String status){
        System.out.println(" ");
        System.out.println("    С   П   И   С   О   К         П   О   Л   Ь   З   О   В   А   Т   Е   Л   Е   Й");
        System.out.println("");
        System.out.println("");
        System.out.println("№ п/п   |          Логин пользователя             |          Статус пользователя");
        System.out.println("______________________________________________________________________________________");
        System.out.println("        |                                         |   ");
        // автоформатирование таблицы: алгоритм автоматического определения ширины отступов
        int length = currentUsers.size();
        int otstup1 = 41;
        int count = 0;
        for (int i = 0; i < length-1; i = i+2) {
            if (count % 2 == 0) System.out.print(currentUsers.get(i) + "       |         " + currentUsers.get(i+1));
            String str = currentUsers.get(i+1);
            int strLen = str.length();
            int otstup2 = otstup1 - 9 - strLen;
            int j = 0;
            while(otstup2 != 0){
                if (count % 2 == 0) System.out.print(" ");
                otstup2--;
            } // Конец цикла while
            if (count % 2 == 0) System.out.println("|          " + status);
            count++;
        } // Конец цикла for
        System.out.println("");
    } // Конец класса PrintUserList
    public void PrintUserList2(ArrayList<String> currentUsers, String status){
        System.out.println("______________________________________________________________________________________");
        System.out.println("        |                                         |   ");
         //автоформатирование таблицы: алгоритм автоматического определения ширины отступов
        int length2 = currentUsers.size();
        int otstup1 = 41;
        int count = 0;
        for (int i = 0; i < length2; i = i+2) {
            if (count % 2 == 0) System.out.print(currentUsers.get(i) + "       |         " + currentUsers.get(i+1));
            String str = currentUsers.get(i+1);
            int strLen = str.length();
            int otstup2 = otstup1 - 9 - strLen;
            int j = 0;
            while(otstup2 != 0){
                if (count % 2 == 0) System.out.print(" ");
                otstup2--;
            } // Конец цикла while
            if (count % 2 == 0) System.out.println("|          " + status);
            count++;
        } // Конец цикла for
        System.out.println("");
    } // Конец класса PrintUserList
}// Конец класса Administrator
