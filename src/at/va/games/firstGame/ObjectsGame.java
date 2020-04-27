package at.va.games.firstGame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectsGame extends BasicGame {

    private List<Actor> actors;
    private  Rocket rocket;

    public ObjectsGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(1920), random.nextInt(1920), random.nextInt(50) + 5, Rectangle.DIRECTION.LEFT);
            this.actors.add(rectangle);
        }
        for (int i = 0; i < 10; i++) {
            Circle circle = new Circle();
            this.actors.add(circle);
        }
        for (int i = 0; i < 10; i++) {
            Ellipse ellipse = new Ellipse();
            this.actors.add(ellipse);
        }

//        for (int i = 0; i < 10; i++) {
//            Rocket rocket = new Rocket();
//            this.actors.add(rocket);
//        }
        Rocket rocket = new Rocket();
        this.rocket = rocket;
        this.actors.add(rocket);

    }

    @Override
    public void keyPressed(int key, char c) {
        if(key == Input.KEY_SPACE){
            CannonBall cannonBall = new CannonBall(this.rocket.getX(), this.rocket.getY());
            CannonBall cannonBall2 = new CannonBall(this.rocket.getX()+90, this.rocket.getY());
            this.actors.add(cannonBall);
            this.actors.add(cannonBall2);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(gameContainer, delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }

    public static void main(String[] args) {
        try {
            AppGameContainer appGameContainer = new AppGameContainer(new ObjectsGame("Rechtangels2"));
            appGameContainer.setDisplayMode(1920, 1080, false);
            appGameContainer.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}