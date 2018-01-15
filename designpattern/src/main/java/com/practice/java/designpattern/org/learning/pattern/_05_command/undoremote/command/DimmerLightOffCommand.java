package com.practice.java.designpattern.org.learning.pattern._05_command.undoremote.command;

import com.practice.java.designpattern.org.learning.pattern._05_command.undoremote.receiver.Light;

public class DimmerLightOffCommand implements Command {
	Light light;
	int prevLevel;

	public DimmerLightOffCommand(Light light) {
		this.light = light;
		prevLevel = 100;
	}

	public void execute() {
		prevLevel = light.getLevel();
		light.off();
	}

	public void undo() {
		light.dim(prevLevel);
	}
}
