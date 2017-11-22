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
    super(str);
  }

  public void add(int index, String value){
    add(value);
  }
  
  public boolean add(String value){
    if (size() != 0) {
      super.add(findIndexBinary(value), value);
    } else {
      super.add(value);
    }
    return true;
  }

  public int findIndex(String value){
    int index = 0;
    String[] data = getData();
    int size = data.length-1;
    for (int x = 0; x < data.length-1; x++) {
      if (data[x] == null) {
        size = x;
        x = data.length-2;
      }
    }
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
}
