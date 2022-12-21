package Classes;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class TankTextureFactory {

    //constructor
    public TankTextureFactory() {

    }
    public Texture generateTankTexture(String tanktype){
        if(tanktype.equals("Abrams")){
            return new Texture("Tanks/Abrams_nobg.png");
        }
        else if(tanktype.equals("Coalition")){
            return new Texture("Tanks/Coalition_nobg.png");
        }
        else{
            return new Texture("Tanks/Spectre_nobg.png");
        }
    }
    public Texture generateTankTexture2(String tanktype){
        if(tanktype.equals("Abrams")){
            return new Texture("Tanks/Abrams_nobg_rev.png");
        }
        else if(tanktype.equals("Coalition")){
            return new Texture("Tanks/Coalition_nobg_rev.png");
        }
        else{
            return new Texture("Tanks/Spectre_nobg_rev.png");
        }
    }

}
