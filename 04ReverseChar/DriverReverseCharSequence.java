public class DriverReverseCharSequence{
  public static void main(String[] args){
    ReversedCharSequence x = new ReversedCharSequence();
    System.out.println(x);
    ReversedCharSequence y = new ReversedCharSequence("SequenceOfCharacters");
    System.out.println(x);
    System.out.println(x.charAt(0));
    System.out.println(x.subSequence(0,3));
    System.out.println(y);
    System.out.println(y.charAt(0));
    System.out.println(y.subSequence(0,3));
    ReversedCharSequence a = new ReversedCharSequence("hello");
    System.out.println(a);
    System.out.println(a.length());
    System.out.println(a.charAt(3));
    System.out.println(a.subSequence(0,3));
  }
}
