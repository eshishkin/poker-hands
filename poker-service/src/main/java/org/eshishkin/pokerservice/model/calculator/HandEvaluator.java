package org.eshishkin.pokerservice.model.calculator;

import java.util.List;
import org.eshishkin.pokerservice.model.Card;

public interface HandEvaluator {

    Hand evaluate(List<Card> cards);
}
