package edu.austral.dissis.starship.collision;

import edu.austral.dissis.starship.game.GameState;

import java.util.ArrayList;
import java.util.List;

public class CollisionEngine {

    private final List<Collider> colliders = new ArrayList<>();

    public void handleCollisions(GameState state) {
        this.colliders.forEach(collider -> collider.execute(state));
    }

    public void addCollider(Collider collider) {
        this.colliders.add(collider);
    }

}
