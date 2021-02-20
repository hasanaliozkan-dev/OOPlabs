package drawing.version2;

import java.util.ArrayList;

import shapes.Circle;
import shapes.Rectangle;

public class Drawing {
	
	private ArrayList<Circle> circles = new ArrayList<Circle>();
	private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
	
	public double calculateTotalArea(){
		double totalArea = 0;

		for (Circle circle : circles){
			totalArea += circle.area();    
		}
		
		for (Rectangle rect : rectangles){            
			totalArea += rect.area();     
		}		
		return totalArea;
	}
	
	public void addCircle(Circle c) {
		circles.add(c);
	}
	
	public void addRectangle(Rectangle r) {
		rectangles.add(r);
	}
}
