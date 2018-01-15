package com.practice.java.designpattern.org.learning.pattern._05_command.simpleremote.command;

import com.practice.java.designpattern.org.learning.pattern._05_command.simpleremote.receiver.GarageDoor;

public class GarageDoorOpenCommand implements Command {
	GarageDoor garageDoor;

	public GarageDoorOpenCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	public void execute() {
		garageDoor.up();
	}
}
