package edu.austral.dissis.starship.drawer;

import edu.austral.dissis.starship.base.framework.ImageLoader;
import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.models.Spaceship;
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

    @Override
    public void draw(Spaceship ship) {
        final Vector2 position = ship.getPosition();
        final float angle = ship.getDirection().getAngle();

        graphics.pushMatrix();

        graphics.translate(position.getX(), position.getY());
        graphics.rotate(angle);

        PImage image = loader.load(ship.imageName);
        graphics.image(image, getImageWidthCenter(image), getImageHeightCenter(image));
        graphics.fill(255, 0, 0);

        graphics.popMatrix();

        graphics.fill(0, 255, 0);
    }
}
