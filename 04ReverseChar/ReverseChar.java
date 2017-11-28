public class ReverseChar{
    private String data;

    public ReverseChar(){
	data = "abcdefghijklmnopqrstuvwxyz";
    }

    public ReverseChar(String info){
	data = "";
	String temp = info;
	for (int x = temp.super.length() - 1; x > -1; x--){
	    data += temp.subString(x,x+1);
	}
    }
    public char charAt(int index){
	return (char)data.substring(index,index+1);
    }
}
