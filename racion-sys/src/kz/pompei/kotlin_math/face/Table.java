package kz.pompei.kotlin_math.face;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Table {

  private final List<List<String>> rows = new ArrayList<>();

  public void addRow(String... row) {
    rows.add(Arrays.stream(row).collect(Collectors.toList()));
  }


  public void print() {
    int maxRowSize = 0;
    for (List<String> row : rows) {
      if (maxRowSize < row.size()) {
        maxRowSize = row.size();
      }
    }

    if (maxRowSize == 0) {
      return;
    }

    for (List<String> row : rows) {
      while (row.size() < maxRowSize) {
        row.add("");
      }
    }

    List<Integer> maxLenList = null;
    for (List<String> row : rows) {
      if (maxLenList == null) {

        maxLenList = new ArrayList<>();
        for (String col : row) {
          maxLenList.add(col.length());
        }

      } else {

        for (int i = 0; i < row.size(); i++) {
          int len = row.get(i).length();
          if (maxLenList.get(i) < len) {
            maxLenList.set(i, len);
          }
        }

      }
    }

    for (List<String> row : rows) {

      for (int i = 0; i < maxLenList.size(); i++) {

        String s = row.get(i);
        int len = maxLenList.get(i) + 1;

        while (s.length() < len) {
          //noinspection StringConcatenationInLoop
          s = s + ' ';
        }

        row.set(i, s);

      }

    }

    for (List<String> row : rows) {

      for (String s : row) {
        System.out.print(s);
      }
      System.out.println();

    }
  }
}
