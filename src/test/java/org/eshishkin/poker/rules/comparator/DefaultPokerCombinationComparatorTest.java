package org.eshishkin.poker.rules.comparator;

import java.util.List;
import java.util.stream.Stream;

import org.eshishkin.poker.model.Card;
import org.eshishkin.poker.rules.calculator.DefaultPokerHandEvaluator;
import org.eshishkin.poker.rules.calculator.Hand;
import org.eshishkin.poker.rules.calculator.HandEvaluator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class DefaultPokerCombinationComparatorTest {

    private final HandEvaluator evaluator = new DefaultPokerHandEvaluator();
    private final DefaultPokerHandComparator comparator = new DefaultPokerHandComparator();

    @ParameterizedTest
    @MethodSource("pokerTestSets")
    public void testCompare(Hand.Rank rank1, List<Card> cards1, Hand.Rank rank2, List<Card> cards2,
                            CompareMode compareMode) {

        Hand hand1  = evaluator.evaluate(cards1);
        Hand hand2  = evaluator.evaluate(cards2);

        assertEquals(rank1, hand1.getRank());
        assertEquals(rank2, hand2.getRank());

        int result = comparator.compare(hand1, hand2);

        switch (compareMode) {
            case LESS:
                assertTrue(result < 0);
                break;
            case GREATER:
                assertTrue(result > 0);
                break;
            case EQUALS:
                assertEquals(0, result);
                break;
        }
    }

    static Stream<Arguments> pokerTestSets() {
        return Stream.of(
                arguments(
                        Hand.Rank.FLUSH, asList(Card.HEART_THREE, Card.HEART_TWO, Card.HEART_FIVE, Card.HEART_SIX, Card.HEART_TEN),
                        Hand.Rank.FLUSH, asList(Card.HEART_THREE, Card.HEART_TWO, Card.HEART_FIVE, Card.HEART_SIX, Card.HEART_TEN),
                        CompareMode.EQUALS
                ),

                arguments(
                        Hand.Rank.FLUSH, asList(Card.HEART_THREE, Card.HEART_TWO, Card.HEART_FIVE, Card.HEART_SIX, Card.HEART_TEN),
                        Hand.Rank.FLUSH, asList(Card.HEART_QUEEN, Card.HEART_TWO, Card.HEART_FIVE, Card.HEART_SIX, Card.HEART_TEN),
                        CompareMode.LESS
                ),

                arguments(
                        Hand.Rank.FLUSH, asList(Card.HEART_THREE, Card.HEART_TWO, Card.HEART_FIVE, Card.HEART_SIX, Card.HEART_TEN),
                        Hand.Rank.STRAIGHT, asList(Card.HEART_KING, Card.HEART_JACK, Card.DIAMOND_ACE, Card.SPADE_QUEEN, Card.HEART_TEN),
                        CompareMode.GREATER
                ),

                arguments(
                        Hand.Rank.FULL_HOUSE, asList(Card.HEART_TEN, Card.HEART_KING, Card.SPADE_KING, Card.DIAMOND_KING, Card.SPADE_TEN),
                        Hand.Rank.FULL_HOUSE, asList(Card.HEART_QUEEN, Card.SPADE_QUEEN, Card.HEART_TEN, Card.SPADE_TEN, Card.DIAMOND_QUEEN),
                        CompareMode.GREATER
                ),

                arguments(
                        Hand.Rank.FULL_HOUSE, asList(Card.HEART_QUEEN, Card.SPADE_QUEEN, Card.DIAMOND_QUEEN, Card.HEART_JACK, Card.SPADE_JACK),
                        Hand.Rank.FULL_HOUSE, asList(Card.HEART_QUEEN, Card.SPADE_QUEEN, Card.DIAMOND_QUEEN, Card.HEART_TEN, Card.SPADE_TEN),
                        CompareMode.GREATER
                ),

                arguments(
                        Hand.Rank.FLUSH, asList(Card.HEART_THREE, Card.HEART_TWO, Card.HEART_FIVE, Card.HEART_SIX, Card.HEART_TEN),
                        Hand.Rank.STRAIGHT, asList(Card.HEART_KING, Card.HEART_JACK, Card.DIAMOND_ACE, Card.SPADE_QUEEN, Card.HEART_TEN),
                        CompareMode.GREATER
                ),

                arguments(
                        Hand.Rank.HIGH_CARD, asList(Card.DIAMOND_KING, Card.CLUB_QUEEN, Card.HEART_ACE, Card.HEART_SEVEN, Card.HEART_FOUR),
                        Hand.Rank.HIGH_CARD, asList(Card.SPADE_ACE, Card.HEART_QUEEN, Card.SPADE_JACK, Card.SPADE_FOUR, Card.HEART_THREE),
                        CompareMode.GREATER
                ),

                arguments(
                        Hand.Rank.TWO_PAIRS, asList(Card.DIAMOND_TWO, Card.HEART_TWO, Card.HEART_FIVE, Card.HEART_SIX, Card.SPADE_SIX),
                        Hand.Rank.THREE_OF_KIND, asList(Card.HEART_TWO, Card.SPADE_TWO, Card.DIAMOND_ACE, Card.SPADE_QUEEN, Card.DIAMOND_TWO),
                        CompareMode.LESS
                )
        );
    }

    private enum CompareMode {
        EQUALS, LESS, GREATER
    }
}
