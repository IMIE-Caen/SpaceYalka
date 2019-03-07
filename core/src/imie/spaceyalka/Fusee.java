package imie.spaceyalka;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class Fusee extends SpaceYalkaObjectWithBody{

    public Fusee(World world) {
        super(  world,
                BodyDef.BodyType.DynamicBody,
                0,
                0,
                10,
                100,
                0.2f);

    }


}
