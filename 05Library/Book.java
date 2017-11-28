public class Book{
    private String author;
    private String title;
    private String ISBN;

    public Book(){
	author = "none";
	title = "also none";
	ISBN = "still none";
    }
    public Book(String writer, String name, String ID){
	author = writer;
	title = name;
	ISBN = ID;
    }
    public void setAuthor(String writer){
	author = writer;
    }
    public void setTitle(String name){
	title = name;
    }
    public void setISBN(String ID){
	ISBN = ID;
    }
    public String getAuthor(){
	return author;
    }
    public String getTitle(){
	return title;
    }
    public String getISBN(){
	return ISBN;
    }

    
    
    public String toString(){
	return "" + title + ", by " + author + "  ISBN: " + ISBN;
    }
}
