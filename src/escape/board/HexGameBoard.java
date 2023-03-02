package escape.board;

import escape.coordinate.CoordinateImpl;
import escape.builder.LocationInitializer;
import escape.builder.PieceTypeDescriptor;
import escape.required.Coordinate.CoordinateType;
import escape.required.LocationType;

public class HexGameBoard implements GameBoard {
  // Global Variables
  //******************************************************************
  private GameBoard gameBoard;
  private CoordinateType gameBoardType = CoordinateType.HEX;
  private int rows;
  private int cols;
  private LocationInitializer locationInitializer;
  private LocationInitializer obstacleLocations[];
  private CoordinateImpl[][] board;
  private PieceTypeDescriptor[] pieceTypeDescriptors;

  // Constructors
  //******************************************************************

  public HexGameBoard(int cols, int rows, LocationInitializer obstacleLocations[], PieceTypeDescriptor[] pieceTypeDescriptors) {
    this.rows = (rows == 0) ? 2147483647 : rows;
    this.cols = (cols == 0) ? 2147483647 : cols;
    this.obstacleLocations = obstacleLocations;
    this.pieceTypeDescriptors = pieceTypeDescriptors;

    // Create game board
    board = new CoordinateImpl[cols][rows];

    if(this.rows == 10000 && this.cols == 10000) {
      // Set all locations on the game board to CLEAR to start
      for(int row = ((rows*-1)/2); row < (this.rows)/2; row++) {
        for(int col = ((cols*-1)/2); col < (this.cols)/2; col++) {
          board[col][row] = new CoordinateImpl(col, row);
          board[col][row].setLocationType(LocationType.CLEAR);
          board[col][row].setPlayer(null);
          board[col][row].setPieceName(null);
          //System.out.println(getBoardLocation(col, row).getColumn() + ", " + getBoardLocation(col, row).getRow() + " " + getBoardLocation(col, row).getLocationType());
        }
      }
    } else if(this.rows == 10000) {
      // Set all locations on the game board to CLEAR to start
      for(int row = ((rows*-1)/2); row < (this.rows)/2; row++) {
        for(int col = 1; col < (this.cols)/2; col++) {
          board[col][row] = new CoordinateImpl(col, row);
          board[col][row].setLocationType(LocationType.CLEAR);
          board[col][row].setPlayer(null);
          board[col][row].setPieceName(null);
          //System.out.println(getBoardLocation(col, row).getColumn() + ", " + getBoardLocation(col, row).getRow() + " " + getBoardLocation(col, row).getLocationType());
        }
      }
    } else if(this.cols == 10000) {
      // Set all locations on the game board to CLEAR to start
      for(int row = 1; row < (this.rows)/2; row++) {
        for(int col = ((cols*-1)/2); col < (this.cols)/2; col++) {
          board[col][row] = new CoordinateImpl(col, row);
          board[col][row].setLocationType(LocationType.CLEAR);
          board[col][row].setPlayer(null);
          board[col][row].setPieceName(null);
          //System.out.println(getBoardLocation(col, row).getColumn() + ", " + getBoardLocation(col, row).getRow() + " " + getBoardLocation(col, row).getLocationType());
        }
      }
    } else {
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
  public void setBoardLocation(int col, int row, LocationInitializer locationInitializer) {
    board[col][row].setLocationType(locationInitializer.locationType);
  }

  public CoordinateImpl getBoardLocation(int row, int col) {
    System.out.println(col);
    System.out.println(row + "\n");
    return board[col][row];
  }

  public CoordinateType getGameBoardType() { return gameBoardType; }

  public PieceTypeDescriptor[] getPieceTypeDescriptors() { return pieceTypeDescriptors; }

  public int getRows() { return this.rows; }

  public int getCols() { return this.cols; }

  public void printBoard() {
    System.out.println("******** Printing Board ********");

    for(int col = 0; col < cols; col++) {
      for(int row = 0; row < rows; row++) {
        System.out.print("(");
        System.out.print(this.board[col][row].getRow() + ", ");
        System.out.print(this.board[col][row].getColumn() + ") ");
        System.out.print(this.board[col][row].getLocationType() + " ");
        System.out.print(this.board[col][row].getPlayer() + " ");
        System.out.println(this.board[col][row].getPieceName());
      }
    }
  }
}