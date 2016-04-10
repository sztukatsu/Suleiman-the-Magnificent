import java.awt.geom.*;import java.awt.*;
public class Square extends Shape
{
    public Square(Point2D.Double center, double radius, Color color)
    {
        super(center, radius, color);
    }
    public boolean isInside(Point2D.Double point)
    {
        Rectangle2D.Double square = new Rectangle2D.Double(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), 2*this.getRadius(), 2*this.getRadius());
        return square.contains(point);
    }
    public void draw(Graphics2D m8, boolean filled)
    {
        Rectangle2D.Double square = new Rectangle2D.Double(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), 2*this.getRadius(), 2*this.getRadius());     
        m8.setColor(this.getColor());
        m8.draw(square);       
        if (filled){m8.fill(square);}         
    }
}