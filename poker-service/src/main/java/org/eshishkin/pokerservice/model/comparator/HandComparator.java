package org.eshishkin.pokerservice.model.comparator;

import java.io.Serializable;
import java.util.Comparator;
import org.eshishkin.pokerservice.model.Hand;

@FunctionalInterface
public interface HandComparator extends Comparator<Hand>, Serializable {
}
