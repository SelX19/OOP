package week8_mid_prep;

public class Dish extends MenuItem{ //IS_A relationship; dish is a menuitem that is billable

    //additional attributes:
    private CuisineType cuisineType;
    private String mainIngredient;

    //constructor:
    public Dish(String code, String name, double price, CuisineType cuisineType, String mainIngredient) {
        super(code, name, price);
        this.cuisineType = cuisineType;
        this.mainIngredient = mainIngredient;
    }

    //getters:
    public CuisineType getCuisineType() {
        return cuisineType;
    }
    public String getMainIngredient() {
        return mainIngredient;
    }

    //setters:
    public void setCuisineType(CuisineType cuisineType) {
        this.cuisineType=cuisineType;
    }
    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient=mainIngredient;
    }

    @Override
    public String getDescription(){
        return super.getDescription() + String.format(", Cuisine type: %s, Main ingredient: %s", cuisineType, mainIngredient);
    }

}
