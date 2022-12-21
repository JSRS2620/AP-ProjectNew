package Screens;
//package com.mygdx.game;

import Classes.Tank;
import Classes.TankTextureFactory;
import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;

public class PauseScreen implements Screen {

        private MyGdxGame game;
        private Tank tank1, tank2;
        Texture tank1Texture, tank2Texture;
        Texture healthBar, healthBar2, fuelBar, fuelBar2;
        Texture backgroundTexture, groundTexture1,groundTexture2;
        Image tank1Image, tank2Image;
        Image healthBarImage1, healthBarImage2, fuelBarImage1, fuelBarImage2;
        Image backgroundImage, groundImage1,groundImage2;
        Texture pauseMenu;
        private Stage stage;

        public PauseScreen(final MyGdxGame game, final Tank tank1, final Tank tank2, Texture healthBar1, final Texture healthBar2, Texture fuelBar1, final Texture fuelBar2) {
            this.game = game;
            this.tank1 = tank1;
            this.tank2 = tank2;
            this.healthBar = healthBar1;
            this.healthBar2 = healthBar2;
            this.fuelBar = fuelBar1;
            this.fuelBar2 = fuelBar2;
            Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
            stage = new Stage(new ScreenViewport());

            TankTextureFactory tankTextureFactory = new TankTextureFactory();
            tank1Texture = tankTextureFactory.generateTankTexture(tank1.getTankType());
            tank1Image = new Image(tank1Texture);
            tank1Image.setPosition(tank1.getPosition().getX(), tank1.getPosition().getY()-1);
            tank1Image.setSize(120, 120);
            tank2Texture = tankTextureFactory.generateTankTexture2(tank2.getTankType());
            tank2Image = new Image(tank2Texture);
            tank2Image.setPosition(tank2.getPosition().getX(), tank2.getPosition().getY()-1);
            tank2Image.setSize(120, 120);

            tank2Texture = tankTextureFactory.generateTankTexture(tank2.getTankType());

            healthBarImage1 = new Image(healthBar1);
            healthBarImage1.setPosition(0, 0);
            healthBarImage1.setSize(400 ,60);
            healthBarImage1.setPosition(40, 850);
            healthBarImage2 = new Image(healthBar2);
            healthBarImage2.setPosition(1350, 850);
            healthBarImage2.setSize(400 ,60);

            fuelBarImage1 = new Image(fuelBar1);
            fuelBarImage1.setPosition(0, 0);
            fuelBarImage1.setSize(200 ,50);
            fuelBarImage1.setPosition(40, 750);
            fuelBarImage2 = new Image(fuelBar2);
            fuelBarImage2.setPosition(0, 0);
            fuelBarImage2.setSize(200 ,50);
            fuelBarImage2.setPosition(1550, 750);

            backgroundTexture = new Texture("Backgrounds/NiceForest1.png");
            backgroundImage = new Image(backgroundTexture);
            backgroundImage.setSize(4500, 1050);
            backgroundImage.setPosition(0, 0);
            stage.addActor(backgroundImage);

            groundTexture1 = new Texture("Ground.jpg");
            groundImage1 = new Image(groundTexture1);
            groundImage1.setSize(900, 200);
            groundImage1.setPosition(0, 0);
            stage.addActor(groundImage1);
            groundTexture2 = new Texture("Ground.jpg");
            groundImage2 = new Image(groundTexture2);
            groundImage2.setSize(900, 200);
            groundImage2.setPosition(900, 0);
            stage.addActor(groundImage2);


            //add to stage

            stage.addActor(healthBarImage1);
            stage.addActor(healthBarImage2);
            stage.addActor(fuelBarImage1);
            stage.addActor(fuelBarImage2);
            stage.addActor(tank1Image);
            stage.addActor(tank2Image);

            //create a resume button
            final Button resumeButton = new TextButton("Resume",mySkin,"small");
            //take input
            Gdx.input.setInputProcessor(stage);
            float resumecol_width = Gdx.graphics.getWidth()/6+75;
            float resumerow_height = Gdx.graphics.getHeight()/3+200;
            resumeButton.setSize(resumecol_width,resumerow_height/6);

            float resumex = resumecol_width+225; //center button in the middle of the screen
            float resumey = Gdx.graphics.getHeight()/2 - resumerow_height/2+250;
            resumeButton.setPosition(resumex,resumey);
            resumeButton.addListener(new InputListener(){
                @Override
                public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
//                outputLabel.setText("Press a Button");
                    game.setScreen(new InGameScene(game, tank1, tank2, healthBar, healthBar2, fuelBar, fuelBar2));

                }
                @Override
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
//                outputLabel.setText("Pressed Text Button");
                    //change button color to blue
                    resumeButton.setColor(0,0,1,1);
                    return true;
                }
            });
            stage.addActor(resumeButton);





            //place the textures in the correct position

//            final Button resumeButton = new Button();
//            resumeButton.setPosition(100, 100);


        }

        @Override
        public void show() {
                Gdx.input.setInputProcessor(stage);

        }

        @Override
        public void render(float delta) {
            Gdx.gl.glClearColor(1, 1, 1, 1);
            stage.act(delta);
            stage.draw();

        }

        @Override
        public void resize(int width, int height) {

        }

        @Override
        public void pause() {

        }

        @Override
        public void resume() {

        }

        @Override
        public void hide() {

        }

        @Override
        public void dispose() {
            stage.dispose();

        }
}
