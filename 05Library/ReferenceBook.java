public class ReferenceBook extends LibraryBook{
  private String collection;

  public ReferenceBook(String writer, String name,String ID,String extraNumber,String location){
    super(writer,name,ID,extraNumber);
    collection = location;
  }
  public void setCollection(String place){
    collection = place;
  }
  public void checkout(String patron, String due){
    System.out.println(" We apologize, " + patron + ", reference books cannot be checked out");
  }
  public void returned(){
    System.out.println(" Impossible. The reference book will foreverly remain here. BWAHAHA!");
  }
  public String circulationStatus(){
    return " A reference book that will NEVER be circulated. BWAHAHA!";
  }
  public String toString(){
    return super.toString() + " This reference book should be found in " + collection +  ".";
  }
}
