package org.eshishkin.pokerservice.model.calculator;

import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import static org.eshishkin.pokerservice.model.Card.CLUB_EIGHT;
import static org.eshishkin.pokerservice.model.Card.CLUB_FOUR;
import static org.eshishkin.pokerservice.model.Card.CLUB_KING;
import static org.eshishkin.pokerservice.model.Card.CLUB_SIX;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_EIGHT;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_FIVE;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_JACK;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_QUEEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_TEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_THREE;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_TWO;
import static org.eshishkin.pokerservice.model.Card.HEART_ACE;
import static org.eshishkin.pokerservice.model.Card.HEART_EIGHT;
import static org.eshishkin.pokerservice.model.Card.HEART_FIVE;
import static org.eshishkin.pokerservice.model.Card.HEART_QUEEN;
import static org.eshishkin.pokerservice.model.calculator.Hand.Rank.FULL_HOUSE;
import static org.eshishkin.pokerservice.model.calculator.Hand.Rank.STRAIGHT;
import static org.eshishkin.pokerservice.model.calculator.Hand.Rank.THREE_OF_KIND;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultPokerHandEvaluatorTest {

    private HandEvaluator calculator = new DefaultPokerHandEvaluator();

    @Test
    public void testEvaluate_FullHouse() {
        Hand result = calculator.evaluate(asList(
                CLUB_FOUR, DIAMOND_FIVE, DIAMOND_QUEEN, DIAMOND_EIGHT, CLUB_EIGHT, HEART_FIVE, HEART_EIGHT
        ));

        assertEquals(FULL_HOUSE, result.getRank());
        assertEquals(
                asList(DIAMOND_EIGHT, CLUB_EIGHT, HEART_EIGHT, DIAMOND_FIVE, HEART_FIVE),
                result.getCards()
        );
    }

    @Test
    public void testEvaluate_ThreeOfKind() {
        Hand result = calculator.evaluate(asList(
                CLUB_FOUR, DIAMOND_TEN, DIAMOND_QUEEN, DIAMOND_EIGHT, CLUB_EIGHT, HEART_FIVE, HEART_EIGHT
        ));

        assertEquals(THREE_OF_KIND, result.getRank());
        assertEquals(
                asList(DIAMOND_EIGHT, CLUB_EIGHT, HEART_EIGHT, DIAMOND_QUEEN, DIAMOND_TEN),
                result.getCards()
        );
    }

    @Test
    public void testEvaluate_Straight_AceTop() {
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
    public void testEvaluate_Straight_AceBottom() {
        Hand result = calculator.evaluate(asList(
                CLUB_FOUR, DIAMOND_TWO, DIAMOND_QUEEN, DIAMOND_THREE, CLUB_EIGHT, HEART_FIVE, HEART_ACE
        ));

        assertEquals(STRAIGHT, result.getRank());
        assertEquals(
                asList(HEART_FIVE, CLUB_FOUR, DIAMOND_THREE, DIAMOND_TWO, HEART_ACE),
                result.getCards()
        );
    }
}
