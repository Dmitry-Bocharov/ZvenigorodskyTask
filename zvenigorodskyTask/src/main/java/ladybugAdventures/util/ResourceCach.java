package ladybugAdventures.util;

import ladybugAdventures.enums.CommandType;
import ladybugAdventures.enums.Direction;
import ladybugAdventures.enums.GameObject;

import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;

public class ResourceCach {
	private static Image ladybugImage, blockImage, holeImage, occupiedCellImage;
	private static int width = 0;
	private static int height = 0;
	public static Image fromTypeToImage(CommandType type,int width, int height){
		ImageData imgData = null;
		switch (type) {
			case JUMP:
				imgData =  new Image(Display.getDefault(), ResourceCach.class.getResourceAsStream("/img/icons/jump.png")).getImageData();
				break;
			case MOVE:
				imgData = new Image(Display.getDefault(), ResourceCach.class.getResourceAsStream("/img/icons/step.png")).getImageData();
				break;
			case PUSH:
				imgData = new Image(Display.getDefault(), ResourceCach.class.getResourceAsStream("/img/icons/push.png")).getImageData();
				break;
			case CYCLE:
				break;
		}
		Image img = new Image(Display.getDefault(), imgData);
		return (new Image(img.getDevice(), img.getImageData().scaledTo(width, height)));
	}
	public static Image fromDirectionToImage(Direction direction,int width, int height){
		Image img = null;
		switch (direction) {
			case UP:
				img = new Image(Display.getDefault(), ResourceCach.class.getResourceAsStream("/img/icons/up.png"));
				break;
			case DOWN:
				img = new Image(Display.getDefault(), ResourceCach.class.getResourceAsStream("/img/icons/down.png"));
				break;
			case LEFT:
				img = new Image(Display.getDefault(), ResourceCach.class.getResourceAsStream("/img/icons/left.png"));
				break;
			case RIGHT:
				img = new Image(Display.getDefault(), ResourceCach.class.getResourceAsStream("/img/icons/right.png"));
				break;
		}
		return (new Image(img.getDevice(), img.getImageData().scaledTo(width, height)));
	}
	public static Image fromGameObjectToImage(GameObject object,int width, int height, Device device){
		if (!(ResourceCach.width == width && ResourceCach.height == height)) {
			if (ladybugImage != null) ladybugImage.dispose();
			ladybugImage = null;
			if (blockImage != null) blockImage.dispose();
			blockImage = null;
			if (holeImage != null) holeImage.dispose();
			holeImage = null;
			if (occupiedCellImage != null) occupiedCellImage.dispose();
			occupiedCellImage = null;
			ResourceCach.width = width;
			ResourceCach.height = height;
		}
		ImageData imgData = null;
		Image img = null;
		switch (object) {
			case LADYBUG:
				if (ladybugImage == null) {
					imgData = new Image(device, ResourceProvider.getResInpStr(ResourceProvider.LADYBUG)).getImageData();
					ladybugImage = new Image(device, imgData.scaledTo(width, height));
				}	
				img = ladybugImage;
				break;
			case BLOCK:
				if (blockImage == null){
					imgData = new Image(device, ResourceProvider.getResInpStr(ResourceProvider.BLOCK)).getImageData();
					blockImage = new Image(device, imgData.scaledTo(width, height));
				}
				img = blockImage;
				break;
			case HOLE:
				if (holeImage == null) {
					imgData = new Image(device, ResourceProvider.getResInpStr(ResourceProvider.HOLE)).getImageData();
					holeImage = new Image(device, imgData.scaledTo(width, height));
				}
				img = holeImage;
				break;
			case OCCUPIED_CELL:
				if (occupiedCellImage == null) {
					imgData = new Image(device, ResourceProvider.getResInpStr(ResourceProvider.OCCUPIED_CELL)).getImageData();
					occupiedCellImage = new Image(device, imgData.scaledTo(width, height));
				}
				img = occupiedCellImage;
				break;
		}
		return img;
	}
}
