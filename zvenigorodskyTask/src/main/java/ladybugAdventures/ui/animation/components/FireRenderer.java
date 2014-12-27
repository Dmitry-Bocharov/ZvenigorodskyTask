package ladybugAdventures.ui.animation.components;

import ladybugAdventures.util.ResourceProvider;

import org.eclipse.swt.graphics.Point;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

public class FireRenderer extends UniversalAnimationRenderer {
	public FireRenderer(GUIContext container, int size) throws SlickException {
		super(container,size);
		SpriteSheet fireFrames = new SpriteSheet(
				new Image(ResourceProvider.getResInpStr(ResourceProvider.FIRE_SPRITE),
						ResourceProvider.FIRE_SPRITE,false), 100, 108);
		sprite = new Animation(fireFrames, 50);
		sprite.setLooping(false);
		visible = false;
	}

	@Override
	public void render(GUIContext container, Graphics g) throws SlickException {
		super.render(container, g);
		if(sprite.isStopped()){
			setVisible(false);
		}
	}

}
