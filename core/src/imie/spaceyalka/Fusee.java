package imie.spaceyalka;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class Fusee extends SpaceYalkaObjectWithBody{




    public Fusee(World world) {
        super(  world,
                BodyDef.BodyType.DynamicBody,
                0,
                0,
                18,
                96,
                0.25f);
        texture = new Texture(Gdx.files.internal("core/assets/falcon-heavy-render.png"));
        sprite = new Sprite(texture);
        sprite.scale(0.5f);
        sprite.setPosition(Gdx.graphics.getWidth()/2 - 12, Gdx.graphics.getHeight()/2 - 64);
        body.getFixtureList().get(0).setRestitution(0);
    }

    public boolean decreaseMass(float delta){
        float newDensity ;
        if(((newDensity = body.getFixtureList().get(0).getDensity() - delta)) < 0f)
            body.getFixtureList().get(0).setDensity(0);
        else   body.getFixtureList().get(0).setDensity(newDensity);
        body.resetMassData();
        System.out.println(newDensity);
        return newDensity > 0;
    }



}
