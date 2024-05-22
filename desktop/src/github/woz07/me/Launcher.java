package github.woz07.me;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import github.woz07.me.Game;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class Launcher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Multiplayer Experimental");
		new Lwjgl3Application(new Game(), config);
	}
}
