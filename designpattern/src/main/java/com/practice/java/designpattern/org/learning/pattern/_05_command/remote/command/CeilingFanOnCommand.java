package com.practice.java.designpattern.org.learning.pattern._05_command.remote.command;

import com.practice.java.designpattern.org.learning.pattern._05_command.remote.receiver.CeilingFan;

public class CeilingFanOnCommand implements Command {
	CeilingFan ceilingFan;

	public CeilingFanOnCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}
	public void execute() {
		ceilingFan.high();
	}
}
