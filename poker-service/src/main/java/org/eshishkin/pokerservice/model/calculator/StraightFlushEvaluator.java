package org.eshishkin.pokerservice.model.calculator;

import java.util.List;
import java.util.stream.Stream;
import org.eshishkin.pokerservice.model.Card;
import org.eshishkin.pokerservice.model.Hand;

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
