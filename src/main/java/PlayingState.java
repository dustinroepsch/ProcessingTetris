import processing.core.PApplet;
import processing.core.PConstants;

/**
 * Created by dusti on 11/4/2016.
 */
public class PlayingState extends GameState {
    private int[][] gameBoard;
    int[][] testShape = {
            {0, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0}
    };
    private Tetronimo testTetronimo = new Tetronimo(pApplet.color(0, 255, 0), testShape, 9, 10);


    public PlayingState(TetrisGame pApplet) {
        super(pApplet);
        gameBoard = new int[TetrisGame.TETRIS_BOARD_HEIGHT][TetrisGame.TETRIS_BOARD_WIDTH];
        fillGameBoardWithZeros(gameBoard);
    }

    private void fillGameBoardWithZeros(int[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = 0;
            }
        }
    }

    @Override
    public void draw() {
        pApplet.clear();
        pApplet.pushMatrix();
        pApplet.scale(TetrisGame.TETRIS_BOARD_WIDTH, TetrisGame.TETRIS_BOARD_HEIGHT);
        renderBoard();
        testTetronimo.render(pApplet);
        pApplet.popMatrix();
    }

    private void renderBoard() {
        pApplet.rectMode(PConstants.CENTER);
        for (int i = 0; i < TetrisGame.TETRIS_BOARD_HEIGHT; i++) {
            for (int j = 0; j < TetrisGame.TETRIS_BOARD_WIDTH; j++) {
                pApplet.stroke(gameBoard[i][j]);
                pApplet.rect(j, i, 0, 0);
            }
        }
    }

    public void tick() {

    }

    public void keyPressed() {

    }
}
