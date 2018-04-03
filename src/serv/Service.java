package serv;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Service extends UnicastRemoteObject implements IService {

	protected Service() throws RemoteException {
		super();
		
	}

	public void send(String msg) {
		System.out.println("User: " + msg);
		
	}
 

}
