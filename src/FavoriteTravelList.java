import java.util.ArrayList;

public class FavoriteTravelList {
    private ArrayList<FavoriteTravel> favoriteTravelList;

    FavoriteTravelList() {
        this.favoriteTravelList = new ArrayList<FavoriteTravel>();
    }

    public void AddFavoriteTravelToFavoriteTravelList(FavoriteTravel favoriteTravel) {
        this.favoriteTravelList.add(favoriteTravel);
    }

    public ArrayList<FavoriteTravel> getFavoriteTravelList() {
        return this.favoriteTravelList;
    }

}
