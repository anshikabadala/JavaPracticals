import java.util.Scanner;
class Tollbooth
{
    record Vehicle(String number,String type) {}
    public static void main(String args[])
    {
    int total=0, carcount = 0, bikecount = 0, truckcount=0;
    Scanner s = new Scanner(System.in);
    while(true)
    {
        System.out.println("Enter the Vehicle number or done to finish :");
        String number = s.nextLine().trim();
        if(number.equalsIgnoreCase("done"))
            break;
        System.out.println("Enter the type of Vehicle");
        String type = s.nextLine().trim().toLowerCase();
        Vehicle vehicle = new Vehicle(number,type);
        int toll=0;
        switch(vehicle.type())
        {
            case "bike": toll=20;break;
            case "car": toll=50; break;
            case "truck": toll=150;break;
            default: System.out.println("Invalid input."); break;
        };

total+=toll;
switch(vehicle.type())
{
    case "bike": bikecount++;break;
    case "car": carcount++; break;
    case "truck": truckcount++; break;
    default : { }
}
 }
        System.out.println("Total toll: " + total);
        String mostFrequent;
        if (carcount >= bikecount && carcount >= truckcount) {
            mostFrequent = "car";
        } else if (truckcount >= bikecount) {
            mostFrequent = "truck";
        } else {
            mostFrequent = "bike";
        }
        System.out.println("Most frequent: " + mostFrequent);
        s.close();
    
    }
}
