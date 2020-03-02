
package encryptdecrypt;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

abstract class Crypt {

    protected Options options;
    protected String message;
    protected String processedMessage;

    public Crypt(Options options) {
        this.options = options;
    }

    public void work() {
        readMessage();
        switch (options.getMode()) {
            case "enc":
                encrypt();
                break;
            case "dec":
                decrypt();
                break;
        }
        writeMessage();
    }

    private void writeMessage() {
        if (options.getOutputFileName().isEmpty()) {
            System.out.println(processedMessage);
        } else {
            writeFileFromString(options.getOutputFileName(), processedMessage);
        }
    }

    private void readMessage() {
        if (options.getData().isEmpty() && !options.getInputFileName().isEmpty()) {
            try {
                message = readFileAsString(options.getInputFileName());
            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        } else {
            message = options.getData();
        }
        processedMessage = message;
    }

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void writeFileFromString(String fileName, String text) {
        File file = new File(fileName);
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.write(text);
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    abstract void encrypt();

    abstract void decrypt();

}