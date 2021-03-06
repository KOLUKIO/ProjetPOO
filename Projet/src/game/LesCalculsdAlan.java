package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;


/*public class Square {
	

	
	//public Square (double posx, double posy, boolean planet) {
		
		
		
		
		
		
		
		/*	if(planet) {
			size = (Math.random() * (Math.min(x,y) / 8)) + Math.min(x,y) / 8;
		}else {
			size = (Math.random() * (Math.min(x,y) / 24)) + Math.min(x,y) / 24;
		}
		maxX = x - size;
		maxY = y - size;
		posX = Math.random() * maxX;
		posY = Math.random() * maxY;
	//}
}*/







public class LesCalculsdAlan {
	private Image image;
	private double x;
	private double y;
	private double xSpeed;
	private double ySpeed;
	private double width;
	private double height;
	private double maxX;
	private double maxY;

	public LesCalculsdAlan(String path, double width, double height, double maxX, double maxY) {
		image = new Image(path, width, height, false, false);
		this.width = width;
		this.height = height;
		this.maxX = maxX;
		this.maxY = maxY;
	}

	public LesCalculsdAlan(LesCalculsdAlan s) {
		image = s.image;
		width = s.width;
		height = s.height;
		maxX = s.maxX;
		maxY = s.maxY;
	}

	public double width() {
		return width;
	}

	public double height() {
		return height;
	}

	public void validatePosition() {
		if (x + width >= maxX) {
			x = maxX - width;
			xSpeed *= -1;
		} else if (x < 0) {
			x = 0;
			xSpeed *= -1;
		}

		if (y + height >= maxY) {
			y = maxY - height;
			ySpeed *= -1;
		} else if (y < 0) {
			y = 0;
			ySpeed *= -1;
		}
	}

	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
		validatePosition();
	}

	public void setSpeed(double xSpeed, double ySpeed) {
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
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
		x += xSpeed;
		y += ySpeed;
		validatePosition();
	}

	public void render(GraphicsContext gc) {
		gc.drawImage(image, x, y);
	}

	public boolean intersects(LesCalculsdAlan s) {
		return ((x >= s.x && x <= s.x + s.width) || (s.x >= x && s.x <= x + width))
				&& ((y >= s.y && y <= s.y + s.height) || (s.y >= y && s.y <= y + height));
	}

	public String toString() {
		return "Sprite<" + x + ", " + y + ">";
	}

}
