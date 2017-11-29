public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String writer, String name, String ID, String extraNumber){
	super(writer,name,ID);
	callNumber = extraNumber;
	
    }
    public String getCallNumber(){
	return callNumber;
    }
    public void setCallNumber(String extraNumber){
	callNumber = extraNumber;
    }
    public int compareTo(LibraryBook other){
      if (getCallNumber().compareTo(other.getCallNumber())<0) {
        return -1;
      } else if (getCallNumber().compareTo(other.getCallNumber())>0) {
        return 1;
      } else {
        return 0;
      }
    }
    public abstract void checkout(String patron, String due);

    public abstract void returned();

    public abstract String circulationStatus();

    public String toString(){
      return super.toString() + "  " + getCallNumber() + "  "  + circulationStatus();
    }
}
