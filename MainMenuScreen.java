package Screens;
//package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
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
    Texture img, abramImg, groundImg1,groundImg2, groundImg3, logoImg, backGroundPurpleImg, backgroundImg, bulletImg, mainMenuImg, sideMenuImg;
    Texture newGameButtonImg, loadGameButtonImg, quitGameButtonImg;


    Sprite abramSprite, groundSprite1, groundSprite2, groundSprite3, logoSprite, backgroundPurpleSprite, backgroundSprite, bulletSprite, mainMenuSprite, sideMenuSprite;
    Sprite newGameButtonSprite, loadGameButtonSprite, quitGameButtonSprite;
    SpriteBatch batch = new SpriteBatch();

    //add a button
    //private Button button;
    private Skin skin;
    private TextureAtlas buttonAtlas;
    private TextButton.TextButtonStyle textButtonStyle;
    private BitmapFont font;

    private Game game;
    public MainMenuScreen(Game game) {
        this.game = game;
    }

    float xAbram = 10; float yAbram = 18;
    float xGround1 = 0;float yGround1 = -10;
    float xGround2 = 100;float yGround2 = -10;
    float xGround3 = 200;float yGround3 = -10;
    float xLogo = 70;float yLogo = 275;
    float xPurpleBackground = 0;float yPurpleBackground = 0;
    float xMaroonBackground = -100;float yMaroonBackground = 0;
    float xBullet = 325;float yBullet = 195;
    float xMainmenu = 450;float yMainmenu = 335;
    float xNewgame = 460;float yNewgame = 245;
    float xLoadgame = 460;float yLoadgame = 145;
    float xQuitgame = 460;float yQuitgame = 45;
    float xSkygradient = 400;float ySkygradient =0;


    public void create () {
        myTexture = new Texture(Gdx.files.internal("NewGameButton1.png"));
        myTextureRegion = new TextureRegion(myTexture);
        myTexRegionDrawable = new TextureRegionDrawable(myTextureRegion);
        button = new ImageButton(myTexRegionDrawable); //Set the button up

        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(button); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stage);


    }

    @Override
    public void show() {

//        stage = new Stage(new ScreenViewport());
//        Gdx.input.setInputProcessor(stage);
//        int Help_Guides = 12;
//        int row_height = Gdx.graphics.getWidth() / 12;
//        int col_width = Gdx.graphics.getWidth() / 12;
//
//        //Skin mySkin = new Skin(Gdx.files.internal("glassy-ui.json"));
//        Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
//        Label title = new Label("Buttons with Skins",mySkin,"big-black");
//        title.setSize(Gdx.graphics.getWidth(),row_height*2);
//        title.setPosition(0,Gdx.graphics.getHeight()-row_height*2);
//        title.setAlignment(Align.center);
//        stage.addActor(title);
//
//        // Button
//        Button button1 = new Button(mySkin,"small");
//        button1.setSize(col_width*4,row_height);
//        button1.setPosition(col_width,Gdx.graphics.getHeight()-row_height*3);
//        button1.addListener(new InputListener(){
//            @Override
//            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
//                outputLabel.setText("Press a Button");
//            }
//            @Override
//            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
//                outputLabel.setText("Pressed Button");
//                return true;
//            }
//        });
//        stage.addActor(button1);
//
//        // Text Button
//        Button button2 = new TextButton("Text Button",mySkin,"small");
//        button2.setSize(col_width*4,row_height);
//        button2.setPosition(col_width*7,Gdx.graphics.getHeight()-row_height*3);
//        button2.addListener(new InputListener(){
//            @Override
//            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
//                outputLabel.setText("Press a Button");
//            }
//            @Override
//            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
//                outputLabel.setText("Pressed Text Button");
//                return true;
//            }
//        });
//        stage.addActor(button2);
//
//        outputLabel = new Label("Press a Button",mySkin,"black");
//        outputLabel.setSize(Gdx.graphics.getWidth(),row_height);
//        outputLabel.setPosition(0,row_height);
//        outputLabel.setAlignment(Align.center);
//        stage.addActor(outputLabel);


        //img = new Texture("badlogic.jpg");

//        Gdx.input.setInputProcessor(new InputAdapter() {
//            @Override
//            public boolean keyDown(int keyCode) {
//                if (keyCode == Input.Keys.SPACE) {
//                    game.setScreen(new TankSelectionScreen(game));
//                }
//                return true;
//            }
//        });


        abramImg = new Texture("Tanks/Abrams_nobg.png");
        groundImg1 = new Texture("Ground.jpg");
        groundImg2 = new Texture("Ground.jpg");
        groundImg3 = new Texture("Ground.jpg");
        logoImg = new Texture("Tank_Stars_Logo_nobg.png");
        backGroundPurpleImg = new Texture("PurpleBackgrounds/Purplebg1.jpeg");
        backgroundImg = new Texture("Backgrounds/M1.jpeg");
        bulletImg = new Texture("Bullets/bullet.png");
        mainMenuImg = new Texture("Text/MainMenu.png");
        newGameButtonImg = new Texture("Buttons/NewGameButton1.png");
        loadGameButtonImg = new Texture("Buttons/LoadGameButton1.png");
        quitGameButtonImg = new Texture("Buttons/QuitGameButton1.png");
        sideMenuImg = new Texture("Backgrounds/SideMenu.png");

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


        //if (Gdx.input.isTouched())  then change to TankSelectScreen
        //if (Gdx.input.isTouched())  then change to LoadGameScreen

//        if(Gdx.input.isKeyPressed(Input.Keys.E)){
//            game.setScreen(new TankSelectionScreen(game));
//            dispose();
//        }
//
//        SimpleButton newgamebutton = new SimpleButton(newgamebuttonImg, xNewgame, yNewgame, 135, 60) {
//            //@Override
//            public void action() {
//                game.setScreen(new TankSelectionScreen(game));
//                dispose();
//            }
//        };
//        boolean a = newgamebutton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY());
//        if(a){
//            //set screen to TankSelectionScreen
//            game.setScreen(new TankSelectionScreen(game));
//            dispose();
//        }


        //stage.act(Gdx.graphics.getDeltaTime());
        //stage.draw();

//        loadgamebuttonSprite = new Sprite(loadgamebuttonImg);
//        loadgamebuttonSprite.setPosition(xLoadgame, yLoadgame);
//        loadgamebuttonSprite.setSize(200, 50);


//        Music menuMusic = Gdx.audio.newMusic(Gdx.files.internal("Storm - AShamaluevMusic.mp3"));
//        menuMusic.setLooping(true);
//        menuMusic.play();
//        menuMusic.setVolume(0.3f);


    }

    @Override
    public void render(float delta) {
        //set color of screen to space purple
        //ScreenUtils.clear(66F, 28F, 82F, 1);

//        Gdx.gl.glClearColor(1, 1, 1, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        ScreenUtils.clear(0, 0, 0, 1);

        //stage.addActor(new Image(backgroundImg));
        batch.begin();
        //game.batch.draw(backgroundpurpleImg, xPurpleBackground, yPurpleBackground);

        backgroundPurpleSprite.draw(batch);
        backgroundSprite.draw(batch);
        sideMenuSprite.draw(batch);
        abramSprite.draw(batch);
        groundSprite1.draw(batch);
        groundSprite2.draw(batch);
        groundSprite3.draw(batch);
        logoSprite.draw(batch);

        bulletSprite.draw(batch);
        mainMenuSprite.draw(batch);
        newGameButtonSprite.draw(batch);
        loadGameButtonSprite.draw(batch);
        quitGameButtonSprite.draw(batch);




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


        //make the bullet disappear after 1 second
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            if(xBullet==325){
                flag = 1;
                long id = bulletSound.play(0.3f);
                bulletSound.setPitch(id, 1);
                bulletSound.setLooping(id, false);
            }
        }

        if(flag==1) {
            xBullet += 4;
        }
        if (xBullet > 730) {
            xBullet = 325;
            flag = 0;
        }

        bulletSprite.setPosition(xBullet,yBullet);

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
        abramImg.dispose();
        groundImg1.dispose();
        groundImg2.dispose();
        groundImg3.dispose();
        logoImg.dispose();
        backGroundPurpleImg.dispose();
        backgroundImg.dispose();
        bulletImg.dispose();
        mainMenuImg.dispose();
        newGameButtonImg.dispose();
        loadGameButtonImg.dispose();
        quitGameButtonImg.dispose();
        sideMenuImg.dispose();
        bulletSound.dispose();
        //stage.dispose();
        batch.dispose();
    }
}
