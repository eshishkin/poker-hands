package org.eshishkin.pokerservice.model.calculator;

import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import static org.eshishkin.pokerservice.model.Card.CLUB_KING;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_FOUR;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_KING;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_SIX;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_TEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_TWO;
import static org.eshishkin.pokerservice.model.Card.HEART_QUEEN;
import static org.eshishkin.pokerservice.model.calculator.Hand.Rank.FLUSH;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlushEvaluatorTest {

    private HandEvaluator calculator = new FlushEvaluator();

    @Test
    public void testEvaluate() {
        Hand result = calculator.evaluate(asList(
                CLUB_KING, DIAMOND_TEN, DIAMOND_SIX, DIAMOND_FOUR, DIAMOND_TWO, HEART_QUEEN, DIAMOND_KING
        ));

        assertEquals(FLUSH, result.getRank());
        assertEquals(
            asList(DIAMOND_KING, DIAMOND_TEN, DIAMOND_SIX, DIAMOND_FOUR, DIAMOND_TWO),
            result.getCards()
        );
    }
}
