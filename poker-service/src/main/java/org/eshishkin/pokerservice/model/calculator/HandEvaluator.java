package org.eshishkin.pokerservice.model.calculator;

import java.util.List;
import org.eshishkin.pokerservice.model.Card;
import org.eshishkin.pokerservice.model.Hand;

public interface HandEvaluator {

    Hand evaluate(List<Card> cards);
}
