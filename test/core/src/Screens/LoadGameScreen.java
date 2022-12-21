package Screens;
//package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
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


public class LoadGameScreen implements Screen {

    private Stage stage;
    private Texture myTexture;
    private TextureRegion myTextureRegion;
    private TextureRegionDrawable myTexRegionDrawable;
    private ImageButton button;
    int flag = 0;
    private Label outputLabel;
    private Sound bulletSound = Gdx.audio.newSound(Gdx.files.internal("Audio/bulletSound.mp3"));
    Texture img, abramImg, groundImg1,groundImg2, groundImg3,groundImg4,groundImg5, logoImg, backGroundPurpleImg, backgroundImg, bulletImg, mainMenuImg, sideMenuImg;
    Texture newGameButtonImg, loadGameButtonImg, quitGameButtonImg;


    Sprite abramSprite, groundSprite1, groundSprite2, groundSprite3,groundSprite4,groundSprite5, logoSprite, backgroundPurpleSprite, backgroundSprite, bulletSprite, mainMenuSprite, sideMenuSprite;
    Sprite newGameButtonSprite, loadGameButtonSprite, quitGameButtonSprite;

    Image abramImage, groundImage1, groundImage2, groundImage3,groundImage4,groundImage5, logoImage, backgroundPurpleImage, backgroundImage, bulletImage, mainMenuImage, sideMenuImage;
    Image newGameButtonImage, loadGameButtonImage, quitGameButtonImage;

    SpriteBatch batch = new SpriteBatch();

    //add a button
    //private Button button;
    private Skin skin;
    private TextureAtlas buttonAtlas;
    private TextButton.TextButtonStyle textButtonStyle;
    private BitmapFont font;

    private final Game game;

    float xAbram = Gdx.graphics.getWidth()-1700; float yAbram = Gdx.graphics.getHeight()/2 - 500;
    float xGround1 = 0;float yGround1 = -10;
    float xGround2 = 300;float yGround2 = -10;
    float xGround3 = 500;float yGround3 = -10;
    float xGround4 = 700;float yGround4 = -10;
    float xGround5 = 900;float yGround5 = -10;
    float xLogo = 370;float yLogo = 600;
    float xPurpleBackground = 0;float yPurpleBackground = 0;
    float xMaroonBackground = 0;float yMaroonBackground = 0;
    float xBullet = 325;float yBullet = 195;
    float xMainmenu = 1300;float yMainmenu = 600;
    float xNewgame = 460;float yNewgame = 245;
    float xLoadgame = 460;float yLoadgame = 145;
    float xQuitgame = 460;float yQuitgame = 45;
    float xSkygradient = 1150;float ySkygradient =0;
    public LoadGameScreen(final Game game) {
        this.game = game;
        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

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




        final Button game1Button = new TextButton("Game 1",mySkin,"small");
        //take input
        Gdx.input.setInputProcessor(stage);
        float game1col_width = Gdx.graphics.getWidth()/6+75;
        float game1row_height = Gdx.graphics.getHeight()/3+200;
        game1Button.setSize(game1col_width,game1row_height/6);

        float game1x = game1col_width+925; //center button in the middle of the screen
        float game1y = Gdx.graphics.getHeight()/2 - game1row_height/2+250;
        game1Button.setPosition(game1x,game1y);
        game1Button.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {


            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(game1Button);

        final Button game2Button = new TextButton("Game 2",mySkin,"small");
        float game2col_width = Gdx.graphics.getWidth()/6+75;
        float game2row_height = Gdx.graphics.getHeight()/3+200;
        game2Button.setSize(game2col_width,game2row_height/6);

        float game2x = game2col_width+925; //center button in the middle of the screen
        float game2y = Gdx.graphics.getHeight()/2 - game2row_height/2+50;
        game2Button.setPosition(game2x,game2y);
        game2Button.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {


            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

                return true;
            }
        });
        stage.addActor(game2Button);

        final Button game3Button = new TextButton("Back",mySkin,"small");
        float game3col_width = Gdx.graphics.getWidth()/6+75;
        float game3row_height = Gdx.graphics.getHeight()/3+200;
        game3Button.setSize(game3col_width,game3row_height/6);

        float game3x = game3col_width+925; //center button in the middle of the screen
        float game3y = Gdx.graphics.getHeight()/2 - game3row_height/2-150;
        game3Button.setPosition(game3x,game3y);
        game3Button.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new MainMenuScreen(game));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(game3Button);



        abramImg = new Texture("Tanks/Abrams_nobg.png");
        abramImage = new Image(abramImg);
        abramImage.setPosition(xAbram,yAbram);
        abramImage.setSize(Gdx.graphics.getWidth()/3 + 350, Gdx.graphics.getHeight()/2+350);
        stage.addActor(abramImage);

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

        mainMenuImg = new Texture("Text/MainMenu.png");
        mainMenuImage = new Image(mainMenuImg);
        mainMenuImage.setPosition(xMainmenu, yMainmenu);
        mainMenuImage.setSize(350, 350);
        stage.addActor(mainMenuImage);


        bulletImg = new Texture("Bullets/bullet.png");
        bulletImage = new Image(bulletImg);
        bulletImage.setPosition(xBullet, yBullet);
        bulletImage.setSize(20, 20);
        stage.addActor(bulletImage);




//        bulletImg = new Texture("Bullet.png");
//        bulletImage = new Image(bulletImg);
//        bulletImage.setPosition(xBullet, yBullet);
//        bulletImage.setSize(100, 100);
//        stage.addActor(bulletImage);






    }




    public void create () {

        abramSprite = new Sprite(abramImg);
        abramSprite.setSize(340,340);
        abramSprite.setPosition(xAbram,yAbram);

        groundSprite1 = new Sprite(groundImg1);
        groundSprite1.setSize(200,120);
        groundSprite1.setPosition(xGround1,yGround1);

        groundSprite2 = new Sprite(groundImg2);
        groundSprite2.setSize(200,120);
        groundSprite2.setPosition(xGround2,yGround2);

        groundSprite3 = new Sprite(groundImg3);
        groundSprite3.setSize(200,120);
        groundSprite3.setPosition(xGround3,yGround3);

        logoSprite = new Sprite(logoImg);
        logoSprite.setSize(200,200);
        logoSprite.setPosition(xLogo,yLogo);

        backgroundPurpleSprite = new Sprite(backGroundPurpleImg);
        backgroundPurpleSprite.setSize(800,600);
        backgroundPurpleSprite.setPosition(xPurpleBackground,yPurpleBackground);

        backgroundSprite = new Sprite(backgroundImg);
        backgroundSprite.setSize(800,600);
        backgroundSprite.setPosition(xMaroonBackground,yMaroonBackground);

        bulletSprite = new Sprite(bulletImg);
        bulletSprite.setSize(50,35);


        mainMenuSprite = new Sprite(mainMenuImg);
        mainMenuSprite.setSize(150,125);
        mainMenuSprite.setPosition(xMainmenu,yMainmenu);


        newGameButtonSprite = new Sprite(newGameButtonImg);
        newGameButtonSprite.setSize(135,60);
        newGameButtonSprite.setPosition(xNewgame,yNewgame);

        loadGameButtonSprite = new Sprite(loadGameButtonImg);
        loadGameButtonSprite.setSize(135,60);
        loadGameButtonSprite.setPosition(xLoadgame,yLoadgame);

        quitGameButtonSprite = new Sprite(quitGameButtonImg);
        quitGameButtonSprite.setSize(135,55);
        quitGameButtonSprite.setPosition(xQuitgame,yQuitgame);

        sideMenuSprite = new Sprite(sideMenuImg);
        sideMenuSprite.setSize(250,600);
        //skygradientSprite.setSize(250,600);
        sideMenuSprite.setPosition(xSkygradient,ySkygradient);



    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(stage);


//        Music menuMusic = Gdx.audio.newMusic(Gdx.files.internal("Audio/Storm - AShamaluevMusic.mp3"));
//        menuMusic.setLooping(true);
//        menuMusic.play();
//        menuMusic.setVolume(0.3f);


    }

    @Override
    public void render(float delta) {
        //set color of screen to space purple
        //ScreenUtils.clear(66F, 28F, 82F, 1);

        Gdx.gl.glClearColor(1, 1, 1, 1);

        //ScreenUtils.clear(0, 0, 0, 1);
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
