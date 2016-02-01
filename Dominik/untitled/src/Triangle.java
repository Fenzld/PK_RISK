import java.awt.*;

public class Triangle implements Object2D {

    private Color color;

    Triangle(Color color) {
        this.color = color;
    }

    public void changeColor() {
        if (color == Color.red) {
            color = Color.green;
        }
        else if (color == Color.green) {
            color = Color.blue;
        }
        else if (color == Color.cyan) {
            color = Color.magenta;
        }
        else if (color == Color.magenta) {
            color = Color.yellow;
        }
        else if (color == Color.yellow) {
            color = Color.darkGray;
        }
    }

    public void draw(Graphics2D g, Point ref) {
        g.setStroke(new BasicStroke(8, BasicStroke.CAP_ROUND,
            BasicStroke.JOIN_ROUND));
        g.setPaint(color);

        int[] xPoints = {
                (int)ref.getX(),
                (int)ref.getX() + 20,
                (int)ref.getX() + 40,
                (int)ref.getX()};

        int[] yPoints = {
                (int)ref.getY() + 40,
                (int)ref.getY(),
                (int)ref.getY() + 40,
                (int)ref.getY() + 40};

        g.drawPolygon(xPoints, yPoints, xPoints.length);
    }
}
