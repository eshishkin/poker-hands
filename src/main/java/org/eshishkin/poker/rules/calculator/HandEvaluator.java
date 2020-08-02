package org.eshishkin.poker.rules.calculator;

import java.util.List;

import org.eshishkin.poker.model.Card;

public interface HandEvaluator {

    Hand evaluate(List<Card> cards);
}
