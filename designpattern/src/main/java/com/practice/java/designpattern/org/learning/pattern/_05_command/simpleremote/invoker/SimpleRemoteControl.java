package com.practice.java.designpattern.org.learning.pattern._05_command.simpleremote.invoker;

import com.practice.java.designpattern.org.learning.pattern._05_command.simpleremote.command.Command;

//
// This is the invoker
//
public class SimpleRemoteControl {
	Command slot;
 
	public SimpleRemoteControl() {}
 
	public void setCommand(Command command) {
		slot = command;
	}
 
	public void buttonWasPressed() {
		slot.execute();
	}
}
