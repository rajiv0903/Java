package com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredientfactory;

import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.cheese.Cheese;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.cheese.ReggianoCheese;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.clams.Clams;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.clams.FreshClams;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.dough.Dough;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.dough.ThinCrustDough;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.pepperoni.Pepperoni;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.pepperoni.SlicedPepperoni;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.sauce.MarinaraSauce;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.sauce.Sauce;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.veggies.Garlic;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.veggies.Mushroom;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.veggies.Onion;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.veggies.RedPepper;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.veggies.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
 
	public Dough createDough() {
		return new ThinCrustDough();
	}
 
	public Sauce createSauce() {
		return new MarinaraSauce();
	}
 
	public Cheese createCheese() {
		return new ReggianoCheese();
	}
 
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}
 
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}
}
