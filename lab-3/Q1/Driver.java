import java.util.Objects;

class point {
    private int x;
    private int y;

    point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "(" + x + ", " + y + ")";
    }

    public boolean equals(Object obj){
        if (this == obj)
        return true;

    if (obj == null || getClass() != obj.getClass())
        return false;

    point p = (point) obj;

    return x == p.x && y == p.y;
    }

    public int hashCode(){
        return Objects.hash(x,y);
    }
}





public class Driver {
    public static void main(String[] args) {

        point p1[] = {
            new point(2,3),
            new point(4,3),
            new point(3,1),
            new point(6,4),
            new point(2,3),
            new point(1,2),
            new point(2,3)
        };

        int count = 0;

        for (int i = 0; i < p1.length; i++) {

            boolean duplicate = false;

            for (int j = 0; j < i; j++) {
                if (p1[i].equals(p1[j])) {
                    duplicate = true;
                    break;
                }
            }

            if (!duplicate) {
                count++;
            }
        }

        System.out.println("Distinct: " + count);
    }
}