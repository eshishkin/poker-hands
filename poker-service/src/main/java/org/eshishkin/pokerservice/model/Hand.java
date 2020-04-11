package org.eshishkin.pokerservice.model;

import java.util.Collections;
import java.util.List;

public class Hand {

    private final Rank rank;
    private final List<Card> cards;

    private Hand(Rank rank, List<Card> cards) {
        this.rank = rank;
        this.cards = cards;
    }

    public static Hand straightFlush(List<Card> cards) {
        return new Hand(Rank.STRAIGHT_FLUSH, cards);
    }

    public static Hand fourOfKind(List<Card> cards) {
        return new Hand(Rank.FOUR_OF_KIND, cards);
    }

    public static Hand fullHouse(List<Card> cards) {
        return new Hand(Rank.FULL_HOUSE, cards);
    }

    public static Hand flush(List<Card> cards) {
        return new Hand(Rank.FLUSH, cards);
    }

    public static Hand straight(List<Card> cards) {
        return new Hand(Rank.STRAIGHT, cards);
    }

    public static Hand threeOfKind(List<Card> cards) {
        return new Hand(Rank.THREE_OF_KIND, cards);
    }

    public static Hand twoPairs(List<Card> cards) {
        return new Hand(Rank.TWO_PAIRS, cards);
    }

    public static Hand onePair(List<Card> cards) {
        return new Hand(Rank.ONE_PAIR, cards);
    }

    public static Hand highCard(List<Card> cards) {
        return new Hand(Rank.HIGH_CARD, cards);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public Rank getRank() {
        return rank;
    }

    public enum Rank {
        HIGH_CARD, ONE_PAIR, TWO_PAIRS, THREE_OF_KIND,
        STRAIGHT, FLUSH, FULL_HOUSE,
        FOUR_OF_KIND, STRAIGHT_FLUSH
    }
}
