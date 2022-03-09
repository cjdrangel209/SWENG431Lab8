
package lab8;

/**
 *
 * @author Cory Drangel
 * @author Noah Spott
 */
public class Box {
        private int l, w, h;

    public int getVolume(){
        return l * w * h;
    }

    public void setBox(int l, int w, int h){
        this.l = l;
        this.w = w;
        this.h = h;
    }

    public Box(){
        l = 1;
        w = 1;
        h = 1;
    }

    public Box(int l, int w, int h){
        this.l = l;
        this.w = w;
        this.h = h;
    }
}
