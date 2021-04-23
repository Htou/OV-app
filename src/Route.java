import java.time.LocalDateTime;
import java.util.ArrayList;

public class Route {
    Location locA;
    Location locB;

    public Route(Location locA, Location locB) {
        this.locA = locA;
        this.locB = locB;
    }


    public Location getLocA() {
        return locA;
    }

    public void setLocA(Location locA) {
        this.locA = locA;
    }

    public Location getLocB() {
        return locB;
    }

    public void setLocB(Location locB) {
        this.locB = locB;
    }
}
