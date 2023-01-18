package Classes;

import com.badlogic.gdx.graphics.Texture;

public class FuelBarFactory {
    public FuelBarFactory(){

    }
    public static Texture generateFuelBarTexture(Tank tank, String tankType, int fuel){
        if (tankType.equals("Abrams")) {
            if (fuel >= 120) {
                return new Texture("InGameStuffOther/f1.png");
            } else if (fuel >= 60 && fuel < 120) {
                return new Texture("InGameStuffOther/f2.png");
            } else if (fuel >= 0 && fuel < 60) {
                return new Texture("InGameStuffOther/f3.png");
            } else {
                return new Texture("InGameStuffOther/f4.png");
            }

        }
        else if(tankType.equals("Coalition")){
            if (fuel >= 120) {
                return new Texture("InGameStuffOther/f1.png");
            } else if (fuel >= 60 && fuel < 120) {
                return new Texture("InGameStuffOther/f2.png");
            } else if (fuel >= 0 && fuel < 60) {
                return new Texture("InGameStuffOther/f3.png");
            } else {
                return new Texture("InGameStuffOther/f4.png");
            }

        }
        else{
            if (fuel >= 120) {
                return new Texture("InGameStuffOther/f1.png");
            } else if (fuel >= 60 && fuel < 120) {
                return new Texture("InGameStuffOther/f2.png");
            } else if (fuel >= 0 && fuel < 60) {
                return new Texture("InGameStuffOther/f3.png");
            } else {
                return new Texture("InGameStuffOther/f4.png");
            }

        }
    }

}
