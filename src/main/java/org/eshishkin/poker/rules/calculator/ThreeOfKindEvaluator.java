package org.eshishkin.poker.rules.calculator;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.eshishkin.poker.model.Card;
import org.eshishkin.poker.model.Card.CardValue;

class ThreeOfKindEvaluator extends AbstractHandEvaluator {

    @Override
    protected boolean isApplicable(List<Card> cards) {
        return groupByValues(cards).values()
                .stream()
                .filter(group -> group.size() == CARDS_IN_TRIPLE)
                .count() == 1;
    }

    @Override
    protected Stream<Card> reorder(List<Card> cards) {
        Map<CardValue, List<Card>> grouped = groupByValues(cards);

        return Stream.concat(
                getGroupsWithSize(grouped.values(), CARDS_IN_TRIPLE),
                getGroupsWithSize(grouped.values(), s -> s < CARDS_IN_PAIR)
        );

    }

    @Override
    protected Hand toHand(List<Card> cards) {
        return Hand.threeOfKind(cards);
    }
}
