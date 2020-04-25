package at.va.games.Snowflakes;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Snowflake implements Actor {
    // private Random random;

    public enum SIZE {BIG, MEDIUM, SMALL}

    private int size;
    private float speed;
    private float x;
    private float y;

    public Snowflake(SIZE size) {
        Random random = new Random();
        if (size == SIZE.BIG) {
            this.size = 12;
            this.speed = 2;
        }
        if (size == SIZE.MEDIUM) {
            this.size = 8;
            this.speed = 5;
        }
        if (size == SIZE.SMALL) {
            this.size = 4;
            this.speed = 10;
        }
        setRandomPosition();
    }

    private void setRandomPosition() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600) - 600;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y, this.size, this.size);
        if (this.speed == 5) {
            graphics.setColor(Color.gray);
        } else  if (this.speed == 4){
            graphics.setColor(Color.darkGray);
        } else  if (this.speed == 2){
            graphics.setColor(Color.white);
        }
    }

    @Override
    public void update(int delta) {
        this.y += (float) delta / this.speed;
        if (this.y > 600) {
            setRandomPosition();
        }
    }


}
