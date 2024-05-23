package github.woz07.me;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Game extends ApplicationAdapter {
	private Stage stage;
	private Skin skin;
	SpriteBatch batch;
	
	@Override
	public void create() {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
		
		skin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas(Gdx.files.internal("uiskin.atlas")));
		
		TextButton play = new TextButton("Play", skin);
		TextButton multiplayer = new TextButton("Multiplayer", skin);
		TextButton setting = new TextButton("Setting", skin);
		
		Table table = new Table();
		table.setFillParent(true);
		table.center();
		table.add(play).padBottom(10).row();
		table.add(multiplayer).padBottom(10).row();
		table.add(setting).padBottom(10).row();
		
		stage.addActor(table);
		
		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		
//		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
//		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}
	
	@Override
	public void dispose() {
		stage.dispose();
		skin.dispose();
		
		batch.dispose();
//		img.dispose();
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
			return reader.readLine(); // Could be null / empty but that must be dealt with by function which calls this
		} catch (IOException e) {
			System.err.println("Failure to read data/temp.txt file as path is incorrect");
			e.printStackTrace();
			
			return null;
		}
	}
}
