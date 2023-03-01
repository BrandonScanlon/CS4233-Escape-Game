package escape.SQUARE_Movement;

// Imports
//*********************************
import escape.*;
import escape.Builder.EscapeGameBuilder;
import escape.required.EscapePiece.PieceName;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class OMNIMovementTests {

  /********************** OMNI MOVEMENT TESTS **********************/
  //***************************************************************************************************************************
  @Test /** 87 **/
  void checkMoveOmniUp() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/OMNIPositiveTests.egc").makeGameManager();
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
    assertEquals(coordA.getRow(), coordB.getRow());
    assertEquals(coordA.getColumn(), coordB.getColumn());
    System.out.println("coordA: " + coordA.getRow() + ", " + coordA.getColumn());
    System.out.println("coordB: " + coordB.getRow() + ", " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 88 **/
  void checkMoveOmniDown() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/OMNIPositiveTests.egc").makeGameManager();
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
    assertEquals(coordA.getRow(), coordB.getRow());
    assertEquals(coordA.getColumn(), coordB.getColumn());
    System.out.println("coordA: " + coordA.getRow() + ", " + coordA.getColumn());
    System.out.println("coordB: " + coordB.getRow() + ", " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 89 **/
  void checkMoveOmniLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/OMNIPositiveTests.egc").makeGameManager();
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
    assertEquals(coordA.getRow(), coordB.getRow());
    assertEquals(coordA.getColumn(), coordB.getColumn());
    System.out.println("coordA: " + coordA.getRow() + ", " + coordA.getColumn());
    System.out.println("coordB: " + coordB.getRow() + ", " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 90 **/
  void checkMoveOmniRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/OMNIPositiveTests.egc").makeGameManager();
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
    assertEquals(coordA.getRow(), coordB.getRow());
    assertEquals(coordA.getColumn(), coordB.getColumn());
    System.out.println("coordA: " + coordA.getRow() + ", " + coordA.getColumn());
    System.out.println("coordB: " + coordB.getRow() + ", " + coordB.getColumn());
  }

  //***************************************************************************************************************************
  @Test /** 91 **/
  void checkMoveOmniUpRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/OMNIPositiveTests.egc").makeGameManager();
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
    assertEquals(coordA.getRow(), coordB.getRow());
    assertEquals(coordA.getColumn(), coordB.getColumn());
    System.out.println("coordA: " + coordA.getRow() + ", " + coordA.getColumn());
    System.out.println("coordB: " + coordB.getRow() + ", " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 92 **/
  void checkMoveOmniUpLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/OMNIPositiveTests.egc").makeGameManager();
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
    assertEquals(coordA.getRow(), coordB.getRow());
    assertEquals(coordA.getColumn(), coordB.getColumn());
    System.out.println("coordA: " + coordA.getRow() + ", " + coordA.getColumn());
    System.out.println("coordB: " + coordB.getRow() + ", " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 93 **/
  void checkMoveOmniDownRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/OMNIPositiveTests.egc").makeGameManager();
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
    assertEquals(coordA.getRow(), coordB.getRow());
    assertEquals(coordA.getColumn(), coordB.getColumn());
    System.out.println("coordA: " + coordA.getRow() + ", " + coordA.getColumn());
    System.out.println("coordB: " + coordB.getRow() + ", " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 94 **/
  void checkMoveOmniDownLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/OMNIPositiveTests.egc").makeGameManager();
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
    assertEquals(coordA.getRow(), coordB.getRow());
    assertEquals(coordA.getColumn(), coordB.getColumn());
    System.out.println("coordA: " + coordA.getRow() + ", " + coordA.getColumn());
    System.out.println("coordB: " + coordB.getRow() + ", " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 95 **/
  void checkMoveOmniUpUpRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/OMNIPositiveTests.egc").makeGameManager();
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
    assertEquals(coordA.getRow(), coordB.getRow());
    assertEquals(coordA.getColumn(), coordB.getColumn());
    System.out.println("coordA: " + coordA.getRow() + ", " + coordA.getColumn());
    System.out.println("coordB: " + coordB.getRow() + ", " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 96 **/
  void checkMoveOmniUpUpLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/OMNIPositiveTests.egc").makeGameManager();
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
    assertEquals(coordA.getRow(), coordB.getRow());
    assertEquals(coordA.getColumn(), coordB.getColumn());
    System.out.println("coordA: " + coordA.getRow() + ", " + coordA.getColumn());
    System.out.println("coordB: " + coordB.getRow() + ", " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 97 **/
  void checkMoveOmniDownDownRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/OMNIPositiveTests.egc").makeGameManager();
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
    assertEquals(coordA.getRow(), coordB.getRow());
    assertEquals(coordA.getColumn(), coordB.getColumn());
    System.out.println("coordA: " + coordA.getRow() + ", " + coordA.getColumn());
    System.out.println("coordB: " + coordB.getRow() + ", " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 98 **/
  void checkMoveOmniDownDownLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/OMNI Configurations/OMNIPositiveTests.egc").makeGameManager();
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
    assertEquals(coordA.getRow(), coordB.getRow());
    assertEquals(coordA.getColumn(), coordB.getColumn());
    System.out.println("coordA: " + coordA.getRow() + ", " + coordA.getColumn());
    System.out.println("coordB: " + coordB.getRow() + ", " + coordB.getColumn());
  }
}
