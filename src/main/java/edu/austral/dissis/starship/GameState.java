package edu.austral.dissis.starship;

import edu.austral.dissis.starship.models.Spaceship;

import java.util.*;

import static edu.austral.dissis.starship.base.vector.Vector2.vector;

public class GameState {


    private final List<Player> players = new ArrayList<>();
    private final HashMap<Integer, Spaceship> playerRegistry = new HashMap<>();

    public void addPlayer(Player player){
        this.players.add(player);
        this.playerRegistry.put(player.getId(), new Spaceship(vector(200, 200), vector(1, 0)));
    }

    public Collection<Spaceship> getSpaceships(){
        return this.playerRegistry.values();
    }

    public void removePlayer(Player player){
        this.players.remove(player);
        this.playerRegistry.remove(player.getId());
    }
}
