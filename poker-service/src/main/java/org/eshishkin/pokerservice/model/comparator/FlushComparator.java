package org.eshishkin.pokerservice.model.comparator;

import java.util.Comparator;
import java.util.List;
import org.eshishkin.pokerservice.model.Card;
import org.eshishkin.pokerservice.model.Hand;
import static org.eshishkin.pokerservice.model.Card.CardValue.DUMMY;
import static org.eshishkin.pokerservice.model.Hand.Rank.FLUSH;

class FlushComparator implements HandComparator {

    @Override
    public int compare(Hand o1, Hand o2) {
        if (o1.getRank() != FLUSH || o2.getRank() != FLUSH) {
            throw new IllegalArgumentException("One of hands is not \"Flush\"");
        }

        return getMax(o1.getCards()).compareTo(getMax(o2.getCards()));
    }

    private Card.CardValue getMax(List<Card> cards) {
        return cards.stream().map(Card::getValue).max(Comparator.naturalOrder()).orElse(DUMMY);
    }
}