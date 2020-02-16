package kz.pompei.kotlin_math.face;

public class FaceCalc {
  public static void main(String[] args) {

    Face f1 = new Face();
    f1.AB = 3.2;
    f1.BC = 4.2;
    f1.CD = 3.5;
    f1.AF = 6.3;
    f1.BF = 4.7;
    f1.CF = 4.0;
    f1.DF = 4.4;
    f1.AE = 9.8;
    f1.FE = 8.2;
    f1.DE = 12.2;

    Face f2 = new Face();
    f2.AB = 2.9;
    f2.BC = 4.6;
    f2.CD = 3.2;
    f2.AF = 5.6;
    f2.BF = 4.2;
    f2.CF = 4.2;
    f2.DF = 4.9;
    f2.AE = 11;
    f2.FE = 9.2;
    f2.DE = 12.8;

    Face f3 = new Face();
    f3.AB = 6;
    f3.BC = 7.7;
    f3.CD = 6.7;
    f3.AF = 11.7;
    f3.BF = 8.7;
    f3.CF = 7.8;
    f3.DF = 8.5;
    f3.AE = 17.8;
    f3.FE = 15;
    f3.DE = 22.2;

    showProv(f1, f2, f3);

  }

  private static void showProv(Face f1, Face f2, Face f3) {
    Table table = new Table();
    table.addRow("", "f1", "f2", "f3");
    table.addRow("ab", "" + f1.ab(), "" + f2.ab(), "" + f3.ab());
    table.addRow("bc", "" + f1.bc(), "" + f2.bc(), "" + f3.bc());
    table.addRow("cd", "" + f1.cd(), "" + f2.cd(), "" + f3.cd());
    table.addRow("af", "" + f1.af(), "" + f2.af(), "" + f3.af());
    table.addRow("bf", "" + f1.bf(), "" + f2.bf(), "" + f3.bf());
    table.addRow("cf", "" + f1.cf(), "" + f2.cf(), "" + f3.cf());
    table.addRow("df", "" + f1.df(), "" + f2.df(), "" + f3.df());
    table.addRow("ae", "" + f1.ae(), "" + f2.ae(), "" + f3.ae());
    table.addRow("fe", "" + f1.fe(), "" + f2.fe(), "" + f3.fe());
    table.addRow("de", "" + f1.de(), "" + f2.de(), "" + f3.de());
    table.print();
  }
}
