import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class SimpleSprite extends Sprite {
	private double velocityX = 0;
	private double velocityY = 0;
	private double accelerationY = 100;
	public SimpleSprite(double currentX, double currentY){
		super();
		this.currentX = currentX;
		this.currentY = currentY;
		
		try{
			this.defaultImage = ImageIO.read(new File("res/gigga2.png"));
			this.IMAGE_HEIGHT = this.defaultImage.getHeight(null);
			this.IMAGE_WIDTH = this.defaultImage.getWidth(null);
			
		}catch(IOException e){
			System.out.println(e.toString());
		}
	}
	
	@Override
	public void update(KeyboardInput keyboard, long actual_delta_time) {
		double newX = currentX;
		double newY = currentY;
		
		if(keyboard.keyDown(37)){
			newX = currentX - actual_delta_time * 0.001 * 100;
		}
		if(keyboard.keyDown(38)){
			newY = currentY - actual_delta_time * 0.001 * 100;
		}
		if(keyboard.keyDown(39)){
			newX = currentX + actual_delta_time * 0.001 * 100;
		}
		if(keyboard.keyDown(40)){
			newY = currentY + actual_delta_time * 0.001 * 100;
		}
		
		if(checkCollisionWithBarrier(newX, newY) == false){
			this.currentX = newX;
			this.currentY = newY;
		}
		
//		if(currentX>=800){
//			currentX = 800;
//		}
//		if(currentX <= 0){
//			currentX = 0;
//		}
//		if(currentY>=800){
//			currentY = 800;
//		}
//		if(currentY <= 0){
//			currentY = 0;
//		}
		
		
		
	}

	@Override
	public double getMinX() {

		return currentX;
	}

	@Override
	public double getMaxX() {

		return currentX + IMAGE_WIDTH;
	}

	@Override
	public double getMinY() {

		return currentY;
	}

	@Override
	public double getMaxY() {

		return currentY + IMAGE_HEIGHT;
	}

	@Override
	public long getHeight() {

		return IMAGE_HEIGHT;
	}

	@Override
	public long getWidth() {

		return IMAGE_WIDTH;
	}

	@Override
	public Image getImage() {
		return defaultImage;
	}

	@Override
	public void setMinX(double currentX) {

		
	}

	@Override
	public void setMinY(double currentY) {

		
	}

	@Override
	public void setBarriers(ArrayList<Rectangle> barriers) {
		this.barriers = barriers;
		
	}

	@Override
	public void setSprites(ArrayList<Sprite> staticSprites) {

		
	}

	@Override
	public void setKeyboard(KeyboardInput keyboard) {

		
	}

	@Override
	public boolean checkCollisionWithSprites(double x, double y) {

		return false;
	}

	@Override
	public boolean checkCollisionWithBarrier(double x, double y) {
		boolean isColliding = false;
		for(Rectangle barrier : barriers){
			if(!((x + this.IMAGE_WIDTH) < barrier.getMinX() || x > barrier.getMaxX())){
				if(!((y + this.IMAGE_HEIGHT) < barrier.getMinY() || y > barrier.getMaxY())){
					isColliding = true;
					break;
				}
			}
		}
		return isColliding;
		
	}

	
}
