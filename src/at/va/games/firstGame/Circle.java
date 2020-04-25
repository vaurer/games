package at.va.games.firstGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Circle implements Actor {
    private float x, y, speed;
    private int diameter;

    public Circle() {
        Random random = new Random();
        this.x = random.nextInt(1920);
        this.y = random.nextInt(1080);
        this.speed = random.nextInt(40) + 10;
        this.diameter = random.nextInt(20) + 20;
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
        if (this.diameter > 600) {
            this.diameter = 1;
        }
    }

    public void update(int delta) {
        this.y += (float) delta / this.speed;
        if (this.y > 1080) {
            this.y = 0;
        }
    }
}
