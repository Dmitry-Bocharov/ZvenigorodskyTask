package ladybugAdventures.ui.animation.components;

import ladybugAdventures.util.ResourceProvider;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

public class UniversalAnimationRenderer extends AbstractComponent {
	protected int x,y,width,height;
	protected Animation sprite;
	protected boolean visible;
	public UniversalAnimationRenderer(GUIContext container, int size) throws SlickException {
		super(container);
		width = size;
		height = size;
		x = 0;
		y = 0;
		visible = false;
	}
	public void setFrameSpeed(float speed){
		sprite.setSpeed(speed);
	}
	public void setRepeated(boolean repeated){
		sprite.setLooping(repeated);
	}
	@Override
	public void render(GUIContext container, Graphics g) throws SlickException {
		if(!visible || sprite == null)
			return;
		sprite.draw(x, y, width, height);
	}
	public void stop(){
		if(sprite!=null)
			sprite.stop();
	}
	@Override
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;

	}
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
		if(visible  && sprite!=null)
			sprite.restart();
	}
	public void restart(){
		if(sprite!=null)
			sprite.restart();
	}
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

}
