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


public class MainMenuScreen implements Screen {

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
    public MainMenuScreen(final Game game) {
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




        final Button newgameButton = new TextButton("New Game",mySkin,"small");
        //take input
        Gdx.input.setInputProcessor(stage);
        float newgamecol_width = Gdx.graphics.getWidth()/6+75;
        float newgamerow_height = Gdx.graphics.getHeight()/3+200;
        newgameButton.setSize(newgamecol_width,newgamerow_height/6);

        float newgamex = newgamecol_width+925; //center button in the middle of the screen
        float newgamey = Gdx.graphics.getHeight()/2 - newgamerow_height/2+250;
        newgameButton.setPosition(newgamex,newgamey);
        newgameButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
//                outputLabel.setText("Press a Button");
                game.setScreen(new TankSelectionScreen(game));

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
//                outputLabel.setText("Pressed Text Button");
                //change button color to blue
                newgameButton.setColor(0,0,1,1);
                return true;
            }
        });
        stage.addActor(newgameButton);

        final Button loadgameButton = new TextButton("Load Game",mySkin,"small");
        float loadgamecol_width = Gdx.graphics.getWidth()/6+75;
        float loadgamerow_height = Gdx.graphics.getHeight()/3+200;
        loadgameButton.setSize(loadgamecol_width,loadgamerow_height/6);

        float loadgamex = loadgamecol_width+925; //center button in the middle of the screen
        float loadgamey = Gdx.graphics.getHeight()/2 - loadgamerow_height/2+50;
        loadgameButton.setPosition(loadgamex,loadgamey);
        loadgameButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new LoadGameScreen(game));

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

                loadgameButton.setColor(0,0,1,1);
                return true;
            }
        });
        stage.addActor(loadgameButton);

        final Button quitgameButton = new TextButton("Quit Game",mySkin,"small");
        float quitgamecol_width = Gdx.graphics.getWidth()/6+75;
        float quitgamerow_height = Gdx.graphics.getHeight()/3+200;
        quitgameButton.setSize(quitgamecol_width,quitgamerow_height/6);

        float quitgamex = quitgamecol_width+925; //center button in the middle of the screen
        float quitgamey = Gdx.graphics.getHeight()/2 - quitgamerow_height/2-150;
        quitgameButton.setPosition(quitgamex,quitgamey);
        quitgameButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
//                outputLabel.setText("Press a Button");
                  Gdx.app.exit();

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
//                outputLabel.setText("Pressed Text Button");
                //change button color to blue
                quitgameButton.setColor(0,0,1,1);
                return true;
            }
        });
        stage.addActor(quitgameButton);






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
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //ScreenUtils.clear(0, 0, 0, 1);
        stage.act(delta);
        stage.draw();

        //stage.addActor(new Image(backgroundImg));
//        batch.begin();
        //game.batch.draw(backgroundpurpleImg, xPurpleBackground, yPurpleBackground);

//        backgroundPurpleSprite.draw(batch);
//        backgroundSprite.draw(batch);
//        sideMenuSprite.draw(batch);
//        abramSprite.draw(batch);
//        groundSprite1.draw(batch);
//        groundSprite2.draw(batch);
//        groundSprite3.draw(batch);
//        logoSprite.draw(batch);
//
//        bulletSprite.draw(batch);
//        mainMenuSprite.draw(batch);
//        newGameButtonSprite.draw(batch);
//        loadGameButtonSprite.draw(batch);
//        quitGameButtonSprite.draw(batch);




//        game.batch.draw(backgroundmaroonImg, xMaroonBackground, yMaroonBackground);
//
//        game.batch.draw(abramImg, xAbram, yAbram);
//        game.batch.draw(groundImg1, xGround1, yGround1);
//        game.batch.draw(groundImg2, xGround2, yGround2);
//        game.batch.draw(getGroundImg3, xGround3, yGround3);
//        game.batch.draw(logoImg, xLogo, yLogo);
//
//        game.batch.draw(skygradientImg, xSkygradient, ySkygradient);
//        game.batch.draw(mainmenuImg, xMainmenu, yMainmenu);
//        game.batch.draw(newgamebuttonImg, xNewgame, yNewgame);
//        game.batch.draw(loadgamebuttonImg, xLoadgame, yLoadgame);
//        game.batch.draw(quitgamebuttonImg, xQuitgame, yQuitgame);
//        game.batch.draw(bulletImg, xBullet, yBullet);


//        //make the bullet disappear after 1 second
//        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
//            if(xBullet==325){
//                flag = 1;
//                long id = bulletSound.play(0.3f);
//                bulletSound.setPitch(id, 1);
//                bulletSound.setLooping(id, false);
//            }
//        }
//
//        if(flag==1) {
//            xBullet += 4;
//        }
//        if (xBullet > 730) {
//            xBullet = 325;
//            flag = 0;
//        }
//
//        bulletSprite.setPosition(xBullet,yBullet);
//
//        batch.end();



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
//        img.dispose();
//        abramImg.dispose();
//        groundImg1.dispose();
//        groundImg2.dispose();
//        groundImg3.dispose();
//        logoImg.dispose();
//        backGroundPurpleImg.dispose();
//        backgroundImg.dispose();
//        bulletImg.dispose();
//        mainMenuImg.dispose();
//        newGameButtonImg.dispose();
//        loadGameButtonImg.dispose();
//        quitGameButtonImg.dispose();
//        sideMenuImg.dispose();
//        bulletSound.dispose();
//        //stage.dispose();
//        batch.dispose();
        stage.dispose();

    }
}
