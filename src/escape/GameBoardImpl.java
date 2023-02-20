package escape;

// Imports
//**************************************
import escape.builder.LocationInitializer;
import escape.builder.PieceTypeDescriptor;
import escape.required.Coordinate.CoordinateType;

public class GameBoardImpl {
  private GameBoard gameBoard;

  // Constructor
  //**************************************
  public GameBoardImpl(GameBoard gameBoard) {
    this.gameBoard = gameBoard;
  }

  // Methods
  //**************************************
  public void setBoardLocation(int col, int row, LocationInitializer locationInitializer) { gameBoard.setBoardLocation(row, col, locationInitializer); }

  public CoordinateImpl getBoardLocation(int row, int col) { return gameBoard.getBoardLocation(col, row); }

  public CoordinateType getGameBoardType() { return gameBoard.getGameBoardType(); }

  public PieceTypeDescriptor[] getPieceTypeDescriptors() { return gameBoard.getPieceTypeDescriptors(); }

  public int getRows() { return gameBoard.getRows(); }

  public int getCols() { return gameBoard.getCols(); }

  public void printBoard() { gameBoard.printBoard(); }
}
