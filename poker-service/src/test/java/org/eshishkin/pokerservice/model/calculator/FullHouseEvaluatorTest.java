package org.eshishkin.pokerservice.model.calculator;

import org.eshishkin.pokerservice.model.Hand;
import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import static org.eshishkin.pokerservice.model.Card.CLUB_KING;
import static org.eshishkin.pokerservice.model.Card.CLUB_SIX;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_QUEEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_SIX;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_TEN;
import static org.eshishkin.pokerservice.model.Card.HEART_QUEEN;
import static org.eshishkin.pokerservice.model.Card.HEART_SIX;
import static org.eshishkin.pokerservice.model.Hand.Rank.FULL_HOUSE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FullHouseEvaluatorTest {

    private HandEvaluator calculator = new FullHouseEvaluator();

    @Test
    public void testEvaluate() {
        Hand result = calculator.evaluate(asList(
                CLUB_KING, DIAMOND_TEN, DIAMOND_SIX, DIAMOND_QUEEN, CLUB_SIX, HEART_QUEEN, HEART_SIX
        ));

        assertEquals(FULL_HOUSE, result.getRank());
        assertEquals(
            asList(DIAMOND_SIX, CLUB_SIX, HEART_SIX, DIAMOND_QUEEN, HEART_QUEEN),
            result.getCards()
        );
    }
}
