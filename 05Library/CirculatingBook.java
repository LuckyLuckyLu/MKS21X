public class CirculatingBook extends LibraryBook{
  private String currentHolder;
  private String dueDate;

  public CirculatingBook(String writer, String name, String ID, String extraNumber){
    super(writer,name,ID,extraNumber);
    currentHolder = null;
    dueDate = null;
  }
  public void setPatron(String newHolder){
    currentHolder = newHolder;
  }
  public void setDueDate(String newDate){
    dueDate = newDate;
  }
  public String getPatron(){
    return currentHolder;
  }
  public String getDueDate(){
    return dueDate;
  }
  public void checkout(String patron, String dateDue){
    currentHolder = patron;
    dueDate = dateDue;
  }
  public void returned(){
    currentHolder = null;
    dueDate = null;
  }
  public String circulationStatus(){
    if (currentHolder == null){
      return " Book available on shelves.";
    } else {
      return " The book is currently out. Checked out by " + currentHolder + ".  Will be returned on " + dueDate;
    }
  }

  public String toString(){
    String result = super.toString();
    if (currentHolder != null){
      result += currentHolder + dueDate;
    }
    return result;
  }

}
