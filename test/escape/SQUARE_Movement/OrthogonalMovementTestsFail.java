package escape.SQUARE_Movement;

// Imports
//*********************************
import escape.*;
import escape.Builder.EscapeGameBuilder;
import escape.required.EscapePiece.PieceName;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class OrthogonalMovementTestsFail {

  /********************** ORTHOGONAL MOVEMENT TESTS FAIL **********************/


  /*************************************************** SINGLE BLOCK TESTS *************************************************/
  @Test /** 72 **/
  void checkMoveOrthogonalUpBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Orthogonal Configurations/OrthogonalNegativeTests.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(6, 4);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordB.getRow(), coordA.getRow());
    assertEquals(coordB.getColumn(), coordA.getColumn());
    System.out.println("A Row: " + coordA.getRow() + " A Column: " + coordA.getColumn());
    System.out.println("B Row: " + coordB.getRow() + " B Column: " + coordB.getColumn());
  }
  //******************************************************************************************************************
  @Test /** 73 **/
  void checkMoveOrthogonalDownBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Orthogonal Configurations/OrthogonalNegativeTests.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(2, 4);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordB.getRow(), coordA.getRow());
    assertEquals(coordB.getColumn(), coordA.getColumn());
    System.out.println("A Row: " + coordA.getRow() + " A Column: " + coordA.getColumn());
    System.out.println("B Row: " + coordB.getRow() + " B Column: " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 74 **/
  void checkMoveOrthogonalRightBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Orthogonal Configurations/OrthogonalNegativeTests2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(4, 6);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordB.getRow(), coordA.getRow());
    assertEquals(coordB.getColumn(), coordA.getColumn());
    System.out.println("A Row: " + coordA.getRow() + " A Column: " + coordA.getColumn());
    System.out.println("B Row: " + coordB.getRow() + " B Column: " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 75 **/
  void checkMoveOrthogonalLeftBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Orthogonal Configurations/OrthogonalNegativeTests2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(4, 2);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordB.getRow(), coordA.getRow());
    assertEquals(coordB.getColumn(), coordA.getColumn());
    System.out.println("A Row: " + coordA.getRow() + " A Column: " + coordA.getColumn());
    System.out.println("B Row: " + coordB.getRow() + " B Column: " + coordB.getColumn());
  }


  /*************************************************** DOUBLE BLOCK TESTS *************************************************/
  //***************************************************************************************************************************
  @Test /** 76 **/
  void checkMoveOrthogonalUpRightBlocks() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Orthogonal Configurations/OrthogonalNegativeTests3.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(6, 4);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordB.getRow(), coordA.getRow());
    assertEquals(coordB.getColumn(), coordA.getColumn());
    System.out.println("A Row: " + coordA.getRow() + " A Column: " + coordA.getColumn());
    System.out.println("B Row: " + coordB.getRow() + " B Column: " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 77 **/
  void checkMoveOrthogonalUpLeftBlocks() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Orthogonal Configurations/OrthogonalNegativeTests4.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(6, 4);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordB.getRow(), coordA.getRow());
    assertEquals(coordB.getColumn(), coordA.getColumn());
    System.out.println("A Row: " + coordA.getRow() + " A Column: " + coordA.getColumn());
    System.out.println("B Row: " + coordB.getRow() + " B Column: " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 78 **/
  void checkMoveOrthogonalDownRightBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Orthogonal Configurations/OrthogonalNegativeTests5.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(2, 4);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordB.getRow(), coordA.getRow());
    assertEquals(coordB.getColumn(), coordA.getColumn());
    System.out.println("A Row: " + coordA.getRow() + " A Column: " + coordA.getColumn());
    System.out.println("B Row: " + coordB.getRow() + " B Column: " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 79 **/
  void checkMoveOrthogonalDownLeftBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Orthogonal Configurations/OrthogonalNegativeTests6.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(2, 4);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordB.getRow(), coordA.getRow());
    assertEquals(coordB.getColumn(), coordA.getColumn());
    System.out.println("A Row: " + coordA.getRow() + " A Column: " + coordA.getColumn());
    System.out.println("B Row: " + coordB.getRow() + " B Column: " + coordB.getColumn());
  }

  /*************************************************** SINGLE PIECE TESTS *************************************************/
  //***************************************************************************************************************************
  @Test /** 80 **/
  void checkMoveOrthogonalUpPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Orthogonal Configurations/OrthogonalNegativeTests7.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(6, 4);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordB.getRow(), coordA.getRow());
    assertEquals(coordB.getColumn(), coordA.getColumn());
    System.out.println("A Row: " + coordA.getRow() + " A Column: " + coordA.getColumn());
    System.out.println("B Row: " + coordB.getRow() + " B Column: " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 81 **/
  void checkMoveOrthogonalDownPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Orthogonal Configurations/OrthogonalNegativeTests7.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(2, 4);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordB.getRow(), coordA.getRow());
    assertEquals(coordB.getColumn(), coordA.getColumn());
    System.out.println("A Row: " + coordA.getRow() + " A Column: " + coordA.getColumn());
    System.out.println("B Row: " + coordB.getRow() + " B Column: " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 82 **/
  void checkMoveOrthogonalRightPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Orthogonal Configurations/OrthogonalNegativeTests8.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(4, 6);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordB.getRow(), coordA.getRow());
    assertEquals(coordB.getColumn(), coordA.getColumn());
    System.out.println("A Row: " + coordA.getRow() + " A Column: " + coordA.getColumn());
    System.out.println("B Row: " + coordB.getRow() + " B Column: " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 83 **/
  void checkMoveOrthogonalLeftPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Orthogonal Configurations/OrthogonalNegativeTests8.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(4, 2);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordB.getRow(), coordA.getRow());
    assertEquals(coordB.getColumn(), coordA.getColumn());
    System.out.println("A Row: " + coordA.getRow() + " A Column: " + coordA.getColumn());
    System.out.println("B Row: " + coordB.getRow() + " B Column: " + coordB.getColumn());
  }

  /*************************************************** DISTANCE TESTS *************************************************/
  //***************************************************************************************************************************
  @Test /** 84 **/
  void checkMoveOrthogonalTooFar() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Orthogonal Configurations/OrthogonalNegativeTests.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(10, 10);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(false);

    CoordinateImpl startingCoord = egm.makeCoordinate(4, 4);
    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(startingCoord.getRow(), coordA.getRow());
    assertEquals(startingCoord.getColumn(), coordA.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 85 **/
  void checkMoveOrthogonalOffBoard() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Orthogonal Configurations/OrthogonalNegativeTests.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(0, 0);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(false);

    CoordinateImpl startingCoord = egm.makeCoordinate(4, 4);
    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(startingCoord.getRow(), coordA.getRow());
    assertEquals(startingCoord.getColumn(), coordA.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 86 **/
  void checkMoveOrthogonalOffBoard2() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Orthogonal Configurations/OrthogonalNegativeTests.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(-1, -1);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(false);

    CoordinateImpl startingCoord = egm.makeCoordinate(4, 4);
    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(startingCoord.getRow(), coordA.getRow());
    assertEquals(startingCoord.getColumn(), coordA.getColumn());
  }
}
