package org.eshishkin.pokerservice.model.comparator;

import java.util.List;
import org.eshishkin.pokerservice.model.Card;
import org.eshishkin.pokerservice.model.Hand;
import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import static org.eshishkin.pokerservice.model.Card.CLUB_SIX;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_FIVE;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_KING;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_QUEEN;
import static org.eshishkin.pokerservice.model.Card.HEART_FIVE;
import static org.eshishkin.pokerservice.model.Card.HEART_KING;
import static org.eshishkin.pokerservice.model.Card.HEART_QUEEN;
import static org.eshishkin.pokerservice.model.Card.HEART_TWO;
import static org.eshishkin.pokerservice.model.Card.SPADE_JACK;
import static org.eshishkin.pokerservice.model.Card.SPADE_KING;
import static org.eshishkin.pokerservice.model.Card.SPADE_QUEEN;
import static org.eshishkin.pokerservice.model.Card.SPADE_THREE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThreeOfKindComparatorTest {

    private final HandComparator comparator = new ThreeOfKindComparator();

    @Test
    public void testCompare_SameSets_AllLKickersAreTheSame() {
        List<Card> cards = asList(HEART_QUEEN, SPADE_QUEEN, DIAMOND_QUEEN, CLUB_SIX, SPADE_JACK);

        Hand first = Hand.threeOfKind(cards);
        Hand second = Hand.threeOfKind(cards);
        assertEquals(0, comparator.compare(first, second));
    }

    @Test
    public void testCompare_SameSets_SecondKickersAreDifferent() {
        Hand first = Hand.threeOfKind(asList(HEART_QUEEN, SPADE_QUEEN, DIAMOND_QUEEN, HEART_FIVE, SPADE_THREE));
        Hand second = Hand.threeOfKind(asList(HEART_QUEEN, SPADE_QUEEN, DIAMOND_QUEEN, DIAMOND_FIVE, HEART_TWO));

        assertTrue(comparator.compare(first, second) > 0);
    }

    @Test
    public void testCompare_SameSets_FirstKickersAreDifferent() {
        Hand first = Hand.threeOfKind(asList(HEART_QUEEN, SPADE_QUEEN, DIAMOND_QUEEN, HEART_FIVE, SPADE_THREE));
        Hand second = Hand.threeOfKind(asList(HEART_QUEEN, SPADE_QUEEN, DIAMOND_QUEEN, DIAMOND_FIVE, HEART_TWO));

        assertTrue(comparator.compare(first, second) > 0);
    }

    @Test
    public void testCompare_DifferentSets() {
        Hand first = Hand.threeOfKind(asList(HEART_KING, SPADE_KING, DIAMOND_KING, HEART_QUEEN, SPADE_THREE));
        Hand second = Hand.threeOfKind(asList(HEART_QUEEN, SPADE_QUEEN, DIAMOND_QUEEN, DIAMOND_KING, HEART_TWO));

        assertTrue(comparator.compare(first, second) > 0);
    }
}
