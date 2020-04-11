package org.eshishkin.pokerservice.model.comparator;

import org.eshishkin.pokerservice.model.Hand;
import static org.eshishkin.pokerservice.model.Hand.Rank.FULL_HOUSE;
import static org.eshishkin.pokerservice.model.comparator.ComparatorUtils.compareElementByElement;
import static org.eshishkin.pokerservice.model.comparator.ComparatorUtils.groupSameValuesAndOrderByValue;

class FullHouseComparator implements HandComparator {

    @Override
    public int compare(Hand o1, Hand o2) {
        if (o1.getRank() != FULL_HOUSE || o2.getRank() != FULL_HOUSE) {
            throw new IllegalArgumentException("One of hands is not a \"Full House\"");
        }

        return compareElementByElement(
                groupSameValuesAndOrderByValue(o1.getCards()),
                groupSameValuesAndOrderByValue(o2.getCards())
        );
    }
}