package org.eshishkin.pokerservice.model.comparator;

import java.util.List;
import org.eshishkin.pokerservice.model.Card;
import org.eshishkin.pokerservice.model.Hand;
import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import static org.eshishkin.pokerservice.model.Card.CLUB_JACK;
import static org.eshishkin.pokerservice.model.Card.CLUB_KING;
import static org.eshishkin.pokerservice.model.Card.CLUB_SIX;
import static org.eshishkin.pokerservice.model.Card.CLUB_TEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_FIVE;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_JACK;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_KING;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_QUEEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_SIX;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_TEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_TWO;
import static org.eshishkin.pokerservice.model.Card.HEART_FIVE;
import static org.eshishkin.pokerservice.model.Card.HEART_JACK;
import static org.eshishkin.pokerservice.model.Card.HEART_KING;
import static org.eshishkin.pokerservice.model.Card.HEART_QUEEN;
import static org.eshishkin.pokerservice.model.Card.HEART_SIX;
import static org.eshishkin.pokerservice.model.Card.HEART_TEN;
import static org.eshishkin.pokerservice.model.Card.HEART_THREE;
import static org.eshishkin.pokerservice.model.Card.SPADE_JACK;
import static org.eshishkin.pokerservice.model.Card.SPADE_KING;
import static org.eshishkin.pokerservice.model.Card.SPADE_QUEEN;
import static org.eshishkin.pokerservice.model.Card.SPADE_SIX;
import static org.eshishkin.pokerservice.model.Card.SPADE_TEN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FullHouseComparatorTest {

    private HandComparator comparator = new FullHouseComparator();

    @Test
    public void testCompare_SameFullHouses() {
        List<Card> cards = asList(HEART_QUEEN, SPADE_QUEEN, DIAMOND_QUEEN, HEART_TEN, SPADE_TEN);

        Hand first = Hand.fullHouse(cards);
        Hand second = Hand.fullHouse(cards);
        assertEquals(0, comparator.compare(first, second));
    }

    @Test
    public void testCompare_TripletsAreTheSame_PairsDifferent() {
        Hand first = Hand.fullHouse(asList(HEART_QUEEN, SPADE_QUEEN, DIAMOND_QUEEN, HEART_JACK, SPADE_JACK));
        Hand second = Hand.fullHouse(asList(HEART_QUEEN, SPADE_QUEEN, DIAMOND_QUEEN, HEART_TEN, SPADE_TEN));

        assertTrue(comparator.compare(first, second) > 0);
    }

    @Test
    public void testCompare_TripletsAreDifferent_PairsAreTheSame() {
        Hand first = Hand.fullHouse(asList(HEART_KING, SPADE_KING, DIAMOND_KING, HEART_TEN, SPADE_TEN));
        Hand second = Hand.fullHouse(asList(HEART_QUEEN, SPADE_QUEEN, DIAMOND_QUEEN, HEART_TEN, SPADE_TEN));

        assertTrue(comparator.compare(first, second) > 0);
    }

    @Test
    public void testCompare_TripletsAndPairsAreDifferent() {
        Hand first = Hand.fullHouse(asList(DIAMOND_TEN, DIAMOND_FIVE, SPADE_TEN, HEART_FIVE, CLUB_TEN));
        Hand second = Hand.fullHouse(asList(DIAMOND_QUEEN, SPADE_SIX, DIAMOND_SIX, HEART_SIX, SPADE_QUEEN));

        assertTrue(comparator.compare(first, second) > 0);
    }
}
