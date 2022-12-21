package Classes;

import com.badlogic.gdx.physics.box2d.World;

public class Abram_Bullet extends BulletMine{

    //constructor
    public Abram_Bullet(World world, int x, int y, int width, int height) {
        super(world, x, y,  width,  height);
        this.damage = 100;
        this.launchPower = 100;
        this.radiusOfImpact = 100;

    }
}
