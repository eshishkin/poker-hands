package org.eshishkin.poker.rules.calculator;

import org.eshishkin.poker.model.Card;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StraightEvaluatorTest {

    private HandEvaluator calculator = new StraightEvaluator();

    @Test
    public void testEvaluate() {
        Hand result = calculator.evaluate(asList(
                Card.CLUB_KING, Card.DIAMOND_TEN, Card.DIAMOND_QUEEN, Card.DIAMOND_JACK, Card.CLUB_SIX, Card.HEART_QUEEN, Card.HEART_NINE
        ));

        assertEquals(Hand.Rank.STRAIGHT, result.getRank());
        assertEquals(
            asList(Card.CLUB_KING, Card.DIAMOND_QUEEN, Card.DIAMOND_JACK, Card.DIAMOND_TEN, Card.HEART_NINE),
            result.getCards()
        );
    }

    @Test
    public void testEvaluate_AceTop() {
        Hand result = calculator.evaluate(asList(
                Card.CLUB_KING, Card.DIAMOND_TEN, Card.DIAMOND_QUEEN, Card.DIAMOND_JACK, Card.CLUB_SIX, Card.HEART_QUEEN, Card.HEART_ACE
        ));

        assertEquals(Hand.Rank.STRAIGHT, result.getRank());
        assertEquals(
                asList(Card.HEART_ACE, Card.CLUB_KING, Card.DIAMOND_QUEEN, Card.DIAMOND_JACK, Card.DIAMOND_TEN),
                result.getCards()
        );
    }

    @Test
    public void testEvaluate_AceBottom() {
        Hand result = calculator.evaluate(asList(
                Card.CLUB_FOUR, Card.DIAMOND_TWO, Card.DIAMOND_QUEEN, Card.DIAMOND_THREE, Card.CLUB_EIGHT, Card.HEART_FIVE, Card.HEART_ACE
        ));

        assertEquals(Hand.Rank.STRAIGHT, result.getRank());
        assertEquals(
                asList(Card.HEART_FIVE, Card.CLUB_FOUR, Card.DIAMOND_THREE, Card.DIAMOND_TWO, Card.HEART_ACE),
                result.getCards()
        );
    }


    @Test
    public void testEvaluate_AceNotInStraight() {
        Hand result = calculator.evaluate(asList(
                Card.CLUB_FOUR, Card.DIAMOND_TWO, Card.DIAMOND_QUEEN, Card.DIAMOND_THREE, Card.CLUB_SIX, Card.HEART_FIVE, Card.HEART_ACE
        ));

        assertEquals(Hand.Rank.STRAIGHT, result.getRank());
        assertEquals(
                asList(Card.CLUB_SIX, Card.HEART_FIVE, Card.CLUB_FOUR, Card.DIAMOND_THREE, Card.DIAMOND_TWO),
                result.getCards()
        );
    }
}
