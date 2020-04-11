package org.eshishkin.pokerservice.model.comparator;

import org.eshishkin.pokerservice.model.Hand;
import static org.eshishkin.pokerservice.model.Hand.Rank.ONE_PAIR;
import static org.eshishkin.pokerservice.model.Hand.Rank.THREE_OF_KIND;
import static org.eshishkin.pokerservice.model.comparator.ComparatorUtils.compareElementByElement;
import static org.eshishkin.pokerservice.model.comparator.ComparatorUtils.groupSameValuesAndOrderByValue;

class ThreeOfKindComparator implements HandComparator {

    @Override
    public int compare(Hand o1, Hand o2) {
        if (o1.getRank() != THREE_OF_KIND || o2.getRank() != THREE_OF_KIND) {
            throw new IllegalArgumentException("One of hands is not \"Three of kind\"");
        }

        return compareElementByElement(
                groupSameValuesAndOrderByValue(o1.getCards()),
                groupSameValuesAndOrderByValue(o2.getCards())
        );
    }
}