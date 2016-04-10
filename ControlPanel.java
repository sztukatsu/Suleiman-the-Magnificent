import javax.swing.*;import java.awt.Color;import java.awt.event.*;
public class ControlPanel extends JPanel
{
    private JButton color;
    private JPanel current;
    private JButton circle;
    private JButton triangle;
    private JButton square;
    private JButton remove;
    private DrawingPanel canvas;
    public ControlPanel(DrawingPanel drawpanel)
    {
        color = new JButton("Pick Color");
        circle = new JButton("Add Circle");
        triangle = new JButton("Add Triangle");
        square = new JButton("Add Square");
        remove = new JButton("Remove Active");
        current = new JPanel();
        this.canvas = drawpanel;
        this.add(color);
        this.add(current);
        this.add(circle);
        this.add(triangle);
        this.add(square);
        this.add(remove);
        this.current.setBackground(this.canvas.getColor());
        color.addActionListener(new ButtonListener());
        circle.addActionListener(new ButtonListener());
        triangle.addActionListener(new ButtonListener());
        square.addActionListener(new ButtonListener());
        remove.addActionListener(new ButtonListener());
    }
    public class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource().equals(color))
            {
                canvas.pickColor();
                current.setBackground(canvas.getColor());
            }
            else if (event.getSource().equals(circle))canvas.addCircle();
            else if (event.getSource().equals(triangle))canvas.addTriangle();
            else if (event.getSource().equals(square))canvas.addSquare();
            else if (event.getSource().equals(remove))canvas.removeShape();
        }
    }
}