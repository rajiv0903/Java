package com.practice.java.designpattern.org.learning.pattern._05_command.macroremote.command;

import com.practice.java.designpattern.org.learning.pattern._05_command.macroremote.receiver.Stereo;

public class StereoOnCommand implements Command {
	Stereo stereo;

	public StereoOnCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	public void execute() {
		stereo.on();
	}

	public void undo() {
		stereo.off();
	}
}
