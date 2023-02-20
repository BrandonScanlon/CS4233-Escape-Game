package escape;

// Imports
//**************************************

import escape.builder.LocationInitializer;
import escape.builder.PieceTypeDescriptor;
import escape.required.*;
import escape.required.Coordinate.CoordinateType;
import escape.required.EscapePiece.MovementPattern;
import escape.required.EscapePiece.PieceAttributeID;

public class EscapeGameManagerImpl<C extends Coordinate> implements EscapeGameManager {

  // Fields
  //**************************************
  private int colMax;

  private int rowMax;

  private String[] players;

  private CoordinateType coordinateType;

  private LocationInitializer obstacleLocations[];

  private GameBoardImpl gameBoard;

  private PieceTypeDescriptor[] pieceTypeDescriptors;

  private int whosTurn = 0;

  // Constructors
  //**************************************
  public EscapeGameManagerImpl(int xMax, int yMax, String[] players, CoordinateType coordinateType, LocationInitializer obstacleLocations[], PieceTypeDescriptor[] pieceTypeDescriptors) throws EscapeException {
    this.rowMax = yMax;
    this.colMax = xMax;
    this.players = players;
    this.coordinateType = coordinateType;
    this.obstacleLocations = obstacleLocations;
    this.pieceTypeDescriptors = pieceTypeDescriptors;

    if(coordinateType == CoordinateType.SQUARE) {
      SquareGameBoard squareGameBoard = new SquareGameBoard(this.colMax, this.rowMax, obstacleLocations, pieceTypeDescriptors);
      this.gameBoard = new GameBoardImpl(squareGameBoard);
    } else if(coordinateType == CoordinateType.HEX) {
      HexGameBoard hexGameBoard = new HexGameBoard(this.colMax, this.rowMax, obstacleLocations, pieceTypeDescriptors);
      this.gameBoard = new GameBoardImpl(hexGameBoard);
    }
  }

  // Methods
  //**************************************

  /**
   * Setters
   **/
  public void setCoordinateType(CoordinateType CoordinateType) {
    this.coordinateType = CoordinateType;
  }

  public void setColMax(int colMax) {
    this.colMax = colMax;
  }

  public void setrowMax(int rowMax) {
    this.rowMax = rowMax;
  }

  public void setPlayers(String[] players) {
    this.players = players;
  }

  /**
   * Getters
   **/
  public CoordinateType getCoordinateType() {
    return coordinateType;
  }

  public int getColMax() {
    return colMax;
  }

  public int getRowMax() {
    return rowMax;
  }

  public String[] getPlayers() {
    return players;
  }

  public GameBoardImpl getGameBoard() {
    return gameBoard;
  }

  /******************** MOVE ********************/
  public GameStatus move(Coordinate from, Coordinate to) {
    GameStatusImpl gameStatus = new GameStatusImpl();
    GameBoardImpl gameBoard = this.getGameBoard();

    //System.out.println(pieceTypeDescriptors[0]);

    /******************** Check if valid move (immediate red flags) ********************/
    // Null Coordinates (Not sure if needed)
    if(from == null || to == null) {
      gameStatus.setValidMove(false);
      return gameStatus;
    }
    // Coordinates are the same
    else if(from.equals(to)) {
      gameStatus.setValidMove(false);
      return gameStatus;
    }
    // There is no piece or player at the from Coordinate
    else if(gameBoard.getBoardLocation(from.getRow(), from.getColumn()).getPieceName() == null ||
        gameBoard.getBoardLocation(from.getRow(), from.getColumn()).getPlayer() == null) {
      gameStatus.setValidMove(false);
      return gameStatus;
    }
    // Coordinate not on board
    else if(gameBoard.getBoardLocation(from.getRow(), from.getColumn()) == null) {
      gameStatus.setValidMove(false);
      return gameStatus;
    }
    // Moving player does not have a piece on the 'from' coordinate
    else if(!gameBoard.getBoardLocation(from.getRow(), from.getColumn()).getPlayer().equals(players[whosTurn])) {
      gameStatus.setValidMove(false);
      return gameStatus;
    }
    // Otherwise, it's a valid move
    else {
      gameStatus.setValidMove(true);
    }

    /******************** If valid, make move, and check for collision and other validation ********************/
    if(gameStatus.isValidMove()) {
      GameBoardImpl tempGameBoard = gameBoard;
      CoordinateImpl newFrom = (CoordinateImpl)from;
      for(PieceTypeDescriptor descriptor : gameBoard.getPieceTypeDescriptors()) {
        // Check if from has an appropriate piece, then determine its capabilities
        if(tempGameBoard.getBoardLocation(from.getRow(), from.getColumn()).getPieceName() == descriptor.getPieceName()) {
          // Determine movement pattern
          MovementPattern movementPattern = descriptor.getMovementPattern();
          int deltaRow = to.getRow() - from.getRow();
          int deltaCol = to.getColumn() - from.getColumn();
          int distance = 0;
          if(deltaRow == deltaCol && (movementPattern == MovementPattern.LINEAR || movementPattern == MovementPattern.DIAGONAL)) {
            distance = deltaRow;
          }
          Move move = new Move(gameStatus, movementPattern, descriptor, players, whosTurn, tempGameBoard, newFrom, deltaCol, deltaRow);
          if(distance == 0 && newFrom.distanceTo(to) <= descriptor.getAttribute(PieceAttributeID.DISTANCE).getValue()) {
            gameStatus = move.movePiece();

          } else if(distance == deltaRow && distance <= descriptor.getAttribute(PieceAttributeID.DISTANCE).getValue()) {
            gameStatus = move.movePiece();
          } else {
            gameStatus.setValidMove(false);
            return gameStatus;
          }
        }
      }
        /******************** Send back the reponse ********************/
        // Respond with appropriate Game Status
        if(!gameStatus.isValidMove()) {
          gameStatus.setMoveResult(GameStatusImpl.MoveResult.NONE);
          gameStatus.setCombatResult(GameStatusImpl.CombatResult.NONE);
          return gameStatus;
        } else {
          return gameStatus;
        }
    }
    return gameStatus;
  }

//            switch(movementPattern) {
////*******************************************************************************************************************************
//              case ORTHOGONAL:
//                // Move by row or column only
//                while(deltaRow != 0 || deltaCol != 0) {
//                  /** Move Row **/
//                  /** Move Row **/
//                  if(deltaRow == deltaCol) {
//                    if(deltaRow > 0) { // Move Up
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
//                      tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
//                      newFrom.setRow(newFrom.getRow() + 1);
//                      deltaRow--;
//                    }
//                    if(deltaRow < 0) { // Move Down
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
//                      tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
//                      newFrom.setRow(newFrom.getRow() - 1);
//                      deltaRow++;
//                    }
//                  }
//                  /** Move Row **/
//                  if(deltaRow > deltaCol || (deltaRow < 0 && deltaCol >= 0)) {
//                    if(deltaRow > 0) { // Move Up
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
//                      tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
//                      newFrom.setRow(newFrom.getRow() + 1);
//                      deltaRow--;
//                    }
//                    if(deltaRow < 0) { // Move Down
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
//                      tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
//                      newFrom.setRow(newFrom.getRow() - 1);
//                      deltaRow++;
//                    }
//                  }
//                  /** Move Column **/
//                  if(deltaRow < deltaCol || (deltaRow >= 0 && deltaCol < 0)) {
//                    if(deltaCol < 0) { // Move Left
//                      //Set initial location to null
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
//                      //Set new location to piece
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1).setPieceName(descriptor.getPieceName());
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1).setPlayer(players[whosTurn]);
//                      newFrom.setColumn(newFrom.getColumn() - 1);
//                      deltaCol++;
//                    }
//                    if(deltaCol > 0) { // Move Right
//                      //Set initial location to null
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
//                      //Set new location to piece
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1).setPieceName(descriptor.getPieceName());
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1).setPlayer(players[whosTurn]);
//                      newFrom.setColumn(newFrom.getColumn() + 1);
//                      deltaCol--;
//                    }
//                  }
//                }
//                if(deltaRow == 0 && deltaCol == 0){
//                  gameStatus.setValidMove(true);
//                  return gameStatus;
//                }
//                break;
////*******************************************************************************************************************************
//              case LINEAR:
//                // Move straight by only row or column
//                while(deltaRow != 0 || deltaCol != 0) {
//                  /** Move Diagonally **/
//                  if(deltaRow == deltaCol) {
//                    if(deltaRow > 0 && deltaCol > 0) { // Move Up Diagonally
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() + 1).setPieceName(descriptor.getPieceName());
//                      tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() + 1).setPlayer(players[whosTurn]);
//                      newFrom.setRow(newFrom.getRow() + 1);
//                      newFrom.setColumn(newFrom.getColumn() + 1);
//                      deltaRow--;
//                      deltaCol--;
//                    }
//                    if(deltaRow < 0 && deltaCol < 0) { // Move Down Diagonally
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() - 1).setPieceName(descriptor.getPieceName());
//                      tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() - 1).setPlayer(players[whosTurn]);
//                      newFrom.setRow(newFrom.getRow() - 1);
//                      newFrom.setColumn(newFrom.getColumn() - 1);
//                      deltaRow++;
//                      deltaCol++;
//                    }
//                  }
//                  /** Move Row **/
//                  if(deltaRow > deltaCol || (deltaRow < 0 && deltaCol >= 0)) {
//                    if(deltaRow > 0) { // Move Up
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
//                      tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
//                      newFrom.setRow(newFrom.getRow() + 1);
//                      deltaRow--;
//                    }
//                    if(deltaRow < 0) { // Move Down
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
//                      tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
//                      newFrom.setRow(newFrom.getRow() - 1);
//                      deltaRow++;
//                    }
//                  }
//                  /** Move Column **/
//                  if(deltaRow < deltaCol || (deltaRow >= 0 && deltaCol < 0)) {
//                    if(deltaCol < 0) { // Move Left
//                      //Set initial location to null
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
//                      //Set new location to piece
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1).setPieceName(descriptor.getPieceName());
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1).setPlayer(players[whosTurn]);
//                      newFrom.setColumn(newFrom.getColumn() - 1);
//                      deltaCol++;
//                    }
//                    if(deltaCol > 0) { // Move Right
//                      //Set initial location to null
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
//                      //Set new location to piece
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1).setPieceName(descriptor.getPieceName());
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1).setPlayer(players[whosTurn]);
//                      newFrom.setColumn(newFrom.getColumn() + 1);
//                      deltaCol--;
//                    }
//                  }
//                }
//                if(deltaRow == 0 && deltaCol == 0){
//                  gameStatus.setValidMove(true);
//                  return gameStatus;
//                }
//                break;
//              //*************************************************************************************************************
//              case DIAGONAL:
//                // Move in any diagonal direction
//                break;
//              //*************************************************************************************************************
//              case OMNI:
//                // Move in any direction
//                break;
//              //*************************************************************************************************************
//
//
//            } // End of Switch
//          } else {
//            gameStatus.setValidMove(false);
//            return gameStatus;
//          }
//        }
//      }


  /** Coordinate **/
  /**
   * Returns a coordinate of the appropriate type. If the coordinate cannot be
   * created, then null is returned and the status message is set appropriately.
   *
   * @param col the col component
   * @param row the row component
   * @return the coordinate or null if the coordinate cannot be implemented
   */
  @Override
  public CoordinateImpl makeCoordinate(int col, int row){
    try {
      Coordinate newCoordinate = new CoordinateImpl(col, row);
      return (CoordinateImpl)newCoordinate;
    } catch(Exception e) {
      System.out.println("Exception from escape builder: " + e.getMessage());
      return null;
    }
  }
}
