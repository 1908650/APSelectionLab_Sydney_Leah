
public class Digit extends Generics {
	public static final String type = "Digit";
	private static final int size = 10;
	public enum KeyType {combo, digit};
	public static KeyType key = KeyType.combo;
	private char digit;

	/*
	 * single digit object
	 */
	public Digit(char l)
	{
		this.setType(type);
		this.digit = l;
	}

	/*
	 * toString provides output based off of key setting
	 */
	@Override
	public String toString()
	{

		String output="";
		switch(key) {
		case digit:
			output += this.digit;
			break;
		case combo:
		default:
			output += type + ": " + this.digit;
		}
		return output;
	}

	/*
	 * single digit array
	 */
	public static Generics[] digitData()
	{
        int size = Digit.size;
		Generics[] Digit = new Digit[size];
		for (int i = 0; i < size; i++)
		{
			Digit[i] = new Digit( (char)('9' - i) );
		}
		return Digit;
	}

	/*
	 * main to test Digit class
	 */
	public static void main(String[] args)
	{
		Generics[] ad = digitData();
		for(Generics a : ad)
			ConsoleMethods.print("" + a + ", ");
	}

}


