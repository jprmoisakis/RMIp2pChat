package serv;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IService extends Remote {
	
	void send(String msg) throws RemoteException;

}
