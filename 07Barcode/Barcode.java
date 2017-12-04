public class Barcode{
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

    public static 
	
	
    public String toString(){
	return "Testing";
    }
}
