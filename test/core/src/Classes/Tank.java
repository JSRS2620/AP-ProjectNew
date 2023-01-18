package Classes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.bullet.Bullet;

public class Tank {
    protected Body body;
    protected String tankType;

    protected int maxFuel;
    protected int fuel;
    protected int health;
    protected Position position;
    protected Position realmodePosition;
    protected float realmodeX;
    protected int speed;
    protected BulletMine bullet;
    protected boolean isAlive;
    protected int maxPowerLaunch;
    protected boolean isSurpriseBoxActive;
    protected final float PPM = 32.0f;

    protected Texture texture;



    public Tank(Body body) {
        this.body = body;
        this.health = 10;
        this.speed = 10;
        this.maxFuel = 200;
        this.fuel = maxFuel;
        this.isAlive = true;
        this.maxPowerLaunch = 100;
        this.isSurpriseBoxActive = false;
        this.body.setLinearDamping(0.5f);

        //set userdata
        this.body.setUserData(this);

    }
    public Tank(World world, int x, int y, int width, int height, String tankType) {
        createBoxBody(world, x, y, width, height);
        this.position = new Position(x, y);
        this.tankType = tankType;
        body.setLinearDamping(20f);
    }
    //getters and setters

    public void createBoxBody(World world,int x, int y, int width, int height){
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(x/PPM, y/PPM);
        bodyDef.fixedRotation = true;
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bodyDef);
        body.setLinearDamping(20f);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width/2/PPM, height/2/PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1.0f;

        this.body = world.createBody(bodyDef);
        this.body.createFixture(fixtureDef).setUserData(this);

    }

    public void hit(int damage) {
        health -= damage;
        if (health <= 0) {
            isAlive = false;
        }
        System.out.println("Tank health: " + health);
    }

    public Body getBody() {return body;}
    public void setBody(Body body) {this.body = body;}
    public int getHealth() {return health;}
    public void setHealth(int health) {this.health = health;}
    public Position getPosition() {return position;}
    public void setPosition(Position position) {this.position = position;}
    public int getSpeed() {return speed;}
    public void setSpeed(int speed) {this.speed = speed;}
    public BulletMine getBullet() {return bullet;}
    public void setBullet(BulletMine bullet) {this.bullet = bullet;}
    public boolean isAlive() {return isAlive;}
    public void setAlive(boolean alive) {isAlive = alive;}
    public int getMaxPowerLaunch() {return maxPowerLaunch;}

    public boolean isSurpriseBoxActive() {return isSurpriseBoxActive;}
    public void setSurpriseBoxActive(boolean surpriseBoxActive) {isSurpriseBoxActive = surpriseBoxActive;}

    public String getTankType() {
        return tankType;
    }

    public void setTankType(String tankType) {
        this.tankType = tankType;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    //reduce fuel by 1
    public void reduceFuelBy1(){
        this.fuel -= 1;
    }

    //reset fuel to max
    public void resetFuel(){
        this.fuel = this.maxFuel;
    }

    public void setWorld(World world) {
    }

    public float getRealmodeX() {
        return realmodeX;
    }

    public void setRealmodeX(float realmodeX) {
        this.realmodeX = realmodeX;
    }

    public Tank(int x, int y, int width, int height, String tankType, int health, int fuel) {
        this.position = new Position(x, y);
        this.tankType = tankType;
        this.health = health;
        this.fuel = fuel;
        this.realmodeX = x;
    }

    public boolean isTankOnGround(Tank tank){
        //check by position
        if(tank.getPosition().getY() <= 175){
            return true;
        }
        return false;
    }

}
