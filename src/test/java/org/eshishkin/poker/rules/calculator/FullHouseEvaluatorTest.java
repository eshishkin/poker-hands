package org.eshishkin.poker.rules.calculator;

import org.eshishkin.poker.model.Card;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FullHouseEvaluatorTest {

    private HandEvaluator calculator = new FullHouseEvaluator();

    @Test
    public void testEvaluate() {
        Hand result = calculator.evaluate(asList(
                Card.CLUB_KING, Card.DIAMOND_TEN, Card.DIAMOND_SIX, Card.DIAMOND_QUEEN, Card.CLUB_SIX, Card.HEART_QUEEN, Card.HEART_SIX
        ));

        assertEquals(Hand.Rank.FULL_HOUSE, result.getRank());
        assertEquals(
            asList(Card.DIAMOND_SIX, Card.CLUB_SIX, Card.HEART_SIX, Card.DIAMOND_QUEEN, Card.HEART_QUEEN),
            result.getCards()
        );
    }
}
