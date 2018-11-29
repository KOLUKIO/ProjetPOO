package shapes;

import shapes.Point2D;

public class Square extends Rectangle{
	
	private double size;
	private Point2D corner;
	
	
	public Square(double size, Point2D corner, String name) {
		super(size,size,corner,name);
	}
	
	public double area() {
		return size*size;
	}
	
	public double perimeter() {
		return 4*size;
	}
	
	public void translation(int deltax,int deltay) {
		corner.setX(corner.getX()+deltax);
		corner.setY(corner.getY()+deltay);
	}
	
	public void print() {
		System.out.println("Square : corner = ("+corner.getX()+";"+corner.getY()+"), size = "+size);
	}
	
	public double getsize() {
		return this.size;
	}
	
	public void setsize(double size) {
		this.size = size;
	}

}