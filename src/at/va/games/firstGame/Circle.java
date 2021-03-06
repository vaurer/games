package at.va.games.firstGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class Circle implements Actor {
    private float x, y, speed;
    private int diameter;
    private Shape collisionShape;

    public Circle() {
        Random random = new Random();
        this.x = random.nextInt(1920);
        this.y = random.nextInt(1080);
        this.speed = random.nextInt(40) + 10;
        this.diameter = random.nextInt(20) + 20;
        this.collisionShape  = new org.newdawn.slick.geom.Circle(this.x,this.y, this.diameter/2);
    }

    public void render(Graphics graphics) {

        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);
        Random random = new Random();
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        Color randomColor = new Color(r, g, b);
        graphics.setColor(randomColor);
        this.diameter++;
        if (this.diameter > 30) {
            this.diameter = 1;
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.y += (float) delta / this.speed;
        if (this.y > 1080) {
            this.y = 0;
        }
    }
    public Shape getCircleCollisionShape() {
        return collisionShape;
    }
}
