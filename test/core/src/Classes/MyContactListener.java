package Classes;

import com.badlogic.gdx.physics.box2d.*;

public class MyContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();

        if(fa==null || fb==null) return;
        if(fa.getUserData()==null || fb.getUserData()==null) return;

<<<<<<< HEAD
        if(fa.getUserData() instanceof Tank && fb.getUserData() instanceof BulletMine) {
=======
        if(fa.getUserData() instanceof Tank && fb.getUserData() instanceof BulletMine || fa.getUserData() instanceof BulletMine && fb.getUserData() instanceof Tank){
            //remove bullet
//            ((BulletMine) fb.getUserData()).setToDestroy();
>>>>>>> ec9b2f24af4094bc0b425409247325c0d554e1c5

        }

        //System.out.println("Collision detected");



    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        // TODO Auto-generated method stub

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
        // TODO Auto-generated method stub

    }

    public void destroy(Fixture fixture){

    }
}
