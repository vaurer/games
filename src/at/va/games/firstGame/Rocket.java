package at.va.games.firstGame;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;

import java.awt.*;
import java.util.Random;

public class Rocket implements Actor {
    private Image rocketImage;
    private float speed;
    private float x, y;
    private Shape collisionShape;


    public Rocket() throws SlickException {
        Random random = new Random();
        Image temp = new Image("testdata/wallpaper/rocket.png");
        this.rocketImage = temp.getFlippedCopy(false, random.nextBoolean());
        this.rocketImage = temp.getScaledCopy(100, 250);
        this.speed = 5;
        this.x = random.nextInt(1700)+100;
        this.y = 900;
        this.collisionShape = new org.newdawn.slick.geom.Rectangle(this.x, this.y, rocketImage.getWidth(), rocketImage.getHeight());
    }

    @Override
    public void render(Graphics graphics) {
        rocketImage.draw(this.x, this.y);
        graphics.draw(this.collisionShape);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        this.y -= (float) delta / this.speed;
        if (this.y < 0) {
            this.y = 1080;
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)){
            this.x++;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)){
            this.x--;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_UP)){
            this.y--;
        }else if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)){
            this.y = this.y+2;
        }

        this.collisionShape.setCenterX(this.x+50);
        this.collisionShape.setCenterY(this.y+125);
    }
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }


}
