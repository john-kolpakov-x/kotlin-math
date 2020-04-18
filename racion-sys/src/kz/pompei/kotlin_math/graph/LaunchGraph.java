package kz.pompei.kotlin_math.graph;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class LaunchGraph {

  public static void main(String[] args) throws Exception {
    new LaunchGraph().exec();
  }

  private void exec() throws Exception {

    BufferedImage image = new BufferedImage(1000, 700, BufferedImage.TYPE_INT_ARGB);

    Graphics2D graphics = image.createGraphics();
    graphics.setColor(Color.WHITE);
    graphics.fillRect(0, 0, image.getWidth(), image.getHeight());

    try (DrawGraphics2D d = new DrawGraphics2D(graphics, image.getWidth(), image.getHeight())
      .offset(new Vec2(500, 350))) {

      d
        .color(Color.GRAY)
        .line(new Vec2(-500, 0), new Vec2(500, 0))
        .line(new Vec2(0, -350), new Vec2(0, 350))
      ;

    }

    File file = new File("build/out-image.png");

    ImageIO.write(image, "png", file);

    System.out.println("asd");
  }

}
