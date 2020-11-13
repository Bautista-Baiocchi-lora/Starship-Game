package edu.austral.dissis.starship.models;

import edu.austral.dissis.starship.Movable;
import edu.austral.dissis.starship.drawer.Drawable;
import edu.austral.dissis.starship.drawer.Drawer;
import edu.austral.dissis.starship.base.vector.Vector2;

public class Spaceship extends GameObject implements Drawable, Movable<Spaceship> {

    public final String imageName = "spaceship.png";

    public Spaceship(Vector2 position, Vector2 direction) {
        super(position, direction);

    }

    @Override
    public void draw(Drawer drawer) {
        drawer.draw(this);
    }

    @Override
    public Spaceship moveForward(float speed) {
        Vector2 position = getPosition().add(getDirection().multiply(speed));
        return new Spaceship(position, getDirection());
    }

    @Override
    public Spaceship moveBackward(float speed) {
        Vector2 position = getPosition().subtract(getDirection().multiply(speed));
        return new Spaceship(position, getDirection());
    }

    @Override
    public Spaceship turn(float angle) {
        return new Spaceship(getPosition(), getDirection().rotate(angle));
    }
}
