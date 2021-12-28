public class StringInverter implements StringTransformer{
    @Override
    public void execute(StringDrink drink) {
       /* String s = "", str = drink.getText();
        for (int i=str.length() - 1;i>=0;i--)
        {
            s += str.charAt(i);
        }
        drink.setText(s);*/

        StringBuilder s = new StringBuilder(drink.getText());
        s.reverse();
        drink.setText(s.toString());
    }
}
