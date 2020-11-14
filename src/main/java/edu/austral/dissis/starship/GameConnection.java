package edu.austral.dissis.starship;


import edu.austral.dissis.starship.drawer.Drawer;
import processing.event.KeyEvent;

public class GameConnection {

    private final GameLobby lobby;
    private final Player player;

    public GameConnection(GameLobby lobby, Player player) {
        this.lobby = lobby;
        this.player = player;
    }

    public void draw(Drawer drawer){
        this.lobby.draw(drawer);
    }

    public void sendKeyPressed(KeyEvent event){
        this.lobby.notifyKeyPressed(player, event);
    }

    public void sendKeyReleased(KeyEvent event){
        this.lobby.notifyKeyReleased(player, event);
    }

    public boolean open(){
        if(lobby.isOpen()){
            return lobby.join(player);
        }
        return false;
    }

    public void close(){
        this.lobby.leave(player);
    }

}
