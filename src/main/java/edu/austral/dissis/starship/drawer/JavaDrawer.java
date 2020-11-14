package edu.austral.dissis.starship.drawer;

import edu.austral.dissis.starship.base.framework.ImageLoader;
import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.models.Spaceship;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

public class JavaDrawer implements Drawer {

    private final PGraphics graphics;
    private final ImageLoader loader;

    public JavaDrawer(ImageLoader loader, PGraphics graphics) {
        this.graphics = graphics;
        this.loader = loader;
    }

    private float getImageHeightCenter(PImage image) {
        return image.pixelHeight / -2f;
    }

    private float getImageWidthCenter(PImage image) {
        return image.pixelWidth / -2f;
    }

    private float calculateRotation(Spaceship ship) {
        return ship.getDirection().rotate(PConstants.PI / 2).getAngle();
    }

    @Override
    public void draw(Spaceship ship) {
        final Vector2 position = ship.getPosition();
        final float angle = calculateRotation(ship);

        graphics.pushMatrix();

        graphics.translate(position.getX(), position.getY());
        graphics.rotate(angle);

        PImage image = loader.load(ship.imageName);
        graphics.image(image, getImageWidthCenter(image), getImageHeightCenter(image));

        graphics.popMatrix();
    }
}
