package com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredientfactory;

import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.cheese.Cheese;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.clams.Clams;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.dough.Dough;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.pepperoni.Pepperoni;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.sauce.Sauce;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredients.veggies.Veggies;

public interface PizzaIngredientFactory {
 
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
 
}
