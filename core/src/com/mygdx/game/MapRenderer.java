/* package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteCache;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer20;
import com.badlogic.gdx.math.Vector3;



  Created by Steven Hancock on 2/18/2016.

public class MapRenderer {
    Map map;
    OrthographicCamera cam;
    SpriteBatch batch = new SpriteBatch();
    Animation playerLeft;
    Animation playerRight;
    Animation playerDead;
    Animation spawn;
    Animation dying;
    FPSLogger fps = new FPSLogger();

    public MapRenderer (Map map) {
        this.map = map;
        this.cam = new OrthographicCamera(24, 16);
        cam.update();
        this.cam.position.set(map.player.position.x, map.player.position.y, 0);

        createAnimations();
        render(Gdx.graphics.getDeltaTime());
    }



    private void createAnimations () {
        Texture playerTexture = new Texture(Gdx.files.internal("runAnim.png"));
        TextureRegion[] split = new TextureRegion(playerTexture).split(20, 20)[0];
        TextureRegion[] mirror = new TextureRegion(playerTexture).split(20, 20)[0];
        for (TextureRegion region : mirror)
            region.flip(true, false);
        playerRight = new Animation(0.1f, split[0], split[1]);
        playerLeft = new Animation(0.1f, mirror[0], mirror[1]);
        playerDead = new Animation(0.2f, split[0]);
        spawn = new Animation(0.1f, split[4], split[3], split[2], split[1]);
        dying = new Animation(0.1f, split[1], split[2], split[3], split[4]);
    }

    float stateTime = 0;
    Vector3 lerpTarget = new Vector3();

    public void render (float deltaTime) {

        cam.position.lerp(lerpTarget.set(map.player.position.x, map.player.position.y, 0), 2f * deltaTime);

        cam.update();

        //map.renderer.setView(cam);
        //map.renderer.render();

        stateTime += deltaTime;
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        renderPlayer();
        batch.end();
        fps.log();
    }

    private void renderPlayer () {
        Animation anim = null;
        boolean loop = true;
        if (map.player.state == Player.RUN) {
            if (map.player.dir == Player.LEFT)
                anim = playerLeft;
            else
                anim = playerRight;
        }
        if (map.player.state == Player.SPAWN) {
            anim = spawn;
            loop = false;
        }
        if (map.player.state == Player.DYING) {
            anim = dying;
            loop = false;
        }
        batch.draw(anim.getKeyFrame(map.player.stateTime, loop), map.player.position.x, map.player.position.y, 1, 1);
    }


    public void dispose () {
        batch.dispose();
    }
}

*/