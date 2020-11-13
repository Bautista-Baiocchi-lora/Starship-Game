package edu.austral.dissis.starship.base.framework;

import edu.austral.dissis.starship.GameController;
import processing.core.PApplet;
import processing.event.KeyEvent;

import java.util.HashSet;
import java.util.Set;

public class GameManager extends PApplet {
    private final GameFramework gameFramework = new GameController();

    public void settings() {
        gameFramework.setup(new WindowSettings(this), new ImageLoader(this));
    }

    public void draw() {
        clear();

        final float timeSinceLastFrame = (frameRate / 60) * 100;
        gameFramework.draw(g, timeSinceLastFrame, null);
    }

    public void keyPressed(KeyEvent event) {
        gameFramework.keyPressed(event);
    }

    public void keyReleased(KeyEvent event) {
        gameFramework.keyReleased(event);
    }
}
