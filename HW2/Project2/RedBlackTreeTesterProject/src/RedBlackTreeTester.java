import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The RedBlackTreeTester is a spell checking program used to test the re black tree.
 * @author ann
 *
 */
public class RedBlackTreeTester {
	//String tester;
	
	public RedBlackTreeTester(){	
	}
	/*not used
	 * public static char toLower(char ch){
		
	}
	public static char toUpper(char ch){
		
	}
	public static boolean isUpper(char c){
		
	}*/
	public static void main(java.lang.String[] args) throws Exception{
		
		RedBlackTree rbt=new RedBlackTree();
		
		String file_w="src/words.txt";
		FileInputStream fs = new FileInputStream(file_w);
		BufferedReader br = new  BufferedReader(new InputStreamReader(fs));
		String Line= null;
		while((Line=br.readLine())!=null)
			rbt.insert(Line);
		br.close();
		fs.close();
		
		
		//basic information
		System.out.println("Red Black Tree is loaded with " + rbt.getSize()+ " words");
		System.out.println("The height of the tree is " + rbt.height());
		System.out.println("2 * Lg( n+1) = " + 2* (Math.log(rbt.getSize() + 1) / Math.log(2)));
		System.out.println("Legal commands are: ");
		System.out.println("<d> display the entire word tree with a level order traversal.");
		System.out.println("<s>  print the words of the tree in sorted order (use an inorder traversal).");
		System.out.println("<r>  print the words of the tree in reverse sorted order.");
		System.out.println("<!> to quit.");
		System.out.println("<c> <word> to spell check this word");
		System.out.println("<a> <word> add word to tree.");
		System.out.println("<f> <fileName> to spell check a text file for spelling errors.");
		
		//interacting
		while(true){
			Scanner in = new Scanner(System.in);
			String input_string = in.nextLine();
			String[] split_input=input_string.split(" ");
			if(split_input[0].equals(">!"))
				{System.out.println("Bye_bye!");
				break;}
			if(split_input[0].equals(">d")){
				System.out.println("display the entire word tree with a level order traversal.");
				rbt.levelOrderTraversal();}
			if(split_input[0].equals(">s"))
				{System.out.println("print the words of the tree in sorted order (use an inorder traversal)");	
				rbt.inOrderTraversal();}
			if(split_input[0].equals(">r")){
				System.out.println("print the words of the tree in reverse sorted order");	
				rbt.reverseOrderTraversal();
			}
			if(split_input[0].equals(">c")){
				if(rbt.contains(split_input[1]))
					System.out.println("Found "+split_input[1]+" after "+rbt.recentCompares+" comparisons");
				else{
					System.out.println(split_input[1]+"Not in dictionary. Perhaps you mean");
					System.out.println(rbt.closeBy(split_input[1]));
				}
			}
			if(split_input[0].equals(">a")){
				rbt.insert(split_input[1]);
				System.out.println(split_input[1]+"has been successfully added to dictionary");
			}
			if(split_input[0].equals(">f")){
				String fileName=split_input[1];
				FileInputStream fs2 = new FileInputStream(fileName);
				BufferedReader br2 = new BufferedReader(new InputStreamReader(fs2));
				String file_line = null;
				int flag=0;
				while((file_line=br2.readLine())!=null){
					Pattern p=Pattern.compile("[.,\"\\?!:']");
			        Matcher m=p.matcher(file_line);
			        String onlyletter=m.replaceAll(""); 
					String[] s=onlyletter.split(" ");
					for(int i=0;i<s.length;  i++){
						if(!rbt.contains(s[i]))
							{flag=flag+1;
							System.out.println(s[i]+" was not in the dictionary");}
					}
					
				}
				if (flag==0) 
					System.out.println("No spelling errors found");
				br2.close();
				fs2.close();
			}
		}
		
	}
}
