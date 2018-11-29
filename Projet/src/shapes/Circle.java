package shapes;

import shapes.Shape2D;
import shapes.Point2D;

public class Circle extends Shape2D{
	private Point2D center;
	private double radius;

	public Circle (Point2D center, double radius, String name) {
		this.center = center;
		this.radius = radius;
		this.name = name;
	}
	
	public Circle (Point2D center, double radius) {
		this(center,radius,"noname");
	}

	public double area() {
		return Math.PI * radius*radius;
	}

	boolean isInside(Point2D p) {
		double distance = p.distance(center);
		return distance <= radius;
	}
	
	Point2D getcenter() {
		return this.center;
	}
	
	double getradius() {
		return this.radius;
	}
	
	void setradius(double newradius) {
		this.radius = newradius;
	}
	
	void setcenter(Point2D newcenter) {
		center.setX(newcenter.getX());
		center.setY(newcenter.getY());
	}
	
	public void print() {
		System.out.println("Circle : center = ("+center.getX()+";"+center.getY()+"), radius = "+radius);
	}
	
	public double perimeter() {
		return 2*Math.PI*radius;
	}
	
	public void translation(int dx, int dy) {
		center.setX(center.getX()+dx);
		center.setY(center.getY()+dy);
	}
}