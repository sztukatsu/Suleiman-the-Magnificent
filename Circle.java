import java.awt.geom.*;import java.awt.*;
public class Circle extends Shape
{
    public Circle(Point2D.Double center, double radius, Color color)
    {
        super(center, radius, color);
    }    
    public boolean isInside(Point2D.Double point)
    {   
        Ellipse2D.Double circle = new Ellipse2D.Double(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), 2*this.getRadius(), 2*this.getRadius());
        return circle.contains(point);
    }    
    public void draw(Graphics2D m8, boolean filled)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), 2*this.getRadius(), 2*this.getRadius());     
        m8.setColor(this.getColor());        
        m8.draw(circle);
        if(filled){m8.fill(circle);}       
    }
}