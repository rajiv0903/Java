package com.practice.java.designpattern.org.learning.pattern._05_command.simpleremote.command;

import com.practice.java.designpattern.org.learning.pattern._05_command.simpleremote.receiver.Light;

public class LightOffCommand implements Command {
	Light light;
 
	public LightOffCommand(Light light) {
		this.light = light;
	}
 
	public void execute() {
		light.off();
	}
}
