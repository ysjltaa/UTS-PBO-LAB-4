package jawaban3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LotreBoard game = new LotreBoard();

        System.out.println("Welcome to E-Lottery Gosok");
        game.displayBoard();

        while (!game.isGameOver()) {
            System.out.print("Masukkan tebakan anda (baris dan kolom) : ");

            // Memastikan input adalah angka
            if (scanner.hasNextInt()) {
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                boolean result = game.guess(row, col);

                if (!result) {
                    System.out.println("BOOM! Anda menemukan bom! Permainan berakhir.");
                } else if (game.isWin()) {
                    System.out.println("Selamat anda menang");
                }

                game.displayBoard();
            } else {
                System.out.println("Input harus berupa angka!");
                scanner.next(); // clear buffer
            }
        }

        scanner.close();
    }
}
