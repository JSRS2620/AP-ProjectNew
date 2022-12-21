package Classes;

import com.badlogic.gdx.graphics.Texture;

public class BulletTextureFactory {

    //constructor
    public BulletTextureFactory() {

    }

    public Texture generateBulletTexture(String bullettype){
        if(bullettype.equals("Abrams")){
            return new Texture("Bullets/b1.png");
        }
        else if(bullettype.equals("Coalition")){
            return new Texture("Bullets/b2.png");
        }
        else{
            return new Texture("Bullets/b3.png");
        }
    }

    public Texture generateBulletTexture2(String bullettype){
        if(bullettype.equals("Abrams")){
            return new Texture("Bullets/b1_rev.png");
        }
        else if(bullettype.equals("Coalition")){
            return new Texture("Bullets/b2_rev.png");
        }
        else{
            return new Texture("Bullets/b3_rev.png");
        }
    }

}
