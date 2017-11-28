public class ReferenceBook extends LibraryBook{
    private String collection;

    public ReferenceBook(String writer, String name,String ID,String extraNumber,String location){
	super(writer,name,ID,extraNumber);
	collection = location;
    }

   
}
