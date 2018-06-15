
public class LukeySim {
private String[] excuses1 = {"Sorry, I'm ","Sorry, I can't talk, I'm","Oh! I'm sorry, I'm about to start","Gotta run, I'm"};
private String[] excuses2 = {" playing xbox."," playing factorio."," eating dinner."," watching a movie.", 
		" going on a bike ride."," making cheese dip."};
private String[] salutations = {"Cya!","Talk to you later","See ya!","Thanks, talk to you later"}; //Are salutations like goodbye or hello? idc that's what I'm calling the variable
private int response_count = 5; 
private String[] fine = {"Good","Fine","Alright","Pretty good"};
private String[] up = {"Nothing much","Not much","Hangning out"};

private int findKeyword(String statement, String goal, int startPos)
{
	String phrase = statement.trim();

	int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
	

	while (psn >= 0) 
	{

		String before = " ", after = " "; 
		if (psn > 0)
		{
			before = phrase.substring (psn - 1, psn).toLowerCase();
		}
		if (psn + goal.length() < phrase.length())
		{
			after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
		}
		
		if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  
				&& ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
		{
			return psn;
		}
		

		psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
		
	}
	
	return -1;
}

public String getResponse(String statement)
{
	response_count--;
	if(response_count<2){
		return bye();
	}
	int psn;

	if (statement.length() != 0){
			if((findKeyword(statement, "up", 0)!=-1||statement.contains("doing")) && (statement.toLowerCase().contains("what")||statement.toLowerCase().contains("been"))){
				Double i = (Math.random()*up.length-1);
				return up[i.intValue()];
			}
			else if(statement.toLowerCase().contains("how")||statement.toLowerCase().contains("doing")){
				Double i = (Math.random()*fine.length-1);
				return fine[i.intValue()];
			}
			
				
		}
	else{
		return "";
	}
	return "cool";
}
	public String question(String statement){
		
		return "a";
	}
	public String bye(){
		if(response_count==1){
		Double i= (Math.random()*excuses1.length-1);
		int pos = i.intValue();
		i = (Math.random()*excuses2.length-1);
		return excuses1[pos].concat(excuses2[i.intValue()]);
		}
		else if(response_count==0){
			Double i = (Math.random()*salutations.length-1);
			return salutations[i.intValue()];
		}
		else{
			return null;
		}
	}
	public boolean cont(){
		if(response_count<1){
			return false;
		}
		else{
			return true; 
		}
	}

}
