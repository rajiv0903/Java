package com.practice.java.designpattern.org.learning.pattern.templatemethod.barista.entry;

import com.practice.java.designpattern.headfirst.templatemethod.barista.Coffee;
import com.practice.java.designpattern.headfirst.templatemethod.barista.CoffeeWithHook;
import com.practice.java.designpattern.headfirst.templatemethod.barista.Tea;
import com.practice.java.designpattern.headfirst.templatemethod.barista.TeaWithHook;

public class BeverageTestDrive {
	public static void main(String[] args) {
 
		Tea tea = new Tea();
		Coffee coffee = new Coffee();
 
		System.out.println("\nMaking tea...");
		tea.prepareRecipe();
 
		System.out.println("\nMaking coffee...");
		coffee.prepareRecipe();

 
		TeaWithHook teaHook = new TeaWithHook();
		CoffeeWithHook coffeeHook = new CoffeeWithHook();
 
		System.out.println("\nMaking tea...");
		teaHook.prepareRecipe();
 
		System.out.println("\nMaking coffee...");
		coffeeHook.prepareRecipe();
	}
}
