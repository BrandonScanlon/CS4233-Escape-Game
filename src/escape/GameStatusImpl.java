package escape;

import escape.required.Coordinate;
import escape.required.GameStatus;

public class GameStatusImpl implements GameStatus {
  private MoveResult moveResult;
  private CombatResult combatResult;
  private boolean validMove;
  private Coordinate finalLocation;


  /**
   * WIN:  Player that moved wins the game
   * LOSE: Player that moved loses the game
   * DRAW: The game is over and is a draw
   * NONE: The game is still in progress and neither player has won
   */
  public static enum MoveResult { WIN, LOSE, DRAW, NONE }

  /**
   * ATTACKER: The player that moved attacked another piece and won
   * DEFENDER: The defending piece won the battle
   * DRAW:     The battle was a draw
   * NONE:     There was no battle
   */
  public static enum CombatResult { ATTACKER, DEFENDER, DRAW, NONE }

  public void setValidMove(boolean validMove){ this.validMove = validMove; }

  /**
   * @return true if the move was a valid move, fals if not (an exception may have
   * been thown in some cases)
   */
  public boolean isValidMove(){
   return validMove;
  }

  /**
   * @return true if more informaton was sent to the objservers
   */
  public boolean isMoreInformation(){
    return false;
  }

  public void setMoveResult(MoveResult moveResult){ this.moveResult = moveResult; }

  /**
   * @return an indicator if the game ended and the state of win/loss
   */
  public MoveResult getMoveResult(){ return moveResult; }

  public void setCombatResult(CombatResult combatResult){ this.combatResult = combatResult; }

  public CombatResult getCombatResult(){ return combatResult; }

  /**
   * @return the location of the moving piece after the move if it is different
   * the destination (to) specified in the move();
   */
  public Coordinate finalLocation(){
//    System.out.println("Successfully Moved To:");
//    System.out.println(finalLocation.toString());
//    return finalLocation;
    return null;
  }

  public void setFinalLocation(Coordinate finalLocation){ this.finalLocation = finalLocation; }
}
