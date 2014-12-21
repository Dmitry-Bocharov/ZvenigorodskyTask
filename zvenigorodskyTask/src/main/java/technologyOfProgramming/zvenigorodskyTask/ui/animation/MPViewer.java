package technologyOfProgramming.zvenigorodskyTask.ui.animation;

import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.lwjgl.LWJGLUtil;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.ImageDataFactory;
import org.newdawn.slick.opengl.TextureImpl;

import technologyOfProgramming.zvenigorodskyTask.data.FileSystemManager;
import technologyOfProgramming.zvenigorodskyTask.data.StorageException;
import technologyOfProgramming.zvenigorodskyTask.entities.GameField;
import technologyOfProgramming.zvenigorodskyTask.entities.ManagementProgram;
import technologyOfProgramming.zvenigorodskyTask.ui.MainFrame;
import technologyOfProgramming.zvenigorodskyTask.ui.animation.components.GameFieldRenderer;
import technologyOfProgramming.zvenigorodskyTask.ui.animation.components.StartButtonRenderer;
import technologyOfProgramming.zvenigorodskyTask.util.CommonUtils;
import technologyOfProgramming.zvenigorodskyTask.util.ResourceProvider;

public class MPViewer extends BasicGame {
	
	
	private Image background;
	private Image ladybug;
	private GameFieldRenderer gameField;
	private GameField startField;
	private ManagementProgram program;
	private StartButtonRenderer startButton;

	private float x;
	private float y;
	public MPViewer(GameField field, ManagementProgram program){
		super("Приключения божьей коровки");
		startField = field;
		this.program = program;
	}



	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		background.draw(0,0,container.getWidth(),container.getHeight());
		gameField.render(container, g);
		startButton.render(container, g);
//		buglady.draw(x,y);

	}

	@Override
	public void init(GameContainer container) throws SlickException {
		background = new Image(ResourceProvider.getResInpStr(ResourceProvider.BACKGROUND_ID),ResourceProvider.BACKGROUND_ID,false);
		startButton = new StartButtonRenderer(container);
		gameField = new GameFieldRenderer(20,20);
		gameField.init(container);
		ladybug = new Image(ResourceProvider.getResInpStr(ResourceProvider.LADYBUG_ID),ResourceProvider.LADYBUG_ID,false);
		ladybug.rotate(90);
		x=10;
		y=20;
	}

	@Override
	public void update(GameContainer container, int t)
			throws SlickException {
		startButton.update(container, t);
		//x+=0.1*delta;


	}

	/*
	 *
	 *
	 * 			MAIN
	 *
	 *
	 */
	public static void main(String[] args) {
		Path resourcePath = null;
		
//		URL resourceUrl = AnimationRunner.class.
//				getResource("/native/win32");
//		try {
			System.out.println(CommonUtils.getJarPath());
			resourcePath = Paths.get(CommonUtils.getJarPath()+"/lib/native/win32/");
//			resourcePath = Paths.get(resourceUrl.toURI());
			System.out.println(resourcePath);
//		} catch (URISyntaxException e1) {
//		}
		System.setProperty("org.lwjgl.librarypath", resourcePath.toString());
		System.setProperty("java.library.path", resourcePath.toString());

		try {
			ManagementProgram mp = FileSystemManager.getManagementProgramm("C:/Users/Ivan/Desktop/managementProgram.xml");
			AppGameContainer container = new AppGameContainer(new MPViewer(FileSystemManager.getGameField(mp.getMapAddress()),mp));
			container.setDisplayMode(800, 600, false);
			
			container.setTargetFrameRate(60);
			container.start();
		} catch (SlickException | StorageException e) {
			e.printStackTrace();
		}

	}

}