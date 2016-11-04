/**
 * Created by dusti on 11/4/2016.
 */
public class SPiece extends Tetronimo {

    public SPiece(TetrisGame pApplet) {
        super(pApplet.color(11, 183, 36), getShape(), TetrisGame.TETRIS_BOARD_WIDTH / 2 - 2, 0, pApplet);
    }

    public static int[][] getShape() {
        int[][] shape = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        return shape;
    }
}
