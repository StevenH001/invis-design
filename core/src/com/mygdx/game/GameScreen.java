package com.mygdx.game;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Player;
import com.mygdx.game.PlayerSprite;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by Steven Hancock on 2/18/2016.
 * This class holds the main execution for the game. It creates the player, the enemy as well as the animations, camera and map. There is currently too much happening in
 * the render function of this class. It needs to be cleaned up and the code reorganized
 */
public class GameScreen extends InvisimanScreen {
    //Declare variables
    float w, h;
    public static Map map;
    public static OrthographicCamera camera;
    public SpriteBatch batch;
    public static Player player;
    public static Enemy enemy;

    //Set the number of columns and rows in the animation png
    private static final int        FRAME_COLS = 3;
    private static final int        FRAME_ROWS = 1;

    //Declare the animations
    Animation walkAnimation;
    Animation runAnimation;
    Animation idleAnimation;
    Animation grabAnimation;
    //Declare the texture sheets to use
    Texture walkSheet;
    Texture runSheet;
    Texture idleSheet;
    Texture grabSheet;
    //Declare an array to hold the frames
    TextureRegion[]walkFrames;
    TextureRegion[]runFrames;
    TextureRegion[]idleFrames;
    TextureRegion[]grabFrames;
    //Declare the current frame
    TextureRegion currentWalkFrame;
    TextureRegion currentRunFrame;
    TextureRegion currentIdleFrame;
    TextureRegion currentGrabFrame;

    //Set the state time for the game
    float stateTime;


    //The main function of the game
    public GameScreen (Game game) {

        super(game);

        //Get the width and height based on the graphics
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();

        //Set up the camera to be used in the game.
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.setToOrtho(false, 700, 700);
        camera.translate(0, -4);
        camera.update();

        //create new batch
        batch = new SpriteBatch();

        //Create a new map
        map = new Map();

        //Create Player
        player = new Player();
        //Create enemy
        enemy = new Enemy(5,5);

        //Call the load function for the player.
        player.load();

        // Add input processor for the player.
        Gdx.input.setInputProcessor(new InputMultiplexer(player.playerInput));

        //Set up the idle animation and load the ong
        idleSheet = new Texture(Gdx.files.internal("AgentIdle1-sheet.png"));
        //Split the png image into even sized chunks based on the frames and columns of the specific animation
        TextureRegion[][] tmp = TextureRegion.split(idleSheet, idleSheet.getWidth()/FRAME_COLS, idleSheet.getHeight()/FRAME_ROWS);
        //Set the frames to the region we just created
        idleFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        //Make a loop to run through and play the animation frame by frame.
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                idleFrames[index++] = tmp[i][j];
            }
        }
        //Set the animation to the frame and set its speed.
        idleAnimation = new Animation(.5f, idleFrames);
        //Set the state time
        stateTime = 0f;

    }


    @Override
    public void render (float delta) {
        // Clear the screen.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        //Set the color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Call the player update function
        player.update(this);

        //Update the state time based on the delta time.
        stateTime += Gdx.graphics.getDeltaTime();
        //Set the current frame to the key frame.
        currentIdleFrame = idleAnimation.getKeyFrame(stateTime, true);


        //Start patrolling for player
        enemy.patrol(delta);


        //Update the camera
        camera.update();
        map.update(camera);

        //Draw screen
        batch.setProjectionMatrix(camera.combined);
        //Begin the drawing batch
        batch.begin();
        //Draw all the players and animations on screen
            batch.draw(player.playerSprite, player.playerPosition.x*32,
                    player.playerPosition.y*32);
            batch.draw(enemy.enemySprite,enemy.position.x*32, enemy.position.y*32);
            batch.draw(currentIdleFrame, 550, 550);
        //End the drawing batch
        batch.end();

        //Exit to main menu if escape is pressed.
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
            game.setScreen(new MainMenu(game));
        }
        //If the player is nearby, chase them
        if (player.playerPosition.x - enemy.position.x < 1)
            enemy.chase(player.playerPosition.x, player.playerPosition.y, delta);
    }

    public void exit()
    {
        game.setScreen(new MainMenu(game));
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show () {
    }

    @Override
    public void hide () {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

}

