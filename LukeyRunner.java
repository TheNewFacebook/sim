import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class LukeyRunner
{

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{
		LukeySim luke = new LukeySim();
	
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.equals("Bye")&&luke.cont())
		{
			System.out.println (luke.getResponse(statement));
			statement = in.nextLine();
		}
	}

}