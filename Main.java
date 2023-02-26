import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.Math.*;
public class Main {
    public static void main(String[] args) {
        String[][] gameBoard = new String[3][3];
        drawBoard(gameBoard);
        playerTurn(gameBoard);
    }

    public static void drawBoard(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = "-";
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void updateBoard(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void playerTurn(String[][] arr) {
        Scanner input = new Scanner(System.in);
        System.out.println("Izberi polje od 1 do 9: ");
        int pi = input.nextInt();
        if (pi == 1 && arr[0][0].equals("-")) {
            arr[0][0] = "O";
        } else if (pi == 2 && arr[0][1].equals("-")) {
            arr[0][1] = "O";
        } else if (pi == 3 && arr[0][2].equals("-")) {
            arr[0][2] = "O";
        } else if (pi == 4 && arr[1][0].equals("-")) {
            arr[1][0] = "O";
        } else if (pi == 5 && arr[1][1].equals("-")) {
            arr[1][1] = "O";
        } else if (pi == 6 && arr[1][2].equals("-")) {
            arr[1][2] = "O";
        } else if (pi == 7 && arr[2][0].equals("-")) {
            arr[2][0] = "O";
        } else if (pi == 8 && arr[2][1].equals("-")) {
            arr[2][1] = "O";
        } else if (pi == 9 && arr[2][2].equals("-")) {
            arr[2][2] = "O";
        } else {
            System.out.println("To polje je že zasedeno. Izberi ponovno.");
            playerTurn(arr);
        }
        updateBoard(arr);
        checkWinCondition(arr);
        opponentTurn(arr);
    }

    public static void opponentTurn(String[][] arr) {
        ArrayList<Integer> free = new ArrayList<Integer>();
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                counter++;
                if (arr[i][j] == "-") {
                    free.add(counter);
                }
            }
        }
        int freeSize = free.size();
        int index = (int)(Math.random() * freeSize);
        int oi = free.get(index);
        if (oi == 1) {
            arr[0][0] = "X";
        } else if (oi == 2) {
            arr[0][1] = "X";
        } else if (oi == 3) {
            arr[0][2] = "X";
        } else if (oi == 4) {
            arr[1][0] = "X";
        } else if (oi == 5) {
            arr[1][1] = "X";
        } else if (oi == 6) {
            arr[1][2] = "X";
        } else if (oi == 7) {
            arr[2][0] = "X";
        } else if (oi == 8) {
            arr[2][1] = "X";
        } else if (oi == 9) {
            arr[2][2] = "X";
        }
        updateBoard(arr);
        checkWinCondition(arr);
        playerTurn(arr);
    }

    public static void checkWinCondition(String[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == "O" && arr[i][1] == "O" && arr[i][2] == "O" ) {
                System.out.println("Player won!");
                System.exit(0);
            }
            if (arr[i][0] == "X" && arr[i][1] == "X" && arr[i][2] == "X") {
                System.out.println("Opponent won!");
                System.exit(0);
            }
        }
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[0][i] == "O" && arr[1][i] == "O" && arr[2][i] == "O") {
                System.out.println("Player won!");
                System.exit(0);
            }
            if (arr[0][i] == "X" && arr[1][i] == "X" && arr[2][i] == "X") {
                System.out.println("Opponent won!");
                System.exit(0);
            }
        }
        if (arr[0][0] == "X" && arr[1][1] == "X" && arr[2][2] == "X") {
            System.out.println("Player won!");
            System.exit(0);
        }
        if (arr[0][2] == "X" && arr[1][1] == "X" && arr[2][0] == "X") {
            System.out.println("Player won!");
            System.exit(0);
        }
        if (arr[0][0] == "O" && arr[1][1] == "O" && arr[2][2] == "O") {
            System.out.println("Opponent won!");
            System.exit(0);
        }
        if (arr[0][2] == "O" && arr[1][1] == "O" && arr[2][0] == "O") {
            System.out.println("Opponent won!");
            System.exit(0);
        }

    }
}