package shapes;

import shapes.Shape2D;

public class Point2D extends Shape2D {
    private double x, y;
    
    public Point2D(double x, double y, String name) {
        this.name = name;
    	this.x = x;
        this.y = y;
    }
    public Point2D(double x, double y) {
        this(x, y,"noname");
    }
    
    
    public Point2D(Point2D p, String name) {
        this(p.x, p.y,p.name);
        
    }
    
    public String toString() {
        return "Point2D (" + x + ", "  + y + ")";
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void translate(int dx, int dy) {
        x = x + dx;
        y = y + dy;
    }

    public void print() {
        System.out.println(this);
    }

    public double distance(Point2D p){
        double d1 = p.x - x;
        double d2 = p.y - y;
        return Math.sqrt(d1*d1 + d2*d2);
    }
        
    public boolean equals(Object o) {
    	if (o != null && o instanceof Point2D) {
    		return ( this.getX()==((Point2D) o).getX() && this.getY()==((Point2D) o).getY() );
    	}
    	else {
    		return false;
    	}

    }
    
    

}