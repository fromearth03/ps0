/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }

    /**
     * Cited, publicly available code that was not course work and is not
     * a required feature should be allowed.
     */
    @Test
    public void testCitedPublicCodeAllowed() {
        assertTrue("Expected true: cited, public, non-course code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
    }

    /**
     * Code written as past 6.005 course work should not be allowed,
     * even if it is public and cited.
     */
    @Test
    public void testPastCourseWorkNotAllowed() {
        assertFalse("Expected false: code written as past 6.005 work",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
    }

    /**
     * Code from elsewhere should not be allowed if the assignment
     * specifically requires implementing that feature yourself.
     */
    @Test
    public void testRequiredFeatureNotAllowed() {
        assertFalse("Expected false: assignment requires implementing it",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, true));
    }
}