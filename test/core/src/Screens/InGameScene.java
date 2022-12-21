package Screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import Classes.*;


public class InGameScene implements Screen {
    private boolean DEBUG = false;
    private final float SCALE = 2.0f;
    private final float PPM = 32.0f;
    private Box2DDebugRenderer debugRenderer;


    private Stage stage;
    private MyGdxGame game;
    private SpriteBatch batch;
    private Texture tank1Texture,tank2Texture,bullet1Texture,bullet2Texture;
    private Texture backgroundTexture, groundTexture1,groundTexture2;
    private Texture healthBarTexture1, fuelBarTexture1, healthBarTexture2, fuelBarTexture2,logoTexture;
    private Image tank1Image, tank2Image,bullet1Image, bullet2Image;
    private Image backgroundImage, groundImage1,groundImage2;
    private Image healthBarImage1, fuelBarImage1, healthBarImage2, fuelBarImage2,logoImage;

    private OrthographicCamera camera;

    private World world;
    private Body player1,player2, bullet1, bullet2;
    private Body ground,leftWall,rightWall;
    private Tank tank1,tank2;
    private GroundObject groundObject;
    private BulletMine bulletMine1,bulletMine2;

    private boolean player1Turn = true;

    //New Game
    public InGameScene(MyGdxGame game, String typetank1, String typetank2) {
        this.game = game;
        //world and debugRenderer
        world = new World(new Vector2(0, -98.1f), false);
        debugRenderer = new Box2DDebugRenderer();
        this.world.setContactListener(new MyContactListener());
        stage = new Stage(new ScreenViewport());
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        //decrease air friction
//        world.setContactFilter(new ContactFilter() {
//            @Override
//            public boolean shouldCollide(Fixture fixtureA, Fixture fixtureB) {
//                if (fixtureA.getBody().getUserData() != null && fixtureA.getBody().getUserData().equals("bullet")) {
//                    fixtureA.setFriction(0);
//                }
//                if (fixtureB.getBody().getUserData() != null && fixtureB.getBody().getUserData().equals("bullet")) {
//                    fixtureB.setFriction(0);
//                }
//                return true;
//            }
//        });

        //add a button to go back to the main menu


        //camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false,  w/SCALE, h/SCALE);



        //players and tanks
        //player1 = createBox(-400,-100,54,28,false);
        //bullet1 = createBox(-400,-400,10,10,false);
        TankFactory tankFactory = new TankFactory();
        tank1 = tankFactory.generateTank(world,-400,-100,54,28,typetank1); tank1.resetFuel();
        tank2 = tankFactory.generateTank(world,0,-100,54,28,typetank2); tank2.resetFuel();
        //player2 = createBox(400,100,54,28,false);

        bulletMine1 = new BulletMine(world,-400,-400,10,10);
        bulletMine2 = new BulletMine(world,-400,-400,10,10);



        //GroundObject groundObject = GroundObject.getInstance(world,0,-202,1280,102, true);

        //create ground
        ground = createBox(0, -202, 1280, 102, true);
        //add friction to ground
        ground.getFixtureList().get(0).setFriction(0.5f);
        //create left wall and right wall
        leftWall = createBox(-470, 0, 32, 720, true);
        rightWall = createBox(470, 0, 32, 720, true);


        batch = new SpriteBatch();

        //depending on the type of tank and bullet, the texture is loaded
        TankTextureFactory tankTextureFactory = new TankTextureFactory();
        tank1Texture = tankTextureFactory.generateTankTexture(typetank1);
        tank2Texture = tankTextureFactory.generateTankTexture2(typetank2);
        BulletTextureFactory bulletTextureFactory = new BulletTextureFactory();
        bullet1Texture = bulletTextureFactory.generateBulletTexture(typetank1);
        bullet2Texture = bulletTextureFactory.generateBulletTexture2(typetank2);


        tank1Texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        tank2Texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        tank1Image = new Image(tank1Texture);
        tank2Image = new Image(tank2Texture);
        bullet1Image = new Image(bullet1Texture);
        bullet2Image = new Image(bullet2Texture);

        tank1Image.setSize(60,60);
        tank2Image.setSize(60,60);
//        if(typetank1.equals("Spectre")){
//            tank1Image.setSize(70,50);
//        }
//        if(typetank2.equals("Spectre")){
//            tank2Image.setSize(70,50);
//        }
        bullet1Image.setSize(10,10);
        bullet2Image.setSize(10,10);

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

        healthBarTexture1 = new Texture("InGameStuffOther/h1.png");
        healthBarImage1 = new Image(healthBarTexture1);
        healthBarImage1.setSize(400, 60);
        healthBarImage1.setPosition(40, 850);
        stage.addActor(healthBarImage1);
        fuelBarTexture1 = new Texture("InGameStuffOther/f2.png");
        fuelBarImage1 = new Image(fuelBarTexture1);
        fuelBarImage1.setSize(200, 50);
        fuelBarImage1.setPosition(40, 750);
        stage.addActor(fuelBarImage1);

        healthBarTexture2 = new Texture("InGameStuffOther/h1.png");
        healthBarImage2 = new Image(healthBarTexture2);
        healthBarImage2.setSize(400, 60);
        healthBarImage2.setPosition(1350, 850);
        stage.addActor(healthBarImage2);
        fuelBarTexture2 = new Texture("InGameStuffOther/f2.png");
        fuelBarImage2 = new Image(fuelBarTexture2);
        fuelBarImage2.setSize(200, 50);
        fuelBarImage2.setPosition(1550, 750);
        stage.addActor(fuelBarImage2);

        logoTexture = new Texture("Tank_Stars_Logo_nobg.png");
        logoImage = new Image(logoTexture);
        logoImage.setSize(200, 200);
        logoImage.setPosition(780, 780);
        stage.addActor(logoImage);




    }
    //Resume Game
    public InGameScene(MyGdxGame game, Tank tank1, Tank tank2, Texture healthBar1, Texture healthBar2, Texture fuelBar1, Texture fuelBar2) {
        this.game = game;
        //world and debugRenderer
        world = new World(new Vector2(0, -98.1f), false);
        debugRenderer = new Box2DDebugRenderer();
        this.world.setContactListener(new MyContactListener());
        stage = new Stage(new ScreenViewport());
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();



        //camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false,  w/SCALE, h/SCALE);



        TankFactory tankFactory = new TankFactory();
        this.tank1 = tank1;
        this.tank2 = tank2;
        this.tank1.setWorld(world);
        this.tank2.setWorld(world);
        tank1.resetFuel(); //reset fuel
        tank2.resetFuel(); //reset fuel
        String typetank1 = tank1.getTankType();
        String typetank2 = tank2.getTankType();
        //player2 = createBox(400,100,54,28,false);

        bulletMine1 = new BulletMine(world,-400,-400,10,10);
        bulletMine2 = new BulletMine(world,-400,-400,10,10);



        //GroundObject groundObject = GroundObject.getInstance(world,0,-202,1280,102, true);

        //create ground
        ground = createBox(0, -202, 1280, 102, true);
        //add friction to ground
        ground.getFixtureList().get(0).setFriction(0.5f);
        //create left wall and right wall
        leftWall = createBox(-470, 0, 32, 720, true);
        rightWall = createBox(470, 0, 32, 720, true);


        batch = new SpriteBatch();

        //depending on the type of tank and bullet, the texture is loaded
        TankTextureFactory tankTextureFactory = new TankTextureFactory();
        tank1Texture = tankTextureFactory.generateTankTexture(typetank1);
        tank2Texture = tankTextureFactory.generateTankTexture2(typetank2);
        BulletTextureFactory bulletTextureFactory = new BulletTextureFactory();
        bullet1Texture = bulletTextureFactory.generateBulletTexture(typetank1);
        bullet2Texture = bulletTextureFactory.generateBulletTexture2(typetank2);


        tank1Texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        tank2Texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        tank1Image = new Image(tank1Texture);
        tank2Image = new Image(tank2Texture);
        bullet1Image = new Image(bullet1Texture);
        bullet2Image = new Image(bullet2Texture);

        tank1Image.setSize(60,60);
        tank2Image.setSize(60,60);
//        if(typetank1.equals("Spectre")){
//            tank1Image.setSize(70,50);
//        }
//        if(typetank2.equals("Spectre")){
//            tank2Image.setSize(70,50);
//        }
        bullet1Image.setSize(10,10);
        bullet2Image.setSize(10,10);

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


        healthBarImage1 = new Image(healthBar1);
        healthBarImage1.setSize(400, 60);
        healthBarImage1.setPosition(40, 850);
        stage.addActor(healthBarImage1);
        fuelBarTexture1 = new Texture("InGameStuffOther/f2.png");
        fuelBarImage1 = new Image(fuelBarTexture1);
        fuelBarImage1.setSize(200, 50);
        fuelBarImage1.setPosition(40, 750);
        stage.addActor(fuelBarImage1);


        healthBarImage2 = new Image(healthBar2);
        healthBarImage2.setSize(400, 60);
        healthBarImage2.setPosition(1350, 850);
        stage.addActor(healthBarImage2);
        fuelBarTexture2 = new Texture("InGameStuffOther/f2.png");
        fuelBarImage2 = new Image(fuelBarTexture2);
        fuelBarImage2.setSize(200, 50);
        fuelBarImage2.setPosition(1550, 750);
        stage.addActor(fuelBarImage2);

        logoTexture = new Texture("Tank_Stars_Logo_nobg.png");
        logoImage = new Image(logoTexture);
        logoImage.setSize(200, 200);
        logoImage.setPosition(780, 780);
        stage.addActor(logoImage);




    }

    private Body createBody(ChainShape groundShape, int i, int i1, boolean b) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(i, i1);
        Body body = world.createBody(bodyDef);
        body.createFixture(groundShape, 0.0f);
        groundShape.dispose();
        return body;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(Gdx.graphics.getDeltaTime());
        ScreenUtils.clear(0, 0, 0.2f, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //stage for static images
        stage.act(delta);
        stage.draw();

        //batch for dynamic images
        batch.begin();

        //draw tank1Image
        tank1Image.setPosition(tank1.getBody().getPosition().x * PPM - 28, tank1.getBody().getPosition().y * PPM - 28);
        tank1Image.draw(batch, 1);
        //draw tank2Image
        tank2Image.setPosition(tank2.getBody().getPosition().x * PPM - 28, tank2.getBody().getPosition().y * PPM - 28);
        tank2Image.draw(batch, 1);

        //draw bullet1Image
        bullet1Image.setPosition(bulletMine1.getBody().getPosition().x * PPM - 5, bulletMine1.getBody().getPosition().y * PPM - 5);
        bullet1Image.draw(batch, 1);
        //draw bullet2Image
        bullet2Image.setPosition(bulletMine2.getBody().getPosition().x * PPM - 5, bulletMine2.getBody().getPosition().y * PPM - 5);
        bullet2Image.draw(batch, 1);


        batch.end();
        debugRenderer.render(world, camera.combined.scl(PPM));
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width/SCALE, height/SCALE);

    }

    public void update(float delta) {
        world.step(1/60f, 6, 2);
        inputUpdate(delta);
        cameraUpdate(delta);
        batch.setProjectionMatrix(camera.combined);
    }

    public void inputUpdate(float delta) {

        //get position of tank1 in screen coordinates
        Vector3 tank1Pos = camera.project(new Vector3(tank1.getBody().getPosition().x-0.9F, tank1.getBody().getPosition().y-0.9F, 0));
        //get position of tank2 in screen coordinates
        Vector3 tank2Pos = camera.project(new Vector3(tank2.getBody().getPosition().x-0.9F, tank2.getBody().getPosition().y-0.9F, 0));
        tank1.getPosition().setX(tank1Pos.x); tank1.getPosition().setY(tank1Pos.y);
        tank2.getPosition().setX(tank2Pos.x); tank2.getPosition().setY(tank2Pos.y);


        //if escape is pressed, go to the pause menu
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            game.setScreen(new PauseScreen(game,tank1,tank2,healthBarTexture1,healthBarTexture2,fuelBarTexture1,fuelBarTexture2));
        }

        if (player1Turn == true) {
            float horizontalForce = 0F;
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && tank1.getFuel() > 0) {
                horizontalForce -= 1;
                tank1.reduceFuelBy1();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && tank1.getFuel() > 0) {
                horizontalForce += 1;
                tank1.reduceFuelBy1();
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                //change bullet1's position to corner of tank1's turret
                bulletMine1.getBody().setTransform(tank1.getBody().getPosition().x + 1, tank1.getBody().getPosition().y + 1, 0);
                //shoot bullet1 in direction of tank1's turret
                bulletMine1.getBody().applyLinearImpulse(20F, 5F, bulletMine1.getBody().getPosition().x, bulletMine1.getBody().getPosition().y, true);

                //make the bullet fall under gravity
                bulletMine1.getBody().setGravityScale(1);
                //shoot bullet1 in direction of tank1's turret with 20F force
                bulletMine1.getBody().applyLinearImpulse(new Vector2(0, 5), bulletMine1.getBody().getWorldCenter(), true);

                player1Turn = false;
                tank2.resetFuel();

            }
            //apply force to player1
            tank1.getBody().applyForceToCenter(horizontalForce * 100, 0, true);

        } else {
            float horizontalForce = 0F;
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && tank2.getFuel() > 0) {
                horizontalForce -= 1;
                tank2.reduceFuelBy1();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && tank2.getFuel() > 0) {
                horizontalForce += 1;
                tank2.reduceFuelBy1();
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                //change bullet2's position to corner of tank2's turret
                bulletMine2.getBody().setTransform(tank2.getBody().getPosition().x + 1, tank2.getBody().getPosition().y + 1, 0);
                //shoot bullet2 in the direction of tank2's turret along a parabola
                bulletMine2.getBody().applyLinearImpulse(-20F, 0F, bulletMine2.getBody().getPosition().x, bulletMine2.getBody().getPosition().y, false);
                player1Turn = true;
                tank1.resetFuel();
            }
            //apply force to player1
            tank2.getBody().applyForceToCenter(horizontalForce * 100, 0, true);



        }

        if (bulletMine1.collideWithEdge() == true) {
            world.destroyBody(bulletMine1.getBody());
            bulletMine1 = new BulletMine(world, -400, -400, 10, 10);
        }

        //if bullet is close to ground, destroy it
        if (bulletMine2.collideWithEdge() == true) {
//            bulletMine2.getBody().setTransform(-450, 0, 0);
            world.destroyBody(bulletMine2.getBody());
            bulletMine2 = new BulletMine(world, -400, -400, 10, 10);
        }


        if (bulletMine1.collideWithTank(tank2) == true){
//            bulletMine1.getBody().setTransform(-450, 0, 0);
            world.destroyBody(bulletMine1.getBody());
            bulletMine1 = new BulletMine(world, -400, -400, 10, 10);

            //tank2 loses health and health bar decreases
            tank2.setHealth(tank2.getHealth() - 1);
            healthBarImage2.remove();
            HealthBarFactory healthBarFactory2 = new HealthBarFactory();
            healthBarTexture2 = healthBarFactory2.generateHealthBarTexture(tank2, tank2.getTankType(),tank2.getHealth());
            healthBarImage2 = new Image(healthBarTexture2);
            healthBarImage2.setSize(400, 60);
            healthBarImage2.setPosition(1350, 850);
            stage.addActor(healthBarImage2);

        }


        //if bullet is close to tank2, destroy it
        if (bulletMine2.collideWithTank(tank1) == true){
            world.destroyBody(bulletMine2.getBody());
            bulletMine2 = new BulletMine(world, -400, -400, 10, 10);

            //tank1 loses health and health bar decreases
            tank1.setHealth(tank1.getHealth() - 1);
            healthBarImage1.remove();
            HealthBarFactory healthBarFactory1 = new HealthBarFactory();
            healthBarTexture1 = healthBarFactory1.generateHealthBarTexture(tank1,tank1.getTankType(),tank1.getHealth());
            healthBarImage1 = new Image(healthBarTexture1);
            healthBarImage1.setSize(400, 60);
            healthBarImage1.setPosition(40, 850);
            stage.addActor(healthBarImage1);
        }

        if(tank1.isAlive() == false){
            //return to main menu
            System.out.println("Player 2 wins!");
            game.setScreen(new MainMenuScreen(game));
        }
        if(tank2.isAlive() == false){
            //return to main menu
            System.out.println("Player 1 wins!");
            game.setScreen(new MainMenuScreen(game));
        }
    }

    public void cameraUpdate(float delta) {
        //fixing the camera
        camera.position.set(0, 0, 0);
        camera.update();
    }

    public Body createBox(int x, int y, int width, int height, boolean isStatic) {
        Body body;
        BodyDef bodyDef = new BodyDef();
        if(isStatic) {
            bodyDef.type = BodyDef.BodyType.StaticBody;
        }
        else {
            bodyDef.type = BodyDef.BodyType.DynamicBody;
        }
        bodyDef.position.set(x/PPM, y/PPM);
        bodyDef.fixedRotation = true;
        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width/2/PPM, height/2/PPM);

        body.createFixture(shape, 1.0f);
        shape.dispose();

        return body;
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
        world.dispose();
        debugRenderer.dispose();
        batch.dispose();
    }

}
