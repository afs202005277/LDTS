import java.util.List;

public class StringRecipe{
    private List<StringTransformer> recipe;

    public StringRecipe(List<StringTransformer> recipe) {
        this.recipe = recipe;
    }

    public void mix(StringDrink drink){
        for (StringTransformer t:recipe)
        {
            t.execute(drink);
        }
    }
}
