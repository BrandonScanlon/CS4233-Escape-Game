package escape.builder;

// Imports
//*********************************
import escape.*;
import escape.required.EscapePiece.PieceName;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class OrthogonalMovementTestsFail {

  /********************** ORTHOGONAL MOVEMENT TESTS FAIL **********************/
  //***************************************************************************************************************************
  @Test /**  **/
  void checkMoveOrthogonalUpBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config13.egc").makeGameManager();
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
    // Have a check for the piece distance and determine if it should or shouldn't be valid
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordB.getRow(), coordA.getRow());
    assertEquals(coordB.getColumn(), coordA.getColumn());
    System.out.println("A Row: " + coordA.getRow() + " A Column: " + coordA.getColumn());
    System.out.println("B Row: " + coordB.getRow() + " B Column: " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /**  **/
  void checkMoveOrthogonalUpAndRightBlocks() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config14.egc").makeGameManager();
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
    // Have a check for the piece distance and determine if it should or shouldn't be valid
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordB.getRow(), coordA.getRow());
    assertEquals(coordB.getColumn(), coordA.getColumn());
    System.out.println("A Row: " + coordA.getRow() + " A Column: " + coordA.getColumn());
    System.out.println("B Row: " + coordB.getRow() + " B Column: " + coordB.getColumn());
  }
  //***************************************************************************************************************************
  @Test /**  **/
  void checkMoveOrthogonalUpRightAndLeftBlocks() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config15.egc").makeGameManager();
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
    // Have a check for the piece distance and determine if it should or shouldn't be valid
    status.setValidMove(false);

    CoordinateImpl startingCoord = egm.makeCoordinate(4, 4);
    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    System.out.println("A Row: " + coordA.getRow() + " A Column: " + coordA.getColumn());
    System.out.println("B Row: " + coordB.getRow() + " B Column: " + coordB.getColumn());
    assertEquals(startingCoord.getRow(), coordA.getRow());
    assertEquals(startingCoord.getColumn(), coordA.getColumn());
    System.out.println("A Row: " + coordA.getRow() + " A Column: " + coordA.getColumn());
    System.out.println("B Row: " + coordB.getRow() + " B Column: " + coordB.getColumn());
  }












  //***************************************************************************************************************************
  @Test /**  **/
  void checkMoveOrthogonalDownBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config11.egc").makeGameManager();
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
    status.setValidMove(false);

    CoordinateImpl startingCoord = egm.makeCoordinate(4, 4);
    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(startingCoord.getRow(), coordA.getRow());
    assertEquals(startingCoord.getColumn(), coordA.getColumn());
  }
  //***************************************************************************************************************************
  @Test /**  **/
  void checkMoveOrthogonalLeftBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config11.egc").makeGameManager();
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
    status.setValidMove(false);

    CoordinateImpl startingCoord = egm.makeCoordinate(4, 4);
    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(startingCoord.getRow(), coordA.getRow());
    assertEquals(startingCoord.getColumn(), coordA.getColumn());
  }
  //***************************************************************************************************************************
  @Test /**  **/
  void checkMoveOrthogonalRightBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config11.egc").makeGameManager();
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
    status.setValidMove(false);

    CoordinateImpl startingCoord = egm.makeCoordinate(4, 4);
    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(startingCoord.getRow(), coordA.getRow());
    assertEquals(startingCoord.getColumn(), coordA.getColumn());
  }

  //***************************************************************************************************************************
  @Test /** 41 **/
  void checkMoveOrthogonalUpRightBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config11.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
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
  void checkMoveOrthogonalUpLeftBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config11.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
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
  void checkMoveOrthogonalDownRightBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config11.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
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
  void checkMoveOrthogonalDownLeftBlock() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config11.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
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
  void checkMoveOrthogonalUpPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config12.egc").makeGameManager();
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
    status.setValidMove(false);

    CoordinateImpl startingCoord = egm.makeCoordinate(4, 4);
    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(startingCoord.getRow(), coordA.getRow());
    assertEquals(startingCoord.getColumn(), coordA.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 46 **/
  void checkMoveOrthogonalDownPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config12.egc").makeGameManager();
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
    status.setValidMove(false);

    CoordinateImpl startingCoord = egm.makeCoordinate(4, 4);
    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(startingCoord.getRow(), coordA.getRow());
    assertEquals(startingCoord.getColumn(), coordA.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 47 **/
  void checkMoveOrthogonalLeftPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config12.egc").makeGameManager();
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
    status.setValidMove(false);

    CoordinateImpl startingCoord = egm.makeCoordinate(4, 4);
    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(startingCoord.getRow(), coordA.getRow());
    assertEquals(startingCoord.getColumn(), coordA.getColumn());
  }
  //***************************************************************************************************************************
  @Test /** 48 **/
  void checkMoveOrthogonalRightPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config12.egc").makeGameManager();
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
    status.setValidMove(false);

    CoordinateImpl startingCoord = egm.makeCoordinate(4, 4);
    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(startingCoord.getRow(), coordA.getRow());
    assertEquals(startingCoord.getColumn(), coordA.getColumn());
  }

  //***************************************************************************************************************************
  @Test /** 49 **/
  void checkMoveOrthogonalUpRightPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config12.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
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
  void checkMoveOrthogonalUpLeftPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config12.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
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
  void checkMoveOrthogonalDownRightPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config12.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
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
  void checkMoveOrthogonalDownLeftPiece() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config12.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
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
  void checkMoveOrthogonalUpUpRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config11.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
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
  void checkMoveOrthogonalUpUpLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config11.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
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
  void checkMoveOrthogonalDownDownRight() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config11.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
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
  void checkMoveOrthogonalDownDownLeft() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config11.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(4, 4);
    coordA.setPieceName(PieceName.SNAIL);
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
  void checkMoveOrthogonalTooFar() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config11.egc").makeGameManager();
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
  @Test /** 58 **/
  void checkMoveOrthogonalOffBoard() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config11.egc").makeGameManager();
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
  @Test /** 59 **/
  void checkMoveOrthogonalOffBoard2() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config11.egc").makeGameManager();
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
