package org.eshishkin.pokerservice.model.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Stream;
import org.eshishkin.pokerservice.model.Card;
import org.eshishkin.pokerservice.model.Card.CardValue;
import org.eshishkin.pokerservice.model.Hand;
import static java.util.Arrays.asList;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static org.eshishkin.pokerservice.model.Card.CardValue.ACE;
import static org.eshishkin.pokerservice.model.Card.CardValue.EIGHT;
import static org.eshishkin.pokerservice.model.Card.CardValue.FIVE;
import static org.eshishkin.pokerservice.model.Card.CardValue.FOUR;
import static org.eshishkin.pokerservice.model.Card.CardValue.JACK;
import static org.eshishkin.pokerservice.model.Card.CardValue.KING;
import static org.eshishkin.pokerservice.model.Card.CardValue.NINE;
import static org.eshishkin.pokerservice.model.Card.CardValue.QUEEN;
import static org.eshishkin.pokerservice.model.Card.CardValue.SEVEN;
import static org.eshishkin.pokerservice.model.Card.CardValue.SIX;
import static org.eshishkin.pokerservice.model.Card.CardValue.TEN;
import static org.eshishkin.pokerservice.model.Card.CardValue.THREE;
import static org.eshishkin.pokerservice.model.Card.CardValue.TWO;

class StraightEvaluator extends AbstractHandEvaluator {

    private static final int[] STRAIGHTS = {
            mask(TEN, JACK, QUEEN, KING, ACE),
            mask(NINE, TEN, JACK, QUEEN, KING),
            mask(EIGHT, NINE, TEN, JACK, QUEEN),
            mask(SEVEN, EIGHT, NINE, TEN, JACK),
            mask(SIX, SEVEN, EIGHT, NINE, TEN),
            mask(FIVE, SIX, SEVEN, EIGHT, NINE),
            mask(FOUR, FIVE, SIX, SEVEN, EIGHT),
            mask(THREE, FOUR, FIVE, SIX, SEVEN),
            mask(TWO, THREE, FOUR, FIVE, SIX),
            mask(ACE, TWO, THREE, FOUR, FIVE)
    };

    @Override
    protected boolean isApplicable(List<Card> cards) {
        int mask = mask(cards.stream().map(Card::getValue).collect(toList()));
        return Arrays.stream(STRAIGHTS).anyMatch(isStraight(mask));
    }

    @Override
    protected Stream<Card> reorder(List<Card> cards) {
        List<CardValue> values = cards.stream().map(Card::getValue).collect(toList());
        int mask = mask(values);

        return Arrays.stream(STRAIGHTS)
                .filter(isStraight(mask))
                .mapToObj(this::maskToValues)
                .flatMap(identity())
                .map(value -> cards.stream().filter(c -> c.getValue() == value).findFirst().get());
    }

    @Override
    protected Hand toHand(List<Card> cards) {
        return Hand.straight(cards);
    }

    private static int mask(List<CardValue> values) {
        int mask = 0;

        for (CardValue value : values) {
            mask |= 1 << value.ordinal();
        }

        return mask;
    }

    private static int mask(CardValue... values) {
        return mask(asList(values));
    }

    private Stream<CardValue> maskToValues(int straight) {
        boolean lowAce = straight == STRAIGHTS[STRAIGHTS.length-1];
        List<CardValue> value = new ArrayList<>();

        Arrays.stream(CardValue.values()).filter(v -> isCardInStraight(straight, v)).forEach(v -> {
            if (lowAce && v == ACE) {
                value.add(ACE);
            } else {
                value.add(0, v);
            }
        });

        return value.stream();
    }

    private IntPredicate isStraight(int mask) {
        return pattern -> (pattern & mask) == pattern;
    }

    private boolean isCardInStraight(int straight, CardValue value) {
        return (straight & (1 << value.ordinal())) != 0;
    }
}
