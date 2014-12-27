package ladybugAdventures.util;

import ladybugAdventures.enums.Behaviour;
import ladybugAdventures.enums.Direction;
import ladybugAdventures.enums.GameObject;
import ladybugAdventures.ui.animation.components.BaseCellRenderer;
import ladybugAdventures.ui.animation.components.GameFieldRenderer;
import ladybugAdventures.ui.animation.components.LadybugRenderer;

import org.eclipse.swt.graphics.Point;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

public class MoveRenderElement {
	public Point source;
	public Point current;
	public Point result;
//	public Animation sprite;
	public AbstractComponent element;
	private boolean animating;
	public MoveRenderElement(StepTrack data, GameFieldRenderer gameField, GUIContext container, Analizator analizator) throws SlickException {

		this.source = new Point(gameField.getRenderPosX() + data.getStartPosition().x*gameField.getCellSize(),
				gameField.getRenderPosY() + data.getStartPosition().y*gameField.getCellSize());
		
		this.current = new Point(gameField.getRenderPosX() + data.getStartPosition().x*gameField.getCellSize(),
				gameField.getRenderPosY() + data.getStartPosition().y*gameField.getCellSize());
		
		this.result = new Point(gameField.getRenderPosX() + data.getFinishPosition().x*gameField.getCellSize(),
				gameField.getRenderPosY() + data.getFinishPosition().y*gameField.getCellSize());
		
		if(data.getGameObject()==GameObject.LADYBUG){
			int deltaX, deltaY;
			deltaX = data.getFinishPosition().x-data.getStartPosition().x;
			deltaY = data.getFinishPosition().y-data.getStartPosition().y;
			Direction direction = Direction.UP;
			if(deltaX>0){
				direction = Direction.RIGHT;
			}
			else{
				if(deltaX<0){
					direction = Direction.LEFT;
				}
				else
					if(deltaY>0)
						direction = Direction.DOWN;
			}
			element = new LadybugRenderer(container,gameField.getCellSize());
			LadybugRenderer ladybug = ((LadybugRenderer)element);
			ladybug.setDirection(direction);
			ladybug.setBehaviour(analizator.getCurrentBehaviour());
			ladybug.setLocation(current.x, current.y);
		}
		else{
			if(data.getGameObject()==GameObject.BLOCK){
				element = new BaseCellRenderer(container, gameField.getCellSize(),GameObject.BLOCK);
				element.setLocation(current.x, current.y);
				
			}
		}
		setAnimating(false);
	}
	
	public boolean isAnimating() {
		return animating;
	}
	public void setAnimating(boolean animating) {
		this.animating = animating;
		if(element instanceof LadybugRenderer && animating)
			((LadybugRenderer)element).restart();
		else
			if(element instanceof LadybugRenderer)
				((LadybugRenderer)element).stop();
	}
	public void setElementLocation(int x, int y){
		element.setLocation(x, y);
	}
	
}
