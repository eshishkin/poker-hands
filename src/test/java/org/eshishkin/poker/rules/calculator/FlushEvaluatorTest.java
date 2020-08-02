package org.eshishkin.poker.rules.calculator;

import org.eshishkin.poker.model.Card;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlushEvaluatorTest {

    private HandEvaluator calculator = new FlushEvaluator();

    @Test
    public void testEvaluate() {
        Hand result = calculator.evaluate(asList(
                Card.CLUB_KING, Card.DIAMOND_TEN, Card.DIAMOND_SIX, Card.DIAMOND_FOUR, Card.DIAMOND_TWO, Card.HEART_QUEEN, Card.DIAMOND_KING
        ));

        assertEquals(Hand.Rank.FLUSH, result.getRank());
        assertEquals(
            asList(Card.DIAMOND_KING, Card.DIAMOND_TEN, Card.DIAMOND_SIX, Card.DIAMOND_FOUR, Card.DIAMOND_TWO),
            result.getCards()
        );
    }
}
