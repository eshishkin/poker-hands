package org.eshishkin.pokerservice.model.comparator;

import java.util.Comparator;
import java.util.List;
import org.eshishkin.pokerservice.model.Card;
import org.eshishkin.pokerservice.model.Card.CardValue;
import org.eshishkin.pokerservice.model.Hand;
import static java.util.stream.Collectors.toList;
import static org.eshishkin.pokerservice.model.Card.CardValue.ACE;
import static org.eshishkin.pokerservice.model.Card.CardValue.DUMMY;
import static org.eshishkin.pokerservice.model.Card.CardValue.TWO;
import static org.eshishkin.pokerservice.model.Hand.Rank.STRAIGHT;

class StraightComparator implements HandComparator {

    @Override
    public int compare(Hand o1, Hand o2) {
        if (o1.getRank() != STRAIGHT || o2.getRank() != STRAIGHT) {
            throw new IllegalArgumentException("One of hands is not \"Straight\"");
        }

        return getMax(o1.getCards()).compareTo(getMax(o2.getCards()));
    }

    private CardValue getMax(List<Card> cards) {
        List<CardValue> values = cards.stream().map(Card::getValue).collect(toList());
        boolean isAceFirst = values.contains(ACE) && values.contains(TWO);

        return values.stream()
                .filter(v -> !isAceFirst || v != ACE)
                .max(Comparator.naturalOrder())
                .orElse(DUMMY);
    }
}