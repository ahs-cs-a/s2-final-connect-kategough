
public class Board {

    private int rows;
    private int cols;

    /** The grid of pieces */
    private Player[][] grid;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Player[rows][cols];
        // set each cell of the board to null (empty).
        reset();

    }

    public void reset() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = null;
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    /**
     * Returns the Player whose piece occupies the given location,
     * 
     * @param row int
     * @param col int
     */
    public Player getCell(int row, int col) throws IndexOutOfBoundsException {
        if ((row < 0) || (col < 0) || (row >= rows) || (col >= cols)) {
            throw new IndexOutOfBoundsException();
        } else {
            return grid[row][col];
        }
    }

    // returns true if there are no more plays left
    public boolean boardFilled() {
        // TODO: write this
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    // Returns true if move is possible given board state.
    public boolean possibleMove(Move move) {
        // TODO: write this. Right now, it ignores filled columns, claiming any move is
        // possible
        for (int r = 0; r < rows; r++) {
            if (grid[r][move.getColumn()] == null) {
                return true;
            }
        }
        return false;

    }

    // Adds a piece to the board for a given Move
    public void addPiece(Move move) {
        // TODO: this is a test stub, you need to rewrite this.

        if (possibleMove(move)) {
            for (int r = 0; r < grid.length; r++) {
                if (grid[r][move.getColumn()] == null) {
                    grid[r][move.getColumn()] = move.getPlayer();
                    r = grid.length + 1;
                }
            }
        }
    }

    // if the board contains a winning position, returns the Player that wins.
    // Otherwise, returns null. You could ignore lastMove.

    public Player winner(Move lastMove) {
        for(int r = grid.length - 1; r >= 0; r--){
            for(int c = 0; c < grid[r].length; c++){
                Player curPlayer = grid[r][c];
                if(curPlayer != null) {
                    if(c + 3 < c && curPlayer == grid[r][c + 1] && curPlayer == grid[r][c + 2] 
                    && curPlayer == grid[r][c + 3]) {
                        return curPlayer;
                    }
                    if(r - 3 >= 0 && curPlayer == grid[r - 1][c] && curPlayer == grid[r - 2][c] 
                    && curPlayer == grid[r - 3][c]) {
                        return curPlayer;
                    }
                    if(r - 3 >= 0 && c + 3 < cols && curPlayer == grid[r - 1][c + 1] 
                    && curPlayer == grid[r - 2][c + 2] && curPlayer == grid[r - 3][c + 3]) {
                        return curPlayer;
                    }
                    if(r + 3 < rows && c + 3 < cols && curPlayer == grid[r + 1][c + 1] 
                    && curPlayer == grid[r + 2][c + 2] && curPlayer == grid[r + 3][c + 3]) {
                        return curPlayer;
                    }
                }
            }
        }
        return null;
       
    
    
}



} // end Board class
