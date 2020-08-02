package org.eshishkin.poker.rules.calculator;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.eshishkin.poker.model.Card;
import org.eshishkin.poker.model.Card.CardValue;

class FullHouseEvaluator extends AbstractHandEvaluator {

    @Override
    protected boolean isApplicable(List<Card> cards) {
        boolean triple = groupByValues(cards).values().stream().filter(x -> x.size() == CARDS_IN_TRIPLE).count() == 1;
        boolean pair = groupByValues(cards).values().stream().filter(x -> x.size() == CARDS_IN_PAIR).count() == 1;

        return triple && pair;
    }

    @Override
    protected Stream<Card> reorder(List<Card> cards) {
        Map<CardValue, List<Card>> grouped = groupByValues(cards);
        return Stream.concat(
                getGroupsWithSize(grouped.values(), CARDS_IN_TRIPLE),
                getGroupsWithSize(grouped.values(), CARDS_IN_PAIR)
        );
    }


    @Override
    protected Hand toHand(List<Card> cards) {
        return Hand.fullHouse(cards);
    }
}
