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
    String Coded = "";
    for (int i = 0; i < zip.length(); i++){
	    Coded += Table[Integer.parseInt(zip.substring(i,i+1))];
    }
    return Coded;
  }
  public int finish(){
    int sum = 0;
    for (int x = 0; x < zip.length(); x++){
	    sum += Integer.parseInt(zip.substring(x,x+1));    
    }
    return sum % 10;
  }

  public static String toZip(String code){
    String[] Table = {"||:::",":::||",
                      "::|:|","::||:",
                      ":|::|",":|:|:",
                      ":||::","|:::|",
                      "|::|:","|:|::"};
    String decoded = "";
    if (code.length() - 2 % 5 != 0){
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
    String[] Table = {"||:::",":::||",
                      "::|:|","::||:",
                      ":|::|",":|:|:",
                      ":||::","|:::|",
                      "|::|:","|:|::"};
    return "|" + toCode(zip) + Table[finish()] + "|";
  }
  public String toString(){
    String[] Table = {"||:::",":::||",
                      "::|:|","::||:",
                      ":|::|",":|:|:",
                      ":||::","|:::|",
                      "|::|:","|:|::"};
    return "|" + getCode() + Table[finish()]  + "|" + "(" + getZip() + ")";
  }
}
