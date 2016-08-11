package com.mygdx.game;

import com.mygdx.game.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;


/**
 * Created by Steven Hancock on 3/24/2016.
 */
public class PlayerMovement {
    public direction moveDirection = null;

    public enum direction {
        LEFT, DOWN, UP, RIGHT
    }

    public void update() {
        if (moveDirection != null) {

            //Call the move direction function
            moveInDirection(moveDirection);

            //not sure why this is here -MZ
            //moveDirection = null;
        }
    }

    public void moveInDirection(direction dirToMove){
        //Set the position of the character
        GameScreen.player.playerPosition.oldPosition.x = GameScreen.player.playerPosition.x;
        GameScreen.player.playerPosition.oldPosition.y = GameScreen.player.playerPosition.y;

        //Moving left
        switch(dirToMove){
            case LEFT:
                GameScreen.player.playerPosition.x -= 1;
                //If the camera position is less then the map width, move the screen. Map width is 992 for this map. camera position is in the hundreds as well.
                if(!(GameScreen.camera.position.x < (GameScreen.map.getWidth())/3)) {
                    //If the character is not in the middle of the screen, then dont translate the camera until he is. This keeps the
                    //the character from being stuck on the edge of the screen.
                    if(!(GameScreen.camera.position.x < ((GameScreen.player.playerPosition.x) * 35))){
                        //Move the camera left the tilesize
                        GameScreen.camera.translate(-GameScreen.player.tileSize, 0);
                    }
                }
                break;

            //Moving right
            case RIGHT:
                GameScreen.player.playerPosition.x += 1;
                //If map size is different then 992 may need to change the - 300 portion
                if(!(GameScreen.camera.position.x > (GameScreen.map.getWidth()-300))) {
                    //If the character is not in the middle of the screen, then dont translate the camera until he is.
                    if(!(GameScreen.camera.position.x > ((GameScreen.player.playerPosition.x) * 35))){
                        //Move the camera right the tilesize
                        GameScreen.camera.translate(GameScreen.player.tileSize, 0);
                    }
                }
                break;

            //Moving up
            case UP:
                GameScreen.player.playerPosition.y += 1;
                //If the camera position is less then the map width, move the screen. Map width is 992 for this map. camera position is in the hundreds as well.
                //If map size is different then 992 may need to change the - 300 portion
                if(!(GameScreen.camera.position.y > (GameScreen.map.getHeight()-300))) {
                    //If the character is not in the middle of the screen, then dont translate the camera until he is.
                    if(!(GameScreen.camera.position.y > ((GameScreen.player.playerPosition.y) * 35))) {
                        //Move the camera upwards the tilesize
                        GameScreen.camera.translate(0, GameScreen.player.tileSize);
                    }
                }
                break;

            //Moving down
            case DOWN:
                GameScreen.player.playerPosition.y -= 1;
                //If the camera position is less then the map width, move the screen. Map width is 992 for this map. camera position is in the hundreds as well.
                if(!(GameScreen.camera.position.y < (GameScreen.map.getWidth())/3)) {
                    //If the character is not in the middle of the screen, then dont translate the camera until he is.
                    if(!(GameScreen.camera.position.y < ((GameScreen.player.playerPosition.y) * 35))) {
                        //Move the camera downwards the tilesize
                        GameScreen.camera.translate(0, -GameScreen.player.tileSize);
                    }
                }
                break;
        }

        collisionCheck();

        //Log position
        Gdx.app.log("x",Integer.toString((int)GameScreen.player.playerPosition.x));
        Gdx.app.log("y",Integer.toString((int)GameScreen.player.playerPosition.y));
    }

    public void collisionCheck(){
        //Screen bounds
        //May need to change this as it causes the screen to jitter back when character is on edge of map
        if(GameScreen.player.playerPosition.x < 0){moveInDirection(direction.RIGHT);}
        if(GameScreen.player.playerPosition.y < 0){moveInDirection(direction.UP);}
        if(GameScreen.player.playerPosition.x > GameScreen.map.getWidth()/32){moveInDirection(direction.LEFT);}
        if(GameScreen.player.playerPosition.y > GameScreen.map.getHeight()/32){moveInDirection(direction.DOWN);}


        //Collision Layer
        Cell cell = GameScreen.map.collisionLayer.getCell((int)GameScreen.player.playerPosition.x, (int)GameScreen.player.playerPosition.y);
        if(cell!=null){
            Vector2 direction = new Vector2(GameScreen.player.playerPosition.x,GameScreen.player.playerPosition.y);
            direction = direction.sub(GameScreen.player.playerPosition.oldPosition);
            direction.nor();

            //Horizontal
            if(direction.equals(new Vector2(1,0))){moveInDirection(PlayerMovement.direction.LEFT);}
            if(direction.equals(new Vector2(-1,0))){moveInDirection(PlayerMovement.direction.RIGHT);}
            //Vertical
            if(direction.equals(new Vector2(0,1))){moveInDirection(PlayerMovement.direction.DOWN);}
            if(direction.equals(new Vector2(0,-1))){moveInDirection(PlayerMovement.direction.UP);}
        }
    }

}
