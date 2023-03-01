/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Copyright ©2016-2023 Gary F. Pollice
 *******************************************************************************/
package master.escape.Builder;

import escape.*;
import escape.Builder.*;
import master.util.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class EscapeGameBuilderTest extends BaseTestMaster {
    private static boolean firstTest = true;

    public EscapeGameBuilderTest() {
        super();
        if (firstTest) {
            testReporter.startNewTestGroup("EscapeGameBuilder tests", 5);
        }
        firstTest = false;
    }

    @AfterAll
    static void testBreakdown() {
        firstTest = false;
    }

    @Test
    void makeGameObject() {
        startTest("Make simplest game object", 5);
        EscapeGameManager egm = null;
        try {
            egm = new EscapeGameBuilder("master_configurations/test1.egc").makeGameManager();
        } catch (Exception e) {
            fail("Exception from builder: " + e.getMessage());
        }
        assertNotNull(egm);
        markTestPassed();
    }
}
