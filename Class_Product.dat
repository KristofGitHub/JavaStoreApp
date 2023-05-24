import java.util.ArrayList;             // Библиотека для работы со списками ArrayList
public class Product {
    String name = "Surpise!!!";
    String cost = "$0.99";
    public void newProduct(String name, String cost){
        String nameProduct = name;
        String costProduct = cost;
        ArrayList<String> catalogueExample = getCatalogue(name, cost);
    } // Конец метода newProduct
    public ArrayList<String> getCatalogue(String name, String cost){
        int productCount = 1;
        ArrayList<String> ourProducts = new ArrayList<String>();
        String strProductCount1 = Integer.toString(productCount); // Конвертация целочисленной переменной в строковую
        ourProducts.add(strProductCount1);
        ourProducts.add("Котелок");
        ourProducts.add("$9.99");
        productCount++;
        String strProductCount2 = Integer.toString(productCount);
        ourProducts.add(strProductCount2);
        ourProducts.add("Монокль");
        ourProducts.add("$109.99");
        productCount++;
        String strProductCount3 = Integer.toString(productCount);
        ourProducts.add(strProductCount3);
        ourProducts.add("Колесница");
        ourProducts.add("$1999.99");
        productCount++;
        String strProductCount4 = Integer.toString(productCount);
        ourProducts.add(strProductCount4);
        ourProducts.add("Меховая шапка");
        ourProducts.add("$52.99");
        productCount++;
        String strProductCount5 = Integer.toString(productCount);
        ourProducts.add(strProductCount5);
        ourProducts.add("Мудрый совет");
        ourProducts.add("$Бесценно");
        productCount++;
        String strProductCount6 = Integer.toString(productCount);
        ourProducts.add(strProductCount6);
        ourProducts.add("Дирижабль");
        ourProducts.add("$77777");
        productCount++;
        String strProductCount7 = Integer.toString(productCount);
        ourProducts.add(strProductCount7);
        ourProducts.add(name);
        ourProducts.add(cost);
        return ourProducts;
    } // Конец метода getCatalogue
    public void printCatalogue(ArrayList<String> Catalogue){
        System.out.println(" ");
        System.out.println("    К   А   Т   А   Л   О   Г        Т   О   В   А   Р   О   В");
        System.out.println("");
        System.out.println("");
        System.out.println("№ п/п   |   Наименование товара   |          Стоимость товара");
        System.out.println("________________________________________________________________________");
        System.out.println("        |                         |   ");
        // автоформатирование таблицы: алгоритм автоматического определения ширины отступов
        int length = Catalogue.size();
        int otstup1 = 25;
        for (int i = 0; i < length; i = i+3) {
            System.out.print(Catalogue.get(i) + "       |   " + Catalogue.get(i+1));
            String str = Catalogue.get(i+1);
            int strLen = str.length();
            int otstup2 = otstup1 - 3 - strLen;
            int j = 0;
            while(otstup2 != 0){
                System.out.print(" ");
                otstup2--;
            } // Конец цикла while
            System.out.println("|          " + Catalogue.get(i+2));
        } // Конец цикла for
        System.out.println("");
    } // Конец метода printCatalogue
} // Конец класса Product
