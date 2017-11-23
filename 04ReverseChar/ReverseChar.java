public class ReverseChar implements CharSequence{
  private String data;

  public ReverseChar(){
    data = "abcdefghijklmnopqrstuvwxyz";
  }

  public ReverseChar(String info){
    data = "";
    for (int x = info.length() - 1; x >= 0; x--) {
      if (x == info.length() - 1){
        data += info.substring(x);
      } else {
        data += info.substring(x,x+1);
      }
    }
  }

  public String getData(){
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

  public static void main(String[] args){
    ReverseChar x = new ReverseChar();
    System.out.println(x.getData());
    ReverseChar y = new ReverseChar("SequenceOfCharacters");
    System.out.println(x.getData());
    System.out.println(x.charAt(0));
    System.out.println(x.subSequence(0,3));
    System.out.println(y.getData());
    System.out.println(y.charAt(0));
    System.out.println(y.subSequence(0,3));
  }
}
