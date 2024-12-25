package Utils;

import java.io.IOException;

public class CommandBuilder {

    public static void runCommand(String command) {
        try {
            // Create a ProcessBuilder instance
            ProcessBuilder processBuilder = new ProcessBuilder();

            // Split the command into parts (if necessary) for ProcessBuilder
            processBuilder.command("cmd.exe", "/c", command);

            // Start the process
            Process process = processBuilder.start();

            // Wait for the process to complete
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            System.err.println("Error while executing command: " + e.getMessage());
        }
    }
}
