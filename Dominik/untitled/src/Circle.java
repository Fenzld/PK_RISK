import java.awt.*;

public class Circle implements Object2D {

    private Color color;

    Circle(Color color) {
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
        g.drawOval((int)ref.getX(), (int)ref.getY(), 40, 40);
    }
}
