package imie.spaceyalka;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class SpaceYalka extends ApplicationAdapter {
	// imports copié-collés
	World world; OrthographicCamera cam; Box2DDebugRenderer debugRenderer;

	Fusee fusee ; // on prépare une référence de fusée
				  // qu'on va réutiliser pendant le "jeu"

	@Override
	public void create () {

		// On s'en fiche :
		world = new World(new Vector2(0,-10f), true);
		cam = new OrthographicCamera(320,240);
		debugRenderer = new Box2DDebugRenderer(true,true,true,true,true,true);


		// On crée la fusée
		fusee = new Fusee(world);		  // le plus important
		// On crée le sol
		new Ground(world); // pas besoin de référence
										  // au sol ultérieurement
	}

	@Override
	public void render () {

		// On s'en fiche :
		world.step(Gdx.graphics.getDeltaTime(), 3, 3);
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		debugRenderer.render(world, cam.combined);



		cam.position.set(fusee.getBody().getPosition().x, fusee.getBody().getPosition().y, 0);
		cam.update();

		// La logique de jeu "controller" commence ici
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			fusee.getBody().applyForceToCenter(0, 20000, true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			fusee.getBody().applyForceToCenter(-2000, 0, true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			fusee.getBody().applyForceToCenter(2000, 0, true);
		}
	}
	
	@Override
	public void dispose () {
	}
}
