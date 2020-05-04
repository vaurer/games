package at.va.games.skyFight.flyingObjects;

import at.va.games.skyFight.actors.Actor;
import at.va.games.skyFight.actors.CollisionActor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JetEnemy implements Actor, CollisionActor {

    private Image planeEnemyImage;
    private float x, y, speed;
    private Shape collisionShape;
    private List<CollisionActor> collisionActors;

    public JetEnemy() throws SlickException {
        Random random = new Random();
        this.planeEnemyImage = planeEnemyImage;
        Image temp = new Image("C:\\Vedran\\Coding\\Code\\Java\\Games\\src\\at\\va\\games\\skyFight\\flyingObjects\\jet2.png");
        this.planeEnemyImage = temp.getScaledCopy(100, 100);
        this.x = random.nextInt(1920);
        this.y = 0;
        this.speed = random.nextInt(6) + 2;
        this.collisionShape = new org.newdawn.slick.geom.Circle(this.x, this.y, 40);
        this.collisionActors = new ArrayList<CollisionActor>();
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        planeEnemyImage.draw(this.x, this.y);
       //graphics.draw(this.collisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        for (CollisionActor collisionActor : this.collisionActors) {
            if (this.collisionShape.intersects(collisionActor.getShape())){
                System.out.println("Huston we have a problem");
                try {
                    collisionActors.remove(collisionActor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        Random random = new Random();
        this.y += (float) delta / this.speed;
        if (this.y > 1080) {
            this.y = 0;
            this.x = random.nextInt(1880) + 20;
        }

        this.collisionShape.setCenterX(this.x + 50);
        this.collisionShape.setCenterY(this.y + 50);

        if (this.y >= 800) {
            fireRocket();
        }
    }

    public Image getPlaneEnemyImage() {
        return planeEnemyImage;
    }

    public void addCollisionPartners(Bullet bullet) {
        this.collisionActors.add(bullet);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void fireRocket() throws SlickException {
        Rocket rocket = new Rocket();
        rocket.setX(this.collisionShape.getX());
        rocket.setY(this.collisionShape.getY());
        rocket.setSpeed(this.speed);

    }

    @Override
    public Shape getShape() {
        return collisionShape;
    }
}
