package org.eshishkin.poker.rules.calculator;

import org.eshishkin.poker.model.Card;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultPokerHandEvaluatorTest {

    private HandEvaluator calculator = new DefaultPokerHandEvaluator();

    @Test
    public void testEvaluate_FullHouse() {
        Hand result = calculator.evaluate(asList(
                Card.CLUB_FOUR, Card.DIAMOND_FIVE, Card.DIAMOND_QUEEN, Card.DIAMOND_EIGHT, Card.CLUB_EIGHT, Card.HEART_FIVE, Card.HEART_EIGHT
        ));

        assertEquals(Hand.Rank.FULL_HOUSE, result.getRank());
        assertEquals(
                asList(Card.DIAMOND_EIGHT, Card.CLUB_EIGHT, Card.HEART_EIGHT, Card.DIAMOND_FIVE, Card.HEART_FIVE),
                result.getCards()
        );
    }

    @Test
    public void testEvaluate_ThreeOfKind() {
        Hand result = calculator.evaluate(asList(
                Card.CLUB_FOUR, Card.DIAMOND_TEN, Card.DIAMOND_QUEEN, Card.DIAMOND_EIGHT, Card.CLUB_EIGHT, Card.HEART_FIVE, Card.HEART_EIGHT
        ));

        assertEquals(Hand.Rank.THREE_OF_KIND, result.getRank());
        assertEquals(
                asList(Card.DIAMOND_EIGHT, Card.CLUB_EIGHT, Card.HEART_EIGHT, Card.DIAMOND_QUEEN, Card.DIAMOND_TEN),
                result.getCards()
        );
    }

    @Test
    public void testEvaluate_Straight_AceTop() {
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
    public void testEvaluate_Straight_AceBottom() {
        Hand result = calculator.evaluate(asList(
                Card.CLUB_FOUR, Card.DIAMOND_TWO, Card.DIAMOND_QUEEN, Card.DIAMOND_THREE, Card.CLUB_EIGHT, Card.HEART_FIVE, Card.HEART_ACE
        ));

        assertEquals(Hand.Rank.STRAIGHT, result.getRank());
        assertEquals(
                asList(Card.HEART_FIVE, Card.CLUB_FOUR, Card.DIAMOND_THREE, Card.DIAMOND_TWO, Card.HEART_ACE),
                result.getCards()
        );
    }
}
