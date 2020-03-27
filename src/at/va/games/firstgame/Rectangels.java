package at.va.games.firstgame;

import org.newdawn.slick.*;

public class Rectangels extends BasicGame {

    private float xOval;
    private float yOval;
    private float xCircle;
    private float yCircle;
    private float xRect;
    private float yRect;
    private float speed;
    private String directionOval = "right";
    private String directionCircle = "down";
    private String directionRect = "right";


    public Rectangels(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.xOval = 100;
        this.yOval = 100;
        this.xCircle = 0;
        this.yCircle = 100;
        this.xRect = 100;
        this.yRect = 200;
        this.speed = 5f;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
//        System.out.println(delta);

        switch (directionOval) {
            case "right":
                this.xOval += (float) delta / this.speed;
                break;
            case "left":
                this.xOval -= (float) delta / this.speed;
                break;
        }
        if (this.xOval >= 500) {
            directionOval = "left";
        } else if (this.xOval <= 100) {
            directionOval = "right";
        }

        switch (directionCircle) {
            case "down":
                this.yCircle += (float) delta / this.speed;
                break;
            case "up":
                this.yCircle -= (float) delta / this.speed;
                break;
        }
        if (this.yCircle >= 500) {
            directionCircle = "up";
        } else if (this.yCircle <= 100) {
            directionCircle = "down";
        }

        switch (directionRect) {
            case "right":
                this.xRect += (float) delta / this.speed;
                break;
            case "down":
                this.yRect += (float) delta / this.speed;
                break;
            case "left":
                this.xRect -= (float) delta / this.speed;
                break;
            case "up":
                this.yRect -= (float) delta / this.speed;
                break;
        }
        if (directionRect == "right" && this.xRect >= 500) {
            directionRect = "down";
        } else if (directionRect == "down" && this.yRect >= 500) {
            directionRect = "left";
        } else if (directionRect == "left" && this.xRect <= 100) {
            directionRect = "up";
        } else if (directionRect == "up" && this.yRect <= 200) {
            directionRect = "right";
        }
    }


    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.xRect, this.yRect, 100, 100);
        graphics.drawOval(this.xOval, this.yOval, 100, 50, 50);
        graphics.drawOval(this.xCircle, this.yCircle, 100, 100);
        graphics.drawString("Hello, World!", 200, 70);

    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Rectangels("Rectangels"));
            container.setDisplayMode(1000, 1000, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
