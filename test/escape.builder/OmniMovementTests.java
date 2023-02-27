package escape.builder;

// Imports
//*********************************
import escape.*;
import escape.required.EscapePiece.PieceName;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class OmniMovementTests {

  /********************** OMNI MOVEMENT TESTS **********************/
  //***************************************************************************************************************************
  @Test /** 55 **/
  void checkMoveOmniUp() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config9.egc").makeGameManager();
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
  }
  //***************************************************************************************************************************
  @Test /** 56 **/
  void checkMoveOmniDown() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config9.egc").makeGameManager();
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
  }
  //***************************************************************************************************************************
  @Test /** 57 **/
  void checkMoveOmniLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config9.egc").makeGameManager();
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
  }
  //***************************************************************************************************************************
  @Test /** 58 **/
  void checkMoveOmniRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config9.egc").makeGameManager();
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
  }

  //***************************************************************************************************************************
  @Test /** 59 **/
  void checkMoveOmniUpRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config9.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(5, 5);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordA.getRow(), coordB.getRow());
    assertEquals(coordA.getColumn(), coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 60 **/
  void checkMoveOmniUpLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config9.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(3, 5);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordA.getRow(), coordB.getRow());
    assertEquals(coordA.getColumn(), coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 61 **/
  void checkMoveOmniDownRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config9.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(5, 3);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordA.getRow(), coordB.getRow());
    assertEquals(coordA.getColumn(), coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 62 **/
  void checkMoveOmniDownLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config9.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(3, 3);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordA.getRow(), coordB.getRow());
    assertEquals(coordA.getColumn(), coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 63 **/
  void checkMoveOmniUpUpRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config9.egc").makeGameManager();
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
  }
  //***************************************************************************************************************************
  @Test /** 64 **/
  void checkMoveOmniUpUpLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config9.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(3, 6);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordA.getRow(), coordB.getRow());
    assertEquals(coordA.getColumn(), coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 65 **/
  void checkMoveOmniDownDownRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config9.egc").makeGameManager();
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
  }
  //***************************************************************************************************************************
  @Test /** 66 **/
  void checkMoveOmniDownDownLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config9.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(3, 2);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordA.getRow(), coordB.getRow());
    assertEquals(coordA.getColumn(), coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 67 **/
  void checkMoveOmniTooFar() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config9.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(8, 8);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(false);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
  }
}
