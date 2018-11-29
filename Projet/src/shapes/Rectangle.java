package shapes;

import java.io.StringWriter;

import shapes.Shape2D;
import shapes.Point2D;

public class Rectangle extends Shape2D{
	
	private double dx;
	private double dy;
	private Point2D corner;
	
	public Rectangle(double dx, double dy, Point2D corner, String name) {
        this.name = name;
		this.dx = dx;
		this.dy = dy;
		this.corner = corner;
	}
	
	public Rectangle(double dx, double dy, Point2D corner) {
        this(dx,dy,corner,"noname");
	}
	
	public double area() {
		return dx*dy;
	}
	
	public double perimeter() {
		return 2*(dx+dy);
	}
	
	public boolean isInside(Point2D p) {
		return ((corner.getX() <= p.getX() && p.getX() <= corner.getX()+this.dx) &&
		(corner.getY() <= p.getY() && p.getY() <= corner.getY()+this.dy));
	}
	
	public void resizeRectangle(double deltax,double deltay) {
		this.setdx(this.getdx()+deltax);
		this.setdy(this.getdy()+deltay);
	}
	
	public void translation(int deltax,int deltay) {
		corner.setX(corner.getX()+deltax);
		corner.setY(corner.getY()+deltay);
	}
	
	public void print() {
		System.out.println("Rectangle : corner = ("+corner+"), dx = "+dx+", dy = "+dy);
	}

	public double getdx() {
		return this.dx;
	}
	
	public double getdy() {
		return this.dy;
	}
	
	public void setdx(double x) {
		this.dx = x;
	}
	
	public void setdy(double y) {
		this.dy = y;
	}
	
	public String svg() {
		StringWriter out = new StringWriter();
		out.write("<svg width="+corner.getX()+" height="+corner.getY()+">"
				+ "<rect width="+dx+" height="+dy+"style=\"fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)\" />"
				+ "</svg>");
		return out.toString();
	}
	
}