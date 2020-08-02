package org.eshishkin.poker.rules.calculator;

import org.eshishkin.poker.model.Card;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnePairEvaluatorTest {

    private HandEvaluator calculator = new OnePairEvaluator();

    @Test
    public void testEvaluate() {
        Hand result = calculator.evaluate(asList(
                Card.CLUB_KING, Card.DIAMOND_TEN, Card.DIAMOND_SIX, Card.DIAMOND_FOUR, Card.CLUB_SIX, Card.HEART_QUEEN, Card.CLUB_TWO
        ));

        assertEquals(Hand.Rank.ONE_PAIR, result.getRank());
        assertEquals(
            asList(Card.DIAMOND_SIX, Card.CLUB_SIX, Card.CLUB_KING, Card.HEART_QUEEN, Card.DIAMOND_TEN),
            result.getCards()
        );
    }
}
