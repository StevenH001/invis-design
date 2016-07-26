package com.mygdx.game;
//test comment
/**
 * Created by Steven Hancock on 3/3/2016.
 */
public class Enemy extends DynamicGameObject {

    public EnemySprite enemySprite;
    boolean chasing = false, lostChase = false;
    public static final float enemyWidth = 1;
    public static final float enemyHeight = 0.6f;
    public static final float enemyVelocity = 2f;

    float stateTime = 0;

    public Enemy(float x, float y) {
        super(x, y, enemyWidth, enemyHeight);
        velocity.set(enemyVelocity, 0);
        enemySprite = new EnemySprite("Player");
    }

    public void patrol(float deltaTime)
    {
        position.add(velocity.x *deltaTime, velocity.y * deltaTime);
        bounds.x = position.x - enemyWidth / 2;
        bounds.y = position.y - enemyHeight /2;

        if(position.x < enemyWidth / 2)
        {
            position.x = enemyWidth;
            velocity.x = enemyVelocity;
        }
        if(position.x > 10 - enemyWidth / 2)
        {
            position.x = 10 - enemyWidth / 2;
            velocity.x = -enemyVelocity;
        }

        stateTime += deltaTime;

    }
    //Need to update this
    public void chase(float posx, float posy, float deltaTime)
    {
        chasing = true;
        velocity.set(posx, posy);
        velocity.sub(position.x, position.y).nor().scl(enemyVelocity - 1f);
        position.add(velocity.x *deltaTime, velocity.y * deltaTime);
        bounds.x = position.x + 0.1f;
        bounds.y = position.y + 0.1f;

        if(position.x == posx && position.y == posy)
        {
            velocity.setZero();

        }
        else if ((position.x - posx < 2 || position.x - posx > 2) && (position.y - posy < 2 || position.y - posy > 2))
        {
            lostChase = true;
        }

        stateTime += deltaTime;
    }

    public void search(float deltaTime)
    {
        //Implement this when it becomes neccessary
    }

}
