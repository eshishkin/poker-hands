package org.eshishkin.pokerservice.model.calculator;

import java.util.Arrays;
import java.util.List;
import org.eshishkin.pokerservice.model.Card;

public class DefaultPokerHandEvaluator  implements HandEvaluator {
    private static final List<HandEvaluator> EVALUATORS = Arrays.asList(
            new StraightFlushEvaluator(),
            new FourOfKindEvaluator(),
            new FullHouseEvaluator(),
            new FlushEvaluator(),
            new StraightEvaluator(),
            new ThreeOfKindEvaluator(),
            new TwoPairsEvaluator(),
            new OnePairEvaluator(),
            new HighCardEvaluator()
    );

    @Override
    public Hand evaluate(List<Card> cards) {
        Hand hand = null;

        for (HandEvaluator evaluator : EVALUATORS) {
            hand = evaluator.evaluate(cards);

            if (hand != null) {
                break;
            }
        }

        return hand;
    }
}
