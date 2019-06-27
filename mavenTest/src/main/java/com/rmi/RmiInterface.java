package com.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiInterface extends Remote {
    String getString(String text)throws RemoteException;

    void writeFile(byte[] data)throws RemoteException;

}
