package escape.builder;

// Imports
//*********************************
import escape.*;
import escape.required.EscapeException;
import escape.required.EscapePiece.PieceName;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class OMNIMovementTestsFail {

  /********************** OMNI MOVEMENT TESTS FAIL **********************/
  //***************************************************************************************************************************
  @Test /** 99 **/
  void checkMoveOMNIUpBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
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
  @Test /** 100 **/
  void checkMoveOMNIDownBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
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
  @Test /** 101 **/
  void checkMoveOMNILeftBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
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
  //***************************************************************************************************************************
  @Test /** 102 **/
  void checkMoveOMNIRightBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
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
  @Test /** 103 **/
  void checkMoveOMNIUpRightBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests3.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(6, 6);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordB.getRow(), coordA.getRow());
    assertEquals(coordB.getColumn(), coordA.getColumn());
    System.out.println("A Row: " + coordA.getRow() + " A Column: " + coordA.getColumn());
    System.out.println("B Row: " + coordB.getRow() + " B Column: " + coordB.getColumn());;

  }
  //***************************************************************************************************************************
  @Test /** 104 **/
  void checkMoveOMNIUpLeftBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests4.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
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
  @Test /** 105 **/
  void checkMoveOMNIDownRightBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests5.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(1, 5);
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
  @Test /** 106 **/
  void checkMoveOMNIDownLeftBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests6.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(2, 2);
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
  @Test /** 107 **/
  void checkMoveOMNIUpPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests7.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
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
  @Test /** 108 **/
  void checkMoveOMNIDownPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests7.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
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
  @Test /** 109 **/
  void checkMoveOMNILeftPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests8.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
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
  @Test /** 110 **/
  void checkMoveOMNIRightPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests8.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
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
  @Test /** 111 **/
  void checkMoveOMNIUpRightPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests8.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(6, 6);
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
  @Test /** 112 **/
  void checkMoveOMNIUpLeftPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests8.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(6, 2);
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
  @Test /** 113 **/
  void checkMoveOMNIDownRightPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests8.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(2, 6);
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
  @Test /** 114 **/
  void checkMoveOMNIDownLeftPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests8.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(2, 2);
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
  @Test /** 115 **/
  void checkMoveOMNIUpUpRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests8.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(6, 5);
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
  @Test /** 116 **/
  void checkMoveOMNIUpUpLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests8.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(6, 3);
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
  @Test /** 117 **/
  void checkMoveOMNIDownDownRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests8.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(2, 5);
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
  @Test /** 118 **/
  void checkMoveOMNIDownDownLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNINegativeTests8.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(2, 3);
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
  @Test /** 119 **/
  void checkMoveOMNITooFar() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNIPositiveTests.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
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
  @Test /** 120 **/
  void checkMoveOMNIOffBoard() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/HEXOMNIPositiveTests.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
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
