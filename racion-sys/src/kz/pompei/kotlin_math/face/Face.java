package kz.pompei.kotlin_math.face;

public class Face {

  public double AB;
  public double BC;
  public double CD;
  public double AF;
  public double BF;
  public double CF;
  public double DF;
  public double AE;
  public double FE;
  public double DE;

  public double ab() {
    return AB / AF;
  }

  public double bc() {
    return BC / AF;
  }

  public double cd() {
    return CD / AF;
  }

  public double af() {
    return 1;
  }

  public double bf() {
    return BF / AF;
  }

  public double cf() {
    return CF / AF;
  }

  public double df() {
    return DF / AF;
  }

  public double ae() {
    return AE / AF;
  }

  public double fe() {
    return FE / AF;
  }

  public double de() {
    return DE / AF;
  }
}
