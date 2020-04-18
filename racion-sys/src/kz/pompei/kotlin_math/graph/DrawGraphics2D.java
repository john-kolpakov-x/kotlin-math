package kz.pompei.kotlin_math.graph;

import java.awt.Color;
import java.awt.Graphics2D;

public class DrawGraphics2D implements Draw, AutoCloseable {
  private final Graphics2D g;
  private final double width;
  private final double height;
  private Vec2 offset = new Vec2(0, 0);

  public DrawGraphics2D(Graphics2D g, double width, double height) {
    this.g = g;
    this.width = width;
    this.height = height;
  }

  @Override
  public DrawGraphics2D color(Color color) {
    g.setColor(color);
    return this;
  }

  public DrawGraphics2D offset(Vec2 offset) {
    this.offset = offset;
    return this;
  }

  private Vec2 toScreen(Vec2 a) {
    return new Vec2(a.getX() + offset.getX(), height - a.getY() - offset.getY());
  }

  @Override
  public DrawGraphics2D line(Vec2 a, Vec2 b) {
    Vec2 a1 = toScreen(a);
    Vec2 b1 = toScreen(b);
    g.drawLine(a1.getIntX(), a1.getIntY(), b1.getIntX(), b1.getIntY());
    return this;
  }

  @Override
  public void close() {
    g.dispose();
  }
}
