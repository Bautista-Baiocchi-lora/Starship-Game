package edu.austral.dissis.starship.models;

import edu.austral.dissis.starship.drawer.Drawable;
import edu.austral.dissis.starship.drawer.Drawer;
import edu.austral.dissis.starship.base.vector.Vector2;

public class Spaceship extends GameObject implements Drawable {

    public final String imageName = "spaceship.png";

    public Spaceship(Vector2 position, Vector2 direction) {
        super(position, direction);

    }

    @Override
    public void draw(Drawer drawer) {
        drawer.draw(this);
    }
}
