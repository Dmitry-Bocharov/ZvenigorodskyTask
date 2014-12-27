package ladybugAdventures.ui.animation.components;

import java.util.EnumMap;

import ladybugAdventures.enums.Behaviour;
import ladybugAdventures.enums.Direction;
import ladybugAdventures.enums.GameObject;
import ladybugAdventures.util.LazyRenderBuffer;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

public class LadybugRenderer extends UniversalAnimationRenderer{
	private Behaviour behaviour;
	private Direction direction;
	private EnumMap<Direction, Animation> moving;
	private EnumMap<Direction, Animation> pushing;
	private EnumMap<Direction, Animation> jumping;
	
//	private Animation  state;
	public LadybugRenderer(GUIContext container, int size) throws SlickException {
		super(container, size);
		//Инициализация анимаций
		moving = new EnumMap<>(Direction.class);
		pushing = new EnumMap<>(Direction.class);
		jumping = new EnumMap<>(Direction.class);
		
		moving.put(Direction.UP, LazyRenderBuffer.getAnimation(GameObject.LADYBUG, Behaviour.MOVING, Direction.UP));
		moving.put(Direction.DOWN, LazyRenderBuffer.getAnimation(GameObject.LADYBUG, Behaviour.MOVING, Direction.DOWN));
		moving.put(Direction.LEFT, LazyRenderBuffer.getAnimation(GameObject.LADYBUG, Behaviour.MOVING, Direction.LEFT));
		moving.put(Direction.RIGHT, LazyRenderBuffer.getAnimation(GameObject.LADYBUG, Behaviour.MOVING, Direction.RIGHT));
		
		pushing.put(Direction.UP, LazyRenderBuffer.getAnimation(GameObject.LADYBUG, Behaviour.PUSHING, Direction.UP));
		pushing.put(Direction.DOWN, LazyRenderBuffer.getAnimation(GameObject.LADYBUG, Behaviour.PUSHING, Direction.DOWN));
		pushing.put(Direction.LEFT, LazyRenderBuffer.getAnimation(GameObject.LADYBUG, Behaviour.PUSHING, Direction.LEFT));
		pushing.put(Direction.RIGHT, LazyRenderBuffer.getAnimation(GameObject.LADYBUG, Behaviour.PUSHING, Direction.RIGHT));
//		
		jumping.put(Direction.UP, LazyRenderBuffer.getAnimation(GameObject.LADYBUG, Behaviour.JUMPING, Direction.UP));
		jumping.put(Direction.DOWN, LazyRenderBuffer.getAnimation(GameObject.LADYBUG, Behaviour.JUMPING, Direction.DOWN));
		jumping.put(Direction.LEFT, LazyRenderBuffer.getAnimation(GameObject.LADYBUG, Behaviour.JUMPING, Direction.LEFT));
		jumping.put(Direction.RIGHT, LazyRenderBuffer.getAnimation(GameObject.LADYBUG, Behaviour.JUMPING, Direction.RIGHT));
		
		behaviour = Behaviour.MOVING;
		direction = Direction.UP;
		updateState();
		visible = true;
	}
	public void setBehaviour(Behaviour behaviour){
		this.behaviour = behaviour;
		updateState();
	}
	public void setDirection(Direction direction){
		this.direction = direction;
		updateState();
	}
	public void updateState(){
		switch (behaviour) {
		case MOVING:
			sprite = moving.get(direction);
			break;
		case PUSHING:
			sprite = pushing.get(direction);	
			break;
				
		case JUMPING:
			sprite = jumping.get(direction);
			break;
		}
	}
}
