package shapes;
public abstract class Shape2D {
	
	protected String name;

    public double area() {
      return 0;
    }
    
    public double perimeter() {
        return 0;
    }
    
    public void translate(int dx, int dy) { }

    public void translate(int delta) {
        translate(delta, delta);
    }

    public void print() {
        System.out.println("Shape2D");
    }
    
    
}