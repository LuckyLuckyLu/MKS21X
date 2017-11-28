public class DriverReverseChar{
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
