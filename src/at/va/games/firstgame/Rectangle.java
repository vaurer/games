package at.va.games.firstgame;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Rectangle {
    private enum DIRECTION {RIGHT, DOWN, LEFT, UP}

    ;
    private float x;
    private float y;
    private float speed;

    public Rectangle(int x, int y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, 10,10);
        graphics.setColor(Color.red);
    }

    public void update(int delta) {
        this.x += (float) delta / this.speed;
        if (this.x > 1920) {
            this.x = 0;
        }
    }
}
