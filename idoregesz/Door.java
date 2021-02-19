
package harschr.idoregesz;

public class Door {
    private String key;
    private boolean locked;
    private boolean closed;
    private Scene one;
    private Scene two;

    public Door(Scene one, Scene two, String key) {
        this.one = one;
        this.two = two;
        this.key = key;
        this.locked = true;
        this.closed = true;
    }

    public Door(Scene one, Scene two, boolean closed) {
        this.one = one;
        this.two = two;
        this.closed = closed;
    }

    public boolean unlock(String key) {
        if (this.key == null || this.key.equals(key)) {
            this.locked = false;
            return true;
        }
        return false;
    }

    public boolean lock(String key) {
        if (this.key == null)
            return false;
        if (this.key.equals(key)) {
            this.locked = true;
            this.closed = true;
            return true;
        }
        return false;
    }

    public boolean open() {
        if (locked) {
            return false;
        }
        this.closed = false;
        return true;
    }

    public void close() {
        this.closed = true;
    }

    public boolean isOpen() {
        return !this.closed;
    }

    public Scene getOtherSide(Scene thisSide) {
        if (thisSide == one) {
            return two;
        }
        if (thisSide == two) {
            return one;
        }
        return thisSide;
    }
}
