package org.eshishkin.poker.rules.calculator;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.eshishkin.poker.model.Card;
import org.eshishkin.poker.model.Card.CardValue;
import org.eshishkin.poker.model.Card.Suite;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

abstract class AbstractHandEvaluator implements HandEvaluator {
    protected final static Comparator<Card> COMPARE_BY_VALUE = Comparator.comparing(Card::getValue).reversed();
    protected static final int CARDS_IN_HAND = 5;
    protected static final int CARDS_IN_PAIR = 2;
    protected static final int CARDS_IN_TRIPLE = 3;
    protected static final int CARDS_IN_QUAD = 4;

    @Override
    public Hand evaluate(List<Card> cards) {
        Hand hand = null;
        if (isApplicable(cards)) {
            hand = toHand(reorder(cards).limit(CARDS_IN_HAND).collect(toList()));
        }

        return hand;
    }

    protected abstract boolean isApplicable(List<Card> cards);

    protected abstract Stream<Card> reorder(List<Card> cards);

    protected abstract Hand toHand(List<Card> cards);


    protected Map<CardValue, List<Card>> groupByValues(List<Card> cards) {
        return cards.stream().collect(groupingBy(Card::getValue, toList()));
    }

    protected Map<Suite, List<Card>> groupBySuite(List<Card> cards) {
        return cards.stream().collect(groupingBy(Card::getSuite, toList()));
    }

    protected Stream<Card> getGroupsWithSize(Collection<List<Card>> groups, int size) {
        return groups
                .stream()
                .filter(v -> v.size() == size)
                .flatMap(Collection::stream)
                .sorted(COMPARE_BY_VALUE);
    }

    protected Stream<Card> getGroupsWithSize(Collection<List<Card>> groups, Predicate<Integer> tester) {
        return groups
                .stream()
                .filter(v -> tester.test(v.size()))
                .flatMap(Collection::stream)
                .sorted(COMPARE_BY_VALUE);
    }
}
