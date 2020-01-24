package com.telnet;

import com.taobao.arthas.client.IOUtil;
import jline.console.ConsoleReader;
import org.apache.commons.net.telnet.InvalidTelnetOptionException;
import org.apache.commons.net.telnet.TelnetClient;
import org.apache.commons.net.telnet.TelnetOptionHandler;
import org.apache.commons.net.telnet.WindowSizeOptionHandler;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Wentworth .
 * @date 2019/12/2 11:18 上午
 */
public class TelnetDemo {
    public static void main(String[] args) throws IOException {
        String hostname = "localhost";
        int port = 8765;
        TelnetClient telnet = new TelnetClient();
        ConsoleReader consoleReader = new ConsoleReader(System.in, System.out);
        TelnetOptionHandler sizeOpt = new WindowSizeOptionHandler(50, 100, true, true, false, false);
        try {
            telnet.addOptionHandler(sizeOpt);
        } catch (InvalidTelnetOptionException e) {
            // ignore
        }
        try {
            telnet.connect(hostname, port);
        } catch (IOException e) {
            System.out.println("Connect to telnet server error: " + hostname + " " + port);
            throw e;
        }

        IOUtil.readWrite(telnet.getInputStream(), telnet.getOutputStream(), System.in, consoleReader.getOutput());
        System.out.println("Connect to telnet server successful: " + hostname + " " + port);
    }
}
