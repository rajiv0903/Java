package com.practice.java.designpattern.org.learning.pattern._05_command.undoremote.entry;

import com.practice.java.designpattern.org.learning.pattern._05_command.undoremote.command.CeilingFanHighCommand;
import com.practice.java.designpattern.org.learning.pattern._05_command.undoremote.command.CeilingFanMediumCommand;
import com.practice.java.designpattern.org.learning.pattern._05_command.undoremote.command.CeilingFanOffCommand;
import com.practice.java.designpattern.org.learning.pattern._05_command.undoremote.command.LightOffCommand;
import com.practice.java.designpattern.org.learning.pattern._05_command.undoremote.command.LightOnCommand;
import com.practice.java.designpattern.org.learning.pattern._05_command.undoremote.invoker.RemoteControlWithUndo;
import com.practice.java.designpattern.org.learning.pattern._05_command.undoremote.receiver.CeilingFan;
import com.practice.java.designpattern.org.learning.pattern._05_command.undoremote.receiver.Light;

public class RemoteLoader {
 
	public static void main(String[] args) {
		RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
 
		Light livingRoomLight = new Light("Living Room");
 
		LightOnCommand livingRoomLightOn = 
				new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = 
				new LightOffCommand(livingRoomLight);
 
		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
 
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();

		CeilingFan ceilingFan = new CeilingFan("Living Room");
   
		CeilingFanMediumCommand ceilingFanMedium = 
				new CeilingFanMediumCommand(ceilingFan);
		CeilingFanHighCommand ceilingFanHigh = 
				new CeilingFanHighCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = 
				new CeilingFanOffCommand(ceilingFan);
  
		remoteControl.setCommand(0, ceilingFanMedium, ceilingFanOff);
		remoteControl.setCommand(1, ceilingFanHigh, ceilingFanOff);
   
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
  
		remoteControl.onButtonWasPushed(1);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
	}
}
