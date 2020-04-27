package at.va.games.Snowflakes;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Snowflakes extends BasicGame {
    private List<Actor> snowflakes;

    public Snowflakes(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.snowflakes = new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            Snowflake snowflake = new Snowflake(Snowflake.SIZE.BIG);
            this.snowflakes.add(snowflake);
        }
        for (int i = 0; i <500 ; i++) {
            Snowflake snowflake = new Snowflake(Snowflake.SIZE.MEDIUM);
            this.snowflakes.add(snowflake);
        }
        for (int i = 0; i <1000 ; i++) {
            Snowflake snowflake = new Snowflake(Snowflake.SIZE.SMALL);
            this.snowflakes.add(snowflake);
        }

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.snowflakes) {
            actor.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.snowflakes) {
            actor.render(graphics);
        }
    }

    public static void main(String[] args) {
        try {
            AppGameContainer appGameContainer = new AppGameContainer(new Snowflakes("Snowflakes"));
            appGameContainer.setDisplayMode(800, 600, false);
            appGameContainer.start();
            appGameContainer.setMusicOn(true);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
