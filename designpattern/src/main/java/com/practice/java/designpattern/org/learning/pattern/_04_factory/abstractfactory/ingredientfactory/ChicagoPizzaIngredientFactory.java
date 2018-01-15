package com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredientfactory;

import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.cheese.Cheese;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.cheese.MozzarellaCheese;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.clams.Clams;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.clams.FrozenClams;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.dough.Dough;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.dough.ThickCrustDough;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.pepperoni.Pepperoni;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.pepperoni.SlicedPepperoni;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.sauce.PlumTomatoSauce;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.sauce.Sauce;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.veggies.BlackOlives;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.veggies.Eggplant;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.veggies.Spinach;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.veggies.Veggies;

public class ChicagoPizzaIngredientFactory 
	implements PizzaIngredientFactory 
{

	public Dough createDough() {
		return new ThickCrustDough();
	}

	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = { new BlackOlives(), 
		                      new Spinach(), 
		                      new Eggplant() };
		return veggies;
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FrozenClams();
	}
}
