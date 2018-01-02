public class DriverReverseCharSequence{
  public static void main(String[] args){
    ReverseCharSequence x = new ReverseCharSequence();
    System.out.println(x.getData());
    ReverseCharSequence y = new ReverseCharSequence("SequenceOfCharacters");
    System.out.println(x.getData());
    System.out.println(x.charAt(0));
    System.out.println(x.subSequence(0,3));
    System.out.println(y.getData());
    System.out.println(y.charAt(0));
    System.out.println(y.subSequence(0,3));
  }
}
