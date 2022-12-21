package Classes;

import com.badlogic.gdx.graphics.Texture;

public class HealthBarFactory {
    public HealthBarFactory() {
    }
    public Texture generateHealthBarTexture(Tank tank, String tankType, int health) {
        if (tankType.equals("Abrams")) {
            if (health >= 5) {
                return new Texture("InGameStuffOther/h1.png");
            } else if (health >= 3 && health < 5) {
                return new Texture("InGameStuffOther/h2.png");
            } else if (health >= 1 && health < 3) {
                return new Texture("InGameStuffOther/h3.png");
            } else {
                tank.setAlive(false);
                return new Texture("InGameStuffOther/h4.png");
            }

        }
        else if(tankType.equals("Coalition")){
            if (health == 3) {
                return new Texture("InGameStuffOther/h1.png");
            } else if (health >= 2 && health < 3) {
                return new Texture("InGameStuffOther/h2.png");
            } else if (health >= 1 && health < 2) {
                return new Texture("InGameStuffOther/h3.png");
            } else {
                tank.setAlive(false);
                return new Texture("InGameStuffOther/h4.png");
            }
        }
        else{
            if (health >= 3) {
                return new Texture("InGameStuffOther/h1.png");
            } else if (health >= 2 && health < 3) {
                return new Texture("InGameStuffOther/h2.png");
            } else if (health >= 1 && health < 2) {
                return new Texture("InGameStuffOther/h3.png");
            } else {
                tank.setAlive(false);
                return new Texture("InGameStuffOther/h4.png");
            }
        }
    }
}
