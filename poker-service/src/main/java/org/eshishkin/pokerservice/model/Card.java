package org.eshishkin.pokerservice.model;

public enum Card {
    HEART_ACE(CardValue.ACE, Suite.HEART),
    HEART_KING(CardValue.KING, Suite.HEART),
    HEART_QUEEN(CardValue.QUEEN, Suite.HEART),
    HEART_JACK(CardValue.JACK, Suite.HEART),
    HEART_TEN(CardValue.TEN, Suite.HEART),
    HEART_NINE(CardValue.NINE, Suite.HEART),
    HEART_EIGHT(CardValue.EIGHT, Suite.HEART),
    HEART_SEVEN(CardValue.SEVEN, Suite.HEART),
    HEART_SIX(CardValue.SIX, Suite.HEART),
    HEART_FIVE(CardValue.FIVE, Suite.HEART),
    HEART_FOUR(CardValue.FOUR, Suite.HEART),
    HEART_THREE(CardValue.THREE, Suite.HEART),
    HEART_TWO(CardValue.TWO, Suite.HEART),


    DIAMOND_ACE(CardValue.ACE, Suite.DIAMOND),
    DIAMOND_KING(CardValue.KING, Suite.DIAMOND),
    DIAMOND_QUEEN(CardValue.QUEEN, Suite.DIAMOND),
    DIAMOND_JACK(CardValue.JACK, Suite.DIAMOND),
    DIAMOND_TEN(CardValue.TEN, Suite.DIAMOND),
    DIAMOND_NINE(CardValue.NINE, Suite.DIAMOND),
    DIAMOND_EIGHT(CardValue.EIGHT, Suite.DIAMOND),
    DIAMOND_SEVEN(CardValue.SEVEN, Suite.DIAMOND),
    DIAMOND_SIX(CardValue.SIX, Suite.DIAMOND),
    DIAMOND_FIVE(CardValue.FIVE, Suite.DIAMOND),
    DIAMOND_FOUR(CardValue.FOUR, Suite.DIAMOND),
    DIAMOND_THREE(CardValue.THREE, Suite.DIAMOND),
    DIAMOND_TWO(CardValue.TWO, Suite.DIAMOND),


    SPADE_ACE(CardValue.ACE, Suite.SPADE),
    SPADE_KING(CardValue.KING, Suite.SPADE),
    SPADE_QUEEN(CardValue.QUEEN, Suite.SPADE),
    SPADE_JACK(CardValue.JACK, Suite.SPADE),
    SPADE_TEN(CardValue.TEN, Suite.SPADE),
    SPADE_NINE(CardValue.NINE, Suite.SPADE),
    SPADE_EIGHT(CardValue.EIGHT, Suite.SPADE),
    SPADE_SEVEN(CardValue.SEVEN, Suite.SPADE),
    SPADE_SIX(CardValue.SIX, Suite.SPADE),
    SPADE_FIVE(CardValue.FIVE, Suite.SPADE),
    SPADE_FOUR(CardValue.FOUR, Suite.SPADE),
    SPADE_THREE(CardValue.THREE, Suite.SPADE),
    SPADE_TWO(CardValue.TWO, Suite.SPADE),


    CLUB_ACE(CardValue.ACE, Suite.CLUB),
    CLUB_KING(CardValue.KING, Suite.CLUB),
    CLUB_QUEEN(CardValue.QUEEN, Suite.CLUB),
    CLUB_JACK(CardValue.JACK, Suite.CLUB),
    CLUB_TEN(CardValue.TEN, Suite.CLUB),
    CLUB_NINE(CardValue.NINE, Suite.CLUB),
    CLUB_EIGHT(CardValue.EIGHT, Suite.CLUB),
    CLUB_SEVEN(CardValue.SEVEN, Suite.CLUB),
    CLUB_SIX(CardValue.SIX, Suite.CLUB),
    CLUB_FIVE(CardValue.FIVE, Suite.CLUB),
    CLUB_FOUR(CardValue.FOUR, Suite.CLUB),
    CLUB_THREE(CardValue.THREE, Suite.CLUB),
    CLUB_TWO(CardValue.TWO, Suite.CLUB);

    private CardValue value;
    private Suite suite;

    Card(CardValue value, Suite suite) {
        this.value = value;
        this.suite = suite;
    }

    public CardValue getValue() {
        return value;
    }

    public Suite getSuite() {
        return suite;
    }

    public enum Suite {
        HEART, DIAMOND, SPADE, CLUB
    }

    public enum CardValue {
        DUMMY, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
        JACK, QUEEN, KING, ACE
    }
}
