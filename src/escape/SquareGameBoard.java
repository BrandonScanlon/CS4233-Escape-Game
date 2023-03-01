package escape;

import escape.Builder.LocationInitializer;
import escape.Builder.PieceTypeDescriptor;
import escape.required.Coordinate.CoordinateType;
import escape.required.LocationType;

public class SquareGameBoard implements GameBoard {
  // Global Variables
  //******************************************************************
  private GameBoard gameBoard;
  private CoordinateType gameBoardType = CoordinateType.SQUARE;
  private int rows;
  private int cols;
  private LocationInitializer locationInitializer;
  private LocationInitializer obstacleLocations[];
  private CoordinateImpl[][] board;
  private PieceTypeDescriptor[] pieceTypeDescriptors;

  // Constructors
  //******************************************************************

  public SquareGameBoard(int cols, int rows, LocationInitializer obstacleLocations[], PieceTypeDescriptor[] pieceTypeDescriptors) {
    this.rows = ((rows == 0) ? 10000 : rows+1);
    this.cols = ((cols == 0) ? 10000 : cols+1);
    this.obstacleLocations = obstacleLocations;
    this.pieceTypeDescriptors = pieceTypeDescriptors;
    // Create game board
    board = new CoordinateImpl[this.cols][this.rows];

    // Set all locations on the game board to CLEAR to start
    for(int row = 1; row < this.rows; row++) {
      for(int col = 1; col < this.cols; col++) {
            board[col][row] = new CoordinateImpl(col, row);
            board[col][row].setLocationType(LocationType.CLEAR);
            board[col][row].setPlayer(null);
            board[col][row].setPieceName(null);
            //System.out.println(getBoardLocation(col, row).getColumn() + ", " + getBoardLocation(col, row).getRow() + " " + getBoardLocation(col, row).getLocationType());
      }
    }
    for(LocationInitializer obstacle : obstacleLocations) {
        //System.out.println("Obstacle found at: " + obstacle.x + ", " + obstacle.y);
        board[obstacle.x][obstacle.y] = new CoordinateImpl(obstacle.x, obstacle.y);
        board[obstacle.x][obstacle.y].setLocationType(obstacle.locationType);
        board[obstacle.x][obstacle.y].setPlayer(obstacle.player);
        board[obstacle.x][obstacle.y].setPieceName(obstacle.pieceName);
    }
  }

  // Methods
  //******************************************************************

  public void setBoardLocation(int row, int col, LocationInitializer locationInitializer) {
    board[col][row].setLocationType(locationInitializer.locationType);
  }

  public CoordinateImpl getBoardLocation(int col, int row) { return board[col][row]; }

  public CoordinateType getGameBoardType() { return gameBoardType; }

  public PieceTypeDescriptor[] getPieceTypeDescriptors() { return pieceTypeDescriptors; }

  public int getRows() { return this.rows; }

  public int getCols() { return this.cols; }

  public void printBoard() {
    System.out.println("******** Printing Board ********");
    for(int col = 1; col < this.cols; col++) {
      for(int row = 1; row < this.rows; row++) {
        System.out.print("(");
        System.out.print(this.board[row][col].getRow() + ", ");
        System.out.print(this.board[row][col].getColumn() + ") ");
        System.out.print(this.board[row][col].getLocationType() + " ");
        System.out.print(this.board[row][col].getPlayer() + " ");
        System.out.println(this.board[row][col].getPieceName());
      }
    }
  }
}
