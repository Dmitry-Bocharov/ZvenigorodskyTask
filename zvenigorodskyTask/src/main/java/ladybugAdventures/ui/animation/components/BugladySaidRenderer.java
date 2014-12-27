package ladybugAdventures.ui.animation.components;

import java.awt.Font;

import ladybugAdventures.util.Analizator;
import ladybugAdventures.util.ResourceProvider;

import org.eclipse.swt.graphics.Point;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

import ladybugAdventures.ui.animation.components.TextInformationRenderer;

public class BugladySaidRenderer extends AbstractComponent{

	private Point location;
	private Point size;
	private TextInformationRenderer text;
	private Image background;
	private Analizator messageProvider;
	private boolean visible;
	public BugladySaidRenderer(GUIContext container, Point location, Analizator analizator, int cellSize) throws SlickException {
		super(container);
		this.size = new Point(220, 60);
		this.location = location;
		text = new TextInformationRenderer(container, new Point(location.x+30, location.y + 10), "");
		text.init(container, new Font("Cambria", Font.ITALIC, 12));
		
//		text.setLocation(location.x+30, location.y + 40);
		background = new Image(ResourceProvider.getResInpStr(ResourceProvider.SAY),ResourceProvider.SAY,false);
	}

	@Override
	public void render(GUIContext container, Graphics g) throws SlickException {
		if(!visible)
			return;
		background.draw(location.x, location.y,size.x,size.y);
		text.setLocation(location.x+30, location.y + 10);
		text.render(container, g,Color.black);
		
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public void setLocation(int x, int y) {
		location = new Point(x, y);
	}
	@Override
	public int getX() {
		return location.x;
	}

	@Override
	public int getY() {
		return location.y;
	}

	@Override
	public int getWidth() {
		return size.x;
	}

	@Override
	public int getHeight() {
		return size.y;
	}
	public void setText(String text){
		this.text.setText(text);
	}
	
}
