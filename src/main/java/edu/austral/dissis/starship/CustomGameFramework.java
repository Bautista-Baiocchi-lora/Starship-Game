package edu.austral.dissis.starship;

import edu.austral.dissis.starship.base.framework.GameFramework;
import edu.austral.dissis.starship.base.framework.ImageLoader;
import edu.austral.dissis.starship.base.framework.WindowSettings;
import edu.austral.dissis.starship.base.vector.Vector2;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.event.KeyEvent;

import java.util.Set;

import static edu.austral.dissis.starship.base.vector.Vector2.vector;

public class CustomGameFramework implements GameFramework {

    private StarshipDrawer starshipDrawer;
    private Starship starship = new Starship(vector(200, 200), vector(0, -1));

    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings
            .setSize(500, 500);

        starshipDrawer = new StarshipDrawer(imageLoader.load("spaceship.png"));
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        if (keySet.contains(PConstants.UP)) {
            starship = starship.moveForward(2);
        }

        if (keySet.contains(PConstants.DOWN)) {
            starship = starship.moveBackwards(2);
        }

        if (keySet.contains(PConstants.LEFT)) {
            starship = starship.rotate(-1 * PConstants.PI / 60);
        }

        if (keySet.contains(PConstants.RIGHT)) {
            starship = starship.rotate(PConstants.PI / 60);
        }

        starshipDrawer.draw(graphics, starship);
    }

    @Override
    public void keyPressed(KeyEvent event) {

    }

    @Override
    public void keyReleased(KeyEvent event) {

    }
}
