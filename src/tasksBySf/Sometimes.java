package tasksBySf;

public class Sometimes {
    public static void main(String[] args) {
        String user1 = "иван";
        String user2 = "Иван Иванов";
        checkUserName(user1, user2);
    }

    public static void checkUserName(String user1, String user2) {
        if (user1.equalsIgnoreCase(user2)) {
            System.out.println("Выберите другое имя пользователя");
        } else {
            System.out.println("Отличное имя! Ваше имя имеет длину: " + user2.length() + " символов");
            String[] symbol = user2.split(" ");
            int count = 0;
            for (int i = 0; i < symbol.length; i++){
                count += symbol[i].length();
            }
            System.out.println("А без пробелов ваше имя занимает " +count + " символов");
        }
    }
}
