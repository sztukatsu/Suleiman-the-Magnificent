import java.awt.geom.Point2D;import java.awt.*;
public abstract class Shape
{
    private Point2D.Double center;private double radius;private Color color;    
    public Shape(Point2D.Double center, double radius, Color color)
    {
        this.color = color;this.center = center;this.radius = radius;
    }
    public Point2D.Double getCenter(){return this.center;}    
    public double getRadius(){return this.radius;}    
    public Color getColor(){return this.color;}    
    public void move(double x, double y)
    {
        this.center.setLocation((this.center.getX() + x), (this.center.getY() + y));
    }
    public void setRadius(double r){this.radius = r;}
    public abstract boolean isInside(Point2D.Double point);
    public abstract void draw(Graphics2D g2, boolean filled);
}