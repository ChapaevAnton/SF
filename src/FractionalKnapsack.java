import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        final Item item = new Item(4, 20);
        final Item item1 = new Item(3, 18);
        final Item item2 = new Item(2, 14);

        final Item[] items = {item, item1, item2};
        //Сортировка элементов 0(т) * log(n)
        Arrays.sort(items, Comparator.comparingDouble(Item::valuePerUnitOfWeight).reversed());

        System.out.println(Arrays.toString(items));

        final int W = 7;

        int weightSoFar = 0; // аккумулируем текущий вес
        double valueSoFar = 0; // аккумулируем текущую ценность
        int currentItem = 0; // индекс текущего предмета

        while (currentItem < items.length && weightSoFar != W){
            if(weightSoFar + items[currentItem].getWeight() < W){
                //Берем объект целиком
                valueSoFar += items[currentItem].getValue();
                weightSoFar += items[currentItem].getWeight();
            }else {
                //Берем только часть объекта
                valueSoFar += ((W - weightSoFar) / (double) items[currentItem].getWeight()) * items[currentItem].getValue();
                weightSoFar = W;
            }

            currentItem++;
        }

        System.out.println("Ценность наилучшего набора " + valueSoFar);
    }
}

class Item {
    private final int weight;
    private final int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public double valuePerUnitOfWeight() {
        return value / (double) weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return "w: " + weight + ", v: " + value;
    }
}
