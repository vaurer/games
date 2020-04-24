package at.va.games.firstgame;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.awt.*;
import java.util.Random;

public class Circle  {
    private float x,y, speed;
    private int diameter;

    public Circle() {
        Random random = new Random();
        this.x = random.nextInt(1920);
        this.y = random.nextInt(1080);
        this.speed = random.nextInt(40)+10;
        this.diameter = random.nextInt(20)+20;
    }

    public void render(Graphics graphics) {

        graphics.drawOval(this.x, this.y, this.diameter,this.diameter);
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColor = new Color(r, g, b);
        graphics.setColor(randomColor);
    }

    public void update(int delta) {
        this.y += (float) delta / this.speed;
        if (this.y > 1080) {
            this.y = 0;
        }
    }
}
