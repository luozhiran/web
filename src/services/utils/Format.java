package services.utils;

import java.util.HashMap;

public class Format {

    private static class Hold {
        static final Format format = new Format();
    }

    public static Format instance() {
        return Hold.format;
    }


    private static int mLineCount;

    public void start(int count) {
        mLineCount = count;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|");
        for (int i = 0; i < mLineCount; i++) {
            stringBuilder.append("~");
        }
        stringBuilder.append("|");
        System.out.println(stringBuilder.toString());
    }


    public void drawLine(String... name) {
        HashMap<Integer, Position> map = new HashMap<>();
        int itemCount = mLineCount / name.length;
        for (int i = 0; i < name.length; i++) {
            Position p = new Position(itemCount * i, itemCount + itemCount * i);
            map.put(i, p);
        }

        StringBuilder builder = new StringBuilder();
        builder.append("|");
        boolean inserted;
        for (int i = 0; i < name.length; i++) {
            Position p = map.get(i);
            int start = 0;
            int end = 0;
            if (name[i].getBytes().length > name[i].length()) {
                start = p.start + (itemCount - name[i].length()*2) / 2;
                end = (int) (start + name[i].length()*1.7);
            } else {
                start = p.start + (itemCount - name[i].length()) / 2;
                end = start + name[i].length();
            }
            inserted = false;
            for (int j = p.start; j < p.end; j++) {
                if (j >= start && j < end) {
                    if (!inserted) {
                        inserted = true;
                        builder.append(name[i]);
                    }
                } else {
                    builder.append(" ");
                }
            }
        }
        builder.append("|");
        System.out.println(builder.toString());
    }


    public void end() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|");
        for (int i = 0; i < mLineCount; i++) {
            stringBuilder.append("_");
        }
        stringBuilder.append("|");
        System.out.println(stringBuilder.toString());
    }


    private static class Position {
        public Position(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int start;
        int end;
    }

}
