package org.eshishkin.poker.rules.calculator;

import org.eshishkin.poker.model.Card;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighCardEvaluatorTest {

    private HandEvaluator calculator = new HighCardEvaluator();

    @Test
    public void testEvaluate() {
        Hand result = calculator.evaluate(asList(
                Card.CLUB_KING, Card.DIAMOND_TEN, Card.DIAMOND_SIX, Card.DIAMOND_FOUR, Card.CLUB_SIX, Card.HEART_QUEEN, Card.CLUB_TWO
        ));

        assertEquals(Hand.Rank.HIGH_CARD, result.getRank());
        assertEquals(
            asList(Card.CLUB_KING, Card.HEART_QUEEN, Card.DIAMOND_TEN, Card.DIAMOND_SIX, Card.CLUB_SIX),
            result.getCards()
        );
    }
}
