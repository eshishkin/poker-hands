package org.eshishkin.pokerservice.model.comparator;

import java.util.List;
import org.eshishkin.pokerservice.model.Card;
import org.eshishkin.pokerservice.model.Hand;
import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import static org.eshishkin.pokerservice.model.Card.CLUB_FOUR;
import static org.eshishkin.pokerservice.model.Card.CLUB_JACK;
import static org.eshishkin.pokerservice.model.Card.CLUB_KING;
import static org.eshishkin.pokerservice.model.Card.CLUB_QUEEN;
import static org.eshishkin.pokerservice.model.Card.CLUB_SIX;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_JACK;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_KING;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_SEVEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_SIX;
import static org.eshishkin.pokerservice.model.Card.HEART_ACE;
import static org.eshishkin.pokerservice.model.Card.HEART_FIVE;
import static org.eshishkin.pokerservice.model.Card.HEART_JACK;
import static org.eshishkin.pokerservice.model.Card.HEART_KING;
import static org.eshishkin.pokerservice.model.Card.HEART_QUEEN;
import static org.eshishkin.pokerservice.model.Card.HEART_SEVEN;
import static org.eshishkin.pokerservice.model.Card.HEART_SIX;
import static org.eshishkin.pokerservice.model.Card.HEART_TEN;
import static org.eshishkin.pokerservice.model.Card.HEART_THREE;
import static org.eshishkin.pokerservice.model.Card.HEART_TWO;
import static org.eshishkin.pokerservice.model.Card.SPADE_JACK;
import static org.eshishkin.pokerservice.model.Card.SPADE_KING;
import static org.eshishkin.pokerservice.model.Card.SPADE_QUEEN;
import static org.eshishkin.pokerservice.model.Card.SPADE_TEN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TwoPairsComparatorTest {

    private HandComparator comparator = new TwoPairsComparator();

    @Test
    public void testCompare_SameTwoPairs_SameKicker() {
        List<Card> cards = asList(HEART_QUEEN, HEART_TEN, SPADE_TEN, SPADE_QUEEN, SPADE_JACK);

        Hand first = Hand.twoPairs(cards);
        Hand second = Hand.twoPairs(cards);
        assertEquals(0, comparator.compare(first, second));
    }

    @Test
    public void testCompare_SameTwoPairs_Different_Kickers() {
        Hand first = Hand.twoPairs(asList(HEART_QUEEN, SPADE_QUEEN, HEART_TEN, SPADE_TEN,SPADE_JACK));
        Hand second = Hand.twoPairs(asList(HEART_QUEEN, SPADE_QUEEN, HEART_TEN, SPADE_TEN, SPADE_KING));

        assertTrue(comparator.compare(first, second) < 0);
    }

    @Test
    public void testCompare_HighPairsAreTheSame() {
        Hand first = Hand.twoPairs(asList(HEART_KING, DIAMOND_KING, DIAMOND_JACK, CLUB_JACK, HEART_THREE));
        Hand second = Hand.twoPairs(asList(SPADE_KING, CLUB_KING, HEART_TEN, SPADE_TEN, SPADE_JACK));

        assertTrue(comparator.compare(first, second) > 0);
    }


    @Test
    public void testCompare_BothPairsAreDifferent() {
        Hand first = Hand.twoPairs(asList(HEART_QUEEN, SPADE_QUEEN, HEART_TEN, SPADE_TEN, SPADE_JACK));
        Hand second = Hand.twoPairs(asList(HEART_KING, DIAMOND_KING, DIAMOND_SIX, CLUB_SIX, HEART_THREE));

        assertTrue(comparator.compare(first, second) < 0);
    }
}
