import java.util.ArrayList;

public class FavoriteTravelList {
    private ArrayList<FavoriteTravel> favoriteTravelListing;

    FavoriteTravelList() {
        this.favoriteTravelListing = new ArrayList<FavoriteTravel>();
    }

    public void AddFavoriteTravelToFavoriteTravelList(FavoriteTravel favoriteTravel) {
        this.favoriteTravelListing.add(favoriteTravel);
    }

    public ArrayList<FavoriteTravel> getFavoriteTravelList() {
        return this.favoriteTravelListing;
    }

}
