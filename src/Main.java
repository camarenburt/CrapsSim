import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int die1;
        int die2;
        int dieTotal;
        int dieSum;
        String yn;
        boolean play = false;
        boolean play2;

        System.out.println("Welcome to the Craps Simulator!");
        System.out.println("Rule 1: If the sum is 2, 3, or 12, it is called crapping out and the game is over with a loss.");
        System.out.println("Rule 2: If the sum is 7 or 11, it is called a natural and the game is over with a win.");
        System.out.println("Rule 3: For all other value, the sum becomes the point and the user makes subsequent rolls until they either roll a 7, in which case they lose, or they roll the point sum in which case they win.");

        while (!play) {
            play2 = false;
            die1 = (int) (Math.random() * 6) + 1;
            die2 = (int) (Math.random() * 6) + 1;
            dieTotal = die1 + die2;
            System.out.printf("\nRoll 1: %5d", die1);
            System.out.printf("\nRoll 2: %5d", die2);
            if (dieTotal == 7 || dieTotal == 11 ) {
                System.out.printf("\nSum: %8d", dieTotal);
                System.out.println("\nYou win!");
                System.out.println("\nPlay Again? [Y/N]");
                yn = scan.nextLine();
                if (yn.equalsIgnoreCase("N")){
                    play = true;
                }
            } else if (dieTotal == 2 || dieTotal == 3 || dieTotal == 12){
                System.out.printf("\nSum: %8d", dieTotal);
                System.out.println("\nSorry, you crapped out.");
                System.out.println("\nPlay Again? [Y/N]");
                yn = scan.nextLine();
                if (yn.equalsIgnoreCase("N")){
                    play = true;
                }
            } else {
                dieSum = dieTotal;
                System.out.printf("\nSum: %8d", dieTotal);
                System.out.println("\nReroll. You must roll a " + dieSum + " in order to win. A roll of 7 will result in a loss");
                while (!play2){
                    die1 = (int) (Math.random() * 6) + 1;
                    die2 = (int) (Math.random() * 6) + 1;
                    dieTotal = die1 + die2;
                    System.out.printf("\nRoll 1: %5d", die1);
                    System.out.printf("\nRoll 2: %5d", die2);
                    if (dieTotal == dieSum){
                        System.out.printf("\nSum: %8d", dieTotal);
                        System.out.println("\nYou win!");
                        play2 = true;
                    } else if (dieTotal == 7){
                        System.out.printf("\nSum: %8d", dieTotal);
                        System.out.println("\nSorry, you crapped out!");
                        play2 = true;
                    } else{
                        System.out.printf("\nSum: %8d", dieTotal);
                        System.out.println("\nReroll. You must roll a " + dieSum + " in order to win. A roll of 7 will result in a loss");
                    }
                }
                System.out.println("\nPlay Again? [Y/N]");
                yn = scan.nextLine();
                if (yn.equalsIgnoreCase("N")){
                    play = true;
                }
            }
        }
    }
}
