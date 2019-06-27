package com.rmi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiInterfaceImpl extends UnicastRemoteObject implements RmiInterface {

    /**
     * Creates and exports a new UnicastRemoteObject object using an
     * anonymous port.
     *
     * <p>The object is exported with a server socket
     * created using the {@link } class.
     *
     * @throws RemoteException if failed to export object
     * @since JDK1.1
     */
    protected RmiInterfaceImpl() throws RemoteException {
        super();
    }


    @Override
    public String getString(String text) throws RemoteException {
        return "hello -> " + text;
    }

    @Override
    public void writeFile(byte[] data) throws RemoteException {
        try {
            FileOutputStream outputStream = new FileOutputStream(new File("E:/1.jpg"));
            outputStream.write(data);
            outputStream.flush();
            System.out.println("写成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
