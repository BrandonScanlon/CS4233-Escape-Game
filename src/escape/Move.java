package escape;

import escape.builder.PieceTypeDescriptor;
import escape.required.EscapePiece;
import escape.required.EscapePiece.MovementPattern;
import escape.required.LocationType;

public class Move {
  GameStatusImpl gameStatus;
  MovementPattern movementPattern;
  PieceTypeDescriptor descriptor;
  String[] players;
  int whosTurn;
  GameBoardImpl tempGameBoard;
  CoordinateImpl newFrom;
  int deltaCol;
  int deltaRow;
  String direction;

  public Move(GameStatusImpl gameStatus, MovementPattern movementPattern, PieceTypeDescriptor descriptor, String[] players, int whosTurn, GameBoardImpl tempGameBoard, CoordinateImpl newFrom, int deltaCol, int deltaRow){
    this.gameStatus = gameStatus;
    this.movementPattern = movementPattern;
    this.descriptor = descriptor;
    this.players = players;
    this.whosTurn = whosTurn;
    this.tempGameBoard = tempGameBoard;
    this.newFrom = newFrom;
    this.deltaCol = deltaCol;
    this.deltaRow = deltaRow;
  }

  public GameStatusImpl movePiece(){
    switch(movementPattern) {
//*******************************************************************************************************************************
      case ORTHOGONAL:
        // Move by row or column only
        while(deltaRow != 0 || deltaCol != 0) {
          /** Move Row **/
          /** Move Row **/
          if(deltaRow == deltaCol) {
            if(deltaRow > 0) { // Move Up
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
              tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
              tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
              newFrom.setRow(newFrom.getRow() + 1);
              deltaRow--;
            }
            if(deltaRow < 0) { // Move Down
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
              tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
              tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
              newFrom.setRow(newFrom.getRow() - 1);
              deltaRow++;
            }
          }
          /** Move Row **/
          if(deltaRow > deltaCol || (deltaRow < 0 && deltaCol >= 0)) {
            if(deltaRow > 0) { // Move Up
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
              tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
              tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
              newFrom.setRow(newFrom.getRow() + 1);
              deltaRow--;
            }
            if(deltaRow < 0) { // Move Down
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
              tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
              tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
              newFrom.setRow(newFrom.getRow() - 1);
              deltaRow++;
            }
          }
          /** Move Column **/
          if(deltaRow < deltaCol || (deltaRow >= 0 && deltaCol < 0)) {
            if(deltaCol < 0) { // Move Left
              //Set initial location to null
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
              //Set new location to piece
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1).setPieceName(descriptor.getPieceName());
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1).setPlayer(players[whosTurn]);
              newFrom.setColumn(newFrom.getColumn() - 1);
              deltaCol++;
            }
            if(deltaCol > 0) { // Move Right
              //Set initial location to null
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
              //Set new location to piece
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1).setPieceName(descriptor.getPieceName());
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1).setPlayer(players[whosTurn]);
              newFrom.setColumn(newFrom.getColumn() + 1);
              deltaCol--;
            }
          }
        }
        if(deltaRow == 0 && deltaCol == 0){
          gameStatus.setValidMove(true);
          return gameStatus;
        }
        break;
//*******************************************************************************************************************************
      case LINEAR:
        // Move straight by only row, column, or diagonally. Can't change direction
        direction = "NONE";
        int prevDeltaRow = deltaRow;
        int prevDeltaCol = deltaCol;

        while(deltaRow != 0 || deltaCol != 0) {
          /** Move Diagonally **/
          if(deltaRow == deltaCol) {
            if(deltaRow > 0 && deltaCol > 0 && (direction == "NONE" || direction == "UPRIGHT")) { // Move Up right
              if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
                tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() + 1).setPieceName(descriptor.getPieceName());
                tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() + 1).setPlayer(players[whosTurn]);
                newFrom.setRow(newFrom.getRow() + 1);
                newFrom.setColumn(newFrom.getColumn() + 1);
                deltaRow--;
                deltaCol--;
                direction = "UPRIGHT";
              } else {
                if(tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType() != LocationType.CLEAR) {
                  gameStatus.setValidMove(false);
                  return gameStatus;
                } else {
                  tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
                  tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
                  tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() + 1).setPieceName(descriptor.getPieceName());
                  tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() + 1).setPlayer(players[whosTurn]);
                  newFrom.setRow(newFrom.getRow() + 1);
                  newFrom.setColumn(newFrom.getColumn() + 1);
                  deltaRow--;
                  deltaCol--;
                  direction = "UPRIGHT";
                }
              }
            }
            else if(deltaRow < 0 && deltaCol < 0 && (direction == "NONE" || direction == "DOWNLEFT")) { // Move Down left
              if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
                tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() - 1).setPieceName(descriptor.getPieceName());
                tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() - 1).setPlayer(players[whosTurn]);
                newFrom.setRow(newFrom.getRow() - 1);
                newFrom.setColumn(newFrom.getColumn() - 1);
                deltaRow++;
                deltaCol++;
                direction = "DOWNLEFT";
              } else {
                if(tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType() != LocationType.CLEAR) {
                  gameStatus.setValidMove(false);
                  return gameStatus;
                } else {
                  tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
                  tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
                  tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() - 1).setPieceName(descriptor.getPieceName());
                  tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() - 1).setPlayer(players[whosTurn]);
                  newFrom.setRow(newFrom.getRow() - 1);
                  newFrom.setColumn(newFrom.getColumn() - 1);
                  deltaRow++;
                  deltaCol++;
                  direction = "DOWNLEFT";
                }
              }
            }
          }
          /** Move Diagonally **/
          if(deltaRow == deltaCol - 2 && deltaRow != 0 && deltaCol != 0 && (direction == "NONE" || direction == "DOWNRIGHT")) { // Move down right
            if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
              tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() + 1).setPieceName(descriptor.getPieceName());
              tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() + 1).setPlayer(players[whosTurn]);
              newFrom.setRow(newFrom.getRow() - 1);
              newFrom.setColumn(newFrom.getColumn() + 1);
              deltaRow++;
              deltaCol--;
              direction = "DOWNRIGHT";
            } else {
              if(tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType() != LocationType.CLEAR) {
                gameStatus.setValidMove(false);
                return gameStatus;
              } else {
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
                tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() + 1).setPieceName(descriptor.getPieceName());
                tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() + 1).setPlayer(players[whosTurn]);
                newFrom.setRow(newFrom.getRow() - 1);
                newFrom.setColumn(newFrom.getColumn() + 1);
                deltaRow++;
                deltaCol--;
                direction = "DOWNRIGHT";
              }
            }
          }
          else if(deltaRow == deltaCol + 2 && deltaRow != 0 && deltaCol != 0 && (direction == "NONE" || direction == "UPLEFT")) { // Move up left
            if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
              tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() - 1).setPieceName(descriptor.getPieceName());
              tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() - 1).setPlayer(players[whosTurn]);
              newFrom.setRow(newFrom.getRow() + 1);
              newFrom.setColumn(newFrom.getColumn() - 1);
              deltaRow--;
              deltaCol++;
              direction = "UPLEFT";
            } else {
              if(tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType() != LocationType.CLEAR) {
                gameStatus.setValidMove(false);
                return gameStatus;
              } else {
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
                tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() - 1).setPieceName(descriptor.getPieceName());
                tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() - 1).setPlayer(players[whosTurn]);
                newFrom.setRow(newFrom.getRow() + 1);
                newFrom.setColumn(newFrom.getColumn() - 1);
                deltaRow--;
                deltaCol++;
                direction = "UPLEFT";
              }
            }
          }
          /** Move Row **/
          if(deltaRow > deltaCol || (deltaRow < 0 && deltaCol >= 0)) {
            if(deltaRow > 0 && (direction == "NONE" || direction == "UP")) { // Move Up
              if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
                tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
                tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
                newFrom.setRow(newFrom.getRow() + 1);
                deltaRow--;
                direction = "UP";
              } else {
                LocationType coordinateType = tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType();
                if(coordinateType != LocationType.CLEAR) {
                  gameStatus.setValidMove(false);
                  return gameStatus;
                } else {
                  tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
                  tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
                  tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
                  tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
                  newFrom.setRow(newFrom.getRow() + 1);
                  deltaRow--;
                  direction = "UP";
                }
              }
            }
            else if(deltaRow < 0 && (direction == "NONE" || direction == "DOWN")) { // Move Down
              if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
                tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
                tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
                newFrom.setRow(newFrom.getRow() - 1);
                deltaRow++;
                direction = "DOWN";
              } else {
                LocationType coordinateType = tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType();
                if(coordinateType != LocationType.CLEAR) {
                  gameStatus.setValidMove(false);
                  return gameStatus;
                } else {
                  tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
                  tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
                  tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
                  tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
                  newFrom.setRow(newFrom.getRow() - 1);
                  deltaRow++;
                  direction = "DOWN";
                }
              }
            }
          }
          /** Move Column **/
          if(deltaRow < deltaCol || (deltaRow >= 0 && deltaCol < 0) && (direction == "NONE" || direction == "LEFT")) {
            if(deltaCol < 0) { // Move Left
              if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1).setPieceName(descriptor.getPieceName());
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1).setPlayer(players[whosTurn]);
                newFrom.setColumn(newFrom.getColumn() - 1);
                deltaCol++;
                direction = "LEFT";
              } else {
                if(tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType() != LocationType.CLEAR) {
                  gameStatus.setValidMove(false);
                  return gameStatus;
                } else {
                  tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
                  tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
                  tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1).setPieceName(descriptor.getPieceName());
                  tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1).setPlayer(players[whosTurn]);
                  newFrom.setColumn(newFrom.getColumn() - 1);
                  deltaCol++;
                  direction = "LEFT";
                }
              }
            }
            if(deltaCol > 0 && (direction == "NONE" || direction == "RIGHT")) { // Move Right
              if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1).setPieceName(descriptor.getPieceName());
                tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1).setPlayer(players[whosTurn]);
                newFrom.setColumn(newFrom.getColumn() + 1);
                deltaCol--;
                direction = "RIGHT";
              } else {
                if(tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType() != LocationType.CLEAR) {
                  gameStatus.setValidMove(false);
                  return gameStatus;
                } else {
                  tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
                  tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
                  tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1).setPieceName(descriptor.getPieceName());
                  tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1).setPlayer(players[whosTurn]);
                  newFrom.setColumn(newFrom.getColumn() + 1);
                  deltaCol--;
                  direction = "RIGHT";
                }
              }
            }
          }
          if(deltaRow == 0 && deltaCol == 0){
            gameStatus.setValidMove(true);
            return gameStatus;
          }
          if(deltaRow == prevDeltaRow && deltaCol == prevDeltaCol){
            gameStatus.setValidMove(false);
            return gameStatus;
          } else {
            prevDeltaRow = deltaRow;
            prevDeltaCol = deltaCol;
          }
        }
        break;
//*******************************************************************************************************************************
      case OMNI:
        // Move straight by only row, column, or diagonally. Can't change direction
        while(deltaRow != 0 || deltaCol != 0) {
          /** Move Diagonally **/
          if(deltaRow == deltaCol) {
            if(deltaRow > 0 && deltaCol > 0) { // Move Up right
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
              tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() + 1).setPieceName(descriptor.getPieceName());
              tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() + 1).setPlayer(players[whosTurn]);
              newFrom.setRow(newFrom.getRow() + 1);
              newFrom.setColumn(newFrom.getColumn() + 1);
              deltaRow--;
              deltaCol--;
            }
            if(deltaRow < 0 && deltaCol < 0) { // Move Down left
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
              tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() - 1).setPieceName(descriptor.getPieceName());
              tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() - 1).setPlayer(players[whosTurn]);
              newFrom.setRow(newFrom.getRow() - 1);
              newFrom.setColumn(newFrom.getColumn() - 1);
              deltaRow++;
              deltaCol++;
            }
          }
          /** Move Diagonally **/
          if(deltaRow == deltaCol - 2 && deltaRow != 0 && deltaCol != 0) { // Move down right
            tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
            tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
            tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() + 1).setPieceName(descriptor.getPieceName());
            tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() + 1).setPlayer(players[whosTurn]);
            newFrom.setRow(newFrom.getRow() - 1);
            newFrom.setColumn(newFrom.getColumn() + 1);
            deltaRow++;
            deltaCol--;
          }
          if(deltaRow == deltaCol + 2 && deltaRow != 0 && deltaCol != 0) { // Move up left
            tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
            tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
            tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() - 1).setPieceName(descriptor.getPieceName());
            tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() - 1).setPlayer(players[whosTurn]);
            newFrom.setRow(newFrom.getRow() + 1);
            newFrom.setColumn(newFrom.getColumn() - 1);
            deltaRow--;
            deltaCol++;
          }
          /** Move Row **/
          if(deltaRow > deltaCol || (deltaRow < 0 && deltaCol >= 0)) {
            if(deltaRow > 0) { // Move Up
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
              tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
              tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
              newFrom.setRow(newFrom.getRow() + 1);
              deltaRow--;
            }
            if(deltaRow < 0) { // Move Down
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
              tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
              tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
              newFrom.setRow(newFrom.getRow() - 1);
              deltaRow++;
            }
          }
          /** Move Column **/
          if(deltaRow < deltaCol || (deltaRow >= 0 && deltaCol < 0)) {
            if(deltaCol < 0) { // Move Left
              //Set initial location to null
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
              //Set new location to piece
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1).setPieceName(descriptor.getPieceName());
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1).setPlayer(players[whosTurn]);
              newFrom.setColumn(newFrom.getColumn() - 1);
              deltaCol++;
            }
            if(deltaCol > 0) { // Move Right
              //Set initial location to null
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
              //Set new location to piece
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1).setPieceName(descriptor.getPieceName());
              tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1).setPlayer(players[whosTurn]);
              newFrom.setColumn(newFrom.getColumn() + 1);
              deltaCol--;
            }
          }
        }
        if(deltaRow == 0 && deltaCol == 0){
          gameStatus.setValidMove(true);
          return gameStatus;
        }
        break;
//********************************************************************************************************************************
      case DIAGONAL:
        // Move in any diagonal direction
        break;
    } // End of Switch
    return gameStatus;
  }

}
