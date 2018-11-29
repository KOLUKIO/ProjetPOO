package game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import shapes.Shape2D;

public class Planet {
	private Image image;
	private int posX; 
	private int posY;
	private double size;
	private double maxX;
	private double maxY;
	private double tauxDeProd;
	
	Shape2D hitBox;
	
	Planet(String path, int posX, int posY, double size, Shape2D hitBox, double maxX, double maxY, double tauxDeProd) {
		
		this.image = new Image(path, size, size, false, false);
		this.posX = posX;
		this.posY = posY;
		this.size = size;
		this.maxX = maxX;
		this.maxY = maxY;
		this.tauxDeProd = tauxDeProd;
		this.hitBox = hitBox;
	}
	
	public void setPosition(int x, int y) {
		this.posX = x;
		this.posY = y;
		//validate position 
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
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
	public double getTauxDeProd() {
		return tauxDeProd;
	}
	public void setTauxDeProd(double tauxDeProd) {
		this.tauxDeProd = tauxDeProd;
	}
	public void render(GraphicsContext gc) {
		gc.drawImage(image, posX, posY);
	}
	
}
