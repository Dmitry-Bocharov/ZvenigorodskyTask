package ladybugAdventures.util;

import java.io.InputStream;

public class ResourceProvider {
	//IDs
	public final static String BACKGROUND 					= 		"/main/background";
	public final static String SPLASH 						= 		"splash";
	public final static String START_BUTTON 				= 		"/main/startButton";
	public final static String START_BUTTON_PRESSED 		= 		"/main/startButtonPressed";
	public final static String EMPTY_CELL 					=		"/img/pictures/cell";
	public final static String BLOCK						=		"/img/pictures/block";
	public final static String HOLE							=		"/img/pictures/hole";
	public final static String OCCUPIED_CELL				=		"/img/pictures/occupiedCell";
	public final static String SAY 							= 		"/img/pictures/say";

	public final static String LADYBUG 						= 		"/gameobject/ladybug";
	
	public final static String LADYBUG_UP 					= 		"/sprites/buglady/moving/up";
	public final static String LADYBUG_DOWN 				= 		"/sprites/buglady/moving/down";
	public final static String LADYBUG_LEFT 				= 		"/sprites/buglady/moving/left.png";
	public final static String LADYBUG_RIGHT 				= 		"/sprites/buglady/moving/right";
	

	public final static String LADYBUG_JUMP_UP 				= 		"/sprites/buglady_fly_up_sprite";
	public final static String LADYBUG_JUMP_DOWN 			= 		"/sprites/buglady_fly_down_sprite";
	public final static String LADYBUG_JUMP_LEFT 			= 		"/sprites/buglady_fly_left_sprite";
	public final static String LADYBUG_JUMP_RIGHT 			= 		"/sprites/buglady_fly_right_sprite";
	
	public final static String LADYBUG_PUSH_UP 				= 		"/sprites/buglady_push_up_sprite";
	public final static String LADYBUG_PUSH_DOWN 			= 		"/sprites/buglady_push_down_sprite";
	public final static String LADYBUG_PUSH_LEFT 			= 		"/sprites/buglady_push_left_sprite";
	public final static String LADYBUG_PUSH_RIGHT 			= 		"/sprites/buglady_push_right_sprite";
	
	public final static String CLOUD_SPRITE 				= 		"/sprites/cloud_sprite";
	public final static String FIRE_SPRITE 					= 		"/sprites/FIRE_sprite";
	
	
	
	//links
	private final static String BACKGROUND_LINK 			= 		"/img/pictures/background.jpg";
	private final static String SPLASH_LINK					= 		"/img/pictures/splash.jpg";
	private final static String START_BUTTON_LINK 			= 		"/img/pictures/startButton.png";
	private final static String START_BUTTON_PRESSED_LINK 	= 		"/img/pictures/startButtonPressed.png";
	private final static String EMPTY_CELL_LINK 			= 		"/img/pictures/cell.png";
	private final static String BLOCK_LINK					=		"/img/pictures/box.png";
	private final static String HOLE_LINK					=		"/img/pictures/hole.png";
	private final static String OCCUPIED_CELL_LINK			=		"/img/pictures/occupied_cell.png";
	private final static String SAY_LINK					=		"/img/pictures/say.png";
	
	private final static String LADYBUG_LINK 				= 		"/img/pictures/ladybug.png";
	
	private final static String LADYBUG_UP_LINK 			= 		"/img/sprites/buglady/moving/up.png";
	private final static String LADYBUG_DOWN_LINK 			= 		"/img/sprites/buglady/moving/down.png";
	private final static String LADYBUG_LEFT_LINK 			= 		"/img/sprites/buglady/moving/left.png";
	private final static String LADYBUG_RIGHT_LINK 			= 		"/img/sprites/buglady/moving/right.png";

	private final static String LADYBUG_JUMP_UP_LINK 		= 		"/img/sprites/buglady/jumping/up.png";
	private final static String LADYBUG_JUMP_DOWN_LINK 		= 		"/img/sprites/buglady/jumping/down.png";
	private final static String LADYBUG_JUMP_LEFT_LINK 		= 		"/img/sprites/buglady/jumping/left.png";
	private final static String LADYBUG_JUMP_RIGHT_LINK 	= 		"/img/sprites/buglady/jumping/right.png";
	
	private final static String LADYBUG_PUSH_UP_LINK 		= 		"/img/sprites/buglady/pushing/up.png";
	private final static String LADYBUG_PUSH_DOWN_LINK 		= 		"/img/sprites/buglady/pushing/down.png";
	private final static String LADYBUG_PUSH_LEFT_LINK 		= 		"/img/sprites/buglady/pushing/left.png";
	private final static String LADYBUG_PUSH_RIGHT_LINK 	= 		"/img/sprites/buglady/pushing/right.png";
	
	private final static String CLOUD_SPRITE_LINK 			= 		"/img/sprites/clouds.jpg";
	private final static String FIRE_SPRITE_LINK 			= 		"/img/sprites/fire1.png";
	
	
	
	
	public static InputStream getResInpStr(String RESOURCE_ID){
		String resultLink = null;
		switch (RESOURCE_ID) {
			
			case LADYBUG:
				resultLink = LADYBUG_LINK;
				break;
			case EMPTY_CELL:
				resultLink = EMPTY_CELL_LINK;
				break;
			case BLOCK:
				resultLink = BLOCK_LINK;
				break;
			case HOLE:
				resultLink = HOLE_LINK;
				break;
			case OCCUPIED_CELL:
				resultLink = OCCUPIED_CELL_LINK;
				break;
			case LADYBUG_UP:
				resultLink = LADYBUG_UP_LINK;
				break;
			case LADYBUG_DOWN:
				resultLink = LADYBUG_DOWN_LINK;
				break;
			case LADYBUG_LEFT:
				resultLink = LADYBUG_LEFT_LINK;
				break;
			case LADYBUG_RIGHT:
				resultLink = LADYBUG_RIGHT_LINK;
				break;
			case LADYBUG_JUMP_UP:
				resultLink = LADYBUG_JUMP_UP_LINK;
				break;
			case LADYBUG_JUMP_DOWN:
				resultLink = LADYBUG_JUMP_DOWN_LINK;
				break;
			case LADYBUG_JUMP_LEFT:
				resultLink = LADYBUG_JUMP_LEFT_LINK;
				break;
			case LADYBUG_JUMP_RIGHT:
				resultLink = LADYBUG_JUMP_RIGHT_LINK;
				break;
			case LADYBUG_PUSH_UP:
				resultLink = LADYBUG_PUSH_UP_LINK;
				break;
			case LADYBUG_PUSH_DOWN:
				resultLink = LADYBUG_PUSH_DOWN_LINK;
				break;
			case LADYBUG_PUSH_LEFT:
				resultLink = LADYBUG_PUSH_LEFT_LINK;
				break;
			case LADYBUG_PUSH_RIGHT:
				resultLink = LADYBUG_PUSH_RIGHT_LINK;
				break;
				
				
				
			case CLOUD_SPRITE:
				resultLink = CLOUD_SPRITE_LINK;
				break;
			case FIRE_SPRITE:
				resultLink = FIRE_SPRITE_LINK;
				break;
			case SAY:
				resultLink = SAY_LINK;
				break;
			
				
				
				
				
				
				
			case BACKGROUND:
				resultLink = BACKGROUND_LINK;
				break;
			case SPLASH:
				resultLink = SPLASH_LINK;
				break;
			case START_BUTTON:
				resultLink = START_BUTTON_LINK;
				break;
			case START_BUTTON_PRESSED:
				resultLink = START_BUTTON_PRESSED_LINK;
				break;
			
		}
		
		return ResourceProvider.class.getResourceAsStream(resultLink);
	}
}
