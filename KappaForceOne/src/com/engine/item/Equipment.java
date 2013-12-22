package com.engine.item;

import java.util.ArrayList;

import com.engine.effect.Effect;
import com.engine.entity.BodyPart;

public class Equipment extends Item{

	private ArrayList<Effect> effects;
	private BodyPart slot;
	
	public Equipment(String name, double weight, BodyPart slot) {
		super(name, true, weight);
		this.slot = slot;
	}
	
}
