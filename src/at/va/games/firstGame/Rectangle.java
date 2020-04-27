package at.va.games.firstGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Rectangle implements Actor {

    public enum DIRECTION {RIGHT, LEFT}

    private float x;
    private float y;
    private float speed;
    private DIRECTION direction;

    public Rectangle(int x, int y, float speed, DIRECTION direction) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
    }
    public Rectangle(float x, float y, float speed) {
    }

    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, 10, 10);
        graphics.setColor(Color.magenta);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

    }

    public void update(int delta) {
        if (this.direction == DIRECTION.RIGHT) {
            this.x += (float) delta / this.speed;
            if (this.x > 1920) {
                this.x = 0;
            }
        } else if (this.direction == DIRECTION.LEFT) {
            this.x -= (float) delta / this.speed;
            if (this.x < 0) {
                this.x = 1920;
            }
        }
    }
}


