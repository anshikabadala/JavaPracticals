
public class driver {

    public static void main(String[] args) {

        String msg = "Hi {name}! Your order number is {id} and it will be delivered on {date}.";

        String[] keys = {"name", "id", "date"};
        String[] data = {"Anshika", "ORD27", "18 August"};

        for (int i = 0; i < keys.length; i++) {
            msg = msg.replace("{" + keys[i] + "}", data[i]);
        }

        System.out.println("----- Order Details -----");
        System.out.println(msg);
    }
}