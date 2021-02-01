package vasko.interfaces;

public class InterfaceRunner {
    public static void main(String[] args) {
        Priceable pizza = new Pizza("Neapolitana", 1, 20, Size.L);
        Priceable phone = new CellPhone("Motorola", "E90", 1, 250);
        Priceable fridge = new Fridge("LG", "E590", 1, 300);

        printDeliveryPrice(pizza);
        printDeliveryPrice(phone);
        printDeliveryPrice(fridge);
    }

    private static void printDeliveryPrice(Priceable del){
        System.out.println("Delivery price " + del.calcDeliveryPrice());
        System.out.println("Order price " + del.calcOrderPrice());
    }
}
