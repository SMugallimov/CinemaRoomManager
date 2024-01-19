package cinema;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        char SEATS = 'S';
        char BUSY = 'B';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = scanner.nextInt();
        int totalNumberOfSeats = numberOfRows * numberOfSeats;
        char[][] matrixOfSeats = new char[numberOfRows][numberOfSeats];
        for (int i = 1; i <= numberOfRows; i++) {
            for (int j = 1; j <= numberOfSeats; j++) {
                matrixOfSeats[i - 1][j - 1] = SEATS;
            }
        }
        int numberOfRow;
        int numberOfSeat;
        int numberOfFrontTickets = 0;
        int numberOfBackTickets = 0;
        int ticketPriceFront = 10;
        int ticketPriceBack = 8;
        int ticketPrice;
        int currentFrontIncome = 0;
        int currentBackIncome = 0;
        int currentIncome;
        int totalIncome = 0;
        double percentages;
        int checkRow = 0;
        int checkSeat = 0;
        boolean isExit = false;
        while (!isExit) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int menu = scanner.nextInt();
            switch (menu) {
                case 0:
                    isExit = true;
                    break;
                case 1:
                    System.out.println("\nCinema:");
                    System.out.print("  ");
                    for (int i = 1; i <= numberOfSeats; i++) {
                        System.out.printf("%2d", i);
                    }
                    System.out.println();
                    for (int i = 1; i <= numberOfRows; i++) {
                        System.out.printf("%2d", i);
                        for (int j = 1; j <= numberOfSeats; j++) {
                            System.out.print(" " + matrixOfSeats[i - 1][j - 1]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 2:
                    while (true) {
                        System.out.println("\nEnter a row number:");
                        numberOfRow = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        numberOfSeat = scanner.nextInt();
                        if (checkRow == numberOfRow && checkSeat == numberOfSeat) {
                            System.out.println("\nThat ticket has already been purchased!");
                        }
                        else if (numberOfRows >= numberOfRow && numberOfSeats >= numberOfSeat) {
                            for (int i = 1; i <= numberOfRows; i++) {
                                for (int j = 1; j <= numberOfSeats; j++) {
                                    if (i == numberOfRow && j == numberOfSeat) {
                                        matrixOfSeats[i - 1][j - 1] = BUSY;
                                        //numberOfTickets++;
                                        checkRow = numberOfRow;
                                        checkSeat = numberOfSeat;
                                    }
                                }
                            }
                            break;
                        }
                        else {
                            System.out.println("\nWrong input!");
                        }
                    }
                    if (totalNumberOfSeats <= 60) {
                        numberOfFrontTickets++;
                        currentFrontIncome = ticketPriceFront * numberOfFrontTickets;
                        ticketPrice = ticketPriceFront;
                    }
                    else if (numberOfRows % 2 != 0 && (numberOfRows - numberOfRow) > numberOfRow) {
                        numberOfFrontTickets++;
                        currentFrontIncome = ticketPriceFront * numberOfFrontTickets;
                        ticketPrice = ticketPriceFront;
                    }
                    else {
                        numberOfBackTickets++;
                        currentBackIncome = ticketPriceBack * numberOfBackTickets;
                        ticketPrice = ticketPriceBack;
                    }
                    System.out.printf("\nTicket price: $%d\n", ticketPrice);
                    break;
                case 3:
                    int numberOfTickets = numberOfFrontTickets + numberOfBackTickets;
                    System.out.printf("\nNumber of purchased tickets: %d\n", numberOfTickets);

                    percentages = (double) (numberOfTickets * 100) / totalNumberOfSeats;
                    System.out.printf("Percentage: %.2f%s", percentages, "%\n");

                    currentIncome = currentFrontIncome + currentBackIncome;
                    System.out.printf("Current income: $%d\n", currentIncome);

                    if (totalNumberOfSeats <= 60) {
                        totalIncome = totalNumberOfSeats * ticketPriceFront;
                    } else if ((totalNumberOfSeats > 60) && (numberOfRows % 2 == 0)) {
                        totalIncome = (((numberOfRows / 2) * numberOfSeats) * ticketPriceFront) +
                                (((numberOfRows / 2) * numberOfSeats) * ticketPriceBack);
                    } else if ((totalNumberOfSeats > 60) && (numberOfRows % 2 != 0)) {
                        totalIncome = (((numberOfRows / 2) * numberOfSeats) * ticketPriceFront) +
                                ((((numberOfRows + 1) / 2) * numberOfSeats) * ticketPriceBack);
                    }
                    System.out.printf("Total income: $%d\n", totalIncome);
                    break;
            }
        }
    }
}