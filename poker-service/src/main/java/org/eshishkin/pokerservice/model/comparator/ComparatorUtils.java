package org.eshishkin.pokerservice.model.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.eshishkin.pokerservice.model.Card;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

final class ComparatorUtils {
    private ComparatorUtils() {
    }

    public static  <T extends Comparable<T>> int compareElementByElement(List<T> first, List<T> second) {
        if (first.size() != second.size()) {
            throw new IllegalArgumentException("Collections have different size");

        }
        int result = 0;
        for (int i = 0; i < first.size(); i++) {
            if (result != 0) {
                break;
            }

            result = first.get(i).compareTo(second.get(i));
        }
        return result;
    }


    public static List<Card.CardValue> groupSameValuesAndOrderByValue(List<Card> cards) {
        Comparator<Map.Entry<Card.CardValue, Long>> compareByCount = Comparator.comparingLong(Map.Entry::getValue);
        Comparator<Map.Entry<Card.CardValue, Long>> compareByValue = Comparator.comparing(Map.Entry::getKey);

        return cards.stream().map(Card::getValue)
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream()
                .sorted(compareByCount.reversed().thenComparing(compareByValue.reversed()))
                .map(Map.Entry::getKey)
                .collect(toList());

    }
}
