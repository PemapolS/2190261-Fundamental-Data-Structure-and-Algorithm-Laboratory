import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Point2Ds {
	private Point2D[] points;
	
	public Point2D getPoint(int i) {
		// Return the point object at index i 
		
		// Put your code here 
		return points[i];
	}
	
	public void readFromFile(String filename) throws FileNotFoundException {
		// Read all points stored in filename
		// Store them in the array points 
	
		// Put your code here 
		try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            ArrayList<Point2D> arrList = new ArrayList<Point2D>();
			String line;
            while ((line = reader.readLine()) != null){
            	String[] parts = line.split(" ");
                arrList.add(new Point2D(Double.parseDouble(parts[0]),Double.parseDouble(parts[1])));
            }
            points = new Point2D[arrList.size()];
            points = arrList.toArray(points);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public Point2D getClosestPointToOrigin() {
		// Return the point that is closest to the origin 
		
		// Put your code here 
		Point2D closestPoint = points[0];
		Point2D origin = new Point2D(0.0,0.0);
		for (int i = 1; i <= points.length-1; i++) {
			if (origin.distance(points[i]) < origin.distance(closestPoint)){
				closestPoint = points[i];
			}
		}
		return closestPoint;
	}

	public Point2D getClosestPoint(double x,double y) {
		// Return the point that is closest to x,y 

		// Put your code here 
		Point2D closestPoint = points[0];
		Point2D target = new Point2D(x,y);
		for (int i = 1; i <= points.length-1; i++) {
			if (target.distance(points[i]) < target.distance(closestPoint)){
				closestPoint = points[i];
			}
		}
		return closestPoint;
	}
}
