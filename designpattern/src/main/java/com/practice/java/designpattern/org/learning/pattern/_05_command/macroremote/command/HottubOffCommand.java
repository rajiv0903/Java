package com.practice.java.designpattern.org.learning.pattern._05_command.macroremote.command;

import com.practice.java.designpattern.org.learning.pattern._05_command.macroremote.receiver.Hottub;

public class HottubOffCommand implements Command {
	Hottub hottub;

	public HottubOffCommand(Hottub hottub) {
		this.hottub = hottub;
	}

	public void execute() {
		hottub.setTemperature(98);
		hottub.off();
	}
	public void undo() {
		hottub.on();
	}
}
