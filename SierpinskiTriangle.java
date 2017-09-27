import java.applet.*;
import java.awt.*;


public class SierpinskiTriangle extends Applet
{
	//Initializing graphics and pointers
    private Graphics g;
    private Point first,second,third, one,two,three, uno,dos,tres;

    //Altering this integer changes the number of triangles in the applet image
    int density = 8;

    //Initialization method
    public void init()
    {
    	//Setting the optional color of the background image
        setBackground( Color.BLACK);
    }

// Draws the big starter triangle
    public void paint(Graphics Triangle)
    {
    	//Optional color altercation of the triangle(s)
        Triangle.setColor( Color.green);
        
        //Setting the boundaries of the arrays then drawing the shapes
        int x[] = {10, 390, 200};
        int y[] = {390, 390, 10};
        Triangle.drawPolygon(x, y, 3);

        drawTriangle(Triangle, new Point(10,390),new Point(390,390),new Point(200,10), density);
    }


    //Function which draws the triangles
    public void drawTriangle(Graphics g, Point a, Point b, Point c, int density)
    {
        if (density == 0)
        {
        	return;
        }
        else
        {
        	density -= 1;
        }

        //Setting the size of the array for the sequential miniature triangles
        int xCoordinates[] = {c.x, (c.x+b.x)/2, (a.x+c.x)/2};
        int yCoordinates[] = {b.y, (c.y+a.y)/2, (c.y+a.y)/2};

        //Calling the function that draws them
        g.drawPolygon(xCoordinates, yCoordinates, 3);

        //Drawing surrounding triangles and initializing their starter points
        first = a;
        second = new Point(c.x, b.y);
        third = new Point((a.x+c.x)/2, (c.y+a.y)/2);
        drawTriangle(g, first, second, third, density);

        one = new Point(c.x, b.y);
        two = b;
        three = new Point((c.x+b.x)/2, (c.y+a.y)/2);
        drawTriangle(g, one, two, three, density);

        uno = new Point((a.x+c.x)/2, (c.y+a.y)/2);
        dos = new Point((c.x+b.x)/2, (c.y+a.y)/2);
        tres = c;
        drawTriangle(g, uno, dos, tres, density);
    }
}