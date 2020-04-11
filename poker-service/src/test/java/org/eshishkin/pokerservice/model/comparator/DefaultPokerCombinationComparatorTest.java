package org.eshishkin.pokerservice.model.comparator;

import org.eshishkin.pokerservice.model.Hand;
import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import static org.eshishkin.pokerservice.model.Card.CLUB_FOUR;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_SEVEN;
import static org.eshishkin.pokerservice.model.Card.HEART_FIVE;
import static org.eshishkin.pokerservice.model.Card.HEART_QUEEN;
import static org.eshishkin.pokerservice.model.Card.HEART_SIX;
import static org.eshishkin.pokerservice.model.Card.HEART_TEN;
import static org.eshishkin.pokerservice.model.Card.HEART_THREE;
import static org.eshishkin.pokerservice.model.Card.HEART_TWO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DefaultPokerCombinationComparatorTest {

    private HandComparator comparator = new DefaultPokerHandComparator();

    @Test
    public void testCompare_TwoEqualFlushes() {
        Hand flush1 = Hand.flush(asList(HEART_THREE, HEART_TWO, HEART_FIVE, HEART_SIX, HEART_TEN));
        Hand flush2 = Hand.flush(asList(HEART_THREE, HEART_TWO, HEART_FIVE, HEART_SIX, HEART_TEN));

        assertEquals(0, comparator.compare(flush1, flush2));
    }

    @Test
    public void testCompare_TwoDifferentFlushes() {
        Hand flush1 = Hand.flush(asList(HEART_THREE, HEART_TWO, HEART_FIVE, HEART_SIX, HEART_TEN));
        Hand flush2 = Hand.flush(asList(HEART_QUEEN, HEART_TWO, HEART_FIVE, HEART_SIX, HEART_TEN));

        assertTrue(comparator.compare(flush1, flush2) < 0);
    }

    @Test
    public void testCompare_StraightAndFlush() {
        Hand straight = Hand.straight(asList(HEART_THREE, CLUB_FOUR, HEART_FIVE, HEART_SIX, DIAMOND_SEVEN));
        Hand flush = Hand.flush(asList(HEART_THREE, HEART_TWO, HEART_FIVE, HEART_SIX, HEART_TEN));

        assertTrue(comparator.compare(straight, flush) < 0);
    }
}
