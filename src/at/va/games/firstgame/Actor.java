package at.va.games.firstgame;

import org.newdawn.slick.Graphics;

public interface Actor {
    public void render(Graphics graphics); //must be public

    public void update(int delta);
}
