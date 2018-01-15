package com.practice.java.designpattern.org.learning.pattern.proxy.gumball.remote;

import java.rmi.*;
import  com.practice.java.designpattern.org.learning.pattern.proxy.gumball.state.State;
 
public interface GumballMachineRemote extends Remote {
	public int getCount() throws RemoteException;
	public String getLocation() throws RemoteException;
	public State getState() throws RemoteException;
}
