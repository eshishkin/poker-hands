package org.eshishkin.pokerservice.model.comparator;

import org.eshishkin.pokerservice.model.Hand;
import static org.eshishkin.pokerservice.model.Hand.Rank.FOUR_OF_KIND;
import static org.eshishkin.pokerservice.model.comparator.ComparatorUtils.compareElementByElement;
import static org.eshishkin.pokerservice.model.comparator.ComparatorUtils.groupSameValuesAndOrderByValue;

class FourOfKindComparator implements HandComparator {

    @Override
    public int compare(Hand o1, Hand o2) {
        if (o1.getRank() != FOUR_OF_KIND || o2.getRank() != FOUR_OF_KIND) {
            throw new IllegalArgumentException("One of hands is not \"Four of kind\"");
        }

        return compareElementByElement(
                groupSameValuesAndOrderByValue(o1.getCards()),
                groupSameValuesAndOrderByValue(o2.getCards())
        );
    }
}