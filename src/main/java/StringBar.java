public class StringBar extends Bar{
    private boolean isHappyHour;
    public StringBar() {
        this.isHappyHour = false;
    }

    public void startHappyHour () {
        isHappyHour = true;
        notifyObservers();
    }

    public void endHappyHour () {
        isHappyHour = false;
        notifyObservers();
    }

    @Override
    public void order(StringDrink drink, StringRecipe recipe) {
        recipe.mix(drink);
    }

    public boolean isHappyHour () {
        return isHappyHour;
    }
}
