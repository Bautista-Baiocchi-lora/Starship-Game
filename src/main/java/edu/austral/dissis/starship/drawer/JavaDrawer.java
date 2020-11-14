package edu.austral.dissis.starship.drawer;

import edu.austral.dissis.starship.base.framework.ImageLoader;
import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.models.asteroid.Asteroid;
import edu.austral.dissis.starship.models.spaceship.Projectile;
import edu.austral.dissis.starship.models.spaceship.Spaceship;
import processing.core.PGraphics;
import processing.core.PImage;

import static edu.austral.dissis.starship.drawer.Drawer.calculateRotation;

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
        final float angle = calculateRotation(ship);

        graphics.pushMatrix();

        graphics.translate(position.getX(), position.getY());
        graphics.rotate(angle);

        PImage image = loader.load(ship.getImageName());
        graphics.image(image, getImageWidthCenter(image), getImageHeightCenter(image));

        graphics.popMatrix();
    }

    @Override
    public void draw(Projectile projectile) {
        final Vector2 position = projectile.getPosition();
        final float angle = calculateRotation(projectile);

        graphics.pushMatrix();

        graphics.translate(position.getX(), position.getY());
        graphics.rotate(angle);

        PImage image = loader.load(projectile.getImageName());
        graphics.image(image, getImageWidthCenter(image), getImageHeightCenter(image));

        graphics.popMatrix();
    }

    @Override
    public void draw(Asteroid asteroid) {
        final Vector2 position = asteroid.getPosition();
        final float angle = calculateRotation(asteroid);

        graphics.pushMatrix();

        graphics.translate(position.getX(), position.getY());
        graphics.rotate(angle);

        PImage image = loader.load(asteroid.getImageName());
        graphics.image(image, getImageWidthCenter(image), getImageHeightCenter(image));

        graphics.popMatrix();
    }
}
