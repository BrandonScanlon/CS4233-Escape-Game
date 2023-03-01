package escape;

// Imports
//**************************************
import escape.Builder.LocationInitializer;
import escape.Builder.PieceTypeDescriptor;
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
  public void setBoardLocation(int row, int col, LocationInitializer locationInitializer) { gameBoard.setBoardLocation(row, col, locationInitializer); }

  public CoordinateImpl getBoardLocation(int row, int col) { return gameBoard.getBoardLocation(row, col); }

  public CoordinateType getGameBoardType() { return gameBoard.getGameBoardType(); }

  public PieceTypeDescriptor[] getPieceTypeDescriptors() { return gameBoard.getPieceTypeDescriptors(); }

  public int getRows() { return gameBoard.getRows(); }

  public int getCols() { return gameBoard.getCols(); }

  public void printBoard() { gameBoard.printBoard(); }
}