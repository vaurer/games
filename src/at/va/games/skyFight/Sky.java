package at.va.games.skyFight;

import at.va.games.skyFight.actors.Actor;
import at.va.games.skyFight.actors.CollisionActor;
import at.va.games.skyFight.flyingObjects.Bullet;
import at.va.games.skyFight.flyingObjects.JetEnemy;
import at.va.games.skyFight.flyingObjects.JetPlayer;
import at.va.games.skyFight.flyingObjects.Rocket;
import org.newdawn.slick.*;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sky extends BasicGame {
    private List<Actor> actors;
    private JetPlayer jetPlayer;
    private JetEnemy jetEnemy;
    private List<CollisionActor> collisionActors;
    private Bullet bullet;
    private Rocket rocket;
    private Audio engine;


    public Sky(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        gameContainer.getGraphics().setBackground(new Color(0.4f, 0.5f, 0.9f));
        this.actors = new ArrayList<>();
        this.collisionActors = new ArrayList<>();

        JetPlayer jetPlayer = new JetPlayer();
        this.jetPlayer = jetPlayer;
        this.actors.add(jetPlayer);

        for (int i = 0; i <10 ; i++) {
            JetEnemy jetEnemy = new JetEnemy();
            this.actors.add(jetEnemy);
            this.jetPlayer.addCollisionPartners(jetEnemy);
            this.collisionActors.add(jetEnemy);
        }

//        Rocket rocket = new Rocket();
//        this.actors.add(rocket);
//        this.jetPlayer.addCollisionPartners(rocket);
//        this.collisionActors.add(rocket);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            try {
                actor.update(gameContainer, delta);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            engine = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("testdata/engine.wav"));
            engine.playAsSoundEffect(1, 1, false);
        } catch (IOException e) {
            throw new SlickException("Failed to load engine", e);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : actors) {
            actor.render(graphics);
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        super.keyPressed(key, c);
        if (key == Input.KEY_SPACE) {
            System.out.println("fire");
            Bullet bullet1 = new Bullet(this.jetPlayer.getX() + 30, this.jetPlayer.getY());
            Bullet bullet2 = new Bullet(this.jetPlayer.getX() + 70, this.jetPlayer.getY());
            this.actors.add(bullet1);
            this.actors.add(bullet2);
            for (CollisionActor collisionActor : this.collisionActors) {
                bullet1.addCollisionPartners(collisionActor);
                bullet2.addCollisionPartners(collisionActor);
            }
            this.collisionActors.add(bullet1);
            this.collisionActors.add(bullet2);
        }
    }

    public static void main(String[] args) throws SlickException {
        try {
            AppGameContainer appGameContainer = new AppGameContainer(new Sky("SkyFight"));
            appGameContainer.setDisplayMode(1920, 1080, false);
            appGameContainer.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
