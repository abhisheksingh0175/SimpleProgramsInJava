
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class DuplicateCharRemover {

	public static void main(String[] args) {
		DuplicateCharRemover remover = new DuplicateCharRemover(); 
		String output = remover.removeduplicates1(args[0]);
		System.out.println(args);
		System.out.println(output);

	}

	public String removeduplicates1(String input){
		if(input == null || input.equals("")){
			return input;
		}
		char[] array = input.toCharArray();
		int len = array.length;
		for(int i=0; i<len;i++){
			for(int j=i+1; j<len; j++){
				if(array[i]==array[j]){
					for(int k = j; k<len-1; k++){
						array[k]=array[k+1];
					}
					len--;
					j--;
				}
			}
		}
		return new String(array).substring(0, len);
	}
	
	//This method is a more augmented version of previous one, as it doesn't re-shuffle the array
	//everytime it comes across a duplicate character, while it puts an empty character '\u0000' at
	//  that place, and creates a new array from original array by escaping the empty character.e
	public String removeduplicates2(String input){
		if(input == null || input.equals("")){
			return input;
		}
		char[] array = input.toCharArray();
		int len = array.length;
		for(int i=0; i<len;i++){
			for(int j=i+1; j<len; j++){
				if(array[i]!='\u0000' && array[i]==array[j]){
					array[i]='\u0000';
					}
				}
			}
		input="";
		for(int z=0;z<array.length;z++){
			if(array[z]!='\u0000') input+=array[z];
		}
		return input;
	}
}
