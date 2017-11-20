//for file stuff:
import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class WordSearch{
  private char[][] data;
  private ArrayList<String> wordsToAdd;
  private ArrayList<String> wordsAdded;
  private Random randgen;
  private int ID;

  public WordSearch(){
    System.out.println("Step right up and test out the Amazing Word Search Generator.");
    System.out.println("");
    System.out.println("To use the program, simply enter the following after Java WordSearch:");
    System.out.println("");
    System.out.println(" [# of rows] [# of columns] [name of txt file] [ID] [key: Y/N]");
    System.out.println("");
    System.out.println("The first three are mandatory for the creation of a word search");
    System.out.println("The last two are optional, but if you want the key, then you need the ID.");
    System.out.println("");
    System.out.println("For example: 10 10 Text.txt would return a 10 by 10 word search");
    System.out.println("with the words from Text.txt hidden within it.");
    System.out.println("");
    System.out.println("Another example: 10 10 Text.txt 123 Y would return a 10 by 10");
    System.out.println("word search with the words from Text.txt hidden within it");
    System.out.println("accompanied by a solution paired with that word search");
  }


  // Constructor with just fileName
  public WordSearch( int rows, int cols, String fileName){
    data = new char[rows][cols];
    clear();
    FileContents(fileName);
    wordsAdded = new ArrayList<String>();
    Random dice = new Random();
    ID = Math.abs(dice.nextInt() % 1000);
    randgen = new Random(ID);
      
  }

  // Constructor with fileName and randSeed  
  public WordSearch( int rows, int cols, String fileName, int randSeed){
    data = new char[rows][cols];
    clear();
    FileContents(fileName);
    wordsAdded = new ArrayList<String>();
    randgen = new Random(randSeed);
  }

  // Constructor with fileName, randSeed, and key  
  public WordSearch( int rows, int cols, String fileName, int randSeed, String key){
    data = new char[rows][cols];
    clear();
    FileContents(fileName);
    wordsAdded = new ArrayList<String>();
    randgen = new Random(randSeed);
  }
  
  private boolean addWord(int r, int c, String word, int rowIncrement, int colIncrement){
    if(rowIncrement == 0 && colIncrement == 0){
	    return false;
    }
    int wordLength = word.length();
    int wordIndex = 0;
    try{
	    for(int rowIndex = r, colIndex = c; wordLength > 0; rowIndex += rowIncrement, colIndex += colIncrement, wordIndex++, wordLength--){
        if(data[rowIndex][colIndex] != word.charAt(wordIndex) &&
           data[rowIndex][colIndex] != '_'){
          return false;
        }
	    }
    }
    catch(ArrayIndexOutOfBoundsException out){
	    return false;
    }
    wordLength = word.length();
    wordIndex = 0;
    for(int rowIndex = r, colIndex = c; wordIndex < wordLength;
        rowIndex += rowIncrement, colIndex += colIncrement, wordIndex++){
	    data[rowIndex][colIndex] = word.charAt(wordIndex);
    }
    wordsAdded.add(word);
    wordsToAdd.remove(word);
    return true;
  }
  
  private boolean addAllWords(){
    try{
	    for(int attempts  = 0; attempts < wordsToAdd.size() * 10000; attempts++){
        int index = randgen.nextInt(wordsToAdd.size());
        addWord(data.length - randgen.nextInt(data.length), //row num.
                data[0].length - randgen.nextInt(data.length), //column num.
                wordsToAdd.get(index), //word
                1 - randgen.nextInt(3), //rowIncrement
                1 - randgen.nextInt(3)); //columnIncrement
	    }
    }
    catch(IndexOutOfBoundsException e){
	    return true;
    }
    return true;
  }
  
  /**Initialize the grid to the size specified 

   *fill all of the positions with '_'
   *@param row is the starting height of the WordSearch
   *@param col is the starting width of the WordSearch
   */
  public WordSearch(int rows,int cols){
    data = new char[rows][cols];
    for (int i = 0; i < data.length; i++){
      for (int j = 0; j < data[i].length; j++){
        data[i][j] = '_';
      }
    }
  }

  /**Set all values in the WordSearch to underscores'_'*/
  private void clear(){
    for (int i = 0; i < data.length; i++){
      for (int j = 0; j < data[i].length; j++){
        data[i][j] = '_';
      }
    }
  }

  /**The proper formatting for a WordGrid is created in the toString.
   *@return a String with each character separated by spaces, and rows
   *separated by newlines.
   */
  public String toString(){
    String result = "";
    for (int i = 0; i < data.length; i++){
      for (int j = 0; j < data[i].length; j++){
        result += data[i][j] + " ";
      }
      result += "\n";
    }

    return result;
	
  }


  public void FileContents(String fileName){
    wordsToAdd = new ArrayList<String>();
    try{
      File file = new File(fileName);//can combine
      Scanner in = new Scanner(file);//into one line
      //NOW read the file here...
      while(in.hasNext()){
        String word = in.next();
        wordsToAdd.add(word.toUpperCase());
        //System.out.println(word);
      }
	    
    }catch(FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      System.exit(1);
    }
  }
  public int getID(){
    return ID;
  }


  public void finishingTouch(){
     for (int i = 0; i < data.length; i++){
      for (int j = 0; j < data[i].length; j++){
        if (data[i][j] == '_'){
          String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
          int N = alphabet.length();
          data[i][j] = alphabet.charAt(randgen.nextInt(N));
        }
      }
    }
  }

  public String StringOfAddedWords(){
    String result = "Find the following words: \n";
    for (int i = 0; i < wordsAdded.size(); i++){
      if (i+1 % 4 == 0){
        result += "\n";
      }
      result += wordsAdded.get(i) + "\t";
    }
    return result;
  }
  

  public static void main(String[] args){
    if(args.length <= 2){
	    WordSearch Result = new WordSearch();
    }
	
    if(args.length == 3){
	    try{
        WordSearch Result = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
        Result.addAllWords();
        Result.finishingTouch();
        System.out.println(Result.toString());
        System.out.println(Result.StringOfAddedWords());
        System.out.println("This is your ID for reference: " +  Result.getID());
	    }
	    catch(NumberFormatException e){
        System.out.println("Invalid dimensions");
        System.exit(1);
	    }
      catch(NegativeArraySizeException e){
        System.out.println("Invalid dimensions");
        System.exit(1);
      }
    }
	
    if(args.length == 4){
	    try{
        WordSearch Result = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
        Result.addAllWords();
        Result.finishingTouch();
        System.out.println(Result.toString());
        System.out.println(Result.StringOfAddedWords());
	    }
	    catch(NumberFormatException e){
        System.out.println("Invalid dimensions or seed inputted!");
        System.exit(1);
	    }
    }
	
    if(args.length == 5){
	    try{
        WordSearch Result = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]), args[4]);
        Result.addAllWords();
        if(args[4].equals("Y")){
          System.out.println(Result);
        }
        else{
          Result.finishingTouch();
          System.out.println("For the key, please type either [Y/N]. Y will return the key, N will not.");
          System.out.println(Result);
        }
	    }
	    catch(NumberFormatException e){
        System.out.println("Invalid ID!");
        System.exit(1);
	    }
    }
  }


}
