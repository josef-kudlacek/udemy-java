package eu.kudljo.emloyees;

public interface Chef {

    String favoriteFood = "hamburger";

    default void cook(String food) {
        System.out.println("I am now cooking " + food);
    }

    default String cleanUp() {
        return "I'm done cleaning up";
    }

    default String getFavoriteFood() {
        return favoriteFood;
    }

    default void setFavoriteFood(String favoriteFood) {
//        favoriteFood is final in interface and cannot be changed
//        this.favoriteFood = favoriteFood;
    }

}
