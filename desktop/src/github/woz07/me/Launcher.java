package github.woz07.me;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import github.woz07.me.Game;

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
}
