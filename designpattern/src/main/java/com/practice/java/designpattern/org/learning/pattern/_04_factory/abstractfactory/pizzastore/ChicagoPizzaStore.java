package com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.pizzastore;

import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredientfactory.ChicagoPizzaIngredientFactory;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.ingredientfactory.PizzaIngredientFactory;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.pizzas.CheesePizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.pizzas.ClamPizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.pizzas.PepperoniPizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.pizzas.Pizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.pizzas.VeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory =
		new ChicagoPizzaIngredientFactory();

		if (item.equals("cheese")) {

			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Chicago Style Cheese Pizza");

		} else if (item.equals("veggie")) {

			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("Chicago Style Veggie Pizza");

		} else if (item.equals("clam")) {

			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("Chicago Style Clam Pizza");

		} else if (item.equals("pepperoni")) {

			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("Chicago Style Pepperoni Pizza");

		}
		return pizza;
	}
}
