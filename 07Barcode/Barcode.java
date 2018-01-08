import java.util.Arrays;

public class Barcode implements Comparable<Barcode>{
  private String zip;

  public Barcode(String zip){
    this.zip = zip;
    if (zip.length() != 5){
	    throw new IllegalArgumentException();
    }
    try{
	    Integer.parseInt(zip);
    }
    catch(NumberFormatException e){
	    throw new IllegalArgumentException();
    }
  }

  public static String toCode(String zip){
    String[] Table = {"||:::",":::||",
                      "::|:|","::||:",
                      ":|::|",":|:|:",
                      ":||::","|:::|",
                      "|::|:","|:|::"};
    String Coded = "|";
    int sum = 0;
    for (int i = 0; i < zip.length(); i++){
	    Coded += Table[Integer.parseInt(zip.substring(i,i+1))];
      sum += Integer.parseInt(zip.substring(i,i+1));
    }
    sum = sum % 10;

    Coded += Table[sum] + "|";
    return Coded;
  }

  public static String toZip(String code){
    String[] Table = {"||:::",":::||",
                      "::|:|","::||:",
                      ":|::|",":|:|:",
                      ":||::","|:::|",
                      "|::|:","|:|::"};
    String decoded = "";
    if ((code.length() - 2) % 5 != 0){
      //System.out.println("You didn't f*** up bro!");
      throw new IllegalArgumentException();
    }
    for (int x = 1; x < code.length() - 6; x += 5){
	    if (Arrays.binarySearch(Table, code.substring(x,x+5)) >= 0){
        decoded += Arrays.binarySearch(Table,code.substring(x,x+5));
	    } else {
        throw new IllegalArgumentException();
	    }
    }
    return decoded;
  }
  public int compareTo(Barcode other){
    if (getZip().compareTo(other.getZip())<0) {
      return -1;
    } else if (getZip().compareTo(other.getZip())>0) {
      return 1;
    } else {
      return 0;
    }
  }
  public boolean equals(Barcode other){
    if (this.compareTo(other) == 0){
      return true;
    }
    return false;
  }
  
  
  public String getZip(){
    return zip;
  }
  public String getCode(){
    return toCode(zip);
  }
  public String toString(){
    return getCode() + "(" + getZip() + ")";
  }
}
