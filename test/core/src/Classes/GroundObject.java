package Classes;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class GroundObject {

    //make singleton
    private Body body;
    protected final float PPM = 32.0f;

    private static GroundObject groundObject;
    public static GroundObject getInstance(World world, int x, int y, int width, int height, boolean isStatic){
        if(groundObject == null){
            groundObject = new GroundObject(world,  x,  y,  width,  height,  isStatic);
        }
        return groundObject;
    }
    private GroundObject(World world, int x, int y, int width, int height, boolean isStatic){
        body = createBox(world, x, y, width, height, isStatic);
    }

    private Body createBox(World world, int x, int y, int width, int height, boolean isStatic) {
        Body body;
        BodyDef bodyDef = new BodyDef();
        if(isStatic) {
            bodyDef.type = BodyDef.BodyType.StaticBody;
        }
        else {
            bodyDef.type = BodyDef.BodyType.DynamicBody;
        }
        bodyDef.position.set(x/PPM, y/PPM);
        bodyDef.fixedRotation = true;
        body = world.createBody(bodyDef);
        body.getFixtureList().get(0).setFriction(0.5f);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width/2/PPM, height/2/PPM);


        body.createFixture(shape, 1.0f);
        shape.dispose();

        return body;
    }

}
