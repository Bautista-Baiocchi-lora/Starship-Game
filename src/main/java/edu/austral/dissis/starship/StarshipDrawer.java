package edu.austral.dissis.starship;

import edu.austral.dissis.starship.base.vector.Vector2;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

public class StarshipDrawer {
    private static final float IMAGE_SIZE = 200;

    private final PImage image;

    public StarshipDrawer(PImage image) {
        this.image = image;
    }

    private float getImageCenter() {
        return (IMAGE_SIZE * -1) / 2;
    }

    public void draw(PGraphics graphics, Starship starship) {
        final Vector2 position = starship.getPosition();
        final Vector2 direction = starship.getDirection().rotate(PConstants.PI / 2);

        graphics.pushMatrix();

        graphics.translate(position.getX(), position.getY());
        graphics.rotate(direction.getAngle());

        graphics.image(image, getImageCenter(), getImageCenter());
//        graphics.fill(255, 0, 0);
//        graphics.rect(-25, -25, 50, 50);

        graphics.popMatrix();
    }
}
