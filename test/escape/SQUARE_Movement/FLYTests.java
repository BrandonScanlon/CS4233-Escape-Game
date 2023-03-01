package escape.SQUARE_Movement;

// Imports
//*********************************
import escape.*;
import escape.Builder.EscapeGameBuilder;
import escape.required.EscapePiece.PieceName;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FLYTests {

  /********************** FLY MOVEMENT TESTS **********************/
  //***************************************************************************************************************************
  @Test /** 68 **/
  void checkMoveFLYUp() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config10.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.BIRD);
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
  @Test /** 69 **/
  void checkMoveFLYDown() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config10.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.BIRD);
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
  @Test /** 70 **/
  void checkMoveFLYLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config10.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.BIRD);
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
  @Test /** 45 **/
  void checkMoveFLYRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config10.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.BIRD);
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
  @Test /** 46 **/
  void checkMoveFLYUpRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config10.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.BIRD);
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
  @Test /** 47 **/
  void checkMoveFLYUpLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config10.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.BIRD);
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
  @Test /** 48 **/
  void checkMoveFLYDownRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config10.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.BIRD);
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
  @Test /** 49 **/
  void checkMoveFLYDownLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config10.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.BIRD);
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
  @Test /** 50 **/
  void checkMoveFLYUpUpRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config10.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.BIRD);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(6, 5);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(false);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
  }
  //***************************************************************************************************************************
  @Test /** 51 **/
  void checkMoveFLYUpUpLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config10.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.BIRD);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(3, 6);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(false);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
  }
  //***************************************************************************************************************************
  @Test /** 52 **/
  void checkMoveFLYDownDownRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config10.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.BIRD);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(2, 5);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(false);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
  }
  //***************************************************************************************************************************
  @Test /** 53 **/
  void checkMoveFLYDownDownLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config10.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.BIRD);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(3, 2);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(false);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
  }
  //***************************************************************************************************************************
  @Test /** 54 **/
  void checkMoveFLYTooFar() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config10.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.BIRD);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(10, 10);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(false);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
  }
}
