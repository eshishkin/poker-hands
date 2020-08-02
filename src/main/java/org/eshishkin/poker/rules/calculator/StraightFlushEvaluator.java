package org.eshishkin.poker.rules.calculator;

import java.util.List;
import java.util.stream.Stream;

import org.eshishkin.poker.model.Card;

/**
 * ToDo: Implement me
 */
class StraightFlushEvaluator extends AbstractHandEvaluator {

    @Override
    protected boolean isApplicable(List<Card> cards) {
        return false;
    }

    @Override
    protected Stream<Card> reorder(List<Card> cards) {
        return cards.stream();
    }

    @Override
    protected Hand toHand(List<Card> cards) {
        return Hand.straightFlush(cards);
    }
}
