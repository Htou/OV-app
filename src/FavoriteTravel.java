public class FavoriteTravel {
    private String favoriteLocationA;
    private String favoriteLocationB;

    FavoriteTravel(String locationA, String locationB) {
        this.favoriteLocationA = locationA;
        this.favoriteLocationB = locationB;
    }

    public void setFavoriteLocationA(String locationA) {
        this.favoriteLocationA = locationA;
    }

    public String getFavoriteLocationA() {
        return this.favoriteLocationA;
    }

    public void setFavoriteLocationB(String locationB) {
        this.favoriteLocationB = locationB;
    }

}
