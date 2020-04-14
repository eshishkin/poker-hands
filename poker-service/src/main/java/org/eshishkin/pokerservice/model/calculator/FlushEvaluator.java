package org.eshishkin.pokerservice.model.calculator;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.eshishkin.pokerservice.model.Card;
import org.eshishkin.pokerservice.model.Card.Suite;

class FlushEvaluator extends AbstractHandEvaluator {

    @Override
    protected boolean isApplicable(List<Card> cards) {
        return groupBySuite(cards).values().stream().anyMatch(group -> group.size() >= CARDS_IN_HAND);
    }

    @Override
    protected Stream<Card> reorder(List<Card> cards) {
        Map<Suite, List<Card>> grouped = groupBySuite(cards);

        return getGroupsWithSize(grouped.values(), s -> s >= CARDS_IN_HAND);
    }

    @Override
    protected Hand toHand(List<Card> cards) {
        return Hand.flush(cards);
    }
}
