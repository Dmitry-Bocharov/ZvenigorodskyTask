package ladybugAdventures.ui.animation;

import ladybugAdventures.util.ResourceProvider;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.Drawable;
import org.lwjgl.opengl.SharedDrawable;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.loading.LoadingList;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class SplashScreen extends BasicGameState {
	Image splash;
	private final int DALAY = 3000;
	private int elapsedTime = 0;
	private final int ID;
	public SplashScreen(int id){
		ID = id;
	}
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		splash = new Image(ResourceProvider.getResInpStr(ResourceProvider.SPLASH),
				ResourceProvider.SPLASH,false);
		LoadingList.setDeferredLoading( true );
	   
			   
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
//		LoadingList.setDeferredLoading( false );
		splash.draw(0,0,1900, 1060);
		LoadingList.setDeferredLoading( false );
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
//		splash.update(delta);
//		System.out.println(LoadingList.get().getRemainingResources());
		if(LoadingList.get().getRemainingResources()==0){
			game.enterState(1);
		}

	}

	@Override
	public int getID() {
		return ID;
	}

}
