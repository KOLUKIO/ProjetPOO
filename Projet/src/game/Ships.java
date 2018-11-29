package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import shapes.Shape2D;

public class Ships {
	private Image image;
	private double posX; 
	private double posY;
	private double size;
	private double maxX;
	private double maxY;
	private double xSpeed;
	private double ySpeed;
	Shape2D hitBox;
	
	public Ships(String path, double posX, double posY, double size, double maxX, double maxY, double xSpeed, double ySpeed, Shape2D hitBox) {
		
		this.image = new Image(path, size, size, false, false);
		this.posX = posX;
		this.posY = posY;
		this.size = size;
		this.maxX = maxX;
		this.maxY = maxY;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.hitBox = hitBox;
	}
	
	public void validatePosition() {
		if (posX + size >= maxX) {
			posX = maxX - size;
			xSpeed *= -1;
		} else if (posX < 0) {
			posX = 0;
			xSpeed *= -1;
		}

		if (posY + size >= maxY) {
			posY = maxY - size;
			ySpeed *= -1;
		} else if (posY < 0) {
			posY = 0;
			ySpeed *= -1; 
		}
	}
	public void render(GraphicsContext gc) {
		gc.drawImage(image, posX-(size/2), posY-(size/2));
	}
	
	public void setPosition(int x, int y) {
		this.posX = x;
		this.posY = y;
	}
	
	public void changeSpeed(KeyCode code) {
		switch (code) {
		case LEFT:
			xSpeed--;
			break;
		case RIGHT:
			xSpeed++;
			break;
		case UP:
			ySpeed--;
			break;
		case DOWN:
			ySpeed++;
			break;
		case SPACE:
			ySpeed = xSpeed = 0;
			break;
		default:
		}
	}
	
	public void updatePosition() {
		posX += xSpeed;
		posY += ySpeed;
		validatePosition();
	}
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getMaxX() {
		return maxX;
	}

	public void setMaxX(double maxX) {
		this.maxX = maxX;
	}

	public double getMaxY() {
		return maxY;
	}

	public void setMaxY(double maxY) {
		this.maxY = maxY;
	}

	public double getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}

	public double getySpeed() {
		return ySpeed;
	}

	public void setySpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}
	public void setSpeed(double xSpeed, double ySpeed) {
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	public Shape2D getHitBox() {
		return hitBox;
	}

	public void setHitBox(Shape2D hitBox) {
		this.hitBox = hitBox;
	}
	
	
	
	
	
	
	
}
