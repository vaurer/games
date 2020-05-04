package at.va.games.skyFight.flyingObjects;

import at.va.games.skyFight.actors.Actor;
import at.va.games.skyFight.actors.CollisionActor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class Rocket implements CollisionActor {

    private float x, y, speed;
    private Image rocketImage;
    private Shape collisionShape;

    public Rocket() throws SlickException {
        Random random = new Random();
        Image temp = new Image("testdata/rocket.png");
        this.rocketImage = temp.getFlippedCopy(false, true);
        this.speed = random.nextInt(6) + 2;
        this.x = random.nextInt(1700) + 100;
        this.y = 0;
        this.collisionShape = new org.newdawn.slick.geom.Rectangle(this.x, this.y, rocketImage.getWidth(), rocketImage.getHeight());
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        rocketImage.draw(this.x, this.y);
        graphics.draw(this.collisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        this.y += (float) delta / this.speed;
        if (this.y > 1080) {
            this.rocketImage.destroy();
        }
        this.collisionShape.setCenterX(this.x + 15);
        this.collisionShape.setCenterY(this.y + 25);
    }

    @Override
    public Shape getShape() {
        return collisionShape;
    }


    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
