package Screens;
//package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class TankSelectionScreen implements Screen {

    private Stage stage;
    private Label outputLabel;
    Texture img, coalitionImg, groundImg1,groundImg2, groundImg3, groundImg4, logoImg, backgroundPurpleImg, backgroundImg, chooseYourTankImg, coalitionTextImg, sideMenuImg;
    Texture goButtonImg, backButtonImg, leftArrowImg, rightArrowImg;
    private Game game;

    //create a batch
    SpriteBatch batch = new SpriteBatch();

    Sprite coalitionSprite, groundSprite1, groundSprite2, groundSprite3, groundSprite4, logoSprite, backgroundPurpleSprite, backgroundSprite, chooseYourTankSprite, coalitionTextSprite, sideMenuSprite;
    Sprite goButtonSprite, backButtonSprite, leftArrowSprite, rightArrowSprite;

    public TankSelectionScreen(Game game) {
        this.game = game;
    }

    float xCoalition = 15; float yCoalition = 10;
    //float xCoaltionText = 40; float yCoalitionText = 300;
    float xCoaltionText = -15; float yCoalitionText = 202;
    float xGround1 = 0;float yGround1 = -10;
    float xGround2 = 100;float yGround2 = -10;
    float xGround3 = 200;float yGround3 = -10;
    float xGround4 = 300;float yGround4 = -10;
    float xLogo = 120;float yLogo = 343;
    float xPurpleBackground = 0;float yPurpleBackground = 0;
    float xMaroonBackground = -100;float yMaroonBackground = 0;
    float xchooseyourtank = 442;float ychooseyourtank = 295;
    float xGo = 457;float yGo = 185;
    float xBack = 457;float yBack = 85;
    float xLeftArrow = 5;float yLeftArrow = 205;
    float xRightArrow = 375;float yRightArrow = 205;
    float xSkygradient = 400;float ySkygradient =0;

    public void create () {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

        coalitionImg = new Texture("Tanks/CoalitionNew.png");
        groundImg1 = new Texture("Ground.jpg");
        groundImg2 = new Texture("Ground.jpg");
        groundImg3 = new Texture("Ground.jpg");
        groundImg4 = new Texture("Ground.jpg");
        logoImg = new Texture("Tank_Stars_Logo_nobg.png");
        backgroundPurpleImg = new Texture("PurpleBackgrounds/Purplebg1.jpeg");
        backgroundImg = new Texture("Backgrounds/M1.jpeg");
        chooseYourTankImg = new Texture("Text/SelectYourTankText.png");
        coalitionTextImg = new Texture("Text/CoalitionText1.png");
        goButtonImg = new Texture("Buttons/GoButton1.png");
        backButtonImg = new Texture("Buttons/BackButton1.png");
        leftArrowImg = new Texture("InGameStuff/LArrow.png");
        rightArrowImg = new Texture("InGameStuff/RArrow.png");
        sideMenuImg = new Texture("Backgrounds/SideMenu.png");

        coalitionSprite = new Sprite(coalitionImg);
        coalitionSprite.setSize(350, 350);
        coalitionSprite.setPosition(xCoalition, yCoalition);

        groundSprite1 = new Sprite(groundImg1);
        groundSprite1.setSize(100, 120);
        groundSprite1.setPosition(xGround1, yGround1);

        groundSprite2 = new Sprite(groundImg2);
        groundSprite2.setSize(100, 120);
        groundSprite2.setPosition(xGround2, yGround2);

        groundSprite3 = new Sprite(groundImg3);
        groundSprite3.setSize(100, 120);
        groundSprite3.setPosition(xGround3, yGround3);

        groundSprite4 = new Sprite(groundImg4);
        groundSprite4.setSize(100, 120);
        groundSprite4.setPosition(xGround4, yGround4);

        logoSprite = new Sprite(logoImg);
        logoSprite.setSize(140, 140);
        logoSprite.setPosition(xLogo, yLogo);

        backgroundPurpleSprite = new Sprite(backgroundPurpleImg);
        backgroundPurpleSprite.setSize(800, 600);
        backgroundPurpleSprite.setPosition(xPurpleBackground, yPurpleBackground);

        backgroundSprite = new Sprite(backgroundImg);
        backgroundSprite.setSize(800, 600);
        backgroundSprite.setPosition(xMaroonBackground, yMaroonBackground);

        chooseYourTankSprite = new Sprite(chooseYourTankImg);
        chooseYourTankSprite.setSize(175, 150);
        chooseYourTankSprite.setPosition(xchooseyourtank, ychooseyourtank);

        coalitionTextSprite = new Sprite(coalitionTextImg);
        coalitionTextSprite.setSize(400, 200);
        coalitionTextSprite.setPosition(xCoaltionText, yCoalitionText);

        goButtonSprite = new Sprite(goButtonImg);
        goButtonSprite.setSize(135, 60);
        goButtonSprite.setPosition(xGo, yGo);

        backButtonSprite = new Sprite(backButtonImg);
        backButtonSprite.setSize(135, 60);
        backButtonSprite.setPosition(xBack, yBack);

        leftArrowSprite = new Sprite(leftArrowImg);
        leftArrowSprite.setSize(25, 25);
        leftArrowSprite.setPosition(xLeftArrow, yLeftArrow);

        rightArrowSprite = new Sprite(rightArrowImg);
        rightArrowSprite.setSize(25, 25);
        rightArrowSprite.setPosition(xRightArrow, yRightArrow);

        sideMenuSprite = new Sprite(sideMenuImg);
        sideMenuSprite.setSize(250, 600);
        sideMenuSprite.setPosition(xSkygradient, ySkygradient);

    }

    @Override
    public void render(float delta) {
        //set color of screen to space purple
        //ScreenUtils.clear(66F, 28F, 82F, 1);

//        Gdx.gl.glClearColor(1, 1, 1, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //ScreenUtils.clear(Color.BLUE);
        //set color of screen to dark blue
        ScreenUtils.clear(0F, 0F, 0F, 1);
        //set screen background as a texture


        //stage.addActor(new Image(backgroundImg));
        batch.begin();

        backgroundPurpleSprite.draw(batch);
        backgroundSprite.draw(batch);
        sideMenuSprite.draw(batch);
        groundSprite1.draw(batch);
        groundSprite2.draw(batch);
        groundSprite3.draw(batch);
        groundSprite4.draw(batch);
        coalitionSprite.draw(batch);
        logoSprite.draw(batch);
        chooseYourTankSprite.draw(batch);
        coalitionTextSprite.draw(batch);
        goButtonSprite.draw(batch);
        backButtonSprite.draw(batch);
        leftArrowSprite.draw(batch);
        rightArrowSprite.draw(batch);



//        //game.batch.draw(backgroundpurpleImg, xPurpleBackground, yPurpleBackground);
//        batch.draw(backgroundmaroonImg, xMaroonBackground, yMaroonBackground);
//        //game.batch.draw(img, x, y);
//        batch.draw(coalitionImg, xCoalition, yCoalition);
//        batch.draw(groundImg1, xGround1, yGround1);
//        batch.draw(groundImg2, xGround2, yGround2);
//        batch.draw(getGroundImg3, xGround3, yGround3);
//        batch.draw(logoImg, xLogo, yLogo);
//        batch.draw(skygradientImg, xSkygradient, ySkygradient);
//        batch.draw(chooseyourtankImg, xchooseyourtank, ychooseyourtank);
//        batch.draw(coalitiontextImg, xCoaltionText, yCoalitionText);
//
//        batch.draw(gobuttonImg, xGo, yGo);
//        batch.draw(backbuttonImg, xBack, yBack);
//        batch.draw(leftarrowImg, xLeftArrow, yLeftArrow);
//        batch.draw(rightarrowImg, xRightArrow, yRightArrow);

        batch.end();

//        stage.act();
//        stage.draw();
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
        img.dispose();
        coalitionImg.dispose();
        groundImg1.dispose();
        groundImg2.dispose();
        groundImg3.dispose();
        logoImg.dispose();
        backgroundPurpleImg.dispose();
        backgroundImg.dispose();
        chooseYourTankImg.dispose();
        coalitionTextImg.dispose();
        goButtonImg.dispose();
        backButtonImg.dispose();
        leftArrowImg.dispose();
        rightArrowImg.dispose();
        sideMenuImg.dispose();
        batch.dispose();

    }
}
