package escape;

// Imports
//**************************************************
import escape.Builder.PieceTypeDescriptor;
import escape.required.Coordinate.CoordinateType;
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
  int prevDeltaRow;
  int prevDeltaCol;
  CoordinateImpl startingCoord;
  int maxDistance;
  int moves = 0;


  // Contructor
  //**********************************************
  public Move(GameStatusImpl gameStatus, MovementPattern movementPattern, PieceTypeDescriptor descriptor, String[] players, int whosTurn, GameBoardImpl tempGameBoard, CoordinateImpl newFrom, int deltaCol, int deltaRow, int maxDistance){
    this.gameStatus = gameStatus;
    this.movementPattern = movementPattern;
    this.descriptor = descriptor;
    this.players = players;
    this.whosTurn = whosTurn;
    this.tempGameBoard = tempGameBoard;
    this.newFrom = newFrom;
    this.deltaCol = deltaCol;
    this.deltaRow = deltaRow;
    this.maxDistance = maxDistance;
  }

  public GameStatusImpl movePiece(){
    switch(movementPattern) {
/*********************************************************** ORTHOGONAL ****************************************************************/
      case ORTHOGONAL:
        // Move by row or column only
        while(deltaRow != 0 || deltaCol != 0) {
          CoordinateImpl upCoord = tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn());
          CoordinateImpl downCoord = tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn());
          CoordinateImpl rightCoord = tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1);
          CoordinateImpl leftCoord = tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1);
            /** Up **/
            if(((deltaRow > deltaCol && deltaRow > 0) || (deltaRow == deltaCol && deltaRow > 0)) && !checkForObstacles(tempGameBoard, upCoord)) {
              moveUp();
              moves++;
              continue;
            }
            /** Right **/
            if((deltaRow <= 0 && deltaCol > 0 && ((Math.abs(deltaRow) <= Math.abs(deltaCol))) && !checkForObstacles(tempGameBoard, rightCoord))) {
              moveRight();
              moves++;
              continue;
            }
            /** Down **/
            if(((deltaRow < deltaCol && deltaRow < 0) || (deltaRow == deltaCol && deltaRow < 0)) && !checkForObstacles(tempGameBoard, downCoord)) {
              moveDown();
              moves++;
              continue;
            }
            /** Left **/
            if((deltaRow <= 0 && deltaCol < 0 || (Math.abs(deltaRow) > Math.abs(deltaCol))) && !checkForObstacles(tempGameBoard, leftCoord)) {
              moveLeft();
              moves++;
              continue;
            }
          if(deltaCol == 0 && !checkForObstacles(tempGameBoard, rightCoord)) {
            moveRight();
            moves++;
            continue;
          } else if(deltaCol == 0 && !checkForObstacles(tempGameBoard, leftCoord)) {
            moveLeft();
            moves++;
            continue;
          } else if(deltaRow == 0 && !checkForObstacles(tempGameBoard, upCoord)) {
            moveUp();
            moves++;
            continue;
          } else if(deltaRow == 0 && !checkForObstacles(tempGameBoard, downCoord)) {
            moveDown();
            moves++;
            continue;
          } else {
            gameStatus.setValidMove(false);
            newFrom = startingCoord;
            return gameStatus;
          }
        } // End While Loop
        if(deltaRow == 0 && deltaCol == 0){
          gameStatus.setValidMove(true);
          return gameStatus;
        }
      if(deltaRow == prevDeltaRow && deltaCol == prevDeltaCol || moves > maxDistance){
        gameStatus.setValidMove(false);
        newFrom = startingCoord;
        return gameStatus;
     }
      if(deltaRow == 0 && deltaCol == 0){
        gameStatus.setValidMove(true);
        return gameStatus;
      } else {
        prevDeltaRow = deltaRow;
        prevDeltaCol = deltaCol;
      }
      break;
/******************************************************** OMNI *************************************************************************/
      case OMNI:
        if(tempGameBoard.getGameBoardType() == CoordinateType.SQUARE) {
          // Move by row, column, or diagonally
          while(deltaRow != 0 || deltaCol != 0) {
            CoordinateImpl upCoord = tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn());
            CoordinateImpl downCoord = tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn());
            CoordinateImpl rightCoord = tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1);
            CoordinateImpl leftCoord = tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1);

            CoordinateImpl upRightCoord = tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() + 1);
            CoordinateImpl upLeftCoord = tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() - 1);
            CoordinateImpl downRightCoord = tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() + 1);
            CoordinateImpl downLeftCoord = tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() - 1);

            if(deltaRow == deltaCol) {
              /** Up Right **/
              if(deltaRow > 0 && !checkForObstacles(tempGameBoard, upRightCoord)) {
                moveUpRight();
                moves++;
                continue;
              }
              /** Down Left **/
              else if(deltaRow < 0 && !checkForObstacles(tempGameBoard, downLeftCoord)) {
                moveDownLeft();
                moves++;
                continue;
              }
            }
            /** Down Right **/
            else if(deltaRow == deltaCol - 2 && deltaRow != 0 && deltaCol != 0) {
              if(!checkForObstacles(tempGameBoard, downRightCoord)) {
                moveDownRight();
                moves++;
                continue;
              }
            }
            /** Up Left **/
            else if(deltaRow == deltaCol + 2 && deltaRow != 0 && deltaCol != 0) {
              if(!checkForObstacles(tempGameBoard, upLeftCoord)) {
                moveUpLeft();
                moves++;
                continue;
              }
            }
            /** Up **/
            if((deltaRow > deltaCol && deltaRow > 0) && !checkForObstacles(tempGameBoard, upCoord)) {
              moveUp();
              moves++;
              continue;
            }
            /** Right **/
            if((deltaRow <= 0 && deltaCol > 0 && ((Math.abs(deltaRow) <= Math.abs(deltaCol))) && !checkForObstacles(tempGameBoard, rightCoord))) {
              moveRight();
              moves++;
              continue;
            }
            /** Down **/
            if((deltaRow < deltaCol && deltaRow < 0) && !checkForObstacles(tempGameBoard, downCoord)) {
              moveDown();
              moves++;
              continue;
            }
            /** Left **/
            if((deltaRow <= 0 && deltaCol < 0 || (Math.abs(deltaRow) > Math.abs(deltaCol))) && !checkForObstacles(tempGameBoard, leftCoord)) {
              moveLeft();
              moves++;
              continue;
            }
            if(deltaCol == 0 && !checkForObstacles(tempGameBoard, rightCoord)) {
              moveRight();
              moves++;
              continue;
            } else if(deltaCol == 0 && !checkForObstacles(tempGameBoard, leftCoord)) {
              moveLeft();
              moves++;
              continue;
            } else if(deltaRow == 0 && !checkForObstacles(tempGameBoard, upCoord)) {
              moveUp();
              moves++;
              continue;
            } else if(deltaRow == 0 && !checkForObstacles(tempGameBoard, downCoord)) {
              moveDown();
              moves++;
              continue;
            } else {
              gameStatus.setValidMove(false);
              newFrom = startingCoord;
              return gameStatus;
            }
          } // End While Loop
          if(deltaRow == 0 && deltaCol == 0) {
            gameStatus.setValidMove(true);
            return gameStatus;
          }

          if(deltaRow == prevDeltaRow && deltaCol == prevDeltaCol || moves > maxDistance) {
            gameStatus.setValidMove(false);
            newFrom = startingCoord;
            return gameStatus;
          }
          if(deltaRow == 0 && deltaCol == 0) {
            gameStatus.setValidMove(true);
            return gameStatus;
          } else {
            prevDeltaRow = deltaRow;
            prevDeltaCol = deltaCol;
          }
          break;
        } else if(tempGameBoard.getGameBoardType() == CoordinateType.HEX){ // HEX BOARD
          // Move by row, column, or diagonally
          while(deltaRow != 0 || deltaCol != 0) {
            CoordinateImpl upCoord = tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn());
            CoordinateImpl downCoord = tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn());
            CoordinateImpl rightCoord = tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1);
            CoordinateImpl leftCoord = tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1);

            CoordinateImpl upRightCoord = tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() + 1);
            CoordinateImpl upLeftCoord = tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() - 1);
            CoordinateImpl downRightCoord = tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() + 1);
            CoordinateImpl downLeftCoord = tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() - 1);

            if(deltaRow == deltaCol) {
              /** Up Right **/
              if(deltaRow > 0 && !checkForObstacles(tempGameBoard, upRightCoord)) {
                moveUpRightHEX();
                moves++;
                continue;
              }
              /** Down Left **/
              else if(deltaRow < 0 && !checkForObstacles(tempGameBoard, downLeftCoord)) {
                moveDownLeftHEX();
                moves++;
                continue;
              }
            }
            /** Down Right **/
            else if(deltaRow == deltaCol - 2 && deltaRow != 0 && deltaCol != 0) {
              if(!checkForObstacles(tempGameBoard, downRightCoord)) {
                moveDownRightHEX();
                moves++;
                continue;
              }
            }
            /** Up Left **/
            else if(deltaRow == deltaCol + 2 && deltaRow != 0 && deltaCol != 0) {
              if(!checkForObstacles(tempGameBoard, upLeftCoord)) {
                moveUpLeftHEX();
                moves++;
                continue;
              }
            }
            /** Up **/
            if((deltaRow > deltaCol && deltaRow > 0) && !checkForObstacles(tempGameBoard, upCoord)) {
              moveUpHEX();
              moves++;
              continue;
            }
            /** Down **/
            if((deltaRow < deltaCol && deltaRow < 0) && !checkForObstacles(tempGameBoard, downCoord)) {
              moveDownHEX();
              moves++;
              continue;
            }
            if(deltaRow == 0 && !checkForObstacles(tempGameBoard, upCoord)) {
              moveUpHEX();
              moves++;
              continue;
            } else if(deltaRow == 0 && !checkForObstacles(tempGameBoard, downCoord)) {
              moveDownHEX();
              moves++;
              continue;
            } else {
              gameStatus.setValidMove(false);
              newFrom = startingCoord;
              return gameStatus;
            }
          } // End While Loop
          if(deltaRow == 0 && deltaCol == 0) {
            gameStatus.setValidMove(true);
            return gameStatus;
          }
          if(deltaRow == prevDeltaRow && deltaCol == prevDeltaCol || moves > maxDistance) {
            gameStatus.setValidMove(false);
            newFrom = startingCoord;
            return gameStatus;
          }
          if(deltaRow == 0 && deltaCol == 0) {
            gameStatus.setValidMove(true);
            return gameStatus;
          } else {
            prevDeltaRow = deltaRow;
            prevDeltaCol = deltaCol;
          }
          break;
        }
/******************************************************** LINEAR *************************************************************************/
      case LINEAR:
        // Move straight by only row, column, or diagonally. Can't change direction
        direction = "NONE";
        prevDeltaRow = deltaRow;
        prevDeltaCol = deltaCol;
        startingCoord = newFrom;

        while(deltaRow != 0 || deltaCol != 0) {
          if(deltaRow == deltaCol) {
            if(deltaRow > 0 && deltaCol > 0 && (direction == "NONE" || direction == "UPRIGHT")) { // Move Up right
              if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
                moveUpRight();
              } else {
                if(tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType() != LocationType.CLEAR) {
                  gameStatus.setValidMove(false);
                  return gameStatus;
                } else {
                  CoordinateImpl upRightCoord = tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() + 1);
                  if(checkForObstacles(tempGameBoard, upRightCoord)) {
                    gameStatus.setValidMove(false);
                    return gameStatus;
                  } else {
                    moveUpRight();
                  }
                }
              }
            } else if(deltaRow < 0 && deltaCol < 0 && (direction == "NONE" || direction == "DOWNLEFT")) { // Move Down left
              if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
                moveDownLeft();
              } else {
                if(tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType() != LocationType.CLEAR) {
                  gameStatus.setValidMove(false);
                  return gameStatus;
                } else {
                  CoordinateImpl downLeftCoord = tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() - 1);
                  if(checkForObstacles(tempGameBoard, downLeftCoord)) {
                    gameStatus.setValidMove(false);
                    return gameStatus;
                  } else {
                    moveDownLeft();
                  }
                }
              }
            }
          }
          if(deltaRow == deltaCol - 2 && deltaRow != 0 && deltaCol != 0 && (direction == "NONE" || direction == "DOWNRIGHT")) { // Move down right
            if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
              moveDownRight();
            } else {
              if(tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType() != LocationType.CLEAR) {
                gameStatus.setValidMove(false);
                return gameStatus;
              } else {
                CoordinateImpl downRightCoord =  tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() + 1);
                if(checkForObstacles(tempGameBoard, downRightCoord)) {
                  gameStatus.setValidMove(false);
                  return gameStatus;
                } else {
                  moveDownRight();
                }
              }
            }
          } else if(deltaRow == deltaCol + 2 && deltaRow != 0 && deltaCol != 0 && (direction == "NONE" || direction == "UPLEFT")) { // Move up left
            if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
              moveUpLeft();
            } else {
              if(tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType() != LocationType.CLEAR) {
                gameStatus.setValidMove(false);
                return gameStatus;
              } else {
                CoordinateImpl upLeftCoord = tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() - 1);
                if(checkForObstacles(tempGameBoard, upLeftCoord)) {
                  gameStatus.setValidMove(false);
                  return gameStatus;
                } else {
                  moveUpLeft();
                }
              }
            }
          }
          if(deltaRow > deltaCol || (deltaRow < 0 && deltaCol >= 0)) {
            if(deltaRow > 0 && (direction == "NONE" || direction == "UP")) { // Move Up
              if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
                moveUp();
              } else {
                LocationType coordinateType = tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType();
                if(coordinateType != LocationType.CLEAR) {
                  gameStatus.setValidMove(false);
                  return gameStatus;
                } else {
                  CoordinateImpl upCoord = tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn());
                  if(checkForObstacles(tempGameBoard, upCoord)) {
                    gameStatus.setValidMove(false);
                    return gameStatus;
                  } else {
                    moveUp();
                  }
                }
              }
            } else if(deltaRow < 0 && (direction == "NONE" || direction == "DOWN")) { // Move Down
              if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
                moveDown();
              } else {
                LocationType coordinateType = tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType();
                if(coordinateType != LocationType.CLEAR) {
                  gameStatus.setValidMove(false);
                  return gameStatus;
                } else {
                  CoordinateImpl downCoord = tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn());
                  if(checkForObstacles(tempGameBoard, downCoord)) {
                    gameStatus.setValidMove(false);
                    return gameStatus;
                  } else {
                    moveDown();
                  }
                }
              }
            }
          }
          /** Move Column **/
          if(deltaRow < deltaCol || (deltaRow >= 0 && deltaCol < 0) && (direction == "NONE" || direction == "LEFT")) {
            if(deltaCol < 0) { // Move Left
              if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
                moveLeft();
              } else {
                if(tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType() != LocationType.CLEAR) {
                  gameStatus.setValidMove(false);
                  return gameStatus;
                } else {
                  CoordinateImpl leftCoord = tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1);
                  if(checkForObstacles(tempGameBoard, leftCoord)) {
                    gameStatus.setValidMove(false);
                    return gameStatus;
                  } else {
                    moveLeft();
                  }
                }
              }
            } if(deltaCol > 0 && (direction == "NONE" || direction == "RIGHT")) { // Move Right
              if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
                moveRight();
              } else {
                if(tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType() != LocationType.CLEAR) {
                  gameStatus.setValidMove(false);
                  return gameStatus;
                } else {
                  CoordinateImpl rightCoord = tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1);
                  if(checkForObstacles(tempGameBoard, rightCoord)) {
                    gameStatus.setValidMove(false);
                    return gameStatus;
                  } else {
                    moveRight();
                  }
                }
              }
            }
          } if(deltaRow == 0 && deltaCol == 0){
            gameStatus.setValidMove(true);
            return gameStatus;
          } if(deltaRow == prevDeltaRow && deltaCol == prevDeltaCol){
            gameStatus.setValidMove(false);
            return gameStatus;
          } else {
            prevDeltaRow = deltaRow;
            prevDeltaCol = deltaCol;
          }
        }
        break;
/********************************************************** DIAGONAL *******************************************************************/
      case DIAGONAL:
        // Move diagonally
        direction = "NONE";
        prevDeltaRow = deltaRow;
        prevDeltaCol = deltaCol;

        while(deltaRow != 0 || deltaCol != 0) {
          if(deltaRow == deltaCol) {
            if(deltaRow > 0 && deltaCol > 0 && (direction == "NONE" || direction == "UPRIGHT")) { // Move Up right
              if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
                moveUpRight();
              } else {
                if(tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType() != LocationType.CLEAR) {
                  gameStatus.setValidMove(false);
                  return gameStatus;
                } else {
                  CoordinateImpl upRightCoord = tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() + 1);
                  if(checkForObstacles(tempGameBoard, upRightCoord)) {
                    gameStatus.setValidMove(false);
                    return gameStatus;
                  } else {
                    moveUpRight();
                  }
                }
              }
            }
            else if(deltaRow < 0 && deltaCol < 0 && (direction == "NONE" || direction == "DOWNLEFT")) { // Move Down left
              if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
                moveDownLeft();
              } else {
                if(tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType() != LocationType.CLEAR) {
                  gameStatus.setValidMove(false);
                  return gameStatus;
                } else {
                  CoordinateImpl downLeftCoord = tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() - 1);
                  if(checkForObstacles(tempGameBoard, downLeftCoord)) {
                    gameStatus.setValidMove(false);
                    return gameStatus;
                  } else {
                    moveDownLeft();
                  }
                }
              }
            }
          }
          if(deltaRow == deltaCol - 2 && deltaRow != 0 && deltaCol != 0 && (direction == "NONE" || direction == "DOWNRIGHT")) { // Move down right
            if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
              moveDownRight();
            } else {
              if(tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType() != LocationType.CLEAR) {
                gameStatus.setValidMove(false);
                return gameStatus;
              } else {
                CoordinateImpl downRightCoord =  tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() + 1);
                if(checkForObstacles(tempGameBoard, downRightCoord)) {
                  gameStatus.setValidMove(false);
                  return gameStatus;
                } else {
                  moveDownRight();
                }
              }
            }
          }
          else if(deltaRow == deltaCol + 2 && deltaRow != 0 && deltaCol != 0 && (direction == "NONE" || direction == "UPLEFT")) { // Move up left
            if(tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).getPieceName() == EscapePiece.PieceName.BIRD) {
              moveUpLeft();
            } else {
              if(tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).getLocationType() != LocationType.CLEAR) {
                gameStatus.setValidMove(false);
                return gameStatus;
              } else {
                CoordinateImpl upLeftCoord = tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() - 1);
                if(checkForObstacles(tempGameBoard, upLeftCoord)) {
                  gameStatus.setValidMove(false);
                  return gameStatus;
                } else {
                  moveUpLeft();
                }
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
      break;
  } // End of Switch
  return gameStatus;
}

  public boolean checkForObstacles(GameBoardImpl gameBoard, CoordinateImpl to) {
    //gameBoard.printBoard();
    if(gameBoard.getBoardLocation(to.getRow(), to.getColumn()).getPieceName() != null && gameBoard.getBoardLocation(to.getRow(), to.getColumn()).getPlayer() != null){
      return true; // Obstacles
    } else if(gameBoard.getBoardLocation(to.getRow(), to.getColumn()).getLocationType() != LocationType.CLEAR || gameBoard.getBoardLocation(to.getRow(), to.getColumn()).getPieceName() != null || gameBoard.getBoardLocation(to.getRow(), to.getColumn()).getPlayer() != null) {
      return true; // Obstacles
    } else {
      return false; // No obstacles
    }
  }

  /** SQUARE MOVES **/
  public void moveUp(){
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
    tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
    tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
    newFrom.setLocationType(LocationType.CLEAR);
    newFrom.setRow(newFrom.getRow() + 1);
    deltaRow--;
    direction = "UP";
  }
  public void moveDown(){
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
    tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
    tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
    newFrom.setRow(newFrom.getRow() - 1);
    deltaRow++;
  }
  public void moveLeft(){
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1).setPieceName(descriptor.getPieceName());
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1).setPlayer(players[whosTurn]);
    newFrom.setLocationType(LocationType.CLEAR);
    newFrom.setColumn(newFrom.getColumn() - 1);
    deltaCol++;
    direction = "LEFT";
  }
  public void moveRight(){
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1).setPieceName(descriptor.getPieceName());
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1).setPlayer(players[whosTurn]);
    newFrom.setLocationType(LocationType.CLEAR);
    newFrom.setColumn(newFrom.getColumn() + 1);
    deltaCol--;
    direction = "RIGHT";
  }
  public void moveUpLeft(){
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
    tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() - 1).setPieceName(descriptor.getPieceName());
    tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() - 1).setPlayer(players[whosTurn]);
    newFrom.setLocationType(LocationType.CLEAR);
    newFrom.setRow(newFrom.getRow() + 1);
    newFrom.setColumn(newFrom.getColumn() - 1);
    deltaRow--;
    deltaCol++;
    direction = "UPLEFT";
  }
  public void moveUpRight(){
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
    tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() + 1).setPieceName(descriptor.getPieceName());
    tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() + 1).setPlayer(players[whosTurn]);
    newFrom.setLocationType(LocationType.CLEAR);
    newFrom.setRow(newFrom.getRow() + 1);
    newFrom.setColumn(newFrom.getColumn() + 1);
    deltaRow--;
    deltaCol--;
    direction = "UPRIGHT";
  }
  public void moveDownLeft(){
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
    tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() - 1).setLocationType(LocationType.CLEAR);
    tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() - 1).setPlayer(players[whosTurn]);
    newFrom.setLocationType(LocationType.CLEAR);
    newFrom.setRow(newFrom.getRow() - 1);
    newFrom.setColumn(newFrom.getColumn() - 1);
    deltaRow++;
    deltaCol++;
    direction = "DOWNLEFT";
  }
  public void moveDownRight(){
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
    tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() + 1).setPieceName(descriptor.getPieceName());
    tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() + 1).setPlayer(players[whosTurn]);
    newFrom.setLocationType(LocationType.CLEAR);
    newFrom.setRow(newFrom.getRow() - 1);
    newFrom.setColumn(newFrom.getColumn() + 1);
    deltaRow++;
    deltaCol--;
    direction = "DOWNRIGHT";
  }

  /** HEX MOVES **/
  public void moveUpHEX(){
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
    tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
    tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
    newFrom.setLocationType(LocationType.CLEAR);
    newFrom.setRow(newFrom.getRow() + 1);
    deltaRow--;
    direction = "UP";
  }
  public void moveDownHEX(){
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
    tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
    tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
    newFrom.setRow(newFrom.getRow() - 1);
    deltaRow++;
  }
  public void moveUpLeftHEX(){
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
    tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() - 1).setPieceName(descriptor.getPieceName());
    tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() - 1).setPlayer(players[whosTurn]);
    newFrom.setLocationType(LocationType.CLEAR);
    newFrom.setRow(newFrom.getRow() + 1);
    newFrom.setColumn(newFrom.getColumn() - 1);
    deltaRow--;
    deltaCol++;
    direction = "UPLEFT";
  }
  public void moveUpRightHEX(){
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
    tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() + 1).setPieceName(descriptor.getPieceName());
    tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn() + 1).setPlayer(players[whosTurn]);
    newFrom.setLocationType(LocationType.CLEAR);
    newFrom.setRow(newFrom.getRow());
    newFrom.setColumn(newFrom.getColumn() + 1);
    deltaCol--;
    direction = "UPRIGHT";
  }
  public void moveDownLeftHEX(){
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
    tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() - 1).setLocationType(LocationType.CLEAR);
    tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() - 1).setPlayer(players[whosTurn]);
    newFrom.setLocationType(LocationType.CLEAR);
    newFrom.setRow(newFrom.getRow());
    newFrom.setColumn(newFrom.getColumn() - 1);
    deltaRow++;
    deltaCol++;
    direction = "DOWNLEFT";
  }
  public void moveDownRightHEX(){
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
    tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
    tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() + 1).setPieceName(descriptor.getPieceName());
    tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn() + 1).setPlayer(players[whosTurn]);
    newFrom.setLocationType(LocationType.CLEAR);
    newFrom.setRow(newFrom.getRow() - 1);
    newFrom.setColumn(newFrom.getColumn() + 1);
    deltaRow++;
    deltaCol--;
    direction = "DOWNRIGHT";
  }
}
