public class ReversedCharSequence implements CharSequence{
    private String data;

    public ReversedCharSequence(){
	data = "abcdefghijklmnopqrstuvwxyz";
    }

    public ReversedCharSequence(String info){
	data = "";
	for (int x = info.length() - 1; x >= 0; x--) {
	    if (x == info.length() - 1){
		data += info.substring(x);
	    } else {
		data += info.substring(x,x+1);
	    }
	}
    }

    public String toString(){
	return data;
    }

    public int length(){
	return data.length();
    }


    public char charAt(int index){
	return data.charAt(index);
    }

    public CharSequence subSequence(int start, int end){
	return data.subSequence(start,end);
    }
}
