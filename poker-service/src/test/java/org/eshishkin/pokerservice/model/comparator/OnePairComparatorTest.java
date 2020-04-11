package org.eshishkin.pokerservice.model.comparator;

import java.util.List;
import org.eshishkin.pokerservice.model.Card;
import org.eshishkin.pokerservice.model.Hand;
import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import static org.eshishkin.pokerservice.model.Card.CLUB_KING;
import static org.eshishkin.pokerservice.model.Card.CLUB_QUEEN;
import static org.eshishkin.pokerservice.model.Card.CLUB_SIX;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_ACE;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_FIVE;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_FOUR;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_JACK;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_KING;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_QUEEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_TEN;
import static org.eshishkin.pokerservice.model.Card.HEART_FIVE;
import static org.eshishkin.pokerservice.model.Card.HEART_FOUR;
import static org.eshishkin.pokerservice.model.Card.HEART_QUEEN;
import static org.eshishkin.pokerservice.model.Card.HEART_TWO;
import static org.eshishkin.pokerservice.model.Card.SPADE_JACK;
import static org.eshishkin.pokerservice.model.Card.SPADE_QUEEN;
import static org.eshishkin.pokerservice.model.Card.SPADE_TEN;
import static org.eshishkin.pokerservice.model.Card.SPADE_THREE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnePairComparatorTest {

    private final HandComparator comparator = new OnePairComparator();

    @Test
    public void testCompare_SameOnePair_AllLKickersAreTheSame() {
        List<Card> cards = asList(HEART_QUEEN, SPADE_QUEEN, SPADE_TEN, CLUB_SIX, SPADE_JACK);

        Hand first = Hand.onePair(cards);
        Hand second = Hand.onePair(cards);
        assertEquals(0, comparator.compare(first, second));
    }

    @Test
    public void testCompare_SameOnePair_ThirdKickersAreDifferent() {
        Hand first = Hand.onePair(asList(HEART_QUEEN, SPADE_QUEEN, SPADE_JACK, HEART_FOUR, SPADE_THREE));
        Hand second = Hand.onePair(asList(DIAMOND_QUEEN, CLUB_QUEEN, DIAMOND_JACK, DIAMOND_FOUR, HEART_TWO));

        assertTrue(comparator.compare(first, second) > 0);
    }

    @Test
    public void testCompare_SameOnePair_SecondKickersAreDifferent() {
        Hand first = Hand.onePair(asList(HEART_QUEEN, SPADE_QUEEN, SPADE_JACK, HEART_FIVE, SPADE_THREE));
        Hand second = Hand.onePair(asList(DIAMOND_QUEEN, CLUB_QUEEN, DIAMOND_JACK, DIAMOND_FOUR, HEART_TWO));

        assertTrue(comparator.compare(first, second) > 0);
    }

    @Test
    public void testCompare_SameOnePair_FirstKickersAreDifferent() {
        Hand first = Hand.onePair(asList(HEART_QUEEN, SPADE_QUEEN, SPADE_JACK, HEART_FIVE, SPADE_THREE));
        Hand second = Hand.onePair(asList(DIAMOND_QUEEN, CLUB_QUEEN, DIAMOND_TEN, DIAMOND_FIVE, HEART_TWO));

        assertTrue(comparator.compare(first, second) > 0);
    }

    @Test
    public void testCompare_DifferentPairs() {
        Hand first = Hand.onePair(asList(HEART_QUEEN, SPADE_QUEEN, SPADE_JACK, HEART_FIVE, SPADE_THREE));
        Hand second = Hand.onePair(asList(DIAMOND_KING, CLUB_KING, DIAMOND_ACE, DIAMOND_FIVE, HEART_TWO));

        assertTrue(comparator.compare(first, second) < 0);
    }
}
