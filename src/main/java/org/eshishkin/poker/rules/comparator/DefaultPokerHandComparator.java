package org.eshishkin.poker.rules.comparator;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

import org.eshishkin.poker.model.Card;
import org.eshishkin.poker.rules.calculator.Hand;

public class DefaultPokerHandComparator implements Comparator<Hand>, Serializable {

    private static final Comparator<Hand> BY_RANK_COMPARATOR =Comparator.comparing(Hand::getRank);
    private static final Comparator<Hand> BY_VALUE_COMPARATOR = new ValueComparator();

    @Override
    public int compare(Hand o1, Hand o2) {
        if (o1 == null) {
            throw new NullPointerException("first argument is null");
        }

        if (o2 == null) {
            throw new NullPointerException("second argument is null");
        }

        return BY_RANK_COMPARATOR.thenComparing(BY_VALUE_COMPARATOR).compare(o1, o2);

    }

    private static class ValueComparator implements Comparator<Hand>, Serializable {
        @Override
        public int compare(Hand o1, Hand o2) {
            List<Card> first = o1.getCards();
            List<Card> second = o2.getCards();

            if (first.size() != second.size()) {
                throw new IllegalArgumentException("Collections have different size");

            }

            int result = 0;

            for (int i = 0; i < first.size(); i++) {
                if (result != 0) {
                    break;
                }
                Card.CardValue value = first.get(i).getValue();
                Card.CardValue value2 = second.get(i).getValue();
                result = value.compareTo(value2);
            }
            return result;
        }
    }
}
