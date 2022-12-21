package Screens;
//package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;


public class TankSelectionScreen implements Screen {

    private Stage stage;
    private Label outputLabel;
    Texture img, coalitionImg, groundImg1,groundImg2, groundImg3, groundImg4,groundImg5, logoImg, backgroundPurpleImg, backgroundImg, chooseYourTankImg, coalitionTextImg, sideMenuImg;
    Texture goButtonImg, backButtonImg, leftArrowImg, rightArrowImg;
    private Game game;

    //create a batch
    SpriteBatch batch = new SpriteBatch();

    Image coalitionImage, groundImage1, groundImage2, groundImage3, groundImage4,groundImage5, logoImage, backgroundPurpleImage, backgroundImage, chooseYourTankImage, coalitionTextImage, sideMenuImage;
    Image goButtonImage, backButtonImage, leftArrowImage, rightArrowImage;

    int globalTankFlag = 0;

    float xCoalition = Gdx.graphics.getWidth()-1700; float yCoalition = Gdx.graphics.getHeight()/2 - 500;
    //float xCoaltionText = 40; float yCoalitionText = 300;
    float xCoaltionText = -15; float yCoalitionText = 202;
    float xGround1 = 0;float yGround1 = -10;
    float xGround2 = 300;float yGround2 = -10;
    float xGround3 = 500;float yGround3 = -10;
    float xGround4 = 700;float yGround4 = -10;
    float xGround5 = 900;float yGround5 = -10;
    float xLogo = 370;float yLogo = 600;
    float xPurpleBackground = 0;float yPurpleBackground = 0;
    float xMaroonBackground = 0;float yMaroonBackground = 0;
    float xchooseyourtank = 1300;float ychooseyourtank = 525;
    float xGo = 457;float yGo = 185;
    float xBack = 457;float yBack = 85;
    float xLeftArrow = 5;float yLeftArrow = 205;
    float xRightArrow = 375;float yRightArrow = 205;
    float xSkygradient = 1150;float ySkygradient =0;

    String FirstTank = "Tank1";
    String SecondTank = "Tank2";
    int numberOfTanksSelected = 0;

    public TankSelectionScreen(final Game game) {

        this.game = game;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        outputLabel = new Label("Tank Selection Screen", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        outputLabel.setPosition(10, 500);
        stage.addActor(outputLabel);

        //remove actor from stage


        backgroundImg = new Texture("Backgrounds/M1.jpeg");
        backgroundImage = new Image(backgroundImg);
        backgroundImage.setPosition(xMaroonBackground, yMaroonBackground);
        backgroundImage.setSize(1500, 1400);
        stage.addActor(backgroundImage);

        logoImg = new Texture("Tank_Stars_Logo_nobg.png");
        logoImage = new Image(logoImg);
        logoImage.setPosition(xLogo, yLogo);
        logoImage.setSize(400, 400);
        stage.addActor(logoImage);

        sideMenuImg = new Texture("Backgrounds/SideMenu.png");
        sideMenuImage = new Image(sideMenuImg);
        sideMenuImage.setPosition(xSkygradient, ySkygradient);
        sideMenuImage.setSize(750, 1100);
        stage.addActor(sideMenuImage);

        chooseYourTankImg = new Texture("Text/Select_Tank_1.png");
        chooseYourTankImage = new Image(chooseYourTankImg);
        chooseYourTankImage.setPosition(xchooseyourtank, ychooseyourtank);
        chooseYourTankImage.setSize(400, 400);
        stage.addActor(chooseYourTankImage);

        final Button goButton = new TextButton("Go!",mySkin,"small");
        goButton.setColor(0,1,0,1);

        //take input
        float gocol_width = Gdx.graphics.getWidth()/6+75;
        float go_height = Gdx.graphics.getHeight()/3+200;
        goButton.setSize(gocol_width,go_height/6);

        float gox = gocol_width+925; //center button in the middle of the screen
        float goy = Gdx.graphics.getHeight()/2 - go_height/2+130;
        goButton.setPosition(gox,goy);
        goButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                numberOfTanksSelected++;
                if(numberOfTanksSelected == 1){
                    if(globalTankFlag%3 == 0){
                        FirstTank = "Abrams";
                    }
                    else if(globalTankFlag%3==1){
                        FirstTank = "Coalition";
                    }
                    else{
                        FirstTank = "Spectre";
                    }
                }
                //remove actor from stage
                stage.getActors().removeValue(chooseYourTankImage, true);
                chooseYourTankImg = new Texture("Text/Select_Tank_2.png");
                chooseYourTankImage = new Image(chooseYourTankImg);
                chooseYourTankImage.setPosition(xchooseyourtank, ychooseyourtank);
                chooseYourTankImage.setSize(400, 400);
                stage.addActor(chooseYourTankImage);
                goButton.setColor(0,1,0,1);

//                outputLabel.setText("Press a Button");
                if(numberOfTanksSelected == 2) {
                    if(globalTankFlag%3 == 0){SecondTank = "Abrams";}
                    else if(globalTankFlag%3==1){SecondTank = "Coalition";}
                    else {SecondTank = "Spectre";}
                    game.setScreen(new InGameScene((MyGdxGame) game, FirstTank, SecondTank));
                }
                else{
                    //select second tank
                }


            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
//                outputLabel.setText("Pressed Text Button");
                //change button color to blue
                goButton.setColor(0,0,1,1);
                return true;
            }
        });
        stage.addActor(goButton);

        final Button backButton = new TextButton("Back",mySkin,"small");
        float back_width = Gdx.graphics.getWidth()/6+75;
        float back_height = Gdx.graphics.getHeight()/3+200;
        backButton.setSize(back_width,back_height/6);

        float backx = back_width+925;
        float backy = Gdx.graphics.getHeight()/2 - back_height/2-70;
        backButton.setPosition(backx,backy);
        backButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new MainMenuScreen((MyGdxGame) game));

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
//                outputLabel.setText("Pressed Text Button");
                //change button color to blue
                backButton.setColor(0,0,1,1);
                return true;
            }
        });
        stage.addActor(backButton);

        coalitionImg = new Texture("Tanks/Abrams_nobg.png");
        coalitionImage = new Image(coalitionImg);
        coalitionImage.setPosition(xCoalition,yCoalition);
        coalitionImage.setSize(Gdx.graphics.getWidth()/3 + 350, Gdx.graphics.getHeight()/2+335);
        stage.addActor(coalitionImage);



        groundImg1 = new Texture("Ground.jpg");
        groundImage1 = new Image(groundImg1);
        groundImage1.setPosition(xGround1, yGround1);
        groundImage1.setSize(300, 250);
        stage.addActor(groundImage1);
        groundImg2 = new Texture("Ground.jpg");
        groundImage2 = new Image(groundImg2);
        groundImage2.setPosition(xGround2, yGround2);
        groundImage2.setSize(300, 250);
        stage.addActor(groundImage2);
        groundImg3 = new Texture("Ground.jpg");
        groundImage3 = new Image(groundImg3);
        groundImage3.setPosition(xGround3, yGround3);
        groundImage3.setSize(300, 250);
        stage.addActor(groundImage3);
        groundImg4 = new Texture("Ground.jpg");
        groundImage4 = new Image(groundImg4);
        groundImage4.setPosition(xGround4, yGround4);
        groundImage4.setSize(300, 250);
        stage.addActor(groundImage4);
        groundImg5 = new Texture("Ground.jpg");
        groundImage5 = new Image(groundImg5);
        groundImage5.setPosition(xGround5, yGround5);
        groundImage5.setSize(250, 250);
        stage.addActor(groundImage5);

        final Button leftArrowButton = new TextButton("<",mySkin,"small");
        //make the buttono circular
        float leftArrow_width = Gdx.graphics.getWidth()/24;
        float leftArrow_height = Gdx.graphics.getHeight()/3;
        leftArrowButton.setSize(leftArrow_width,leftArrow_height/6);
        leftArrowButton.setColor(0,1,0,1);

        float leftArrowx = leftArrow_width; //center button in the middle of the screen
        float leftArrowy = Gdx.graphics.getHeight()/2 - leftArrow_height/2+150;
        leftArrowButton.setPosition(leftArrowx,leftArrowy);
        leftArrowButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //change the tank image
                globalTankFlag--;
                leftArrowButton.setColor(0,1,0,1);

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                leftArrowButton.setColor(0,0,1,1);
                return true;
            }
        });



        final Button rightArrowButton = new TextButton(">",mySkin,"small");
        float rightArrow_width = Gdx.graphics.getWidth()/24;
        float rightArrow_height = Gdx.graphics.getHeight()/3;
        rightArrowButton.setSize(rightArrow_width,rightArrow_height/6);
        rightArrowButton.setColor(0,1,0,1);

        float rightArrowx = rightArrow_width+950; //center button in the middle of the screen
        float rightArrowy = Gdx.graphics.getHeight()/2 - rightArrow_height/2+150;
        rightArrowButton.setPosition(rightArrowx,rightArrowy);
        rightArrowButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                globalTankFlag++;
                rightArrowButton.setColor(0,1,0,1);

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                rightArrowButton.setColor(0,0,1,1);
                return true;
            }
        });
        leftArrowButton.setColor(0,0,1,1);
        rightArrowButton.setColor(0,0,1,1);
        stage.addActor(rightArrowButton);
        stage.addActor(leftArrowButton);

        //return to main menu


    }


    public void create () {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(0F, 0F, 0F, 1);



        int tankChoice = Math.abs(globalTankFlag%3);

        if(tankChoice==0){
            stage.getActors().removeValue(coalitionImage, true);
            coalitionImg = new Texture("Tanks/Abrams_nobg.png");
            coalitionImage = new Image(coalitionImg);
            coalitionImage.setPosition(xCoalition,yCoalition+15);
            coalitionImage.setSize(Gdx.graphics.getWidth()/3 + 350, Gdx.graphics.getHeight()/2+320);
            stage.addActor(coalitionImage);
        }
        //float xCoalition = 65; float yCoalition = 10;
        if(tankChoice==1){
            stage.getActors().removeValue(coalitionImage, true);
            coalitionImg = new Texture("Tanks/Coalition_nobg.png");
            coalitionImage = new Image(coalitionImg);
            coalitionImage.setPosition(xCoalition-10,yCoalition);
            coalitionImage.setSize(Gdx.graphics.getWidth()/3 + 350, Gdx.graphics.getHeight()/2+320);
            stage.addActor(coalitionImage);
        }
        if(tankChoice==2){
            stage.getActors().removeValue(coalitionImage, true);
            coalitionImg = new Texture("Tanks/Spectre_nobg.png");
            coalitionImage = new Image(coalitionImg);
            coalitionImage.setPosition(xCoalition+80,yCoalition+235);
            coalitionImage.setSize(Gdx.graphics.getWidth()/3 + 150, Gdx.graphics.getHeight()/2-110);
            stage.addActor(coalitionImage);
        }


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
