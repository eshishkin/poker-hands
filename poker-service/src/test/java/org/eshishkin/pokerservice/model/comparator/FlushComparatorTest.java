package org.eshishkin.pokerservice.model.comparator;

import java.util.List;
import org.eshishkin.pokerservice.model.Card;
import org.eshishkin.pokerservice.model.Hand;
import org.eshishkin.pokerservice.model.comparator.FlushComparator;
import org.eshishkin.pokerservice.model.comparator.HandComparator;
import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_FOUR;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_KING;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_NINE;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_QUEEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_SEVEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_TWO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlushComparatorTest {

    private HandComparator comparator = new FlushComparator();

    @Test
    public void testCompare_SameFlushes() {
        List<Card> cards = asList(DIAMOND_SEVEN, DIAMOND_FOUR, DIAMOND_QUEEN, DIAMOND_NINE, DIAMOND_TWO);

        Hand first = Hand.flush(cards);
        Hand second = Hand.flush(cards);
        assertEquals(0, comparator.compare(first, second));
    }

    @Test
    public void testCompare_DifferentFlushes() {
        Hand first = Hand.flush(asList(DIAMOND_QUEEN, DIAMOND_SEVEN, DIAMOND_FOUR, DIAMOND_NINE, DIAMOND_TWO));
        Hand second = Hand.flush(asList(DIAMOND_SEVEN, DIAMOND_FOUR, DIAMOND_NINE, DIAMOND_TWO, DIAMOND_KING));

        assertTrue(comparator.compare(first, second) < 0);
    }
}
