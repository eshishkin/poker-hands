package org.eshishkin.pokerservice.model.comparator;

import java.util.List;
import org.eshishkin.pokerservice.model.Card;
import org.eshishkin.pokerservice.model.Hand;
import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import static org.eshishkin.pokerservice.model.Card.CLUB_NINE;
import static org.eshishkin.pokerservice.model.Card.CLUB_QUEEN;
import static org.eshishkin.pokerservice.model.Card.CLUB_TEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_NINE;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_QUEEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_TEN;
import static org.eshishkin.pokerservice.model.Card.HEART_NINE;
import static org.eshishkin.pokerservice.model.Card.HEART_QUEEN;
import static org.eshishkin.pokerservice.model.Card.SPADE_JACK;
import static org.eshishkin.pokerservice.model.Card.SPADE_NINE;
import static org.eshishkin.pokerservice.model.Card.SPADE_QUEEN;
import static org.eshishkin.pokerservice.model.Card.SPADE_TEN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FourOfKindComparatorTest {

    private final HandComparator comparator = new FourOfKindComparator();

    @Test
    public void testCompare_SameQuadruplets_SameKickers() {
        List<Card> cards = asList(HEART_QUEEN, SPADE_QUEEN, DIAMOND_QUEEN, CLUB_QUEEN, SPADE_JACK);

        Hand first = Hand.fourOfKind(cards);
        Hand second = Hand.fourOfKind(cards);
        assertEquals(0, comparator.compare(first, second));
    }

    @Test
    public void testCompare_SameQuadruplets_DifferentKickers() {
        Hand first = Hand.fourOfKind(asList(HEART_QUEEN, SPADE_QUEEN, DIAMOND_QUEEN, CLUB_QUEEN, SPADE_JACK));
        Hand second = Hand.fourOfKind(asList(HEART_QUEEN, SPADE_QUEEN, DIAMOND_QUEEN, CLUB_QUEEN, SPADE_TEN));

        assertTrue(comparator.compare(first, second) > 0);
    }

    @Test
    public void testCompare_DifferentQuadruplets() {
        Hand first = Hand.fourOfKind(asList(HEART_QUEEN, SPADE_TEN, DIAMOND_TEN, CLUB_TEN, CLUB_TEN));
        Hand second = Hand.fourOfKind(asList(HEART_NINE, SPADE_QUEEN, DIAMOND_NINE, CLUB_NINE, SPADE_NINE));

        assertTrue(comparator.compare(first, second) > 0);
    }
}
