/**
 * Created by dusti on 11/4/2016.
 */

public class OPiece extends Tetronimo {

    public OPiece(TetrisGame pApplet) {
        super(pApplet.color(211, 211, 46), getShape(), TetrisGame.TETRIS_BOARD_WIDTH / 2 - 2, 0, pApplet);
    }

    public static int[][] getShape() {
        int[][] shape = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        return shape;
    }

    @Override
    public int[][] rotateLeftMatrix() {
        return this.shape;
    }
}
