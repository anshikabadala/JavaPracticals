import java.util.Objects;

public class point {
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
        if(this == obj){
            return true;
        }else{
            return false;
        }
    }

    public int hashCode(){
        return Objects.hash(x,y);
    }
}


