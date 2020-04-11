package org.eshishkin.pokerservice.model.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Map;
import org.eshishkin.pokerservice.model.Hand;
import static org.eshishkin.pokerservice.model.Hand.Rank.FLUSH;
import static org.eshishkin.pokerservice.model.Hand.Rank.FOUR_OF_KIND;
import static org.eshishkin.pokerservice.model.Hand.Rank.FULL_HOUSE;
import static org.eshishkin.pokerservice.model.Hand.Rank.HIGH_CARD;
import static org.eshishkin.pokerservice.model.Hand.Rank.ONE_PAIR;
import static org.eshishkin.pokerservice.model.Hand.Rank.STRAIGHT;
import static org.eshishkin.pokerservice.model.Hand.Rank.STRAIGHT_FLUSH;
import static org.eshishkin.pokerservice.model.Hand.Rank.THREE_OF_KIND;
import static org.eshishkin.pokerservice.model.Hand.Rank.TWO_PAIRS;

public class DefaultPokerHandComparator implements HandComparator {
    private static final Comparator<Hand> BY_RANK_COMPARATOR =
            Comparator.comparing(Hand::getRank);

    private static final Map<Hand.Rank, HandComparator> HAND_COMPARATORS;

    static {
        Map<Hand.Rank, HandComparator> map = new EnumMap<>(Hand.Rank.class);

        map.put(STRAIGHT_FLUSH, new StraightComparator());
        map.put(FOUR_OF_KIND, new FourOfKindComparator());
        map.put(FULL_HOUSE, new FullHouseComparator());
        map.put(FLUSH, new FlushComparator());
        map.put(STRAIGHT, new StraightComparator());
        map.put(THREE_OF_KIND, new ThreeOfKindComparator());
        map.put(TWO_PAIRS, new TwoPairsComparator());
        map.put(ONE_PAIR, new OnePairComparator());
        map.put(HIGH_CARD, new HighCardComparator());


        HAND_COMPARATORS = Collections.unmodifiableMap(map);
    }

    @Override
    public int compare(Hand o1, Hand o2) {
        if (o1 == null) {
            throw new NullPointerException("first argument is null");
        }

        if (o2 == null) {
            throw new NullPointerException("second argument is null");
        }

        return BY_RANK_COMPARATOR
                .thenComparing(HAND_COMPARATORS.get(o1.getRank()))
                .compare(o1, o2);
    }
}
