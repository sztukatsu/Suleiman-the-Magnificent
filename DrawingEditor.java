import javax.swing.JFrame;import java.awt.BorderLayout;
public class DrawingEditor extends JFrame
{
    private DrawingPanel canvas;
    private ControlPanel controls;
    private int height;
    private int width;
    public DrawingEditor()
    {
        canvas = new DrawingPanel();
        controls = new ControlPanel(canvas);
        this.height = (int)canvas.getPreferredSize().getWidth();
        this.width = (int)canvas.getPreferredSize().getHeight();
        this.add(canvas, BorderLayout.CENTER);
        this.add(controls, BorderLayout.SOUTH);
        this.setTitle("Drawing Editor");
        this.setSize(this.width, this.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args)
    {
        DrawingEditor deditor = new DrawingEditor();
    }
}