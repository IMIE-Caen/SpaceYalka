package imie.spaceyalka;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class Ground extends SpaceYalkaObjectWithBody{
    public Ground(World world) {

            super(  world,
                    BodyDef.BodyType.StaticBody,
                    0,
                    -100,
                    50,
                    3,
                    0f);


    }



}
