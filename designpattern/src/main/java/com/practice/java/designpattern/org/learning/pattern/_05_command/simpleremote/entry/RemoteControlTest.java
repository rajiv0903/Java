package com.practice.java.designpattern.org.learning.pattern._05_command.simpleremote.entry;

import com.practice.java.designpattern.org.learning.pattern._05_command.simpleremote.command.GarageDoorOpenCommand;
import com.practice.java.designpattern.org.learning.pattern._05_command.simpleremote.command.LightOnCommand;
import com.practice.java.designpattern.org.learning.pattern._05_command.simpleremote.invoker.SimpleRemoteControl;
import com.practice.java.designpattern.org.learning.pattern._05_command.simpleremote.receiver.GarageDoor;
import com.practice.java.designpattern.org.learning.pattern._05_command.simpleremote.receiver.Light;

public class RemoteControlTest {
	public static void main(String[] args) {
		SimpleRemoteControl remote = new SimpleRemoteControl();
		Light light = new Light();
		GarageDoor garageDoor = new GarageDoor();
		LightOnCommand lightOn = new LightOnCommand(light);
		GarageDoorOpenCommand garageOpen = 
		    new GarageDoorOpenCommand(garageDoor);
 
		remote.setCommand(lightOn);
		remote.buttonWasPressed();
		remote.setCommand(garageOpen);
		remote.buttonWasPressed();
    }
}
