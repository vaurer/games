package at.va.games.firstGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class CannonBall implements Actor {
    private float speed;

    public CannonBall(float x, float y) {
        this.x = x;
        this.y = y;
    }

    private float x,y;


    @Override
    public void render(Graphics graphics) {

        graphics.fillOval(this.x, this.y, 10, 10);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        this.y = this.y -2;
    }

}
