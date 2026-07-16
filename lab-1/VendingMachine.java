import java.util.Scanner;
class VendingMachine {
   VendingMachine() {
   }
   public static void main(String[] var0) {
      byte var1 = 15;
      int var2 = 0;
      Scanner var3 = new Scanner(System.in);

      while(var2 < var1) {
         System.out.println("Enter the coin :");
         String var4 = var3.nextLine().trim().toUpperCase();
         Coin var5 = VendingMachine.Coin.valueOf(var4);
         byte var6 = 0;
         switch (var5.ordinal()) {
            case 0 -> var6 = 1;
            case 1 -> var6 = 2;
            case 2 -> var6 = 5;
            case 3 -> var6 = 10;
            default -> System.out.println("Invalid input.");
         }
         var2 += var6;
         System.out.println("Total so far : " + var2);
      }

      System.out.println("Paid. Change : " + (var2 - var1));
      var3.close();
   }
   static enum Coin {
      ONE,
      TWO,
      FIVE,
      TEN;
      private Coin() {
      }
   }
}

