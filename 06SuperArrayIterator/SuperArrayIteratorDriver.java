public class SuperArrayIteratorDriver{
  public static void main(String[] args) {
    SuperArrayIterator data = new SuperArrayIterator();
    int i = 0;
    while(i < 26){
      data.add(""+(char)('A'+i%26));
      i++;
    }

    System.out.println(data);
    System.out.println("Standard loop:");

    for(int n = 0; n < data.size(); n++){
      System.out.print(data.get(n)+" ");
    }
    System.out.println();
    System.out.println("Data: " + data);
    System.out.println("for-each loop:");
    for(String s : data){
      System.out.print(s +" ");
    }
  }
}
