/**
 * Created by dusti on 11/4/2016.
 */
public class TPiece extends Tetronimo {

    public TPiece(TetrisGame pApplet) {
        super(pApplet.color(130, 13, 130), getShape(), TetrisGame.TETRIS_BOARD_WIDTH / 2 - 2, 0, pApplet);
    }

    public static int[][] getShape() {
        int[][] shape = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        return shape;
    }
}