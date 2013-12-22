package com.engine.effect;

import com.engine.entity.Statistic;

/**
 * Base class for any effect that can occur to an entity, such as a buff or
 * debuff.
 * 
 * @author Matt
 * 
 */
public class Effect {
  // the affected statistics.
  private Statistic[] changedStatistics;
  // the duration of the effect.
  private long duration;
  // the change in the statistic values.
  private double[] valueChange;

}
