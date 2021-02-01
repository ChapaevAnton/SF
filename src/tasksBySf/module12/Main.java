package tasksBySf.module12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Заводим счет на бирже
        StockAccount stockAccount = new StockAccount();
        //Счет начинает работать
        stockAccount.start();
        //Прибыль
        long profit = 0;
        //блок управления
        Scanner in = new Scanner(System.in);
        String command = "";
        while (!command.equals("exit")) {
            command = in.next();
            switch (command) {
                case "check":
                    System.out.println(stockAccount.money);
                    break;
                case "fix":
                    // фиксируем прибыль
                    profit += (long) stockAccount.money - 1000;
                    System.out.print("Profit is " + profit);
                    //на счету остается минимальный остаток
                    stockAccount.money = 1000;
            }
        }
    }
}
