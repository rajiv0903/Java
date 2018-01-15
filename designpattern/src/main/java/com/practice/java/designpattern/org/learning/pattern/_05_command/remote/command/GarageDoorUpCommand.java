package com.practice.java.designpattern.org.learning.pattern._05_command.remote.command;

import com.practice.java.designpattern.org.learning.pattern._05_command.remote.receiver.GarageDoor;

public class GarageDoorUpCommand implements Command {
	GarageDoor garageDoor;

	public GarageDoorUpCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	public void execute() {
		garageDoor.up();
	}
}
