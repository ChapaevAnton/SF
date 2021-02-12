package tasksBySf.module13.pizza;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Pizzeria {

    LinkedBlockingDeque<Order> orders = new LinkedBlockingDeque<>();
    final long START_TIME;

    Pizzeria() {
        START_TIME = System.currentTimeMillis();
        //запуск вагончиков
        new PizzaCar().start();
        new PizzaCar().start();
    }

    class Order {

        String pizzaName;
        long orderTime;

        public Order(String pizzaName, long orderTime) {
            this.pizzaName = pizzaName;
            this.orderTime = orderTime;
        }
    }

    class PizzaCar extends Thread {
        public void run() {
            //соблюдаем нормы труда
            while (System.currentTimeMillis() - START_TIME < 5000) {
                Order order = null;
                // самая принципиальная строка кода
                // обращение к очереди
                // если нет заказа, ждем 10 миллисекунд
                try {
                    order = orders.poll(10, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    break;
                }
                // если заказ пришел
                if (order != null) {
                    // если успеваем доставить
                    if (System.currentTimeMillis() + 500 - order.orderTime <= 750) {
                        //исполняем заказ
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            break;
                        }
                        System.out.println(order.pizzaName + " is delivered");
                    } else {
                        //отменяем заказ
                        System.out.println(order.pizzaName + " is NOT delivered");
                    }
                }
            }
        }
    }

    void order(String pizzaName) {
        try {
            orders.put(new Order(pizzaName, System.currentTimeMillis()));
        } catch (InterruptedException e) {
            return;
        }
    }
}
