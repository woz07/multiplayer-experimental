package github.woz07.me;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import github.woz07.me.Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class Launcher {
	public static void main(String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Multiplayer Experimental");
		new Lwjgl3Application(new Game(), config);
	}
	
	/**
	 * Method to execute python scripts
	 * @param path The path where the script is stored at
	 * @return The return code
	 */
	public static int execute(String path) {
		Process process;
		try {
			final String[] command = {"python", path};
			ProcessBuilder builder = new ProcessBuilder(command);
			process = builder.start();
			int exit = process.waitFor();
			process.destroy();
			
			return exit;
		} catch (IOException | InterruptedException e) {
			System.err.println("Failure to execute file: " + path);
			e.printStackTrace();
			
			return -1;
		}
	}
	
	/**
	 * Method to read data from data/temp.txt
	 * @return The data read from temp.txt
	 */
	public static String read() {
		try (BufferedReader reader = new BufferedReader((new FileReader("data/temp.txt")))) {
			// As file only contains 1 line data there's no need for while loop to loop through entire file
			return reader.readLine(); // Could be null
		} catch (IOException e) {
			System.err.println("Failure to read data/temp.txt file as path is incorrect");
			e.printStackTrace();
			
			return null;
		}
	}
}
