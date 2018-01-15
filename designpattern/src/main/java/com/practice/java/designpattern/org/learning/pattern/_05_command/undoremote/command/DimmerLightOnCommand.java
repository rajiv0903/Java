package com.practice.java.designpattern.org.learning.pattern._05_command.undoremote.command;

import com.practice.java.designpattern.org.learning.pattern._05_command.undoremote.receiver.Light;

public class DimmerLightOnCommand implements Command {
	Light light;
	int prevLevel;

	public DimmerLightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		prevLevel = light.getLevel();
		light.dim(75);
	}

	public void undo() {
		light.dim(prevLevel);
	}
}
