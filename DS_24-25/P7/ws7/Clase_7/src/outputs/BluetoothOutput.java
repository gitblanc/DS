package outputs;

import java.io.*;

import files.Output;

public class BluetoothOutput implements Output {
    public BluetoothOutput(String device) {
        stringWriter = new StringWriter();
        stringWriter.append("\n--- START Bluetooth[" + device + "]\n");
    }

    public void send(char c) throws IOException {
        stringWriter.append(c);
    }

    public void close() throws IOException {
        System.out.print(stringWriter.toString());
        System.out.println("--- END   Bluetooth");
    }

    private StringWriter stringWriter;
}
