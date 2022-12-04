package org.carlos.gps;

public class Search {
    private String origin;

    private String dest;

    public Search() {
    }

    public Search(String origin, String dest) {
        this.origin = origin;
        this.dest = dest;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }
}
