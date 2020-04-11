package org.eshishkin.pokerservice.model.comparator;

import java.util.Comparator;
import java.util.List;
import org.eshishkin.pokerservice.model.Card;
import org.eshishkin.pokerservice.model.Hand;
import static java.util.stream.Collectors.toList;
import static org.eshishkin.pokerservice.model.comparator.ComparatorUtils.compareElementByElement;

class HighCardComparator implements HandComparator {

    @Override
    public int compare(Hand o1, Hand o2) {
        return compareElementByElement(sort(o1), sort(o2));
    }

    private List<Card.CardValue> sort(Hand o1) {
        return o1.getCards().stream().map(Card::getValue).sorted(Comparator.reverseOrder()).collect(toList());
    }
}