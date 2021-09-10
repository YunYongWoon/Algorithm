package ex1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
    private double x, y, rad;

    public Point(double x, double y, double rad) {
        this.x = x;
        this.y = y;
        this.rad = rad;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getRad() {
        return this.rad;
    }

    public boolean check(Point point) {
        double length = Math.pow(x - point.getX(), 2) + Math.pow(y - point.getY(), 2);
        if (length < Math.pow(point.getRad(),2))
            return true;
        return false;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        int T;
        int count = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());


        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            Point start = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), 0);
            Point end = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), 0);
            int n = Integer.parseInt(bf.readLine());
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(bf.readLine());
                Point thisArea = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()),
                        Double.parseDouble(st.nextToken()));
                boolean a = start.check(thisArea);
                boolean b = end.check(thisArea);

                if(a != b)
                    count++;
            }
            System.out.println(count);
            count = 0;
        }

    }
}
