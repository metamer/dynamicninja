package com.item;

import java.util.ArrayList;

import com.effect.Effect;
import com.entity.BodyPart;

public class Equipment extends Item{

	private ArrayList<Effect> effects;
	private BodyPart slot;
	
	public Equipment(String name, double weight, BodyPart slot) {
		super(name, true, weight);
		this.slot = slot;
	}
	
}
