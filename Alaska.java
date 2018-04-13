//James Gadoury
//MATHWORKS test - Takes in a set of string arrays and replies if they are all in the top, middle, bottom or mixed row of characters
import java.util.*;


public class Alaska {
	final String topElements[]={"q","w","e","r","t","y","u","i","o","p"};
	final String middleElements[]={"a","s","d","f","g","h","j","k","l"};
	final String bottomElements[]={"z","x","c","v","b","n","m"};
	final Set <String>  topRow=new HashSet<String>(Arrays.asList(topElements));
	final Set <String>  middleRow=new HashSet<String>(Arrays.asList(middleElements));
	final Set <String>  bottomRow=new HashSet<String>(Arrays.asList(bottomElements));
	
	
	public LinkedList<String> fillWordsList(String input)
	{
		char currCh;
		String currWord="";
		LinkedList<String> words = new LinkedList<String>();
    	for(int i=0; i<input.length();i++)
		{
			currCh=input.charAt(i);
			if(currCh==' ')
			{
				words.add(currWord);
				currWord="";
			}
			else currWord+=currCh;
			if(i==input.length()-1)
			{
				words.add(currWord);
				currWord="";
				break;
			}
			
		}
		return words;
	}
    private String[] inputCheck(LinkedList<String> words)
    {
    
    	String[] output=new String[words.size()];
    	
    	String thisWord="";
    	char thisCh;
		String rowId="";
		
		for (int j=0;j<words.size();j++)
		{
			thisWord=words.get(j).toLowerCase();
			output[j]="Yes";
			rowId="";
			for (int k=0;k<thisWord.length();k++)
			{
				
				thisCh=thisWord.charAt(k);
				if(k==0)
				{
					if(topRow.contains(Character.toString(thisCh))) rowId="top"; 
					else if(middleRow.contains(Character.toString(thisCh))) rowId="middle";
					else if(bottomRow.contains(Character.toString(thisCh))) rowId="bottom";
					else {output[j]="Invalid input";break;}
				}
				else
				{
					if(!topRow.contains(Character.toString(thisCh))&&!middleRow.contains(Character.toString(thisCh))&&!bottomRow.contains(Character.toString(thisCh)))
					{
						output[j]="Invalid input";
						break;
					}
					else
					{
						if(rowId.equals("top"))
						{
							if(!topRow.contains(Character.toString(thisCh)))
							{
								output[j]="No";
								break;
							}
						}
						else if(rowId.equals("middle"))
						{
							if(!middleRow.contains(Character.toString(thisCh)))
							{
								output[j]="No";
								break;
							}
						}
						else if(rowId.equals("bottom"))
						{
							if(!bottomRow.contains(Character.toString(thisCh)))
							{
								output[j]="No";
								break;
							}
						}
					}
							
				}
			}
		}
    	return output;
    }
	
	public static void main(String[] args) {
			Alaska f= new Alaska();
			Scanner stdin = new Scanner(System.in);
			
			String input = stdin.nextLine();
			
			LinkedList<String> words=f.fillWordsList(input);
			
			String[] response= new String[words.size()];
			response=f.inputCheck(words);
			
			for(int i=0; i<response.length;i++)
			{
				System.out.println(response[i]);
			}
			stdin.close();
			

	}

}
