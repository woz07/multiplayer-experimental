package github.woz07.me;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player {
    int speed;
    Texture image;
    Vector2 position;
    public Player(int speed, Texture image, Vector2 position) {
        this.speed = speed;
        this.image = image;
        this.position = position;
    }
    
    public void move(float delta, int dx, int dy) {
        position.x += getSpeed() * delta * dx;
        position.y += getSpeed() * delta * dy;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public Texture getImage() {
        return image;
    }
    
    public Vector2 getPosition() {
        return position;
    }
}
