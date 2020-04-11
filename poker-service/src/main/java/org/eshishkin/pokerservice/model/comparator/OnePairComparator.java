package org.eshishkin.pokerservice.model.comparator;

import org.eshishkin.pokerservice.model.Hand;
import static org.eshishkin.pokerservice.model.Hand.Rank.ONE_PAIR;
import static org.eshishkin.pokerservice.model.comparator.ComparatorUtils.compareElementByElement;
import static org.eshishkin.pokerservice.model.comparator.ComparatorUtils.groupSameValuesAndOrderByValue;

class OnePairComparator implements HandComparator {

    @Override
    public int compare(Hand o1, Hand o2) {
        if (o1.getRank() != ONE_PAIR || o2.getRank() != ONE_PAIR) {
            throw new IllegalArgumentException("One of hands is not \"One pair\"");
        }

        return compareElementByElement(
                groupSameValuesAndOrderByValue(o1.getCards()),
                groupSameValuesAndOrderByValue(o2.getCards())
        );
    }
}