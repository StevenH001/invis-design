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
 */
public class GameScreen extends InvisimanScreen {
    float w, h;
    public static Map map;
    public static OrthographicCamera camera;
    public SpriteBatch batch;
    public static Player player;
    public static Enemy enemy;


    private static final int        FRAME_COLS = 6;         // #1
    private static final int        FRAME_ROWS = 1;         // #2

    Animation                       walkAnimation;          // #3
    Texture                         walkSheet;              // #4
    TextureRegion[]                 walkFrames;             // #5
    TextureRegion                   currentFrame;           // #7

    float stateTime;                                        // #8


    public GameScreen (Game game) {

        super(game);

        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();

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
        enemy = new Enemy(5,5);

        player.load();



        // Add input processor.
        Gdx.input.setInputProcessor(new InputMultiplexer(player.playerInput));


        walkSheet = new Texture(Gdx.files.internal("YellowLight.png")); // #9
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight()/FRAME_ROWS);              // #10
        walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }
        walkAnimation = new Animation(1f, walkFrames);      // #11
        stateTime = 0f;                         // #13

    }


    @Override
    public void render (float delta) {
        // Clear the screen.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        player.update(this);


        stateTime += Gdx.graphics.getDeltaTime();           // #15
        currentFrame = walkAnimation.getKeyFrame(stateTime, true);  // #16


        //Start patrolling for player
        enemy.patrol(delta);


        camera.update();
        map.update(camera);

        //Draw screen
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
            batch.draw(player.playerSprite, player.playerPosition.x*32,
                    player.playerPosition.y*32);
            batch.draw(enemy.enemySprite,enemy.position.x*32, enemy.position.y*32);
            batch.draw(currentFrame, 300, 550);

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

