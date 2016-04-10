import java.awt.geom.*;import java.awt.*;
public class Triangle extends Shape
{
    public Triangle(Point2D.Double center, double radius, Color color)
    {
        super(center, radius, color);
    }
    public boolean isInside(Point2D.Double point)
    {
        double xTopLeft = this.getCenter().getX() - this.getRadius();
        double yTopLeft = this.getCenter().getY() - this.getRadius();        
        int diameter = (int) this.getRadius() * 2;
        int[] xVals = new int[]{(int)xTopLeft, (int)xTopLeft+diameter, (int)xTopLeft+diameter/2};
        int[] yVals = new int[]{(int)yTopLeft, (int)yTopLeft, (int)(yTopLeft+diameter*1.73/2)};
        Polygon polygon = new Polygon(xVals,yVals,3);
        return polygon.contains(point);
    }
    public void draw(Graphics2D m8, boolean filled)
    {
        double xTopLeft = this.getCenter().getX() - this.getRadius();
        double yTopLeft = this.getCenter().getY() - this.getRadius();        
        int diameter = (int) this.getRadius() * 2;
        int[] xVals = new int[]{(int)xTopLeft, (int)xTopLeft+diameter, (int)xTopLeft+diameter/2};
        int[] yVals = new int[]{(int)yTopLeft, (int)yTopLeft, (int)(yTopLeft+diameter*1.73/2)};
        Polygon polygon = new Polygon(xVals,yVals,3);
        m8.setColor(this.getColor());
        m8.draw(polygon);
        if(filled){m8.fill(polygon);}
    }
}