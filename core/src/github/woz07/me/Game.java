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
}
