package org.eshishkin.pokerservice.model.calculator;

import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import static org.eshishkin.pokerservice.model.Card.CLUB_KING;
import static org.eshishkin.pokerservice.model.Card.CLUB_SIX;
import static org.eshishkin.pokerservice.model.Card.CLUB_TWO;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_FOUR;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_SIX;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_TEN;
import static org.eshishkin.pokerservice.model.Card.HEART_QUEEN;
import static org.eshishkin.pokerservice.model.calculator.Hand.Rank.ONE_PAIR;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnePairEvaluatorTest {

    private HandEvaluator calculator = new OnePairEvaluator();

    @Test
    public void testEvaluate() {
        Hand result = calculator.evaluate(asList(
                CLUB_KING, DIAMOND_TEN, DIAMOND_SIX, DIAMOND_FOUR, CLUB_SIX, HEART_QUEEN, CLUB_TWO
        ));

        assertEquals(ONE_PAIR, result.getRank());
        assertEquals(
            asList(DIAMOND_SIX, CLUB_SIX, CLUB_KING, HEART_QUEEN, DIAMOND_TEN),
            result.getCards()
        );
    }
}
