package Classes;

import com.badlogic.gdx.physics.box2d.World;

public class TankFactory {

    //constructor
    public TankFactory() {
    }

    public Tank generateTank(World world, int x, int y, int width, int height, String tankType){
        if(tankType.equals("Abrams")){
            return new Abram_Tank(world, x, y, width, height, tankType);
        }
        else if(tankType.equals("Coalition")){
            return new Coalition_Tank(world, x, y, width, height, tankType);
        }
        else{
            return new Spectre_Tank(world, x, y, width, height, tankType);
        }
    }

    public Tank generateTankResume(World world, int x, int y, int width, int height, String tankType, int health, int fuel){
        if(tankType.equals("Abrams")){
            return new Abram_Tank(world, x, y, width, height, tankType, health, fuel);
        }
        else if(tankType.equals("Coalition")){
            return new Coalition_Tank(world, x, y, width, height, tankType, health, fuel);
        }
        else{
            return new Spectre_Tank(world, x, y, width, height, tankType, health, fuel);
        }
    }
}
