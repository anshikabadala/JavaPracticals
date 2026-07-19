class Thermostat{
    private String location;
    private int temperature;
    private static final int MIN = 16;
    private static final int MAX = 30;

    private static int activecount = 0;

    public Thermostat(String location, int starttemp){
        this.location = location;

        if(starttemp >= MIN && starttemp <= MAX){
            this.temperature = starttemp;
        }else{
            this.temperature = 22;
        }
        activecount++;
    }
    public Thermostat(String location){
        this(location, 22);
    }

    public void raise(){
        if(temperature < MAX){
            temperature++;
        }else{
            System.out.println("Already maximum at 30");
        }
    }
     public void lower(){
        if(temperature > MIN){
            temperature--;
        }else{
            System.out.println("Already minimum at 16");
        }
    }

    public int gettemperature(){
        return temperature;
    }

    public static int getactivecount(){
        return activecount;
    }

    public static void main(String[] args){

        Thermostat t1 = new Thermostat("Room");
        Thermostat t2 = new Thermostat("kitchen", 25);

         System.out.println("Raising temperature of Living Room:");

        for (int i = 0; i < 10; i++) {
            t1.raise();
            System.out.println("Temperature: " + t1.gettemperature());
        }

        System.out.println("\nLowering temperature of Living Room:");

        for (int i = 0; i < 20; i++) {
            t1.lower();
            System.out.println("Temperature: " + t1.gettemperature());
        }



    }
}