import java.util.ArrayList;import javax.swing.*;import java.awt.event.*;import java.awt.*;
import java.awt.geom.Point2D;
public class DrawingPanel extends JPanel
{
    private ArrayList<Shape> shapeList;
    private Shape activeShape;
    private Color color;
    private Dimension dimension;
    public DrawingPanel()
    {
        this.setBackground(Color.WHITE);
        this.color = new Color(255,0,127);
        dimension = new Dimension(800,800);
        shapeList = new ArrayList<Shape>();
        this.activeShape = null;
        this.setSize(this.dimension);
        this.addMouseListener(new MousePressListener());
        this.addMouseMotionListener(new MouseMoveListener());
    }
    public void pickColor(){this.color = JColorChooser.showDialog(null, "Pick a color", Color.BLACK);}
    public Dimension getPreferredSize(){return this.dimension;}  
    public Color getColor(){return this.color;}
    public void addCircle()
    {
        double xofCenter = this.getPreferredSize().getWidth()/2;
        double yofCenter = this.getPreferredSize().getHeight()/2;
        Point2D.Double center = new Point2D.Double(xofCenter, yofCenter);        
        double radius = 80;        
        Circle circle = new Circle(center, radius, this.color);       
        this.shapeList.add(circle);        
        this.activeShape = circle;
        repaint();
    }
    public void addTriangle()
    {
        double xofCenter = this.getPreferredSize().getWidth()/2;
        double yofCenter = this.getPreferredSize().getHeight()/2;
        Point2D.Double center = new Point2D.Double(xofCenter, yofCenter);        
        double radius = 80;        
        Triangle triangle = new Triangle(center, radius, this.color);       
        this.shapeList.add(triangle);        
        this.activeShape = triangle;
        repaint();
    }
    public void addSquare()
    {
        double xofCenter = this.getPreferredSize().getWidth()/2;
        double yofCenter = this.getPreferredSize().getHeight()/2;
        Point2D.Double center = new Point2D.Double(xofCenter, yofCenter);        
        double radius = 80;        
        Square square = new Square(center, radius, this.color);        
        this.shapeList.add(square);        
        this.activeShape = square;        
        repaint();
    }
    public void removeShape()
    {
        if(this.activeShape != null)
        {
            this.shapeList.remove(this.activeShape);
            repaint();
        }
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;       
        for (Shape shape : this.shapeList)
        {
            if (shape.equals(this.activeShape) == false)
            {
                shape.draw(g2, true);
            }
        }        
        if (this.activeShape != null)
        {
            this.activeShape.draw(g2, false);
        }
    }
    class MousePressListener implements MouseListener
    {
        public void mousePressed(MouseEvent event)
        {
            activeShape = null;
            Point2D.Double point = new Point2D.Double(event.getX(), event.getY());
            for (int i = 0; i < shapeList.size(); i++)
            {
                if (shapeList.get(i).isInside(point))
                {
                    activeShape = shapeList.get(i);
                }
            }
            repaint();
        }
        public void mouseReleased(MouseEvent event) {}
        public void mouseClicked(MouseEvent event) {}
        public void mouseEntered(MouseEvent event) {}
        public void mouseExited(MouseEvent event) {}
    }
    public class MouseMoveListener implements MouseMotionListener
    {
        /**
         * The method that is executed whenever the mouse is pressed and dragged
         */
        public void mouseDragged(MouseEvent event)
        {
            if (activeShape != null)
            {
                 Point2D.Double center = activeShape.getCenter();
                 double dx = event.getX() - center.getX();
                 double dy = event.getY() - center.getY();
                 activeShape.move(dx, dy);
            }
            repaint();
        }
        public void mouseMoved(MouseEvent event){}
    }
}