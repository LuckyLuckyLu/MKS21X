import java.util.*;

public class IterfiedArray extends SuperArrayIterator implements iterator{
  private String[] data;
  private int size;
  private int index = 0;

  public IterfiedArray(String[] d,int s){
    data = d;
    size = s;

  }
  public String next(){
    if(hasNext()){
      index ++;
    }else{
      System.exit(0);
    }

    return data.get(index-1);
  }

  public boolean hasNext(){
    return index <= size;
  }

}
