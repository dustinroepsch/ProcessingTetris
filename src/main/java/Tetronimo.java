import processing.core.PApplet;

/**
 * Created by dusti on 11/4/2016.
 */
public abstract class Tetronimo {
    protected int color;
    protected int[][] shape;
    protected int x;
    protected int y;
    private TetrisGame pApplet;

    public Tetronimo(int color, int[][] shape, int x, int y, TetrisGame pApplet) {
        this.color = color;
        this.shape = shape;
        this.x = x;
        this.y = y;
        this.pApplet = pApplet;
    }

    public void render() {
        pApplet.stroke(color);
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j] != 0) {
                    pApplet.rect(x + j, y + i, 0, 0);
                }
            }
        }
    }

    public void fall() {
        y++;
    }

    public boolean canFall(int[][] board) {
        return checkTheoreticalPosition(this.shape, this.y + 1, this.x, board);
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

    private boolean checkTheoreticalPosition(int[][] shape, int i, int j, int[][] board) {
        for (int row = 0; row < shape.length; row++) {
            for (int col = 0; col < shape[row].length; col++) {
                if (shape[row][col] != 0) {
                    if (row + i >= TetrisGame.TETRIS_BOARD_HEIGHT) {
                        return false;
                    }
                    if (col + j < 0 || col + j >= TetrisGame.TETRIS_BOARD_WIDTH) {
                        return false;
                    }
                    if (board[row + i][col + j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean canMoveLeft(int[][] gameBoard) {
        return checkTheoreticalPosition(this.shape, y, x - 1, gameBoard);
    }

    public boolean canMoveRight(int[][] gameBoard) {
        return checkTheoreticalPosition(this.shape, y, x + 1, gameBoard);
    }

    public int[][] rotateLeftMatrix() {
        int[][] transposed = transpose(shape);
        return reverseRows(transposed);
    }

    private int[][] reverseRows(int[][] transposed) {
        int[][] reveresed = new int[transposed.length][transposed[0].length];
        for (int i = 0; i < transposed.length; i++) {
            for (int j = 0; j < transposed.length; j++) {
                reveresed[transposed.length - 1 - i][j] = transposed[i][j];
            }
        }
        return reveresed;
    }

    protected int[][] transpose(int[][] shape) {
        int[][] transposed = new int[shape[0].length][shape.length];
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                transposed[j][i] = shape[i][j];
            }
        }
        return transposed;
    }

    public boolean canRotateLeft(int[][] gameBoard) {
        return checkTheoreticalPosition(rotateLeftMatrix(), y, x, gameBoard);
    }

    public void rotateLeft() {
        this.shape = rotateLeftMatrix();
    }
}
