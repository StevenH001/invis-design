package com.mygdx.game;

import com.mygdx.game.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;


/**
 * Created by Steven Hancock on 3/24/2016.
 */
public class PlayerInput implements InputProcessor
{

    PlayerMovement.direction dir = null;
    boolean keyPressed = false;
    GameScreen gs;

    @Override
    public boolean keyDown(int keycode) {
        switch(keycode){
            case Keys.UP:
                dir = PlayerMovement.direction.UP;
                break;
            case Keys.DOWN:
                dir = PlayerMovement.direction.DOWN;
                break;
            case Keys.LEFT:
                dir = PlayerMovement.direction.LEFT;
                break;
            case Keys.RIGHT:
                dir = PlayerMovement.direction.RIGHT;
                break;
            default:
                dir = null;
                break;
        }
        keyPressed = true;
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //gs.tabBar.clicked(screenX, Gdx.graphics.getHeight()-screenY,button);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        //gs.tabBar.mouseUp(screenX, Gdx.graphics.getHeight()-screenY,button);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        //gs.tabBar.mouseDragged(screenX, Gdx.graphics.getHeight()-screenY);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        if(screenX < 1248 && screenY < 672){
            //800 is initial cam pos
            int x = (int) ((screenX+GameScreen.camera.position.x-800)/32);
            //222 is initial cam pos, 228 is UI offset
            int y = (int) ((-screenY+GameScreen.camera.position.y+222+228)/32);
        }

        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        // TODO Auto-generated method stub
        return false;
    }

    public PlayerMovement.direction update(GameScreen gs){
        this.gs = gs;
        if(keyPressed == false){
            dir = null;
        }
        keyPressed = false;
        return dir;

    }


}
