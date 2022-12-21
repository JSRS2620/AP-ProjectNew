package Screens;
//package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.*;
import com.mygdx.game.MyGdxGame;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class InGameScreen implements Screen {

    private Stage stage;
    private Label outputLabel;
    private boolean player1Turn = true;

    Texture img, abramImg, spectreImg;
    Texture groundImg1,groundImg2, groundImg3, groundImg4, groundImg5, groundImg6;
    Texture logoImg, backgroundPurpleImg, backgroundImg;
    Texture player1HealthBarImg, player2HealthBarImg, player1FuelBarImg, player2FuelBarImg, player1AimArrowImg, player2aimarrowImg;
    Texture player1HealthTextImg, player2HealthTextImg, player1FuelTextImg, player2FuelTextImg, pauseButtonImg;
    MyGdxGame game;

    SpriteBatch batch;
    //make sprites for the images
    Sprite abramSprite, spectreSprite, groundSprite1, groundSprite2, groundSprite3, groundSprite4, groundSprite5, groundSprite6;
    Sprite logoSprite, backgroundPurpleSprite, backgroundSprite;
    Sprite player1HealthBarSprite, player2HealthBarSprite, player1FuelBarSprite, player2FuelBarSprite, player1AimarrowSprite, player2AimarrowSprite;
    Sprite player1HealthTextSprite, player2HealthTextSprite, player1FuelTextSprite, player2FuelTextSprite, pauseButtonSprite;
    //make a camera
    OrthographicCamera camera;
    //make a viewport
    Viewport viewport;
    //make a font
    BitmapFont font;


    public InGameScreen(MyGdxGame game) {

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
    float xPurpleBackground = 0;float yPurpleBackground = 0;
    float xMaroonBackground = 0;float yMaroonBackground = 0;
    float xPlayer1HealthBar = -35;float yPlayer1HealthBar = 410;
    float xPlayer2HealthBar =352;float yPlayer2HealthBar = 410;
    float xPlayer1FuelBar = -7;float yPlayer1FuelBar = 350;
    float xPlayer2FuelBar = 538;float yPlayer2FuelBar = 350;
    float xPlayer1AimArrow = 130;float yPlayer1AimArrow = 155;

    float xPlayer1HealthText = 5;float yPlayer1HealthText = 430;
    float xPlayer2HealthText =535;float yPlayer2HealthText = 430;
    float xPlayer1FuelText = 5;float yPlayer1FuelText = 380;
    float xPlayer2FuelText = 580;float yPlayer2FuelText = 380;
    float xPauseButton = 590;float yPauseButton = 20;
    float xTranslucentBG = 0;float yTranslucentBG = 0;

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
        backgroundPurpleImg = new Texture("PurpleBackgrounds/Purplebg1.jpeg");
        backgroundImg = new Texture("Backgrounds/NiceForest1.png");
        player1HealthBarImg = new Texture("InGameStuff/HealthBar.png");
        player2HealthBarImg = new Texture("InGameStuff/HealthBar.png");
        player1FuelBarImg = new Texture("InGameStuff/FuelBar.png");
        player2FuelBarImg = new Texture("InGameStuff/FuelBar.png");
        //player1aimarrowImg = new Texture("AimArrow.png");
        player1HealthTextImg = new Texture("InGameStuff/HealthText.png");
        player2HealthTextImg = new Texture("InGameStuff/HealthText.png");
        player1FuelTextImg = new Texture("InGameStuff/FuelText.png");
        player2FuelTextImg = new Texture("InGameStuff/FuelText.png");
        pauseButtonImg = new Texture("Buttons/PauseButton.png");


        //make sprites for the images
        abramSprite = new Sprite(abramImg);
        abramSprite.setSize(50,50);

        spectreSprite = new Sprite(spectreImg);
        spectreSprite.setSize(50,30);

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

        backgroundPurpleSprite = new Sprite(backgroundPurpleImg);
        backgroundPurpleSprite.setSize(3000,1000);
        backgroundPurpleSprite.setPosition(xPurpleBackground,yPurpleBackground);

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

        pauseButtonSprite = new Sprite(pauseButtonImg);
        pauseButtonSprite.setSize(40,40);
        pauseButtonSprite.setPosition(xPauseButton,yPauseButton);

    }

    @Override
    public void render(float delta) {
        //set color of screen to space purple
        //ScreenUtils.clear(66F, 28F, 82F, 1);
//        Gdx.gl.glClearColor(1, 1, 1, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        ScreenUtils.clear(Color.PURPLE);
        //set screen background as a texture


        //stage.addActor(new Image(backgroundImg));
        game.batch.begin();
        //game.batch.draw(backgroundpurpleImg, xPurpleBackground, yPurpleBackground);
        game.batch.draw(backgroundImg, xMaroonBackground, yMaroonBackground);
        //game.batch.draw(img, x, y);

        //game.batch.draw(abramImg, xAbram, yAbram);
        //game.batch.draw(spectreImg, xSpectre, ySpectre);
        //backgroundmaroonSprite.draw(game.batch);
        abramSprite.draw(game.batch);
        spectreSprite.draw(game.batch);

//        groundSprite1.draw(game.batch);
//        groundSprite2.draw(game.batch);
//        groundSprite3.draw(game.batch);
//        groundSprite4.draw(game.batch);
//        groundSprite5.draw(game.batch);
//        groundSprite6.draw(game.batch);

        logoSprite.draw(game.batch);
        player1HealthBarSprite.draw(game.batch);
        player2HealthBarSprite.draw(game.batch);
        player1FuelBarSprite.draw(game.batch);
        player2FuelBarSprite.draw(game.batch);
        player1HealthTextSprite.draw(game.batch);
        player2HealthTextSprite.draw(game.batch);
        player1FuelTextSprite.draw(game.batch);
        player2FuelTextSprite.draw(game.batch);

        game.batch.draw(groundImg1, xGround1, yGround1);
        game.batch.draw(groundImg2, xGround2, yGround2);
        game.batch.draw(groundImg3, xGround3, yGround3);
        game.batch.draw(groundImg4, xGround4, yGround4);
        game.batch.draw(groundImg5, xGround5, yGround5);
        game.batch.draw(groundImg6, xGround6, yGround6);

        pauseButtonSprite.draw(game.batch);

//        game.batch.draw(groundImg1, xGround1, yGround1);
//        game.batch.draw(groundImg2, xGround2, yGround2);
//        game.batch.draw(groundImg3, xGround3, yGround3);
//        game.batch.draw(groundImg4, xGround4, yGround4);
//        game.batch.draw(groundImg5, xGround5, yGround5);
//        game.batch.draw(groundImg6, xGround6, yGround6);
//        game.batch.draw(logoImg, xLogo, yLogo);
//        game.batch.draw(player1healthbarImg, xPlayer1HealthBar, yPlayer1HealthBar);
//        game.batch.draw(player2healthbarImg, xPlayer2HealthBar, yPlayer2HealthBar);
//        game.batch.draw(player1fuelbarImg, xPlayer1FuelBar, yPlayer1FuelBar);
//        game.batch.draw(player2fuelbarImg, xPlayer2FuelBar, yPlayer2FuelBar);
//        game.batch.draw(player1healthtextImg, xPlayer1HealthText, yPlayer1HealthText);
//        game.batch.draw(player2healthtextImg, xPlayer2HealthText, yPlayer2HealthText);
//        game.batch.draw(player1fueltextImg, xPlayer1FuelText, yPlayer1FuelText);
//        game.batch.draw(player2fueltextImg, xPlayer2FuelText, yPlayer2FuelText);
        //game.batch.draw(pausebuttonImg, xPauseButton, yPauseButton);

        //game.batch.draw(player1aimarrowImg, xPlayer1AimArrow, yPlayer1AimArrow);
        //game.batch.draw(translucentbgImg, xTranslucentBG, yTranslucentBG);


        //roatate the aim arrow
        //player1aimarrowImg.



        //if key is pressed then move the tank abrams
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            xAbram -= 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            xAbram += 1;
        }


        //if key is pressed then move the tank spectre
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            xSpectre -= 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            xSpectre += 1;
        }


//        if(player1Turn==true){
//
//        }
//        if(player1Turn==false){
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
//            player1Turn = !player1Turn;
//        }

        abramSprite.setPosition(xAbram,yAbram);
        spectreSprite.setPosition(xSpectre,ySpectre);

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
        backgroundPurpleImg.dispose();
        backgroundImg.dispose();
        player1HealthBarImg.dispose();
        player2HealthBarImg.dispose();
        player1FuelBarImg.dispose();
        player2FuelBarImg.dispose();
        player1HealthTextImg.dispose();
        player2HealthTextImg.dispose();
        player1FuelTextImg.dispose();
        player2FuelTextImg.dispose();
        player1AimArrowImg.dispose();
        pauseButtonImg.dispose();
        batch.dispose();

    }
}
