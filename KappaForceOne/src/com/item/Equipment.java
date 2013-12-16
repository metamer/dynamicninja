package com.item;

import java.util.ArrayList;

import com.entity.BodyPart;
import com.entity.Effect;

public class Equipment extends Item{

	private ArrayList<Effect> effects;
	private BodyPart slot;
	
	public Equipment(String name, boolean wearable, double weight, BodyPart slot) {
		super(name, wearable, weight);
	}
	
	

}
