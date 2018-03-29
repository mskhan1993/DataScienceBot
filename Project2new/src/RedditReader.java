import java.io.*;
import java.util.Scanner;

public class RedditReader {
	String fileToAnalyze;
	
	RedditReader()
	{
		//System.out.println("Default constructor");
		fileToAnalyze="";
		
	}
	

        RedditPost [] wordSearch(String fileToRead) {
    	RedditPost [] wordSearch= new RedditPost[6465];
    
     
    	try
		{
			FileReader myFileReader=new FileReader(fileToRead);
			BufferedReader myBufferReader= new BufferedReader(myFileReader);
			
			Scanner in = new Scanner(System.in);
			  System.out.println("Please type a word you would like to find?");
			  
			  String findWord= in.nextLine();
			  String findWordLC=findWord.toLowerCase();
				
			String line=null;
			int postCounter=0;
			
			
			
			
			while ((line=myBufferReader.readLine())!=null) {
			
				
				if(line.contains(findWordLC)) {
				
				System.out.println(line);
				
				
				wordSearch[postCounter]=new RedditPost(line);
				postCounter+=1;
				}
				
				
				
			}
			
			System.out.println("Your search word :"+ findWord+" was used "+postCounter+" times");
			return wordSearch;
			
		
		}
			
		
		catch (Exception ex)
		{
			System.out.println("I don't think I was able to find your file");
		}
		return wordSearch;
	}
    
	

	
	

	
	

	

        RedditPost [] getURLReddit(String fileToRead) {
    	RedditPost [] theURLPosts= new RedditPost[6465];
    	try
		{
			FileReader myFileReader=new FileReader(fileToRead);
			BufferedReader myBufferReader= new BufferedReader(myFileReader);
			String line=null;
			int postCounter=0;
			while ((line=myBufferReader.readLine())!=null)
			{
				//System.out.println(line);
				theURLPosts[postCounter]=new RedditPost(line);
				postCounter+=1;
				
				
				
			}
			//System.out.println("exited while:");
			return theURLPosts;
			
			
		}
		catch (Exception ex)
		{
			System.out.println("I don't think I was able to find your file");
		}
		return theURLPosts;
	}
    
 
 // code from class ( extended for project)   
    void PostWithMostUpVotes() {
    	RedditPost[] authors= getRedditAuthors("Authors.txt");
    	RedditPost [] urls = getURLReddit("url.txt");
    	RedditPost [] posts=getPostsReddit("RedditPosts.txt");
    	int[] numUpVotes= getUpVotesReddit("upvotes.txt");
    	
    	
 		int indexLargestNumberofupvotes=0;
		int largestNumberofupvotes=0;
		
	for(int i=0; i<numUpVotes.length;i++) {
       int numVotesPost=numUpVotes[i];
		//System.out.println("Number of Up Votes:"+ numVotesPost);
		if(numVotesPost>largestNumberofupvotes) {
			//System.out.println("Entered IF, new largest UpVotes :" + numVotesPost);
			//System.out.println("Previously we had:" + largestNumberofupvotes);
			largestNumberofupvotes=numVotesPost;
			indexLargestNumberofupvotes=i;
		}
	}
	System.out.println("Largest number of up Votes:" + largestNumberofupvotes);
	RedditPost titlePostWithMostupVotes=posts[indexLargestNumberofupvotes];
	System.out.println("The post with "+ largestNumberofupvotes + " Up Votes is " +titlePostWithMostupVotes.title);
    System.out.println("Index number of largerst number of upVotes is :"+indexLargestNumberofupvotes); 
    RedditPost authorsWithmostupVotes= authors[indexLargestNumberofupvotes];
    System.out.println("The username for author who posted is:"+authorsWithmostupVotes.title);
    RedditPost urlwithMostupVotes= urls[indexLargestNumberofupvotes];
    System.out.println("The url for the most upVoted post is :"+ urlwithMostupVotes.attachedURL);
    System.out.println("");
    }
    
    
    void PostWithLeastUpVotes() {
    	RedditPost[] authors= getRedditAuthors("Authors.txt");
    	RedditPost [] urls = getURLReddit("url.txt");
    	RedditPost [] posts=getPostsReddit("RedditPosts.txt");
    	int[] numUpVotes= getUpVotesReddit("upvotes.txt");
    	
    	int indexSmallestNumberofupvotes=0;
		int smallestNumberofupvotes=0;
		
		
		for(int i=0; i<numUpVotes.length;i++) {
			int numVotesPostS=numUpVotes[i];
			if(smallestNumberofupvotes<numVotesPostS) {
				numVotesPostS=smallestNumberofupvotes;
				indexSmallestNumberofupvotes=i;
			}
		}
		System.out.println("Smallest number of up Votes:" + smallestNumberofupvotes);
		RedditPost titlePostWithLeastupVotes=posts[indexSmallestNumberofupvotes];
		System.out.println("The post with "+ smallestNumberofupvotes + " Up Votes is " +titlePostWithLeastupVotes.title);
	    System.out.println("Index number of smallest number of upVotes is :"+indexSmallestNumberofupvotes); 
	    RedditPost authorsWithLeastupVotes= authors[indexSmallestNumberofupvotes];
	    System.out.println("The username for author who posted is:"+authorsWithLeastupVotes.title);
	    RedditPost urlwithLeastupVotes= urls[indexSmallestNumberofupvotes];
	    System.out.println("The url for the least upVoted post is :"+ urlwithLeastupVotes.attachedURL);
	    System.out.println("");
		
    }
    
    
    	

    // code from class ( extended for project)   
    void PostWithMostComments() {
    
    	RedditPost[] authors= getRedditAuthors("Authors.txt");
    	RedditPost [] urls = getURLReddit("url.txt");

 		int [] numCommentsArray=getNumCommentsReddit("numComments.txt");
 		 RedditPost [] posts=getPostsReddit("RedditPosts.txt");
 		 
 		int indexLargestNumberofComments=0;
		int largestNumberofComments=0;
		
		for ( int i=0; i<numCommentsArray.length;i++) {
			
			int numCommentsPost=numCommentsArray[i];
			
			//System.out.println("Number of Comment Post:" + numCommentsPost);
			
			if(numCommentsPost>largestNumberofComments) {
				
				//System.out.println("Entered IF, new largest Comments :" + numCommentsPost);
				//System.out.println("Previously we had:" + largestNumberofComments);
				largestNumberofComments= numCommentsPost;
				indexLargestNumberofComments=i;
			}
			
			
		}
		
		
		
		System.out.println("Largest number of comments:" + largestNumberofComments);
		RedditPost titlePostWithMostComments= posts[indexLargestNumberofComments];
		System.out.println("The post with "+ largestNumberofComments+" Comments is "+titlePostWithMostComments.title);	
		System.out.println("Index number of largerst number of Comments is :"+indexLargestNumberofComments);
		RedditPost authorWithMostComments= authors[indexLargestNumberofComments];
		System.out.println("The username for the author who posted the post is :"+authorWithMostComments.title);
		RedditPost urlWithMostComments= urls[indexLargestNumberofComments];
		System.out.println("The url for the post with most comment is :"+ urlWithMostComments.attachedURL);
		System.out.println("");
			
    }
    
 
    
    
    
    void PostWithLeastComments() {

    	RedditPost[] authors= getRedditAuthors("Authors.txt");
    	RedditPost [] urls = getURLReddit("url.txt");

 		int [] numCommentsArray=getNumCommentsReddit("numComments.txt");
 		 RedditPost [] posts=getPostsReddit("RedditPosts.txt");
 		 
 		 
    	 int indexSmallestNumberofComments=0;
         int smallestNumberofComments=0;
       
         
         for ( int i=0; i<numCommentsArray.length;i++) {
 			
 			int numCommentsPostS=numCommentsArray[i];
 			
 			//System.out.println("Number of Comment Post:" + numCommentsPost);
 			
 			if(smallestNumberofComments<numCommentsPostS) {
 				
 				//System.out.println("Entered IF, new largest Comments :" + numCommentsPost);
 				//System.out.println("Previously we had:" + largestNumberofComments);
 				numCommentsPostS=smallestNumberofComments;
 				indexSmallestNumberofComments=i;
 		
 		}
 			
 		}
 		
         System.out.println("Smallest number of comments:" + numCommentsArray[indexSmallestNumberofComments]);	
  		
 		RedditPost titlePostWithLeastComments= posts[indexSmallestNumberofComments];
 		System.out.println("The post with "+ numCommentsArray[indexSmallestNumberofComments]+" Comments is "+titlePostWithLeastComments.title);	
 		System.out.println("Index number of smallest number of Comments is :"+indexSmallestNumberofComments);
 		RedditPost authorWithLeastComments= authors[indexSmallestNumberofComments];
 		System.out.println("The username for the author who posted the post is :"+authorWithLeastComments.title);
 		RedditPost urlWithLeastComments= urls[indexSmallestNumberofComments];
 		System.out.println("The url for the post with least comment is :"+ urlWithLeastComments.attachedURL);
 		System.out.println("");	
 		
 		
 		
 		
 		
 		}
         
 		
 		
 	
    
   
    // code from class (used in Project)
	RedditPost [] getPostsReddit(String fileToRead)
	{
		RedditPost [] theDonaldPosts=new RedditPost[6465];
		
		try
		{
			FileReader myFileReader=new FileReader(fileToRead);
			BufferedReader myBufferReader= new BufferedReader(myFileReader);
			String line=null;
			int postCounter=0;
			while ((line=myBufferReader.readLine())!=null)
			{
				//System.out.println(line);
				theDonaldPosts[postCounter]=new RedditPost(line);
				postCounter+=1;
					
			}
			//System.out.println("exited while:");
			return theDonaldPosts;	
			
		}
		catch (Exception ex)
		{
			System.out.println("I don't think I was able to find your file");
		}
		return theDonaldPosts;
	}
			
	
	RedditPost[] getRedditAuthors(String fileToRead)
	{
		RedditPost [] theAuthors=new RedditPost[6465];
		
		try
		{
			FileReader myFileReader=new FileReader(fileToRead);
			BufferedReader myBufferReader= new BufferedReader(myFileReader);
			String line=null;
			int postCounter=0;
			while ((line=myBufferReader.readLine())!=null)
			{
				//System.out.println(line);
				theAuthors[postCounter]=new RedditPost(line);
				postCounter+=1;
				
				
				
			}
			//System.out.println("exited while:");
			return theAuthors;
			
			
		}
		catch (Exception ex)
		{
			System.out.println("I don't think I was able to find your file");
		}
		return theAuthors;
	}
			
	
	  // code from class (used in Project)
	public int [] getNumCommentsReddit(String fileToRead)
	{
		int [] numCommentsArray=new int[6465];
		
		try
		{
			FileReader myFileReader=new FileReader(fileToRead);
			BufferedReader myBufferReader= new BufferedReader(myFileReader);
			String line=null;
			int postCounter=0;
			while ((line=myBufferReader.readLine())!=null)
			{
				//System.out.println("Num Comments:"+line);
				int numCommentsPost=Integer.parseInt(line);
				
				numCommentsArray[postCounter]=numCommentsPost;
				postCounter+=1;
				
				
				
			}
			//System.out.println("exited while:");
			return numCommentsArray;
			
			
		}
		catch (Exception ex)
		{
			System.out.println("I don't think I was able to find your file");
		}
		return numCommentsArray;
	
		
		
		
	}
	

	
	  // code from class (Used for Project)
	public int [] getUpVotesReddit(String fileToRead)
	{
		int [] upVotes=new int[6465];
		
		try
		{
			FileReader myFileReader=new FileReader(fileToRead);
			BufferedReader myBufferReader= new BufferedReader(myFileReader);
			String line=null;
			int postCounter=0;
			while ((line=myBufferReader.readLine())!=null)
			{
				//System.out.println("Num Votes:"+line);
				int numCommentsPost=Integer.parseInt(line);
				
				upVotes[postCounter]=numCommentsPost;
				postCounter+=1;
				
				
				
			}
			//System.out.println("exited while:");
			
			
		}
		catch (Exception ex)
		{
			System.out.println("I don't think I was able to find your file");
		}
		return upVotes;
		
	
		
		
		
	}
}