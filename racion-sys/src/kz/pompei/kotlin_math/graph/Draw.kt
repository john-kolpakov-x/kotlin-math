package kz.pompei.kotlin_math.graph;

import java.awt.Color;

public interface Draw {

  Draw color(Color color);

  Draw line(Vec2 a, Vec2 b);

}
