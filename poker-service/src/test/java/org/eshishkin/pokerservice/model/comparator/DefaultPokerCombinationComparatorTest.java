package org.eshishkin.pokerservice.model.comparator;

import java.util.List;
import java.util.stream.Stream;
import org.eshishkin.pokerservice.model.Card;
import org.eshishkin.pokerservice.model.Hand;
import org.eshishkin.pokerservice.model.calculator.DefaultPokerHandEvaluator;
import org.eshishkin.pokerservice.model.calculator.HandEvaluator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static java.util.Arrays.asList;
import static org.eshishkin.pokerservice.model.Card.CLUB_QUEEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_ACE;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_KING;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_QUEEN;
import static org.eshishkin.pokerservice.model.Card.DIAMOND_TWO;
import static org.eshishkin.pokerservice.model.Card.HEART_ACE;
import static org.eshishkin.pokerservice.model.Card.HEART_FIVE;
import static org.eshishkin.pokerservice.model.Card.HEART_FOUR;
import static org.eshishkin.pokerservice.model.Card.HEART_JACK;
import static org.eshishkin.pokerservice.model.Card.HEART_KING;
import static org.eshishkin.pokerservice.model.Card.HEART_QUEEN;
import static org.eshishkin.pokerservice.model.Card.HEART_SEVEN;
import static org.eshishkin.pokerservice.model.Card.HEART_SIX;
import static org.eshishkin.pokerservice.model.Card.HEART_TEN;
import static org.eshishkin.pokerservice.model.Card.HEART_THREE;
import static org.eshishkin.pokerservice.model.Card.HEART_TWO;
import static org.eshishkin.pokerservice.model.Card.SPADE_ACE;
import static org.eshishkin.pokerservice.model.Card.SPADE_FOUR;
import static org.eshishkin.pokerservice.model.Card.SPADE_JACK;
import static org.eshishkin.pokerservice.model.Card.SPADE_KING;
import static org.eshishkin.pokerservice.model.Card.SPADE_QUEEN;
import static org.eshishkin.pokerservice.model.Card.SPADE_SIX;
import static org.eshishkin.pokerservice.model.Card.SPADE_TEN;
import static org.eshishkin.pokerservice.model.Card.SPADE_TWO;
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
                        Hand.Rank.FLUSH, asList(HEART_THREE, HEART_TWO, HEART_FIVE, HEART_SIX, HEART_TEN),
                        Hand.Rank.FLUSH, asList(HEART_THREE, HEART_TWO, HEART_FIVE, HEART_SIX, HEART_TEN),
                        CompareMode.EQUALS
                ),

                arguments(
                        Hand.Rank.FLUSH, asList(HEART_THREE, HEART_TWO, HEART_FIVE, HEART_SIX, HEART_TEN),
                        Hand.Rank.FLUSH, asList(HEART_QUEEN, HEART_TWO, HEART_FIVE, HEART_SIX, HEART_TEN),
                        CompareMode.LESS
                ),

                arguments(
                        Hand.Rank.FLUSH, asList(HEART_THREE, HEART_TWO, HEART_FIVE, HEART_SIX, HEART_TEN),
                        Hand.Rank.STRAIGHT, asList(HEART_KING, HEART_JACK, DIAMOND_ACE, SPADE_QUEEN, HEART_TEN),
                        CompareMode.GREATER
                ),

                arguments(
                        Hand.Rank.FULL_HOUSE, asList(HEART_TEN, HEART_KING, SPADE_KING, DIAMOND_KING, SPADE_TEN),
                        Hand.Rank.FULL_HOUSE, asList(HEART_QUEEN, SPADE_QUEEN, HEART_TEN, SPADE_TEN, DIAMOND_QUEEN),
                        CompareMode.GREATER
                ),

                arguments(
                        Hand.Rank.FULL_HOUSE, asList(HEART_QUEEN, SPADE_QUEEN, DIAMOND_QUEEN, HEART_JACK, SPADE_JACK),
                        Hand.Rank.FULL_HOUSE, asList(HEART_QUEEN, SPADE_QUEEN, DIAMOND_QUEEN, HEART_TEN, SPADE_TEN),
                        CompareMode.GREATER
                ),

                arguments(
                        Hand.Rank.FLUSH, asList(HEART_THREE, HEART_TWO, HEART_FIVE, HEART_SIX, HEART_TEN),
                        Hand.Rank.STRAIGHT, asList(HEART_KING, HEART_JACK, DIAMOND_ACE, SPADE_QUEEN, HEART_TEN),
                        CompareMode.GREATER
                ),

                arguments(
                        Hand.Rank.HIGH_CARD, asList(DIAMOND_KING, CLUB_QUEEN, HEART_ACE, HEART_SEVEN, HEART_FOUR),
                        Hand.Rank.HIGH_CARD, asList(SPADE_ACE, HEART_QUEEN, SPADE_JACK, SPADE_FOUR, HEART_THREE),
                        CompareMode.GREATER
                ),

                arguments(
                        Hand.Rank.TWO_PAIRS, asList(DIAMOND_TWO, HEART_TWO, HEART_FIVE, HEART_SIX, SPADE_SIX),
                        Hand.Rank.THREE_OF_KIND, asList(HEART_TWO, SPADE_TWO, DIAMOND_ACE, SPADE_QUEEN, DIAMOND_TWO),
                        CompareMode.LESS
                )
        );
    }

    private enum CompareMode {
        EQUALS, LESS, GREATER
    }
}
