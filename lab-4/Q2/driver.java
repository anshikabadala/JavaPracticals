public class driver {

    public static void main(String[] args) {
        String[] logs = new String[] {
            "10:05 Anshika Hello there",
            "10:15 Ashu hi everyone",
            "InvalidLine"
        };

        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine();

        String report = ChatFilter.filterLogs(logs, keyword);
        System.out.print(report);
        sc.close();
    }
}