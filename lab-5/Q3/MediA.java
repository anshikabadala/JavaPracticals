import java.util.Scanner;

abstract class Media {
    String title;
    int lateDays;

    Media(String title, int lateDays) {
        this.title = title;
        this.lateDays = lateDays;
    }

    abstract double lateFee();
}

class Book extends Media {

    Book(String title, int lateDays) {
        super(title, lateDays);
    }

    @Override
    double lateFee() {
        return lateDays * 2;
    }
}

class DVD extends Media {

    DVD(String title, int lateDays) {
        super(title, lateDays);
    }

    @Override
    double lateFee() {
        return lateDays * 5;
    }
}

class Magazine extends Media {

    Magazine(String title, int lateDays) {
        super(title, lateDays);
    }

    @Override
    double lateFee() {
        return lateDays * 1;
    }
}

public class MediA {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of media: ");
        int n = sc.nextInt();

        Media[] media = new Media[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\n1. Book");
            System.out.println("2. DVD");
            System.out.println("3. Magazine");

            System.out.print("Enter media type: ");
            int choice = sc.nextInt();

            System.out.print("Enter title: ");
            String title = sc.next();

            System.out.print("Enter late days: ");
            int days = sc.nextInt();

            if (choice == 1) {
                media[i] = new Book(title, days);
            } else if (choice == 2) {
                media[i] = new DVD(title, days);
            } else if (choice == 3) {
                media[i] = new Magazine(title, days);
            } else {
                System.out.println("Invalid choice!");
                i--;
            }
        }

        double total = 0;

        System.out.println("\n----- Late Fee Details -----");

        for (int i = 0; i < media.length; i++) {

            double fee = media[i].lateFee();

            System.out.println("Title: " + media[i].title);

            if (media[i] instanceof Book) {
                System.out.println("Type: Book");
            } else if (media[i] instanceof DVD) {
                System.out.println("Type: DVD");
            } else if (media[i] instanceof Magazine) {
                System.out.println("Type: Magazine");
            }

            System.out.println("Late Fee: Rs. " + fee);

            total += fee;
        }

        System.out.println("\nTotal Late Fee = Rs. " + total);

        sc.close();
    }
}