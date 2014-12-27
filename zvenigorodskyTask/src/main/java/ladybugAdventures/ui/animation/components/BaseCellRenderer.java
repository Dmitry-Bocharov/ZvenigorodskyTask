package ladybugAdventures.ui.animation.components;

import ladybugAdventures.enums.GameObject;
import ladybugAdventures.util.LazyRenderBuffer;
import ladybugAdventures.util.ResourceProvider;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

/**
 * Ячейка поля
 * @author Осипов Иван
 *
 */
public class BaseCellRenderer extends AbstractComponent {
	
	private int x,y,width,height;
	private Image image;
	public BaseCellRenderer(GUIContext container, int cellSize) throws SlickException {
		super(container);
		image = new Image(ResourceProvider.getResInpStr(ResourceProvider.EMPTY_CELL),
				ResourceProvider.EMPTY_CELL,false);
		this.width = cellSize;
		this.height = cellSize;
	}
	
	public BaseCellRenderer(GUIContext container,int cellSize, GameObject objectType) throws SlickException {
		super(container);
		image = LazyRenderBuffer.getImage(objectType);
		this.width = cellSize;
		this.height = cellSize;
	}
	
	@Override
	public void render(GUIContext container, Graphics g) throws SlickException {
		image.draw(x, y, width, height);
	}

	@Override
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
}
