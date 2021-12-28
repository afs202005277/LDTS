public class StringReplacer implements StringTransformer{
    private char b, a;

    public StringReplacer(char b, char a) {
        this.b = b;
        this.a = a;
    }

    @Override
    public void execute(StringDrink drink) {
        drink.setText(drink.getText().replace(b, a));
    }
}
