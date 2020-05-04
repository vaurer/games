package at.va.games.skyFight.flyingObjects;

import at.va.games.skyFight.actors.Actor;
import at.va.games.skyFight.actors.CollisionActor;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JetPlayer implements Actor {
    private Image planePlayerImage;
    private float x, y, speed;
    private Shape collisionShape;
    public List<CollisionActor> collisionActors;
    double counter = 0;

    public JetPlayer() throws SlickException {
        this.planePlayerImage = planePlayerImage;
        Image temp = new Image("C:\\Vedran\\Coding\\Code\\Java\\Games\\src\\at\\va\\games\\skyFight\\flyingObjects\\jetup.png");
        this.planePlayerImage = temp.getScaledCopy(100, 100);
        this.speed = 5;
        this.x = 960;
        this.y = 540;
        this.collisionShape = new org.newdawn.slick.geom.Circle(this.x + 50, this.y + 50, 40);
        this.collisionActors = new ArrayList<CollisionActor>();
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        planePlayerImage.draw(this.x, this.y);
        //graphics.draw(this.playerCollisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        for (CollisionActor collisionActor : this.collisionActors) {
            if (this.collisionShape.intersects(collisionActor.getShape()))  {
                System.out.println("Collision");
                counter++;
                if (counter > 1) {
                    try {
                        collisionActors.remove(collisionActor);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("GAME OVER");
                    TimeUnit.SECONDS.sleep(5);
                    System.exit(0);
                }
            }
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
            this.y--;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
            this.y++;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            this.x--;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            this.x++;
        }

        this.collisionShape.setCenterX(this.x + 50);
        this.collisionShape.setCenterY(this.y + 50);
    }

    public void addCollisionPartners(JetEnemy jetEnemy) {
        this.collisionActors.add(jetEnemy);
    }
    public void addCollisionPartners(Rocket rocket) {
        this.collisionActors.add(rocket);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
