package JUnitTest;

import Classes.*;

//import all the classes that you want to test
import org.junit.*;

public class Test1 {

    @Test
    void show(){
        //test if 1 + 1 = 2
        Tank tank = new Tank(1,1,1,1,"Abrams",1,1);
        //test tank.reduceFuel()
        tank.reduceFuelBy1();
        Assert.assertEquals(0, tank.getFuel());
    }
    @Test
    void show1(){
        Tank tank = new Tank(1,1,1,1,"Abrams",1,1);
        //reset fuel to max
        tank.resetFuel();
        Assert.assertEquals(200, tank.getFuel());
    }
}
