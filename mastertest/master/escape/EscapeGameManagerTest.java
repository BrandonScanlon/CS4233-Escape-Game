/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Copyright ©2016-2017 Gary F. Pollice
 *******************************************************************************/
package master.escape;

import escape.*;
import escape.Builder.*;
import escape.required.*;
import master.util.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class EscapeGameManagerTest extends BaseTestMaster {
    private static boolean firstTest = true;

    private EscapeGameManager<? extends Coordinate> manager = null;

    @AfterAll
    static void testBreakdown() {
        firstTest = false;
    }

    @BeforeEach
    void setup() throws Exception {
        manager = new EscapeGameBuilder("master_configurations/test1.egc").makeGameManager();
    }

    public EscapeGameManagerTest() {
        super();
        if (firstTest) {
            testReporter.startNewTestGroup("EscapeGameManager tests", 10);
        }
        firstTest = false;
    }

    /*********************************** Coordinate tests ***********************************/

    @Test
    void makeCoordinateObject() {
        startTest("Make a Coordinate object", 5);
        Coordinate c = manager.makeCoordinate(1, 2);
        assertNotNull(c);
        assertTrue(c instanceof Coordinate);
        markTestPassed();
    }

    @Test
    void correctCoordinates() {
        startTest("Check coordinates", 5);
        Coordinate c = manager.makeCoordinate(2, 1);
        assertEquals(2, c.getRow());
        assertEquals(1, c.getColumn());
        markTestPassed();
    }

    @Test
    void xyNotOnBoard() {
        startTest("Row and column off board", 2);
        Coordinate c = manager.makeCoordinate(-2, 5000);
        assertEquals(-2, c.getRow());
        assertEquals(5000, c.getColumn());
        markTestPassed();
    }

    @Test
    void extraCreditEquals() {
        startExtraCreditTest("Coordinate equals (EC)", -2);
        Coordinate c1 = manager.makeCoordinate(2, 5);
        Coordinate c2 = manager.makeCoordinate(2, 5);
        assertEquals(c1, c2);
        markExtraCreditTestPassed();
    }
}
