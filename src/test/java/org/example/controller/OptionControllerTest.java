package org.example.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionControllerTest {

    @Test
    void checkReviewOrAddProvidedTrue() {
        //given
        final String testString = "Review";
        boolean result;
        //when
        result = OptionController.checkReviewOrAddProvided(testString);
        //then
        assertTrue(result);
    }

    @Test
    void checkReviewOrAddProvidedTrueSecond() {
        //given
        final String testString = "Add";
        boolean result;
        //when
        result = OptionController.checkReviewOrAddProvided(testString);
        //then
        assertTrue(result);
    }

    @Test
    void checkReviewOrAddProvidedFalse() {
        //given
        final String testString = "";
        boolean result;
        //when
        result = OptionController.checkReviewOrAddProvided(testString);
        //then
        assertFalse(result);
    }

    @Test
    void checkReviewOrAddProvidedFalseSecond() {
        //given
        final String testString = "testTxt";
        boolean result;
        //when
        result = OptionController.checkReviewOrAddProvided(testString);
        //then
        assertFalse(result);
    }

    @Test
    void checkReviewOrAddProvidedTrueThird() {
        //given
        final String testString = null;
        boolean result;
        //when
        result = OptionController.checkReviewOrAddProvided(testString);
        //then
        assertFalse(result);
    }

    @Test
    void checkContinueTheProgramAnswerTrue() {
        //given
        final String testString = "N";
        boolean result;
        //when
        result = OptionController.checkContinueTheProgramAnswer(testString);
        //then
        assertTrue(result);
    }

    @Test
    void checkContinueTheProgramAnswerFalse() {
        //given
        final String testString = null;
        boolean result;
        //when
        result = OptionController.checkContinueTheProgramAnswer(testString);
        //then
        assertFalse(result);
    }

    @Test
    void checkContinueTheProgramAnswerFalseSecond() {
        //given
        final String testString = "y";
        boolean result;
        //when
        result = OptionController.checkContinueTheProgramAnswer(testString);
        //then
        assertFalse(result);
    }

    @Test
    void checkContinueTheProgramAnswerFalseThird() {
        //given
        final String testString = "1 Test String  ";
        boolean result;
        //when
        result = OptionController.checkContinueTheProgramAnswer(testString);
        //then
        assertFalse(result);
    }

    @Test
    void checkContinueTheProgramAnswerFalseFourth() {
        //given
        final String testString = "";
        boolean result;
        //when
        result = OptionController.checkContinueTheProgramAnswer(testString);
        //then
        assertFalse(result);
    }
}