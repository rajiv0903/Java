package com.practice.java.designpattern.org.learning.pattern._05_command.macroremote.command;

import com.practice.java.designpattern.org.learning.pattern._05_command.macroremote.receiver.TV;

public class TVOffCommand implements Command {
	TV tv;

	public TVOffCommand(TV tv) {
		this.tv= tv;
	}

	public void execute() {
		tv.off();
	}

	public void undo() {
		tv.on();
	}
}
