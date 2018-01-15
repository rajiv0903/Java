package com.practice.java.designpattern.org.learning.pattern._05_command.remote.command;

import com.practice.java.designpattern.org.learning.pattern._05_command.remote.receiver.GarageDoor;

public class GarageDoorDownCommand implements Command {
	GarageDoor garageDoor;

	public GarageDoorDownCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	public void execute() {
		garageDoor.up();
	}
}
