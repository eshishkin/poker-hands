package org.eshishkin.pokerservice.model.comparator;

import org.eshishkin.pokerservice.model.Hand;
import static org.eshishkin.pokerservice.model.Hand.Rank.TWO_PAIRS;
import static org.eshishkin.pokerservice.model.comparator.ComparatorUtils.compareElementByElement;
import static org.eshishkin.pokerservice.model.comparator.ComparatorUtils.groupSameValuesAndOrderByValue;

class TwoPairsComparator implements HandComparator {

    @Override
    public int compare(Hand o1, Hand o2) {
        if (o1.getRank() != TWO_PAIRS || o2.getRank() != TWO_PAIRS) {
            throw new IllegalArgumentException("One of hands is not a \"Two pairs\"");
        }

        return compareElementByElement(
                groupSameValuesAndOrderByValue(o1.getCards()),
                groupSameValuesAndOrderByValue(o2.getCards())
        );
    }
}