package at.va.games.firstGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Ellipse implements Actor {
    private float x, y, speed;
    private float width, height;
    private int diameter;

    public Ellipse() {
        Random random = new Random();
        this.x = random.nextInt(1920);
        this.y = random.nextInt(1080);
        this.width = random.nextInt(60) + 10;
        this.height = this.width / 2;
        this.speed = random.nextInt(100);

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.width, this.height);
        graphics.setColor(Color.yellow);

    }

    @Override
    public void update(int delta) {
        this.y -= (float) delta / this.speed;
        if (this.y < 0) {
            this.y = 1080;
        }
    }
}
