import java.util.List;

public class StringTransformerGroup implements StringTransformer{
    private List<StringTransformer> l;

    public StringTransformerGroup(List<StringTransformer> l) {
        this.l = l;
    }

    @Override
    public void execute(StringDrink drink) {
        for (StringTransformer t:l)
        {
            t.execute(drink);
        }
    }
}
