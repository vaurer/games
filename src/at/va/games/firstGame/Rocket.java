package at.va.games.firstGame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Rocket implements Actor {
    private Image rocketImage;
    private float speed;
    private float x, y;
    private Shape rocketCollisionShape;
    private ArrayList<Circle> circles;
    double counter = 0;


    public Rocket() throws SlickException {
        Random random = new Random();
        Image temp = new Image("testdata/wallpaper/rocket.png");
        this.rocketImage = temp.getFlippedCopy(false, random.nextBoolean());
        this.rocketImage = temp.getScaledCopy(100, 250);
        this.speed = 5;
        this.x = random.nextInt(1700) + 100;
        this.y = 900;
        this.rocketCollisionShape = new org.newdawn.slick.geom.Rectangle(this.x, this.y, rocketImage.getWidth(), rocketImage.getHeight());
        this.circles = new ArrayList<Circle>();
    }

    @Override
    public void render(Graphics graphics) {
        rocketImage.draw(this.x, this.y);
        graphics.draw(this.rocketCollisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        for(Circle circle:circles){

            if(this.rocketCollisionShape.intersects(circle.getCircleCollisionShape())){
                System.out.println("Collision " + counter);
                counter++;
                System.out.println("GAME OVER");
                TimeUnit.SECONDS.sleep(3);
                System.exit(0);
            }
        }

        this.y -= (float) delta / this.speed;
        if (this.y < 0) {
            this.y = 1080;
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            this.x++;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            this.x--;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_UP)){
            this.y--;
        }else if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)){
            this.y = this.y+2;
        }

        this.rocketCollisionShape.setCenterX(this.x+50);
        this.rocketCollisionShape.setCenterY(this.y + 125);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void addCollisionPartners(Circle circle) {
        this.circles.add(circle);
    }
    public Shape getRocketCollisionShape() {
        return rocketCollisionShape;
    }
}
