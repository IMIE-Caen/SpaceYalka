package imie.spaceyalka;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class SpaceYalkaObjectWithBody {
    Body body;

    // Cette classe utilitaire maison regroupe
    // pas mal de choses communes aux objets Box2d qu'on utilise


    public Body getBody(){
        return body;
    }
    public SpaceYalkaObjectWithBody(World world, BodyDef.BodyType bodyType, long centerX, long centerY, long width, long height, float density){

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = bodyType; // défini dans les constructeurs des
        // classes enfant
        bodyDef.position.set(centerX,centerY);

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width, height);
        body.createFixture(shape,density);
        shape.dispose();
    }
}
