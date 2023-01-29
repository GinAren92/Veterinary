package org.example.service;

import org.example.service.OptionService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionServiceTest {

    @Test
    void checkReviewOrAddProvidedTrue() {
        //given
        final String testString = "Review";
        boolean result;
        //when
        result = OptionService.checkReviewOrAddProvided(testString);
        //then
        assertTrue(result);
    }

    @Test
    void checkReviewOrAddProvidedTrueSecond() {
        //given
        final String testString = "Add";
        boolean result;
        //when
        result = OptionService.checkReviewOrAddProvided(testString);
        //then
        assertTrue(result);
    }

    @Test
    void checkReviewOrAddProvidedFalse() {
        //given
        final String testString = "";
        boolean result;
        //when
        result = OptionService.checkReviewOrAddProvided(testString);
        //then
        assertFalse(result);
    }

    @Test
    void checkReviewOrAddProvidedFalseSecond() {
        //given
        final String testString = "testTxt";
        boolean result;
        //when
        result = OptionService.checkReviewOrAddProvided(testString);
        //then
        assertFalse(result);
    }

    @Test
    void checkReviewOrAddProvidedTrueThird() {
        //given
        final String testString = null;
        boolean result;
        //when
        result = OptionService.checkReviewOrAddProvided(testString);
        //then
        assertFalse(result);
    }

    @Test
    void checkContinueTheProgramAnswerTrue() {
        //given
        final String testString = "N";
        boolean result;
        //when
        result = OptionService.checkContinueTheProgramAnswer(testString);
        //then
        assertTrue(result);
    }

    @Test
    void checkContinueTheProgramAnswerFalse() {
        //given
        final String testString = null;
        boolean result;
        //when
        result = OptionService.checkContinueTheProgramAnswer(testString);
        //then
        assertFalse(result);
    }

    @Test
    void checkContinueTheProgramAnswerFalseSecond() {
        //given
        final String testString = "y";
        boolean result;
        //when
        result = OptionService.checkContinueTheProgramAnswer(testString);
        //then
        assertFalse(result);
    }

    @Test
    void checkContinueTheProgramAnswerFalseThird() {
        //given
        final String testString = "1 Test String  ";
        boolean result;
        //when
        result = OptionService.checkContinueTheProgramAnswer(testString);
        //then
        assertFalse(result);
    }

    @Test
    void checkContinueTheProgramAnswerFalseFourth() {
        //given
        final String testString = "";
        boolean result;
        //when
        result = OptionService.checkContinueTheProgramAnswer(testString);
        //then
        assertFalse(result);
    }

    @Test
    void checkFilterOptionShouldBeTrue() {
        //given
        final String testOptionProvided = "  owner  ";
        boolean result;
        //when
        result = org.example.service.OptionService.checkFilterOption(testOptionProvided);
        //then
        assertTrue(result);
    }
    @Test
    void checkFilterOptionShouldBeTrueSecond() {
        //given
        final String testOptionProvided = "breed   ";
        boolean result;
        //when
        result = org.example.service.OptionService.checkFilterOption(testOptionProvided);
        //then
        assertTrue(result);
    }
    @Test
    void checkFilterOptionShouldBeTrueThird() {
        //given
        final String testOptionProvided = "   date";
        boolean result;
        //when
        result = org.example.service.OptionService.checkFilterOption(testOptionProvided);
        //then
        assertTrue(result);
    }
    @Test
    void checkFilterOptionShouldBeFalse() {
        //given
        final String testOptionProvided = "";
        boolean result;
        //when
        result = org.example.service.OptionService.checkFilterOption(testOptionProvided);
        //then
        assertFalse(result);
    }
    @Test
    void checkFilterOptionShouldBeFalseSecond() {
        //given
        final String testOptionProvided = "test";
        boolean result;
        //when
        result = org.example.service.OptionService.checkFilterOption(testOptionProvided);
        //then
        assertFalse(result);
    }
}