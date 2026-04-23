package jawaban3;

import java.util.Random;

public class LotreBoard {
    private char[][] board;      // tampilan (*, O, X)
    private boolean[][] revealed; // Status kotak sudah dibuka atau belum
    private int[][] data;         // 0 = aman, 1 = bom
    private final int ROWS = 4;
    private final int COLS = 5;
    private int safeCellsOpened = 0;
    private final int TOTAL_SAFE_CELLS = 18;
    private boolean hitBomb = false;

    public LotreBoard() {
        board = new char[ROWS][COLS];
        revealed = new boolean[ROWS][COLS];
        data = new int[ROWS][COLS];

        // Inisialisasi tampilan awal dengan '*'
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = '*';
                revealed[i][j] = false;
                data[i][j] = 0; // Set semua aman dulu
            }
        }
        generateBoard();
    }

    public void generateBoard() {
        Random rand = new Random();
        int bombsPlaced = 0;
        while (bombsPlaced < 2) {
            int r = rand.nextInt(ROWS);
            int c = rand.nextInt(COLS);
            if (data[r][c] == 0) {
                data[r][c] = 1; // Taruh bom
                bombsPlaced++;
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean guess(int row, int col) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            System.out.println("Koordinat di luar papan!");
            return true;
        }

        // Cek jika sudah pernah dibuka
        if (revealed[row][col]) {
            System.out.println("Kotak telah dibuka sebelumnya!");
            return true;
        }

        revealed[row][col] = true;

        if (data[row][col] == 1) {
            board[row][col] = 'X';
            hitBomb = true;
            return false; // Mengembalikan false jika kena bom
        } else {
            board[row][col] = 'O';
            safeCellsOpened++;
            System.out.println("Kotak Aman");
            return true; // Mengembalikan true jika aman
        }
    }

    public boolean isGameOver() {
        // Permainan selesai jika kena bom atau semua kotak aman terbuka
        return hitBomb || safeCellsOpened == TOTAL_SAFE_CELLS;
    }

    public boolean isWin() {
        return safeCellsOpened == TOTAL_SAFE_CELLS && !hitBomb;
    }
}
