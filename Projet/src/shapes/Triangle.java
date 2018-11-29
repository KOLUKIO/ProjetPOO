package shapes;

import shapes.Shape2D;
import shapes.Point2D;

public class Triangle extends Shape2D{
	
	private Point2D point1;
	private Point2D point2;
	private Point2D point3;

	public Triangle(Point2D point1, Point2D point2, Point2D point3, String name) {
        this.name = name;
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
	}
	
	public Triangle(Point2D point1, Point2D point2, Point2D point3) {
        this(point1,point2,point3,"noname");
	}
	
	public double perimeter() {
		return point1.distance(point2) + point2.distance(point3) + point3.distance(point1);
	}
	
	public double area() {
		double p = ( point1.distance(point2) + point2.distance(point3) + point3.distance(point1) )/2;
		return Math.sqrt(p*(p-point1.distance(point2))*(p-point2.distance(point3))*(p-point3.distance(point1)));
	}
	
	public void moveTriangle(int dx, int dy) {
		point1.setX(point1.getX()+dx);
		point1.setY(point1.getY()+dy);
		point2.setX(point2.getX()+dx);
		point2.setY(point2.getY()+dy);
		point3.setX(point3.getX()+dx);
		point3.setY(point3.getY()+dy);
	}
	
	public void print() {
		System.out.println("Triangle : point1 = ("+point1.getX()+";"+point1.getY()+"), point2 = ("+point2.getX()+";"+point2.getY()+"), point3 = ("+point3.getX()+";"+point3.getY()+")");
	}
	
	public Point2D getPoint1() {
		return this.point1;
	}
	
	public Point2D getPoint2() {
		return this.point2;
	}
	
	public Point2D getPoint3() {
		return this.point3;
	}
	
	public void setPoint1(Point2D p) {
		this.point1 = p;
	}
	
	public void setPoint2(Point2D p) {
		this.point2 = p;
	}
	
	public void setPoint3(Point2D p) {
		this.point3 = p;
	}
	
}