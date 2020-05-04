package at.va.games.skyFight.flyingObjects;

import at.va.games.skyFight.actors.CollisionActor;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class Bullet implements CollisionActor {

    private float x, y, speed;
    private int diameter;
    private Shape collisionShape;
    private List<CollisionActor> collisionActors;
    private Sound sound;


    public Bullet(float x, float y) {
        this.x = x;
        this.y = y;
        this.collisionShape = new Circle(this.x, this.y, 15);
        this.collisionActors = new ArrayList<CollisionActor>();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y, 5, 5);
        graphics.setColor(Color.red);
        //graphics.draw(collisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        sound = new Sound("testdata/restart.ogg");

        for (CollisionActor collisionActor : this.collisionActors) {
            if (this.collisionShape.intersects(collisionActor.getShape())){
                System.out.println("Bullet hit the target!");
                try {
                    sound.play();
                    collisionActors.remove(collisionActor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        this.y = this.y - 2;
        this.collisionShape.setCenterY(this.y);
        this.collisionShape.setCenterX(this.x);
    }

    @Override
    public Shape getShape() {
        return collisionShape;
    }

    public void addCollisionPartners(CollisionActor collisionActor) {
        this.collisionActors.add(collisionActor);
    }
}
