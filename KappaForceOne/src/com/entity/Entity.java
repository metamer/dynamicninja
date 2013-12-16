package com.entity;

import java.util.ArrayList;

/**
 * Base entity class, anything should inherit from this one.
 * @author Matt
 *
 */
public class Entity {
	private String name;
	// All the statistics that something has.
	private Statistic[] statistics;
	// Size of a thing in terms of a 1 = tile.
	private double size;
	// List of effects that can be iterated through when determining things each turn.
	private ArrayList<Effect> effectList;
	// Symbol to be used to show this entity on the screen
	private char symbol;
	
	

}
