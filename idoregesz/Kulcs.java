package harschr.idoregesz;

public class Kulcs {

    private boolean isThereAKey;
    private String description;

    public Kulcs(String description, boolean isThereAKey) {
        this.description = description;
        this.isThereAKey = isThereAKey;
    }

    public boolean isThereAKey(String key) {
        if (!isThereAKey) {
            return false;
        }
        return true;
    }
    
    public void setKey () {
        isThereAKey = true;
    }
}
