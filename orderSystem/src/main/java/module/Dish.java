package module;

public class Dish {
    private final String DishId;
    private String DishName;
    private double DishPrice;
    private boolean DishAvailability;
    private final String D_RestaurantId;


    public Dish(String DishId, String DishName, double DishPrice, boolean DishAvailability, String D_RestaurantId) {
        this.DishId = DishId;
        this.DishName = DishName;
        this.DishPrice = DishPrice;
        this.DishAvailability = DishAvailability;
        this.D_RestaurantId = D_RestaurantId;
    }

    public String getDishId() {
        return DishId;
    }


    public String getDishName() {
        return DishName;
    }

    public double getDishPrice() {
        return DishPrice;
    }

    public boolean isDishAvailability() {
        return DishAvailability;
    }

    public String getD_RestaurantId() {
        return D_RestaurantId;
    }

    public void setDishName(String DishName) {
        this.DishName = DishName;
    }

    public void setDishPrice(double DishPrice) {
        this.DishPrice = DishPrice;
    }

    public void setDishAvailability(boolean DishAvailability) {
        this.DishAvailability = DishAvailability;
    }

}
