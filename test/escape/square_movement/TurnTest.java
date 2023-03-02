package escape.square_movement;

import escape.builder.EscapeGameBuilder;
import escape.coordinate.CoordinateImpl;
import escape.manager.EscapeGameManagerImpl;
import escape.utils.GameStatusImpl;
import escape.required.EscapePiece;
import escape.required.GameStatus;
import escape.required.LocationType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnTest {
  //***************************************************************************************************************************
  @Test
  /** **/
  void checkFullGame1() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/turn configurations/FullGame.egc").makeGameManager();
    } catch (Exception e){
      e.printStackTrace();
      fail("Exception from escape builder: " + e.getMessage());
    }

    /** CHRIS' PIECES **/
    CoordinateImpl CF = new CoordinateImpl(8, 3);
    CoordinateImpl CH = new CoordinateImpl(6, 8);
    CoordinateImpl CB = new CoordinateImpl(10, 6);
    CoordinateImpl CS = new CoordinateImpl(17, 2);
    CoordinateImpl CD = new CoordinateImpl(4, 14);

    /** PAT'S PIECES **/
    CoordinateImpl PF = new CoordinateImpl(8, 13);
    CoordinateImpl PH = new CoordinateImpl(8, 17);
    CoordinateImpl PB = new CoordinateImpl(7, 16);
    CoordinateImpl PS = new CoordinateImpl(10, 13);
    CoordinateImpl PD = new CoordinateImpl(9, 8);

    /** Check all pieces line up **/
    EscapePiece.PieceName pieceName = egm.getGameBoard().getBoardLocation(CF.getRow(), CF.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.FROG);

    pieceName = egm.getGameBoard().getBoardLocation(CH.getRow(), CH.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.HORSE);

    pieceName = egm.getGameBoard().getBoardLocation(CB.getRow(), CB.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.BIRD);

    pieceName = egm.getGameBoard().getBoardLocation(CS.getRow(), CS.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.SNAIL);

    pieceName = egm.getGameBoard().getBoardLocation(CD.getRow(), CD.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.DOG);

    pieceName = egm.getGameBoard().getBoardLocation(PF.getRow(), PF.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.FROG);

    pieceName = egm.getGameBoard().getBoardLocation(PH.getRow(), PH.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.HORSE);

    pieceName = egm.getGameBoard().getBoardLocation(PB.getRow(), PB.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.BIRD);

    pieceName = egm.getGameBoard().getBoardLocation(PS.getRow(), PS.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.SNAIL);

    pieceName = egm.getGameBoard().getBoardLocation(PD.getRow(), PD.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.DOG);

    /** Check validMove is true **/
    GameStatusImpl gameStatus = new GameStatusImpl();
    gameStatus.setValidMove(true);
    assertTrue(gameStatus.isValidMove());

    /** Check moveResult is NONE **/
    GameStatusImpl simpleMove = new GameStatusImpl();
    simpleMove.setMoveResult(GameStatusImpl.MoveResult.NONE);
    assertEquals(simpleMove.getMoveResult(), GameStatusImpl.MoveResult.NONE);

    /** Check moveResult is LOSE **/
    GameStatusImpl losingMove = new GameStatusImpl();
    losingMove.setMoveResult(GameStatusImpl.MoveResult.LOSE);
    assertEquals(losingMove.getMoveResult(), GameStatusImpl.MoveResult.LOSE);

    /** Check moveResult is WIN **/
    GameStatusImpl winningMove = new GameStatusImpl();
    winningMove.setMoveResult(GameStatusImpl.MoveResult.WIN);
    assertEquals(winningMove.getMoveResult(), GameStatusImpl.MoveResult.WIN);


    /** Would you like to play a game? **/
    System.out.println("******** GAME INITIALIZED ********");
    GameStatus aMove = null;
    CoordinateImpl TO = null;

    // First Move
    TO = new CoordinateImpl(13, 9);
    aMove = egm.move(CB, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    assertEquals(egm.getGameBoard().getBoardLocation(10, 6).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(10, 6).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(10, 6).getLocationType(), LocationType.CLEAR);
    System.out.println("First Move: ");
    System.out.println("(" + CB.getRow() + ", " + CB.getColumn() + ")\n");

    // Second Move
    TO = new CoordinateImpl(11, 12);
    aMove = egm.move(PS, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    assertEquals(egm.getGameBoard().getBoardLocation(10, 13).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(10, 13).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(10, 13).getLocationType(), LocationType.CLEAR);
    System.out.println("Second Move: ");
    System.out.println("(" + PS.getRow() + ", " + PS.getColumn() + ")\n");

    egm.getGameBoard().printBoard();
    // Third Move
    TO = new CoordinateImpl(13, 10);
    aMove = egm.move(CB, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    assertEquals(egm.getGameBoard().getBoardLocation(13, 9).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(13, 9).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(13, 9).getLocationType(), LocationType.CLEAR);

    assertEquals(egm.getGameBoard().getBoardLocation(13, 10).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(13, 10).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(13, 10).getLocationType(), LocationType.EXIT);

    System.out.println("Third Move: ");
    System.out.println("(" + CB.getRow() + ", " + CB.getColumn() + ")\n");

    // Fourth Move
    TO = new CoordinateImpl(12, 11);
    aMove = egm.move(PS, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    assertEquals(egm.getGameBoard().getBoardLocation(11, 12).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(11, 12).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(11, 12).getLocationType(), LocationType.CLEAR);
    System.out.println("Fourth Move: ");
    System.out.println("(" + PS.getRow() + ", " + PS.getColumn() + ")\n");

    // Fifth Move
    TO = new CoordinateImpl(10, 4);
    aMove = egm.move(CF, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    assertEquals(egm.getGameBoard().getBoardLocation(8, 3).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(8, 3).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(8, 3).getLocationType(), LocationType.CLEAR);
    System.out.println("Fifth Move: ");
    System.out.println("(" + CF.getRow() + ", " + CF.getColumn() + ")\n");

    // Sixth Move
    TO = new CoordinateImpl(12, 10);
    aMove = egm.move(PS, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    assertEquals(egm.getGameBoard().getBoardLocation(12, 11).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(12, 11).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(12, 11).getLocationType(), LocationType.CLEAR);
    System.out.println("Sixth Move: ");
    System.out.println("(" + PS.getRow() + ", " + PS.getColumn() + ")\n");


    // Seventh Move
    TO = new CoordinateImpl(11, 6);
    aMove = egm.move(CF, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    assertEquals(egm.getGameBoard().getBoardLocation(10, 4).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(10, 4).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(10, 4).getLocationType(), LocationType.CLEAR);
    System.out.println("Seventh Move: ");
    System.out.println("(" + CF.getRow() + ", " + CF.getColumn() + ")\n");

    // Eighth Move
    TO = new CoordinateImpl(13, 10);
    aMove = egm.move(PB, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    assertEquals(egm.getGameBoard().getBoardLocation(7, 16).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(7, 16).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(7, 16).getLocationType(), LocationType.CLEAR);

    assertEquals(egm.getGameBoard().getBoardLocation(13, 10).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(13, 10).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(13, 10).getLocationType(), LocationType.EXIT);

    System.out.println("Eighth Move: ");
    System.out.println("(" + PB.getRow() + ", " + PB.getColumn() + ")\n");

    // Ninth Move
    TO = new CoordinateImpl(12, 8);
    aMove = egm.move(CF, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    assertEquals(egm.getGameBoard().getBoardLocation(11, 6).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(11, 6).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(11, 6).getLocationType(), LocationType.CLEAR);
    System.out.println("Ninth Move: ");
    System.out.println("(" + CF.getRow() + ", " + CF.getColumn() + ")\n");

    // Tenth Move
    TO = new CoordinateImpl(10, 12);
    aMove = egm.move(PF, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(egm.getGameBoard().getBoardLocation(8, 13).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(8, 13).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(8, 13).getLocationType(), LocationType.CLEAR);
    System.out.println("Tenth Move: ");
    System.out.println("(" + PF.getRow() + ", " + PF.getColumn() + ")\n");

    gameStatus.setMoveResult(GameStatusImpl.MoveResult.DRAW);
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    System.out.println(aMove.getMoveResult().toString());
  }
  //***************************************************************************************************************************
  @Test
  /** **/
  void checkFullGame2() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/turn configurations/FullGame.egc").makeGameManager();
    } catch (Exception e){
      e.printStackTrace();
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    /** CHRIS' PIECES **/
    CoordinateImpl CF = new CoordinateImpl(8, 3);
    CoordinateImpl CH = new CoordinateImpl(6, 8);
    CoordinateImpl CB = new CoordinateImpl(10, 6);
    CoordinateImpl CS = new CoordinateImpl(17, 2);
    CoordinateImpl CD = new CoordinateImpl(4, 14);

    /** PAT'S PIECES **/
    CoordinateImpl PF = new CoordinateImpl(8, 13);
    CoordinateImpl PH = new CoordinateImpl(8, 17);
    CoordinateImpl PB = new CoordinateImpl(7, 16);
    CoordinateImpl PS = new CoordinateImpl(10, 13);
    CoordinateImpl PD = new CoordinateImpl(9, 8);

    /** Check all pieces line up **/
    EscapePiece.PieceName pieceName = egm.getGameBoard().getBoardLocation(CF.getRow(), CF.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.FROG);

    pieceName = egm.getGameBoard().getBoardLocation(CH.getRow(), CH.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.HORSE);

    pieceName = egm.getGameBoard().getBoardLocation(CB.getRow(), CB.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.BIRD);

    pieceName = egm.getGameBoard().getBoardLocation(CS.getRow(), CS.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.SNAIL);

    pieceName = egm.getGameBoard().getBoardLocation(CD.getRow(), CD.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.DOG);

    pieceName = egm.getGameBoard().getBoardLocation(PF.getRow(), PF.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.FROG);

    pieceName = egm.getGameBoard().getBoardLocation(PH.getRow(), PH.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.HORSE);

    pieceName = egm.getGameBoard().getBoardLocation(PB.getRow(), PB.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.BIRD);

    pieceName = egm.getGameBoard().getBoardLocation(PS.getRow(), PS.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.SNAIL);

    pieceName = egm.getGameBoard().getBoardLocation(PD.getRow(), PD.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.DOG);

    /** Check validMove is true **/
    GameStatusImpl gameStatus = new GameStatusImpl();
    gameStatus.setValidMove(true);
    assertTrue(gameStatus.isValidMove());

    /** Check moveResult is NONE **/
    GameStatusImpl simpleMove = new GameStatusImpl();
    simpleMove.setMoveResult(GameStatusImpl.MoveResult.NONE);
    assertEquals(simpleMove.getMoveResult(), GameStatusImpl.MoveResult.NONE);

    /** Check moveResult is LOSE **/
    GameStatusImpl losingMove = new GameStatusImpl();
    losingMove.setMoveResult(GameStatusImpl.MoveResult.LOSE);
    assertEquals(losingMove.getMoveResult(), GameStatusImpl.MoveResult.LOSE);

    /** Check moveResult is WIN **/
    GameStatusImpl winningMove = new GameStatusImpl();
    winningMove.setMoveResult(GameStatusImpl.MoveResult.WIN);
    assertEquals(winningMove.getMoveResult(), GameStatusImpl.MoveResult.WIN);


    /** Would you like to play a game? **/
    System.out.println("******** GAME INITIALIZED ********");
    GameStatus aMove = null;
    CoordinateImpl TO = null;

    // First Move
    TO = new CoordinateImpl(13, 9);
    aMove = egm.move(CB, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    assertEquals(egm.getGameBoard().getBoardLocation(10, 6).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(10, 6).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(10, 6).getLocationType(), LocationType.CLEAR);
    System.out.println("First Move: ");
    System.out.println("(" + CB.getRow() + ", " + CB.getColumn() + ")\n");

    // Second Move
    TO = new CoordinateImpl(11, 12);
    aMove = egm.move(PS, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    assertEquals(egm.getGameBoard().getBoardLocation(10, 13).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(10, 13).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(10, 13).getLocationType(), LocationType.CLEAR);
    System.out.println("Second Move: ");
    System.out.println("(" + PS.getRow() + ", " + PS.getColumn() + ")\n");

    // Third Move
    TO = new CoordinateImpl(13, 10);
    aMove = egm.move(CB, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    assertEquals(egm.getGameBoard().getBoardLocation(13, 9).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(13, 9).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(13, 9).getLocationType(), LocationType.CLEAR);

    assertEquals(egm.getGameBoard().getBoardLocation(13, 10).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(13, 10).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(13, 10).getLocationType(), LocationType.EXIT);

    System.out.println("Third Move: ");
    System.out.println("(" + CB.getRow() + ", " + CB.getColumn() + ")\n");

    // Fourth Move
    TO = new CoordinateImpl(12, 11);
    aMove = egm.move(PS, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    assertEquals(egm.getGameBoard().getBoardLocation(11, 12).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(11, 12).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(11, 12).getLocationType(), LocationType.CLEAR);
    System.out.println("Fourth Move: ");
    System.out.println("(" + PS.getRow() + ", " + PS.getColumn() + ")\n");

    // Fifth Move
    TO = new CoordinateImpl(10, 4);
    aMove = egm.move(CF, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    assertEquals(egm.getGameBoard().getBoardLocation(8, 3).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(8, 3).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(8, 3).getLocationType(), LocationType.CLEAR);
    System.out.println("Fifth Move: ");
    System.out.println("(" + CF.getRow() + ", " + CF.getColumn() + ")\n");

    // Sixth Move
    TO = new CoordinateImpl(12, 10);
    aMove = egm.move(PS, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    assertEquals(egm.getGameBoard().getBoardLocation(12, 11).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(12, 11).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(12, 11).getLocationType(), LocationType.CLEAR);
    System.out.println("Sixth Move: ");
    System.out.println("(" + PS.getRow() + ", " + PS.getColumn() + ")\n");


    // Seventh Move
    TO = new CoordinateImpl(11, 6);
    aMove = egm.move(CF, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    assertEquals(egm.getGameBoard().getBoardLocation(10, 4).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(10, 4).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(10, 4).getLocationType(), LocationType.CLEAR);
    System.out.println("Seventh Move: ");
    System.out.println("(" + CF.getRow() + ", " + CF.getColumn() + ")\n");

    // Eighth Move
    TO = new CoordinateImpl(9, 14);
    aMove = egm.move(PB, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    assertEquals(egm.getGameBoard().getBoardLocation(7, 16).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(7, 16).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(7, 16).getLocationType(), LocationType.CLEAR);

    System.out.println("Eighth Move: ");
    System.out.println("(" + PB.getRow() + ", " + PB.getColumn() + ")\n");

    // Ninth Move
    TO = new CoordinateImpl(12, 8);
    aMove = egm.move(CF, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    assertEquals(egm.getGameBoard().getBoardLocation(11, 6).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(11, 6).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(11, 6).getLocationType(), LocationType.CLEAR);
    System.out.println("Ninth Move: ");
    System.out.println("(" + CF.getRow() + ", " + CF.getColumn() + ")\n");

    // Tenth Move
    TO = new CoordinateImpl(10, 12);
    aMove = egm.move(PF, TO);
    assertEquals(gameStatus.isValidMove(), aMove.isValidMove());
    assertEquals(egm.getGameBoard().getBoardLocation(8, 13).getPieceName(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(8, 13).getPlayer(), null);
    assertEquals(egm.getGameBoard().getBoardLocation(8, 13).getLocationType(), LocationType.CLEAR);
    System.out.println("Tenth Move: ");
    System.out.println("(" + PF.getRow() + ", " + PF.getColumn() + ")\n");

    gameStatus.setMoveResult(GameStatusImpl.MoveResult.LOSE);
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    System.out.println(aMove.getMoveResult().toString());
  }
  //***************************************************************************************************************************
  @Test
  /** **/
  void checkQuickLoss1() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/turn configurations/FullGame.egc").makeGameManager();
    } catch (Exception e){
      e.printStackTrace();
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    /** CHRIS' PIECES **/
    CoordinateImpl CF = new CoordinateImpl(8, 3);

    /** Check all pieces line up **/
    EscapePiece.PieceName pieceName = egm.getGameBoard().getBoardLocation(CF.getRow(), CF.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.FROG);

    /** Check validMove is true **/
    GameStatusImpl gameStatus = new GameStatusImpl();
    gameStatus.setValidMove(true);
    assertTrue(gameStatus.isValidMove());

    /** Check moveResult is NONE **/
    GameStatusImpl simpleMove = new GameStatusImpl();
    simpleMove.setMoveResult(GameStatusImpl.MoveResult.NONE);
    assertEquals(simpleMove.getMoveResult(), GameStatusImpl.MoveResult.NONE);

    /** Check moveResult is LOSE **/
    GameStatusImpl losingMove = new GameStatusImpl();
    losingMove.setMoveResult(GameStatusImpl.MoveResult.LOSE);
    assertEquals(losingMove.getMoveResult(), GameStatusImpl.MoveResult.LOSE);

    /** Check moveResult is WIN **/
    GameStatusImpl winningMove = new GameStatusImpl();
    winningMove.setMoveResult(GameStatusImpl.MoveResult.WIN);
    assertEquals(winningMove.getMoveResult(), GameStatusImpl.MoveResult.WIN);


    /** Would you like to play a game? **/
    System.out.println("******** GAME INITIALIZED ********");
    GameStatus aMove = null;
    CoordinateImpl TO = null;

    // First Move
    TO = new CoordinateImpl(20, 20);
    aMove = egm.move(CF, TO);
    assertEquals(!gameStatus.isValidMove(), aMove.isValidMove());
    System.out.println("First Move: ");
    System.out.println("(" + CF.getRow() + ", " + CF.getColumn() + ")\n");

    gameStatus.setMoveResult(GameStatusImpl.MoveResult.LOSE);
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    System.out.println(aMove.getMoveResult().toString());
  }
  //***************************************************************************************************************************
  @Test
  /** **/
  void checkQuickLoss2() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/turn configurations/FullGame.egc").makeGameManager();
    } catch (Exception e){
      e.printStackTrace();
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    /** CHRIS' PIECES **/
    CoordinateImpl CF = new CoordinateImpl(19, 19);

    /** Check validMove is true **/
    GameStatusImpl gameStatus = new GameStatusImpl();
    gameStatus.setValidMove(true);
    assertTrue(gameStatus.isValidMove());

    /** Check moveResult is NONE **/
    GameStatusImpl simpleMove = new GameStatusImpl();
    simpleMove.setMoveResult(GameStatusImpl.MoveResult.NONE);
    assertEquals(simpleMove.getMoveResult(), GameStatusImpl.MoveResult.NONE);

    /** Check moveResult is LOSE **/
    GameStatusImpl losingMove = new GameStatusImpl();
    losingMove.setMoveResult(GameStatusImpl.MoveResult.LOSE);
    assertEquals(losingMove.getMoveResult(), GameStatusImpl.MoveResult.LOSE);

    /** Check moveResult is WIN **/
    GameStatusImpl winningMove = new GameStatusImpl();
    winningMove.setMoveResult(GameStatusImpl.MoveResult.WIN);
    assertEquals(winningMove.getMoveResult(), GameStatusImpl.MoveResult.WIN);


    /** Would you like to play a game? **/
    System.out.println("******** GAME INITIALIZED ********");
    GameStatus aMove = null;
    CoordinateImpl TO = null;

    // First Move
    TO = new CoordinateImpl(15, 4);
    aMove = egm.move(CF, TO);
    assertEquals(!gameStatus.isValidMove(), aMove.isValidMove());
    System.out.println("First Move: ");
    System.out.println("(" + CF.getRow() + ", " + CF.getColumn() + ")\n");

    gameStatus.setMoveResult(GameStatusImpl.MoveResult.LOSE);
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    System.out.println(aMove.getMoveResult().toString());
  }
  //***************************************************************************************************************************
  @Test
  /** **/
  void checkQuickLoss3() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/turn configurations/FullGame.egc").makeGameManager();
    } catch (Exception e){
      e.printStackTrace();
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    /** CHRIS' PIECES **/
    CoordinateImpl CF = new CoordinateImpl(8, 3);

    /** Check validMove is true **/
    GameStatusImpl gameStatus = new GameStatusImpl();
    gameStatus.setValidMove(true);
    assertTrue(gameStatus.isValidMove());

    /** Check moveResult is NONE **/
    GameStatusImpl simpleMove = new GameStatusImpl();
    simpleMove.setMoveResult(GameStatusImpl.MoveResult.NONE);
    assertEquals(simpleMove.getMoveResult(), GameStatusImpl.MoveResult.NONE);

    /** Check moveResult is LOSE **/
    GameStatusImpl losingMove = new GameStatusImpl();
    losingMove.setMoveResult(GameStatusImpl.MoveResult.LOSE);
    assertEquals(losingMove.getMoveResult(), GameStatusImpl.MoveResult.LOSE);

    /** Check moveResult is WIN **/
    GameStatusImpl winningMove = new GameStatusImpl();
    winningMove.setMoveResult(GameStatusImpl.MoveResult.WIN);
    assertEquals(winningMove.getMoveResult(), GameStatusImpl.MoveResult.WIN);


    /** Would you like to play a game? **/
    System.out.println("******** GAME INITIALIZED ********");
    GameStatus aMove = null;
    CoordinateImpl TO = null;

    // First Move
    TO = new CoordinateImpl(8, 3);
    aMove = egm.move(CF, TO);
    assertEquals(!gameStatus.isValidMove(), aMove.isValidMove());
    System.out.println("First Move: ");
    System.out.println("(" + CF.getRow() + ", " + CF.getColumn() + ")\n");

    gameStatus.setMoveResult(GameStatusImpl.MoveResult.LOSE);
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    System.out.println(aMove.getMoveResult().toString());
  }
  //***************************************************************************************************************************
  @Test
  /** **/
  void checkQuickLoss4() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/turn configurations/FullGame.egc").makeGameManager();
    } catch (Exception e){
      e.printStackTrace();
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    /** CHRIS' PIECES **/
    CoordinateImpl CF = new CoordinateImpl(7, 16);

    /** Check validMove is true **/
    GameStatusImpl gameStatus = new GameStatusImpl();
    gameStatus.setValidMove(true);
    assertTrue(gameStatus.isValidMove());

    /** Check moveResult is NONE **/
    GameStatusImpl simpleMove = new GameStatusImpl();
    simpleMove.setMoveResult(GameStatusImpl.MoveResult.NONE);
    assertEquals(simpleMove.getMoveResult(), GameStatusImpl.MoveResult.NONE);

    /** Check moveResult is LOSE **/
    GameStatusImpl losingMove = new GameStatusImpl();
    losingMove.setMoveResult(GameStatusImpl.MoveResult.LOSE);
    assertEquals(losingMove.getMoveResult(), GameStatusImpl.MoveResult.LOSE);

    /** Check moveResult is WIN **/
    GameStatusImpl winningMove = new GameStatusImpl();
    winningMove.setMoveResult(GameStatusImpl.MoveResult.WIN);
    assertEquals(winningMove.getMoveResult(), GameStatusImpl.MoveResult.WIN);


    /** Would you like to play a game? **/
    System.out.println("******** GAME INITIALIZED ********");
    GameStatus aMove = null;
    CoordinateImpl TO = null;

    // First Move
    TO = new CoordinateImpl(8, 3);
    aMove = egm.move(CF, TO);
    assertEquals(!gameStatus.isValidMove(), aMove.isValidMove());
    System.out.println("First Move: ");
    System.out.println("(" + CF.getRow() + ", " + CF.getColumn() + ")\n");

    gameStatus.setMoveResult(GameStatusImpl.MoveResult.LOSE);
    assertEquals(gameStatus.getMoveResult(), aMove.getMoveResult());
    System.out.println(aMove.getMoveResult().toString());
  }
}
