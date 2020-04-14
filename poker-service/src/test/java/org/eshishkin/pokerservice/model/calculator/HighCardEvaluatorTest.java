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
import static org.eshishkin.pokerservice.model.calculator.Hand.Rank.HIGH_CARD;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighCardEvaluatorTest {

    private HandEvaluator calculator = new HighCardEvaluator();

    @Test
    public void testEvaluate() {
        Hand result = calculator.evaluate(asList(
                CLUB_KING, DIAMOND_TEN, DIAMOND_SIX, DIAMOND_FOUR, CLUB_SIX, HEART_QUEEN, CLUB_TWO
        ));

        assertEquals(HIGH_CARD, result.getRank());
        assertEquals(
            asList(CLUB_KING, HEART_QUEEN, DIAMOND_TEN, DIAMOND_SIX, CLUB_SIX),
            result.getCards()
        );
    }
}
