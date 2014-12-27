package ladybugAdventures.ui.animation.components;

import ladybugAdventures.util.ResourceProvider;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

public class StartButtonRenderer extends org.newdawn.slick.gui.AbstractComponent{
	private int x,y;
	private Image unpressedImage;
//	private Image pressedImage;
	private Image drawbleImage;
	private boolean visible;
	private final int BOTTOM_SPACING = 20;
	
	
	public StartButtonRenderer(GUIContext container,int xpos, int ypos) throws SlickException {
		this(container);
		x = xpos;
		y = ypos;
		
	}
	public StartButtonRenderer(GUIContext container) throws SlickException {
		super(container);
		unpressedImage = new Image(ResourceProvider.getResInpStr(ResourceProvider.START_BUTTON),ResourceProvider.START_BUTTON, false);
//		pressedImage = new Image(ResourceProvider.getResInpStr(ResourceProvider.START_BUTTON_PRESSED_ID),ResourceProvider.START_BUTTON_PRESSED_ID, false);
		visible = true;
		drawbleImage = unpressedImage;
		x = container.getWidth()/2-getWidth()/2;
		y = container.getHeight()-getHeight()-BOTTOM_SPACING;
	}

	@Override
	public void render(GUIContext container, Graphics g) throws SlickException {
		if(visible)
			g.drawImage(drawbleImage, getX(), getY());
		
	}
	public boolean update(GUIContext container, int t){
		Input input = container.getInput();

        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            int clickedX = input.getMouseX();
            int clickedY = input.getMouseY();
            if( 	   clickedX >= this.x 
            		&& clickedX <= (this.x+getWidth()) 
            		&& clickedY >= this.y 
            		&& clickedY <= (this.y+getHeight())){
//            				drawbleImage = pressedImage;
            				visible = false;
            				return true;
            		}
        }
        return false;
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
		
		return unpressedImage.getWidth();
	}
	@Override
	public int getHeight() {
		return unpressedImage.getHeight();
	}
	public boolean isClicked(int x, int y){
		return false;
	}
	public void setVisible(boolean visible){
		this.visible = visible;
	}
}
