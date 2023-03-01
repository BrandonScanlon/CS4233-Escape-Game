package escape.HEX_Movement;

// Imports
//*********************************
import escape.*;
import escape.Builder.EscapeGameBuilder;
import escape.required.EscapePiece.PieceName;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HEXOMNIMovementTests {

  /********************** HEXOMNI MOVEMENT TESTS **********************/
  //***************************************************************************************************************************
  @Test /**  **/
  void checkMoveHEXOMNIUp() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/HEX OMNI Configurations/HEXOMNIPositiveTests.egc").makeGameManager();
    } catch (Exception e){
      e.printStackTrace();
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(0, 0);
    coordA.setPieceName(PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(4, 0);
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
  @Test /**  **/
  void checkMoveHEXOMNIDown() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/HEX OMNI Configurations/HEXOMNIPositiveTests.egc").makeGameManager();
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
  @Test /**  **/
  void checkMoveHEXOMNILeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/HEX OMNI Configurations/HEXOMNIPositiveTests.egc").makeGameManager();
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
  @Test /**  **/
  void checkMoveHEXOMNIRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/HEX OMNI Configurations/HEXOMNIPositiveTests.egc").makeGameManager();
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
  @Test /**  **/
  void checkMoveHEXOMNIUpRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/HEX OMNI Configurations/HEXOMNIPositiveTests.egc").makeGameManager();
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
  @Test /**  **/
  void checkMoveHEXOMNIUpLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/HEX OMNI Configurations/HEXOMNIPositiveTests.egc").makeGameManager();
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
  @Test /**  **/
  void checkMoveHEXOMNIDownRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/HEX OMNI Configurations/HEXOMNIPositiveTests.egc").makeGameManager();
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
  @Test /**  **/
  void checkMoveHEXOMNIDownLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/HEX OMNI Configurations/HEXOMNIPositiveTests.egc").makeGameManager();
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
  @Test /**  **/
  void checkMoveHEXOMNIUpUpRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/HEX OMNI Configurations/HEXOMNIPositiveTests.egc").makeGameManager();
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
  @Test /**  **/
  void checkMoveHEXOMNIUpUpLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/HEX OMNI Configurations/HEXOMNIPositiveTests.egc").makeGameManager();
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
  @Test /**  **/
  void checkMoveHEXOMNIDownDownRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/HEX OMNI Configurations/HEXOMNIPositiveTests.egc").makeGameManager();
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
  @Test /**  **/
  void checkMoveHEXOMNIDownDownLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/HEX OMNI Configurations/HEXOMNIPositiveTests.egc").makeGameManager();
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
