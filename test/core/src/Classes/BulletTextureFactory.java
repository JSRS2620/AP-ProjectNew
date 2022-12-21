package Classes;

import com.badlogic.gdx.graphics.Texture;

public class BulletTextureFactory {

    //constructor
    public BulletTextureFactory() {

    }

    public Texture generateBulletTexture(String bullettype){
        if(bullettype.equals("Abrams")){
            return new Texture("Bullets/bullet1.png");
        }
        else if(bullettype.equals("Coalition")){
            return new Texture("Bullets/bullet1.png");
        }
        else{
            return new Texture("Bullets/bullet1.png");
        }
    }

    public Texture generateBulletTexture2(String bullettype){
        if(bullettype.equals("Abrams")){
            return new Texture("Bullets/bullet1_rev.png");
        }
        else if(bullettype.equals("Coalition")){
            return new Texture("Bullets/bullet1_rev.png");
        }
        else{
            return new Texture("Bullets/bullet1_rev.png");
        }
    }

}
