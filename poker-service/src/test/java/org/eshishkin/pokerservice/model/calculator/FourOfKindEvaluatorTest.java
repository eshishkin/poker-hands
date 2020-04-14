package org.eshishkin.pokerservice.model.calculator;

import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import static org.eshishkin.pokerservice.model.Card.CLUB_SIX;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_FOUR;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_SIX;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_TEN;
import static org.eshishkin.pokerservice.model.Card.HEART_QUEEN;
import static org.eshishkin.pokerservice.model.Card.HEART_SIX;
import static org.eshishkin.pokerservice.model.Card.SPADE_SIX;
import static org.eshishkin.pokerservice.model.calculator.Hand.Rank.FOUR_OF_KIND;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourOfKindEvaluatorTest {

    private HandEvaluator calculator = new FourOfKindEvaluator();

    @Test
    public void testEvaluate() {
        Hand result = calculator.evaluate(asList(
                SPADE_SIX, DIAMOND_TEN, DIAMOND_SIX, DIAMOND_FOUR, CLUB_SIX, HEART_QUEEN, HEART_SIX
        ));

        assertEquals(FOUR_OF_KIND, result.getRank());
        assertEquals(
            asList(SPADE_SIX, DIAMOND_SIX, CLUB_SIX, HEART_SIX, HEART_QUEEN),
            result.getCards()
        );
    }
}
