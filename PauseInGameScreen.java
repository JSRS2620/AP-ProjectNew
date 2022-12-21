package Screens;
//package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class PauseInGameScreen implements Screen {

    private Stage stage;
    private Label outputLabel;
    Texture img, abramImg, spectreImg;
    Texture groundImg1,groundImg2, groundImg3, groundImg4, groundImg5, groundImg6;
    Texture logoImg, backgroundImg;

    Texture pauseMenuImg, resumeButtonImg, saveGameButtonImg, quitButtonImg, pausedTextImg;

    Texture player1HealthBarImg, player2HealthBarImg, player1FuelBarImg, player2FuelBarImg, player1AimArrowImg, player2AimArrowImg;
    Texture player1HealthTextImg, player2HealthTextImg, player1FuelTextImg, player2FuelTextImg, pauseButtonImg;
    MyGdxGame game;

    SpriteBatch batch;
    //make sprites for the images
    Sprite abramSprite, spectreSprite, groundSprite1, groundSprite2, groundSprite3, groundSprite4, groundSprite5, groundSprite6;
    Sprite logoSprite, backgroundSprite;
    Sprite player1HealthBarSprite, player2HealthBarSprite, player1FuelBarSprite, player2FuelBarSprite;
    Sprite player1HealthTextSprite, player2HealthTextSprite, player1FuelTextSprite, player2FuelTextSprite, pauseMenuSprite;
    Sprite pauseButtonSprite, resumeButtonSprite, saveGameButtonSprite, quitButtonSprite, pausedTextSprite;

    public PauseInGameScreen(MyGdxGame game) {
        this.game = game;
    }
    float xAbram = 20; float yAbram = 100;
    float xSpectre = 550; float ySpectre = 115;
    float xGround1 = 0;float yGround1 = -10;
    float xGround2 = 100;float yGround2 = -10;
    float xGround3 = 200;float yGround3 = -10;
    float xGround4 = 300;float yGround4 = -10;
    float xGround5 = 400;float yGround5 = -10;
    float xGround6 = 500;float yGround6 = -10;
    float xLogo = 273;float yLogo = 375;
    float xMaroonBackground = 0;float yMaroonBackground = 0;
    float xPlayer1HealthBar = -35;float yPlayer1HealthBar = 410;
    float xPlayer2HealthBar =352;float yPlayer2HealthBar = 410;
    float xPlayer1FuelBar = -7;float yPlayer1FuelBar = 350;
    float xPlayer2FuelBar = 538;float yPlayer2FuelBar = 350;
    float xPlayer1HealthText = 5;float yPlayer1HealthText = 430;
    float xPlayer2HealthText =535;float yPlayer2HealthText = 430;
    float xPlayer1FuelText = 5;float yPlayer1FuelText = 380;
    float xPlayer2FuelText = 580;float yPlayer2FuelText = 380;

    // old float xPauseMenu = 155;float yPauseMenu = 50;
    float xPauseMenu = 186;float yPauseMenu = 90;
    float xResumeButton = 274;float yResumeButton = 245;
    float xSaveGameButton= 274;float ySaveGameButton = 195;
    float xQuitButton = 274;float yQuitButton = 145;
    float xPausedText = 264.5F;float yPausedText = 292;

    public void create () {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

        abramImg = new Texture("Tanks/Abrams_nobg.png");
        spectreImg = new Texture("Tanks/Spectre_rev_nobg.png");
        groundImg1 = new Texture("Ground.jpg");
        groundImg2 = new Texture("Ground.jpg");
        groundImg3 = new Texture("Ground.jpg");
        groundImg4 = new Texture("Ground.jpg");
        groundImg5 = new Texture("Ground.jpg");
        groundImg6 = new Texture("Ground.jpg");
        logoImg = new Texture("Tank_Stars_Logo_nobg.png");
        backgroundImg = new Texture("Backgrounds/NiceForest1.png");
        pauseMenuImg = new Texture("InGameStuff/PauseMenu2.png");
        resumeButtonImg = new Texture("Buttons/ResumeButton1.png");
        saveGameButtonImg = new Texture("Buttons/SaveGameButton1.png");
        quitButtonImg = new Texture("Buttons/QuitInGameButton1.png");
        pausedTextImg = new Texture("Text/PausedText1.png");
        player1HealthBarImg = new Texture("InGameStuff/HealthBar.png");
        player2HealthBarImg = new Texture("InGameStuff/HealthBar.png");
        player1FuelBarImg = new Texture("InGameStuff/FuelBar.png");
        player2FuelBarImg = new Texture("InGameStuff/FuelBar.png");
        //player1aimarrowImg = new Texture("AimArrow.png");
        player1HealthTextImg = new Texture("InGameStuff/HealthText.png");
        player2HealthTextImg = new Texture("InGameStuff/HealthText.png");
        player1FuelTextImg = new Texture("InGameStuff/FuelText.png");
        player2FuelTextImg = new Texture("InGameStuff/FuelText.png");


        //make sprites for the images
        abramSprite = new Sprite(abramImg);
        abramSprite.setSize(50,50);
        abramSprite.setPosition(xAbram,yAbram);

        spectreSprite = new Sprite(spectreImg);
        spectreSprite.setSize(50,30);
        spectreSprite.setPosition(xSpectre,ySpectre);

        groundSprite1 = new Sprite(groundImg1);
        groundSprite1.setSize(10,10);
        groundSprite1.setPosition(xGround1,yGround1);

        groundSprite2 = new Sprite(groundImg2);
        groundSprite2.setSize(100,10);
        groundSprite2.setPosition(xGround2,yGround2);

        groundSprite3 = new Sprite(groundImg3);
        groundSprite3.setSize(100,10);
        groundSprite3.setPosition(xGround3,yGround3);

        groundSprite4 = new Sprite(groundImg4);
        groundSprite4.setSize(100,10);
        groundSprite4.setPosition(xGround4,yGround4);

        groundSprite5 = new Sprite(groundImg5);
        groundSprite5.setSize(100,10);
        groundSprite5.setPosition(xGround5,yGround5);

        groundSprite6 = new Sprite(groundImg6);
        groundSprite6.setSize(100,10);
        groundSprite6.setPosition(xGround6,yGround6);

        logoSprite = new Sprite(logoImg);
        logoSprite.setSize(100,100);
        logoSprite.setPosition(xLogo,yLogo);

//        backgroundpurpleSprite = new Sprite(backgroundpurpleImg);
//        backgroundpurpleSprite.setSize(3000,1000);
//        backgroundpurpleSprite.setPosition(xPurpleBackground,yPurpleBackground);

        backgroundSprite = new Sprite(backgroundImg);
        backgroundSprite.setSize(600,400);
        backgroundSprite.setPosition(xMaroonBackground,yMaroonBackground);

        player1HealthBarSprite = new Sprite(player1HealthBarImg);
        player1HealthBarSprite.setSize(300,30);
        player1HealthBarSprite.setPosition(xPlayer1HealthBar,yPlayer1HealthBar);

        player2HealthBarSprite = new Sprite(player2HealthBarImg);
        player2HealthBarSprite.setSize(300,30);
        player2HealthBarSprite.setPosition(xPlayer2HealthBar,yPlayer2HealthBar);

        player1FuelBarSprite = new Sprite(player1FuelBarImg);
        player1FuelBarSprite.setSize(120,40);
        player1FuelBarSprite.setPosition(xPlayer1FuelBar,yPlayer1FuelBar);

        player2FuelBarSprite = new Sprite(player2FuelBarImg);
        player2FuelBarSprite.setSize(120,40);
        player2FuelBarSprite.setPosition(xPlayer2FuelBar,yPlayer2FuelBar);

        player1HealthTextSprite = new Sprite(player1HealthTextImg);
        player1HealthTextSprite.setSize(110,45);
        player1HealthTextSprite.setPosition(xPlayer1HealthText,yPlayer1HealthText);

        player2HealthTextSprite = new Sprite(player2HealthTextImg);
        player2HealthTextSprite.setSize(100,45);
        player2HealthTextSprite.setPosition(xPlayer2HealthText,yPlayer2HealthText);

        player1FuelTextSprite = new Sprite(player1FuelTextImg);
        player1FuelTextSprite.setSize(50,35);
        player1FuelTextSprite.setPosition(xPlayer1FuelText,yPlayer1FuelText);

        player2FuelTextSprite = new Sprite(player2FuelTextImg);
        player2FuelTextSprite.setSize(50,35);
        player2FuelTextSprite.setPosition(xPlayer2FuelText,yPlayer2FuelText);


        pauseMenuSprite = new Sprite(pauseMenuImg);
        pauseMenuSprite.setSize(280,300);
        pauseMenuSprite.setPosition(xPauseMenu,yPauseMenu);

        resumeButtonSprite = new Sprite(resumeButtonImg);
        resumeButtonSprite.setSize(100,37);
        resumeButtonSprite.setPosition(xResumeButton,yResumeButton);

        saveGameButtonSprite = new Sprite(saveGameButtonImg);
        saveGameButtonSprite.setSize(100,37);
        saveGameButtonSprite.setPosition(xSaveGameButton,ySaveGameButton);

        quitButtonSprite = new Sprite(quitButtonImg);
        quitButtonSprite.setSize(100,37);
        quitButtonSprite.setPosition(xQuitButton,yQuitButton);

        pausedTextSprite = new Sprite(pausedTextImg);
        pausedTextSprite.setSize(120,50);
        pausedTextSprite.setPosition(xPausedText,yPausedText);




    }

    @Override
    public void render(float delta) {


        ScreenUtils.clear(Color.PURPLE);


        //stage.addActor(new Image(backgroundImg));
        game.batch.begin();
        //game.batch.draw(backgroundpurpleImg, xPurpleBackground, yPurpleBackground);
        game.batch.draw(backgroundImg, xMaroonBackground, yMaroonBackground);

        abramSprite.draw(game.batch);
        spectreSprite.draw(game.batch);

        logoSprite.draw(game.batch);
        player1HealthBarSprite.draw(game.batch);
        player2HealthBarSprite.draw(game.batch);
        player1FuelBarSprite.draw(game.batch);
        player2FuelBarSprite.draw(game.batch);
        player1HealthTextSprite.draw(game.batch);
        player2HealthTextSprite.draw(game.batch);
        player1FuelTextSprite.draw(game.batch);
        player2FuelTextSprite.draw(game.batch);
        pauseMenuSprite.draw(game.batch);
        resumeButtonSprite.draw(game.batch);
        saveGameButtonSprite.draw(game.batch);
        quitButtonSprite.draw(game.batch);
        pausedTextSprite.draw(game.batch);


        game.batch.draw(groundImg1, xGround1, yGround1);
        game.batch.draw(groundImg2, xGround2, yGround2);
        game.batch.draw(groundImg3, xGround3, yGround3);
        game.batch.draw(groundImg4, xGround4, yGround4);
        game.batch.draw(groundImg5, xGround5, yGround5);
        game.batch.draw(groundImg6, xGround6, yGround6);


        //game.batch.draw(img, x, y);
//        game.batch.draw(abramImg, xAbram, yAbram);
//        game.batch.draw(spectreImg, xSpectre, ySpectre);
//        game.batch.draw(groundImg1, xGround1, yGround1);
//        game.batch.draw(groundImg2, xGround2, yGround2);
//        game.batch.draw(groundImg3, xGround3, yGround3);
//        game.batch.draw(groundImg4, xGround4, yGround4);
//        game.batch.draw(groundImg5, xGround5, yGround5);
//        game.batch.draw(groundImg6, xGround6, yGround6);
//        game.batch.draw(logoImg, xLogo, yLogo);
//        game.batch.draw(pausemenuImg, xPauseMenu, yPauseMenu);
//        game.batch.draw(resumebuttonImg, xResumeButton, yResumeButton);
//        game.batch.draw(savegamebuttonImg, xSaveGameButton, ySaveGameButton);
//        game.batch.draw(quitbuttonImg, xQuitButton, yQuitButton);
//        game.batch.draw(pausedtextImg, xPausedText, yPausedText);
//        game.batch.draw(player1healthbarImg, xPlayer1HealthBar, yPlayer1HealthBar);
//        game.batch.draw(player2healthbarImg, xPlayer2HealthBar, yPlayer2HealthBar);
//        game.batch.draw(player1fuelbarImg, xPlayer1FuelBar, yPlayer1FuelBar);
//        game.batch.draw(player2fuelbarImg, xPlayer2FuelBar, yPlayer2FuelBar);
//        game.batch.draw(player1healthtextImg, xPlayer1HealthText, yPlayer1HealthText);
//        game.batch.draw(player2healthtextImg, xPlayer2HealthText, yPlayer2HealthText);
//        game.batch.draw(player1fueltextImg, xPlayer1FuelText, yPlayer1FuelText);
//        game.batch.draw(player2fueltextImg, xPlayer2FuelText, yPlayer2FuelText);


        game.batch.end();


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
        abramImg.dispose();
        spectreImg.dispose();
        groundImg1.dispose();
        groundImg2.dispose();
        groundImg3.dispose();
        groundImg4.dispose();
        groundImg5.dispose();
        groundImg6.dispose();
        logoImg.dispose();
        backgroundImg.dispose();
        pauseMenuImg.dispose();
        resumeButtonImg.dispose();
        saveGameButtonImg.dispose();
        quitButtonImg.dispose();
        pausedTextImg.dispose();
        player1HealthBarImg.dispose();
        player2HealthBarImg.dispose();
        player1FuelBarImg.dispose();
        player2FuelBarImg.dispose();
        player1HealthTextImg.dispose();
        player2HealthTextImg.dispose();
        player1FuelTextImg.dispose();
        player2FuelTextImg.dispose();
        batch.dispose();

    }
}
