import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Collections;
public class OrderedSuperArray extends SuperArray{
  private String[] data;
  // private int size;
  
  public OrderedSuperArray(){
    super();
  }

  public OrderedSuperArray(int Capacity){
    super(Capacity);
  }

  public OrderedSuperArray(String[] str){
    data = new String[0];
    for (int x = 0; x < str.length; x++){
      add(str[x]);
    }
  }

  public void add(int index, String value){
    add(value);
  }
  
  public boolean add(String value){
    if (size() != 0) {
	    super.add(findIndex(value), value);
    } else {
	    super.add(value);
    }
    return true;
  }

  public String set(int x, String str){
    throw new UnsupportedOperationException();
  }

  public int findIndex(String value){
    int index = 0;
    String[] data = getData();
    int size = super.size();
    //for (int x = 0; x < data.length-1; x++) {
	  //  if (data[x] == null) {
    //    size = x;
    //    x = data.length-2;
	  //  }
    //}
    for (int x = 0; x < size; x++){
	    if (value.compareTo(data[x]) < 0){
        return index;
	    } else {
        index += 1;
	    }
    }
    return index;
  }
  public int findIndexBinary(String element){
    int index = 0;
    int start = 0;
    int end = size()-1;
    String[] data = getData();
    if (end <= 3){
	    return findIndex(element);
    }
    if (element.compareTo(data[0])<0){
	    end = 0;
    }
    while ((end - start) > 1) {
	    if (element.compareTo(data[(start + end)/2]) < 0){
        end = (start+end)/2;
        index = end;
	    } else {
        start = (start + end)/2;
        index = start;
	    }
    }
    if ((end-start)==1){
	    if (element.compareTo(data[index])>0){
        index +=1;
	    }
    }
    return index;
  }

  public int indexOfBinary(String element){
    int index = 0;
    int start = 0;
    int end = size()-1;
    String[] data = getData();
    if (end <= 3){
	    return findIndex(element);
    }
    if (element.compareTo(data[0])<0){
	    end = 0;
    }
    while ((end - start) > 1) {
	    if (element.compareTo(data[(start + end)/2]) < 0){
        end = (start+end)/2;
        index = end;
	    } else {
        start = (start + end)/2;
        index = start;
	    }
    }
    if ((end-start)==1){
	    if (element.compareTo(data[index])>0){
        index +=1;
	    }
    }
    while (element==data[index-1]){
	    index -=1;
    }
    index -=1;
    return index;
  }

  public int lastIndexOf(String element){
    int index = 0;
    int start = 0;
    int end = size()-1;
    String[] data = getData();
    if (end <= 3){
	    return findIndex(element);
    }
    if (element.compareTo(data[0])<0){
	    end = 0;
    }
    while ((end - start) > 1) {
	    if (element.compareTo(data[(start + end)/2]) < 0){
        end = (start+end)/2;
        index = end;
	    } else {
        start = (start + end)/2;
        index = start;
	    }
    }
    if ((end-start)==1){
	    if (element.compareTo(data[index])>0){
        index +=1;
	    }
    }
    while (element==data[index+1]){
	    index +=1;
    }
    return index;
  }
  public static void runTest02(int testID){
  
    if(testID<0){
	    System.out.println("Error in driver usage!");
	    System.exit(0);
    }
  
    OrderedSuperArray s1 = new OrderedSuperArray();
    ArrayList<String> s2 = new ArrayList<>();
  
    try{
	    if(testID == 0 ){
	    }
    
	    if(testID == 1 ){
        s1.add("4");
        s2.add("4");
        s1.add("1");
        s2.add("1");
        s1.add("0");
        s2.add("0");
	    }
    
	    if(testID == 2 ){
        s1.add("3");
        s2.add("3");
        //System.out.println("" + s1 + "vs" + s2);
        s1.add("1");
        s2.add("1");
        //System.out.println("" + s1 + "vs" + s2);
        s1.add("5");
        s2.add("5");
        //System.out.println("" + s1 + "vs" + s2);
        s1.add("0");
        s2.add("0");
	    }
    
	    if(testID == 3 ){
        s1.add("1");
        s2.add("1");
        for(int i = 0; i < 10; i ++){
          String v = ""+(int)(Math.random()*1000);
          int in = (int)(Math.random()*s2.size());
          s1.add(in,v);
          s2.add(in,v);
          //System.out.println("" + s1 + "vs" + s2);
        }
	    }
    
	    if(testID == 4 ){
        s1.add("1");
        s2.add("1");
        try{
          s1.set(0,"");
        } catch(UnsupportedOperationException e){
        
        }
	    }
    
	    if(testID == 5 ){
        try{
          s1.set(0,"");
        } catch(UnsupportedOperationException e){
        
        }
	    }
    
	    if(testID == 6 ){
        String[] x= {"adsf","b","X","C","fish","cat","Abby","break","romp"};
        s1 = new OrderedSuperArray(x);
        s2.addAll(Arrays.asList(x));
	    }
	    if(testID == 7 ){
        s1.add("1");
        s2.add("1");
      
        for(int i = 0; i < 1000;   i ++){
          String v = ""+(int)(Math.random()*1000);
          s1.add(v);
          s2.add(v);
        }
	    }
    
    
    }catch(Exception f){
	    s2.add("0");
	    //f.printStackTrace();
    }
  
    Collections.sort(s2);
    if(equals(s1,s2)){
	    System.out.println("Test "+testID+",PASS");
    }else{
	    System.out.println("Test "+testID+",FAIL!"+s1+"!="+s2);
    }
  }

  public static boolean equals(OrderedSuperArray s, ArrayList<String> a){
    if(s.size() == a.size()){
	    for(int i = 0; i < s.size(); i++){
        if(!s.get(i).equals( a.get(i))){

          return false;
        }
	    }
	    return true;
    }
    return false;
  }

  public static void main(String[] args){
    for (int x = 0; x < 8; x++){
	    runTest02(x);
    }
  }

}
