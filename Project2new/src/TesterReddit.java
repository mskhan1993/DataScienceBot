import java.io.*;
import java.util.Scanner;

public class TesterReddit {
	public static void main(String[] args) throws IOException 
	{
	
		RedditReader myReader=new RedditReader();
		myReader.PostWithMostComments();
		myReader.PostWithLeastComments();
		
		myReader.PostWithMostUpVotes();
		myReader.PostWithLeastUpVotes();
		
		
		System.out.println(" The part of the next code is to determine how many times a word has been used in the authors.txt and"
				+ "\n"+" followed by AuthorPost.txt which contains Author Name corresponding to Posts by Users");
		System.out.println("");
		
		System.out.println(" Focus was to check for an bot which might have posted several posts to influence people during"
				+"\n"+ " election time. Hence, First first step is to search for word : Example Bot in the authors to see how many times an author name"
				+ "\n"+" including bot made posts.");
		System.out.println("");
		
		System.out.println(" After getting a authorname which has bot included in it , we can search"
				+ "\n"+" the authorName in AuthorPosts.txt to see the posts author has posted, comments and UpVotes ");
		
		System.out.println(" Interesting author name including bot were:"
				+ "\n"+" shotbot"+  "\n"+ " turbotrump");
		System.out.println("");
		
		System.out.print("Also search for posts related to :"+ "\n"+" obama" +"\n"+ " hillary"+"\n");
		System.out.println("");
	
		 
		
	   	System.out.println("Please type the word bot or any other word you would like to analyze.");
		 myReader.wordSearch("Authors.txt");
		 System.out.println("");
		 
		 System.out.println("The next option is to enter upto three authors name to check posts corresponding to author name");
		 System.out.println("");
		 System.out.println("Please type author name to check posts made by the author");
		 myReader.wordSearch("AuthorPost.txt");
		 
		 System.out.println("Please type author name to check posts made by the author");
		 myReader.wordSearch("AuthorPost.txt");
		 
		 System.out.println("Please type author name to check posts made by the author");
		 myReader.wordSearch("AuthorPost.txt");
		 
		 System.out.println(" In the Word Doc with project further, analysis is given.");
	
		

		
			
				
	}
}

			