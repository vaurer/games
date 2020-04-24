package at.va.games.firstgame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ObjectsGame extends BasicGame {
//    private Rectangle2 rectangle2;

    private List<Rectangle> rectangles;
    private List<Circle> circles;


    public ObjectsGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
//        this.rectangle2 = new Rectangle2(100, 100, 5);
        this.rectangles = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(1920), random.nextInt(1920), random.nextInt(50));
            rectangles.add(rectangle);
        }
        this.circles = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            Circle circle = new Circle();
            this.circles.add(circle);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
//        this.rectangle2.update(delta);
        for (Rectangle rectangle : this.rectangles) {
            rectangle.update(delta);
        }
        for (Circle circle : this.circles) {
            circle.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
//        this.rectangle2.render(graphics);
        for (Rectangle rectangle : this.rectangles) {
            rectangle.render(graphics);
        }
        for (Circle circle : this.circles) {
            circle.render(graphics);
        }
    }

    public static void main(String[] args) {
        try {
            AppGameContainer appGameContainer = new AppGameContainer(new ObjectsGame("Rechtangels2"));
            appGameContainer.setDisplayMode(1920, 1080, true);
            appGameContainer.start();

        } catch (SlickException e) {
            e.printStackTrace();
        }

    }
}
