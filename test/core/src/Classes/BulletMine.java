package Classes;

import com.badlogic.gdx.physics.box2d.*;

public class BulletMine {

    private Body body;
    protected int damage;
    protected int launchPower;
    protected int angle;
    protected int radiusOfImpact;
    protected Position initialPosition;
    protected Position finalPosition;
    private final float PPM = 32.0f;


    public BulletMine(World world, int x, int y, int width, int height) {
        createBoxBody(world, x, y, width, height);
        body.setLinearDamping(0f);
    }
    //getters and setters

    public void createBoxBody(World world,int x, int y, int width, int height){
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(x/PPM, y/PPM);
        bodyDef.fixedRotation = true;
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bodyDef);
        body.setLinearDamping(0f);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width/2/PPM, height/2/PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1.0f;

        this.body = world.createBody(bodyDef);
        this.body.createFixture(fixtureDef).setUserData(this);

    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLaunchPower() {
        return launchPower;
    }

    public void setLaunchPower(int launchPower) {
        this.launchPower = launchPower;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int getRadiusOfImpact() {
        return radiusOfImpact;
    }

    public void setRadiusOfImpact(int radiusOfImpact) {
        this.radiusOfImpact = radiusOfImpact;
    }

    public Position getInitialPosition() {
        return initialPosition;
    }

    public void setInitialPosition(Position initialPosition) {
        this.initialPosition = initialPosition;
    }

    public Position getFinalPosition() {
        return finalPosition;
    }

    public void setFinalPosition(Position finalPosition) {
        this.finalPosition = finalPosition;
    }

    public float getPPM() {
        return PPM;
    }

    public boolean collideWithEdge(){
        if(getBody().getPosition().y - 175.5 < -180 || getBody().getPosition().x < -450 || getBody().getPosition().x > 45){
            return true;
        }
        return false;
    }

    public boolean collideWithTank(Tank tank) {
        if (getBody().getPosition().x > tank.getBody().getPosition().x - 1 && getBody().getPosition().x < tank.getBody().getPosition().x + 1 && getBody().getPosition().y > tank.getBody().getPosition().y - 1 && getBody().getPosition().y < tank.getBody().getPosition().y + 1) {
            return true;
        }
        return false;
    }


}
