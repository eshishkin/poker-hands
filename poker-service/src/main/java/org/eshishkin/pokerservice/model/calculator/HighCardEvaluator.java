package org.eshishkin.pokerservice.model.calculator;

import java.util.List;
import java.util.stream.Stream;
import org.eshishkin.pokerservice.model.Card;

class HighCardEvaluator extends AbstractHandEvaluator {

    @Override
    protected boolean isApplicable(List<Card> cards) {
        return true;
    }

    @Override
    protected Stream<Card> reorder(List<Card> cards) {
        return cards.stream().sorted(COMPARE_BY_VALUE);
    }

    @Override
    protected Hand toHand(List<Card> cards) {
        return Hand.highCard(cards);
    }
}
