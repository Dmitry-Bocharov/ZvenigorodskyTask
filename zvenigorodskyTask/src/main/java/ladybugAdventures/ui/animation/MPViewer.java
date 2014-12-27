package ladybugAdventures.ui.animation;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.jws.Oneway;

import ladybugAdventures.entities.GameField;
import ladybugAdventures.entities.ManagementProgram;
import ladybugAdventures.enums.Behaviour;
import ladybugAdventures.enums.ErrorType;
import ladybugAdventures.enums.GameObject;
import ladybugAdventures.ui.animation.components.BugladySaidRenderer;
import ladybugAdventures.ui.animation.components.CommandLogRenderer;
import ladybugAdventures.ui.animation.components.FireRenderer;
import ladybugAdventures.ui.animation.components.LadybugRenderer;
import ladybugAdventures.ui.animation.components.TextInformationRenderer;
import ladybugAdventures.ui.animation.components.GameFieldRenderer;
import ladybugAdventures.ui.animation.components.StartButtonRenderer;
import ladybugAdventures.util.Analizator;
import ladybugAdventures.util.LazyRenderBuffer;
import ladybugAdventures.util.MoveRenderElement;
import ladybugAdventures.util.ResourceProvider;
import ladybugAdventures.util.StepTrack;

import org.eclipse.swt.graphics.Point;
import org.newdawn.slick.Animation;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MPViewer extends BasicGameState {
	
	
	private Image background;
	private GameFieldRenderer gameField;
	private StartButtonRenderer startButton;
	private Analizator analizator;
	private String info;
	private List<MoveRenderElement> renderTrackList;
	private TextInformationRenderer infoRenderer;
	private CommandLogRenderer logViewer;
	private BugladySaidRenderer say;
	private FireRenderer fire;
	private GUIContext container;
	private boolean animating;
	private int oneStep = 0;
	public MPViewer(GameField field, ManagementProgram program){
		info = MessageFormat.format("Автор: {0}\r\nКоличество команд: {1}\r\nРазмер поля: {2}x{3}", program.getAuthor(),program.getAllCommandAmountWithIterations(),
				field.getWidth(),field.getHeigh());
		
		analizator = new Analizator(field, program);
	}
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		this.container = container;
		background = new Image(ResourceProvider.getResInpStr(ResourceProvider.BACKGROUND),
				ResourceProvider.BACKGROUND,false);
		startButton = new StartButtonRenderer(container);
		gameField = new GameFieldRenderer(analizator.getFieldBeforeStep());
		gameField.init(container);
		
		
		fire = new FireRenderer(container, gameField.getCellSize());
		logViewer = new CommandLogRenderer(container);
		
		say = new BugladySaidRenderer(container, new Point(0,0), analizator, gameField.getCellSize());
		infoRenderer = new TextInformationRenderer(container, new Point(10, container.getHeight()-90),  info);
		infoRenderer.init(container);
		//СПИСОК ОТРИСУЕМЫХ
		renderTrackList = new ArrayList<MoveRenderElement>();
		if(!updateRenderTrackList()){
//			startButton.setVisible(false);
			say.setVisible(true);
			say.setLocation(gameField.getRenderPosX() + gameField.getCellSize()*(gameField.getControlObjectCoordinates().x+1), 
					gameField.getRenderPosY() + gameField.getCellSize()*gameField.getControlObjectCoordinates().y);
		}
	}


	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		background.draw(0,0,container.getWidth(),container.getHeight());
		gameField.render(container, g);
		startButton.render(container, g);
		g.setColor(new Color(152,251,152,0.6f));
		g.fillRect(0, container.getHeight()-100, 240, 100);//фон
		infoRenderer.render(container, g,Color.black);
		logViewer.render(container, g);
		
		for(MoveRenderElement renderElement: renderTrackList){
			renderElement.element.render(container, g);
		}

		fire.render(container, g);
		say.render(container, g);

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int t)
			throws SlickException {
		if(!animating){
			if(startButton.update(container, t)){
				animating = true;
				oneStep = Math.round(25/gameField.getCellSize());//размер 1 шага
				if(oneStep == 0){
					oneStep = 1;
				}
				say.setVisible(true);
			}
		}
		else{
			for(int i = 0; i<renderTrackList.size(); i++){
				MoveRenderElement currentElement = renderTrackList.get(i);
				if(!currentElement.isAnimating()){
					currentElement.setAnimating(true);
				}
				int deltaX = currentElement.result.x-currentElement.current.x;
				int deltaY = currentElement.result.y-currentElement.current.y;
				if(currentElement.element instanceof LadybugRenderer)
					say.setLocation(currentElement.current.x + gameField.getCellSize()*2/3, 
							currentElement.current.y);
				if(!(Math.abs(deltaX)<oneStep && Math.abs(deltaY)<oneStep)){
					if(deltaX>0){
						currentElement.current.x+=oneStep;
						currentElement.element.setLocation(currentElement.current.x, currentElement.element.getY());
						continue;
					}
					if(deltaX<0){
						currentElement.current.x-=oneStep;
						currentElement.element.setLocation(currentElement.current.x, currentElement.element.getY());
						continue;
					}
					if(deltaY>0){
						currentElement.current.y+=oneStep;
						currentElement.element.setLocation(currentElement.element.getX(), currentElement.current.y);
						continue;
					}
					if(deltaY<0){
						currentElement.current.y-=oneStep;
						currentElement.element.setLocation(currentElement.element.getX(), currentElement.current.y);
						continue;
					}
				}
				if(analizator.getCurrentBehaviour()==Behaviour.PUSHING){
					if(currentElement.element instanceof LadybugRenderer){
						((LadybugRenderer)currentElement.element).setBehaviour(Behaviour.PUSHING);
					}
					if(analizator.isBlockFellInHole()){
						fire.setLocation(renderTrackList.get(1).result.x, renderTrackList.get(1).result.y);
						fire.setVisible(true);
					}
				}
				if(!updateRenderTrackList())
					animating = false;
//				}
			}
				
		}


	}
	private boolean updateRenderTrackList() throws SlickException{
		renderTrackList.clear();
		
		if(analizator.nextStep())
		{
			say.setText(analizator.getCurrentBehaviourDefinition());
			logViewer.addToLog(analizator.getLastPerformedCommand());
			List<StepTrack> tracks = analizator.getTrackList();
			gameField.setNotRenderList(tracks);
			
			for(int i = 0;i<tracks.size();i++){
				renderTrackList.add(new MoveRenderElement(tracks.get(i),gameField, container, analizator));
			}
			
			gameField.setGameField(analizator.getFieldBeforeStep());
			
			return true;
		}
		startButton.setVisible(false);
		say.setText(analizator.getCurrentErrorDefinition());
		gameField.setNotRenderList(new ArrayList<StepTrack>());
		gameField.setGameField(analizator.getFieldAfterStep());
		return false;
	}
	
	/*
	 *
	 *
	 * 			MAIN
	 *
	 *
	 */
//	public static void main(String[] args) {
//		Path resourcePath = null;
//		
////		URL resourceUrl = AnimationRunner.class.
////				getResource("/native/win32");
////		try {
//			System.out.println(CommonUtils.getJarPath());
//			resourcePath = Paths.get(CommonUtils.getJarPath()+"/lib/native/");
////			resourcePath = Paths.get(resourceUrl.toURI());
//			System.out.println(resourcePath);
////		} catch (URISyntaxException e1) {
////		}
//		System.setProperty("org.lwjgl.librarypath", resourcePath.toString());
//		System.setProperty("java.library.path", resourcePath.toString());
//
//		try {
//			ManagementProgram mp = FileSystemManager.getManagementProgramm("C:/Users/Ivan/Desktop/managementProgram.xml");
//			AppGameContainer container = new AppGameContainer(new MPViewer(FileSystemManager.getGameField(mp.getMapAddress()),mp));
//			container.setDisplayMode(800, 600, false);
//			
//			container.setTargetFrameRate(60);
//			container.start();
//		} catch (SlickException | StorageException e) {
//			e.printStackTrace();
//		}
//
//	}
	@Override
	public int getID() {
		return 1;
	}

}
