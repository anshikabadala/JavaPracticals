import java.util.*;

public class CinemaShow {

    private String movie;
    private int seats;
    private final int capacity;
    private static int totalBooked = 0;

    public CinemaShow(String movie, int capacity) {
        this.movie = movie;
        this.capacity = capacity;
        seats = capacity;
    }

    public CinemaShow(String movie) {
        this(movie, 100);
    }

    public boolean book(int num) {
        if (num <= seats) {
            seats -= num;
            totalBooked += num;
            return true;
        }
        return false;
    }

    public void cancel(int num) {
        seats += num;

        if (seats > capacity) {
            seats = capacity;
        }

        totalBooked -= num;
    }

    public int getSeats() {
        return seats;
    }

    public static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie name: ");
        String name = sc.nextLine();

        System.out.print("Enter capacity: ");
        int cap = sc.nextInt();

        CinemaShow c = new CinemaShow(name, cap);

        while (true) {

            System.out.println("\n1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Show Seats");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.print("Enter tickets: ");
                    int b = sc.nextInt();

                    if (c.book(b))
                        System.out.println("Booking Successful");
                    else
                        System.out.println("Booking Failed");

                    break;

                case 2:
                    System.out.print("Enter tickets to cancel: ");
                    int x = sc.nextInt();

                    c.cancel(x);
                    System.out.println("Ticket Cancelled");
                    break;

                case 3:
                    System.out.println("Available Seats: " + c.getSeats());
                    break;

                case 4:
                    System.out.println("Total Booked: " + CinemaShow.getTotalBooked());
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}