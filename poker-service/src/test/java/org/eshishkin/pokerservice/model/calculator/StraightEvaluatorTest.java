package org.eshishkin.pokerservice.model.calculator;

import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import static org.eshishkin.pokerservice.model.Card.CLUB_EIGHT;
import static org.eshishkin.pokerservice.model.Card.CLUB_FOUR;
import static org.eshishkin.pokerservice.model.Card.CLUB_KING;
import static org.eshishkin.pokerservice.model.Card.CLUB_SIX;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_JACK;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_QUEEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_TEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_THREE;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_TWO;
import static org.eshishkin.pokerservice.model.Card.HEART_ACE;
import static org.eshishkin.pokerservice.model.Card.HEART_FIVE;
import static org.eshishkin.pokerservice.model.Card.HEART_NINE;
import static org.eshishkin.pokerservice.model.Card.HEART_QUEEN;
import static org.eshishkin.pokerservice.model.calculator.Hand.Rank.STRAIGHT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StraightEvaluatorTest {

    private HandEvaluator calculator = new StraightEvaluator();

    @Test
    public void testEvaluate() {
        Hand result = calculator.evaluate(asList(
                CLUB_KING, DIAMOND_TEN, DIAMOND_QUEEN, DIAMOND_JACK, CLUB_SIX, HEART_QUEEN, HEART_NINE
        ));

        assertEquals(STRAIGHT, result.getRank());
        assertEquals(
            asList(CLUB_KING, DIAMOND_QUEEN, DIAMOND_JACK, DIAMOND_TEN, HEART_NINE),
            result.getCards()
        );
    }

    @Test
    public void testEvaluate_AceTop() {
        Hand result = calculator.evaluate(asList(
                CLUB_KING, DIAMOND_TEN, DIAMOND_QUEEN, DIAMOND_JACK, CLUB_SIX, HEART_QUEEN, HEART_ACE
        ));

        assertEquals(STRAIGHT, result.getRank());
        assertEquals(
                asList(HEART_ACE, CLUB_KING, DIAMOND_QUEEN, DIAMOND_JACK, DIAMOND_TEN),
                result.getCards()
        );
    }

    @Test
    public void testEvaluate_AceBottom() {
        Hand result = calculator.evaluate(asList(
                CLUB_FOUR, DIAMOND_TWO, DIAMOND_QUEEN, DIAMOND_THREE, CLUB_EIGHT, HEART_FIVE, HEART_ACE
        ));

        assertEquals(STRAIGHT, result.getRank());
        assertEquals(
                asList(HEART_FIVE, CLUB_FOUR, DIAMOND_THREE, DIAMOND_TWO, HEART_ACE),
                result.getCards()
        );
    }


    @Test
    public void testEvaluate_AceNotInStraight() {
        Hand result = calculator.evaluate(asList(
                CLUB_FOUR, DIAMOND_TWO, DIAMOND_QUEEN, DIAMOND_THREE, CLUB_SIX, HEART_FIVE, HEART_ACE
        ));

        assertEquals(STRAIGHT, result.getRank());
        assertEquals(
                asList(CLUB_SIX, HEART_FIVE, CLUB_FOUR, DIAMOND_THREE, DIAMOND_TWO),
                result.getCards()
        );
    }
}
