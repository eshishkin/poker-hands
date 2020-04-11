package org.eshishkin.pokerservice.model.comparator;

import java.util.List;
import org.eshishkin.pokerservice.model.Card;
import org.eshishkin.pokerservice.model.Hand;
import org.eshishkin.pokerservice.model.comparator.StraightComparator;
import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import static org.eshishkin.pokerservice.model.Card.CLUB_ACE;
import static org.eshishkin.pokerservice.model.Card.CLUB_FOUR;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_FOUR;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_NINE;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_QUEEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_SEVEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_SIX;
import static org.eshishkin.pokerservice.model.Card.HEART_ACE;
import static org.eshishkin.pokerservice.model.Card.HEART_FIVE;
import static org.eshishkin.pokerservice.model.Card.HEART_JACK;
import static org.eshishkin.pokerservice.model.Card.HEART_KING;
import static org.eshishkin.pokerservice.model.Card.HEART_SIX;
import static org.eshishkin.pokerservice.model.Card.HEART_THREE;
import static org.eshishkin.pokerservice.model.Card.SPADE_EIGHT;
import static org.eshishkin.pokerservice.model.Card.SPADE_TEN;
import static org.eshishkin.pokerservice.model.Card.SPADE_THREE;
import static org.eshishkin.pokerservice.model.Card.SPADE_TWO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StraightComparatorTest {

    private StraightComparator comparator = new StraightComparator();

    @Test
    public void testCompare_SameStraights() {
        List<Card> cards = asList(HEART_THREE, CLUB_FOUR, HEART_FIVE, HEART_SIX, DIAMOND_SEVEN);

        Hand first = Hand.straight(cards);
        Hand second = Hand.straight(cards);
        assertEquals(0, comparator.compare(first, second));
    }

    @Test
    public void testCompare_DifferentStraights() {
        Hand first = Hand.straight(asList(DIAMOND_SEVEN, HEART_THREE, CLUB_FOUR, HEART_FIVE, HEART_SIX));
        Hand second = Hand.straight(asList(CLUB_FOUR, HEART_FIVE, HEART_SIX, DIAMOND_SEVEN, SPADE_EIGHT));

        assertTrue(comparator.compare(first, second) < 0);
    }

    @Test
    public void testCompare_DifferentStraights_AceTop() {
        Hand first = Hand.straight(asList(SPADE_TEN, HEART_JACK, DIAMOND_QUEEN, HEART_KING, CLUB_ACE));
        Hand second = Hand.straight(asList(DIAMOND_NINE, SPADE_TEN, HEART_JACK, DIAMOND_QUEEN, HEART_KING));

        assertTrue(comparator.compare(first, second) > 0);
    }
    @Test
    public void testCompare_DifferentStraights_AceFirst() {
        Hand first = Hand.straight(asList(SPADE_TWO, SPADE_THREE, DIAMOND_FOUR, HEART_FIVE, HEART_ACE));
        Hand second = Hand.straight(asList(SPADE_TWO, SPADE_THREE, DIAMOND_FOUR, HEART_FIVE, DIAMOND_SIX));

        assertTrue(comparator.compare(first, second) < 0);
    }

}
