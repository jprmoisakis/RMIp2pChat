package serv;

import java.nio.channels.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Server {
    
	public static void main(String[] args) throws RemoteException, AlreadyBoundException, java.rmi.AlreadyBoundException, InterruptedException, NotBoundException {
        Scanner in = new Scanner(System.in);
		
		Service service = new Service();
        Registry registry = LocateRegistry.createRegistry(8001);
        registry.bind("chat", service);
	 	
        String msg = in.nextLine();

        Registry registryClient = LocateRegistry.getRegistry("127.0.0.1", 8002);
	    IService serviceClient = (IService) registryClient.lookup("chat");
	    while(true) {
	    	 	serviceClient.send(msg);
	    	 	msg = in.nextLine();
	   }
	}
}

