package org.eshishkin.pokerservice.model.comparator;

import java.util.List;
import org.eshishkin.pokerservice.model.Card;
import org.eshishkin.pokerservice.model.Hand;
import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import static org.eshishkin.pokerservice.model.Card.CLUB_FOUR;
import static org.eshishkin.pokerservice.model.Card.CLUB_QUEEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_KING;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_SEVEN;
import static org.eshishkin.pokerservice.model.Card.HEART_ACE;
import static org.eshishkin.pokerservice.model.Card.HEART_FIVE;
import static org.eshishkin.pokerservice.model.Card.HEART_FOUR;
import static org.eshishkin.pokerservice.model.Card.HEART_KING;
import static org.eshishkin.pokerservice.model.Card.HEART_QUEEN;
import static org.eshishkin.pokerservice.model.Card.HEART_SEVEN;
import static org.eshishkin.pokerservice.model.Card.HEART_SIX;
import static org.eshishkin.pokerservice.model.Card.HEART_THREE;
import static org.eshishkin.pokerservice.model.Card.HEART_TWO;
import static org.eshishkin.pokerservice.model.Card.SPADE_ACE;
import static org.eshishkin.pokerservice.model.Card.SPADE_FOUR;
import static org.eshishkin.pokerservice.model.Card.SPADE_JACK;
import static org.eshishkin.pokerservice.model.Card.SPADE_QUEEN;
import static org.eshishkin.pokerservice.model.Card.SPADE_SEVEN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HighCardComparatorTest {

    private HandComparator comparator = new HighCardComparator();

    @Test
    public void testCompare_SameHighCards() {
        List<Card> cards = asList(HEART_THREE, CLUB_FOUR, HEART_FIVE, HEART_SIX, DIAMOND_SEVEN);

        Hand first = Hand.highCard(cards);
        Hand second = Hand.highCard(cards);

        assertEquals(0, comparator.compare(first, second));
    }

    @Test
    public void testCompare_FirstFourCardsAreTheSame() {
        Hand first = Hand.highCard(asList(HEART_ACE, DIAMOND_KING, CLUB_QUEEN, HEART_SEVEN, HEART_FOUR));
        Hand second = Hand.highCard(asList(SPADE_ACE, HEART_KING, SPADE_QUEEN, SPADE_SEVEN, HEART_THREE));

        assertTrue(comparator.compare(first, second) > 0);
    }

    @Test
    public void testCompare_FirstThreeCardsAreTheSame() {
        Hand first = Hand.highCard(asList(HEART_ACE, DIAMOND_KING, CLUB_QUEEN, HEART_SEVEN, HEART_FOUR));
        Hand second = Hand.highCard(asList(SPADE_ACE, HEART_KING, SPADE_QUEEN, SPADE_FOUR, HEART_THREE));

        assertTrue(comparator.compare(first, second) > 0);
    }


    @Test
    public void testCompare_FirstTwoCardsAreTheSame() {
        Hand first = Hand.highCard(asList(HEART_ACE, DIAMOND_KING, CLUB_QUEEN, HEART_SEVEN, HEART_FOUR));
        Hand second = Hand.highCard(asList(SPADE_ACE, HEART_KING, SPADE_JACK, SPADE_FOUR, HEART_THREE));

        assertTrue(comparator.compare(first, second) > 0);
    }

    @Test
    public void testCompare_FirstCardsAreTheSame() {
        Hand first = Hand.highCard(asList(HEART_ACE, DIAMOND_KING, CLUB_QUEEN, HEART_SEVEN, HEART_FOUR));
        Hand second = Hand.highCard(asList(SPADE_ACE, HEART_QUEEN, SPADE_JACK, SPADE_FOUR, HEART_THREE));

        assertTrue(comparator.compare(first, second) > 0);
    }

    @Test
    public void testCompare_AllCardsAreDifferent() {
        Hand first = Hand.highCard(asList(HEART_ACE, DIAMOND_KING, CLUB_QUEEN, HEART_SEVEN, HEART_TWO));
        Hand second = Hand.highCard(asList(DIAMOND_KING, CLUB_QUEEN, HEART_SEVEN, HEART_TWO, HEART_THREE));

        assertTrue(comparator.compare(first, second) > 0);
    }

}
