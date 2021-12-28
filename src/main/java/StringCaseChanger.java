public class StringCaseChanger implements StringTransformer{
    @Override
    public void execute(StringDrink drink) {
        String s = drink.getText(), new_s = "";
        for (int i=0;i<s.length();i++)
        {
            if (Character.isLowerCase((s.charAt(i))))
                new_s += Character.toUpperCase(s.charAt(i));
            else
                new_s += Character.toLowerCase(s.charAt(i));
        }
        drink.setText(new_s);
    }
}
