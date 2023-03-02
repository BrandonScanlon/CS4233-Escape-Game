package escape.square_movement;

// Imports
//*********************************
import escape.builder.EscapeGameBuilder;
import escape.coordinate.CoordinateImpl;
import escape.manager.EscapeGameManagerImpl;
import escape.required.EscapePiece.PieceName;
import escape.utils.GameStatusImpl;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LinearMovementTestsFail {

  /********************** LINEAR MOVEMENT TESTS FAIL **********************/
  //***************************************************************************************************************************
  @Test /** 37 **/
  void checkMoveLinearUpBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(6, 4);
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
  @Test /** 38 **/
  void checkMoveLinearDownBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(2, 4);
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
  @Test /** 39 **/
  void checkMoveLinearLeftBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(4, 2);
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
  @Test /** 40 **/
  void checkMoveLinearRightBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(4, 6);
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
  @Test /** 41 **/
  void checkMoveLinearUpRightBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(6, 6);
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
  @Test /** 42 **/
  void checkMoveLinearUpLeftBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(6, 2);
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
  @Test /** 43 **/
  void checkMoveLinearDownRightBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(2, 6);
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
  @Test /** 44 **/
  void checkMoveLinearDownLeftBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(2, 2);
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
  @Test /** 45 **/
  void checkMoveLinearUpPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(6, 4);
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
  @Test /** 46 **/
  void checkMoveLinearDownPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(2, 4);
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
  @Test /** 47 **/
  void checkMoveLinearLeftPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(2, 4);
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
  @Test /** 48 **/
  void checkMoveLinearRightPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(4, 6);
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
  @Test /** 49 **/
  void checkMoveLinearUpRightPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(6, 6);
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
  @Test /** 50 **/
  void checkMoveLinearUpLeftPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(6, 2);
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
  @Test /** 51 **/
  void checkMoveLinearDownRightPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(2, 6);
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
  @Test /** 52 **/
  void checkMoveLinearDownLeftPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(2, 2);
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
  @Test /** 53 **/
  void checkMoveLinearUpUpRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(6, 5);
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
  @Test /** 54 **/
  void checkMoveLinearUpUpLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(6, 3);
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
  @Test /** 55 **/
  void checkMoveLinearDownDownRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(2, 5);
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
  @Test /** 56 **/
  void checkMoveLinearDownDownLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(2, 3);
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
  @Test /** 57 **/
  void checkMoveLinearTooFar() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
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
  @Test /** 58 **/
  void checkMoveLinearOffBoard() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(0, 0);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    EscapeGameManagerImpl finalEgm = egm;
    assertThrows(NullPointerException.class, () -> {
      finalEgm.move(coordA, coordB);
    });;
  }
  //***************************************************************************************************************************
  @Test /** 59 **/
  void checkMoveLinearOffBoard2() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/linear configurations/LinearNegativeTests1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.DOG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(-1, -1);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    EscapeGameManagerImpl finalEgm = egm;
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
      finalEgm.move(coordA, coordB);
    });
  }
}
