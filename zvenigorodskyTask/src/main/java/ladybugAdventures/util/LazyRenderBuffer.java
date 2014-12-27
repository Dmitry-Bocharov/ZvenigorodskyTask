package ladybugAdventures.util;


import ladybugAdventures.enums.Behaviour;
import ladybugAdventures.enums.Direction;
import ladybugAdventures.enums.GameObject;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class LazyRenderBuffer {
	public static int duration = 40;
	private static Image emptyCell;
	private static Image box;
	private static Image hole;
	private static Image occupiedCell;
	private static Image ladybug;
	
	private static Animation ladybug_up,ladybug_down,ladybug_right,ladybug_left;
	private static Animation ladybug_jump_up,ladybug_jump_down,ladybug_jump_right,ladybug_jump_left;
	private static Animation ladybug_push_up,ladybug_push_down,ladybug_push_right,ladybug_push_left;
	
	public static Image getImage(GameObject gameObject) throws SlickException{
		Image recieve = null;
		switch (gameObject) {
			case EMPTY_CELL:
				if(emptyCell==null){
					emptyCell = new Image(ResourceProvider.getResInpStr(ResourceProvider.EMPTY_CELL),
							ResourceProvider.EMPTY_CELL,false);
				}
				recieve = emptyCell;
				break;
				
			case BLOCK:
				if(box==null){
					box = new Image(ResourceProvider.getResInpStr(ResourceProvider.BLOCK),
							ResourceProvider.BLOCK,false);
				}
				recieve = box;
				break;
			
			case HOLE:
				if(hole==null){
					hole = new Image(ResourceProvider.getResInpStr(ResourceProvider.HOLE),
							ResourceProvider.HOLE,false);
				}
				recieve = hole;
				break;
				
			case OCCUPIED_CELL:
				if(occupiedCell==null){
					occupiedCell = new Image(ResourceProvider.getResInpStr(ResourceProvider.OCCUPIED_CELL),
							ResourceProvider.OCCUPIED_CELL,false);
				}		
				recieve = occupiedCell;
				break;
				
			case LADYBUG:
				if(ladybug==null){
					ladybug = new Image(ResourceProvider.getResInpStr(ResourceProvider.LADYBUG),
							ResourceProvider.LADYBUG,false);
				}
				recieve = ladybug;
				break;
		}
		return recieve;
				
	}
	public static Animation getAnimation(GameObject gameObject, Behaviour behaviour ,Direction derection) throws SlickException{
		Animation animation = null;
		switch (gameObject) {
			case LADYBUG:
				switch (behaviour) {
				case MOVING:
					switch (derection) {
					case UP:
						if(ladybug_up==null){
							SpriteSheet frames = new SpriteSheet(
									new Image(ResourceProvider.getResInpStr(ResourceProvider.LADYBUG_UP),
											ResourceProvider.LADYBUG_UP,false), 256, 256);
							ladybug_up = new Animation(frames, duration);
							
						}
						animation = ladybug_up;
						break;
		
					case DOWN:
						if(ladybug_down==null){
							SpriteSheet frames = new SpriteSheet(
									new Image(ResourceProvider.getResInpStr(ResourceProvider.LADYBUG_DOWN),
											ResourceProvider.LADYBUG_DOWN,false), 256, 256);
							ladybug_down = new Animation(frames, duration);
							
						}
						animation = ladybug_down;
						break;
					case LEFT:
						if(ladybug_left==null){
							SpriteSheet frames = new SpriteSheet(
									new Image(ResourceProvider.getResInpStr(ResourceProvider.LADYBUG_LEFT),
											ResourceProvider.LADYBUG_LEFT,false), 256, 256);
							ladybug_left = new Animation(frames, duration);
							
						}	
						animation = ladybug_left;
						break;
					case RIGHT:
						if(ladybug_right==null){
							SpriteSheet frames = new SpriteSheet(
									new Image(ResourceProvider.getResInpStr(ResourceProvider.LADYBUG_RIGHT),
											ResourceProvider.LADYBUG_RIGHT,false), 256, 256);
							ladybug_right = new Animation(frames, duration);
							
						}
						animation = ladybug_right;
						break;
				}
				break;
				case JUMPING:
					switch (derection) {
					case UP:
						if(ladybug_jump_up==null){
							SpriteSheet frames = new SpriteSheet(
									new Image(ResourceProvider.getResInpStr(ResourceProvider.LADYBUG_JUMP_UP),
											ResourceProvider.LADYBUG_JUMP_UP,false), 256, 256);
							ladybug_jump_up = new Animation(frames, duration);
							
						}
						animation = ladybug_jump_up;
						break;
		
					case DOWN:
						if(ladybug_jump_down==null){
							SpriteSheet frames = new SpriteSheet(
									new Image(ResourceProvider.getResInpStr(ResourceProvider.LADYBUG_JUMP_DOWN),
											ResourceProvider.LADYBUG_JUMP_DOWN,false), 256, 256);
							ladybug_jump_down = new Animation(frames, duration);
							
						}
						animation = ladybug_jump_down;
						break;
					case LEFT:
						if(ladybug_jump_left==null){
							SpriteSheet frames = new SpriteSheet(
									new Image(ResourceProvider.getResInpStr(ResourceProvider.LADYBUG_JUMP_LEFT),
											ResourceProvider.LADYBUG_JUMP_LEFT,false), 256, 256);
							ladybug_jump_left = new Animation(frames, duration);
							
						}	
						animation = ladybug_jump_left;
						break;
					case RIGHT:
						if(ladybug_jump_right==null){
							SpriteSheet frames = new SpriteSheet(
									new Image(ResourceProvider.getResInpStr(ResourceProvider.LADYBUG_JUMP_RIGHT),
											ResourceProvider.LADYBUG_JUMP_RIGHT,false), 256, 256);
							ladybug_jump_right = new Animation(frames, duration);
							
						}
						animation = ladybug_jump_right;
						break;
				}
				break;

				case PUSHING:
					switch (derection) {
					case UP:
						if(ladybug_push_up==null){
							SpriteSheet frames = new SpriteSheet(
									new Image(ResourceProvider.getResInpStr(ResourceProvider.LADYBUG_PUSH_UP),
											ResourceProvider.LADYBUG_PUSH_UP,false), 256, 256);
							ladybug_push_up = new Animation(frames, 400);
							
						}
						animation = ladybug_push_up;
						break;
		
					case DOWN:
						if(ladybug_push_down==null){
							SpriteSheet frames = new SpriteSheet(
									new Image(ResourceProvider.getResInpStr(ResourceProvider.LADYBUG_PUSH_DOWN),
											ResourceProvider.LADYBUG_PUSH_DOWN,false), 256, 256);
							ladybug_push_down = new Animation(frames, 400);
							
						}
						animation = ladybug_push_down;
						break;
					case LEFT:
						if(ladybug_push_left==null){
							SpriteSheet frames = new SpriteSheet(
									new Image(ResourceProvider.getResInpStr(ResourceProvider.LADYBUG_PUSH_LEFT),
											ResourceProvider.LADYBUG_PUSH_LEFT,false), 256, 256);
							ladybug_push_left = new Animation(frames, 400);
							
						}	
						animation = ladybug_push_left;
						break;
					case RIGHT:
						if(ladybug_push_right==null){
							SpriteSheet frames = new SpriteSheet(
									new Image(ResourceProvider.getResInpStr(ResourceProvider.LADYBUG_PUSH_RIGHT),
											ResourceProvider.LADYBUG_PUSH_RIGHT,false), 256, 256);
							ladybug_push_right = new Animation(frames, 400);
							
						}
						animation = ladybug_push_right;
						break;
				}
				break;
						
			
						
			}
		}
		return animation;
	}
}
