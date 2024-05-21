package module;

public class Dish {
    private final int DishId;
    private String DishName;
    private double DishPrice;
    private boolean DishAvailability;
    private final int D_RestaurantId;


    public Dish(int DishId, String DishName, double DishPrice, boolean DishAvailability, int D_RestaurantId) {
        this.DishId = DishId;
        this.DishName = DishName;
        this.DishPrice = DishPrice;
        this.DishAvailability = DishAvailability;
        this.D_RestaurantId = D_RestaurantId;
    }

    public int getDishId() {
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

    public int getD_RestaurantId() {
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
