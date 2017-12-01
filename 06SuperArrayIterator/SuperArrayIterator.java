public class SuperArrayIterator implements Iterable<String[]>{
  private String[] data;
  private int size;

  public String[] getData(){
    return data;
  }
  
  public SuperArray(){
    data = new String[10];
    size = data.length;
  }
  public SuperArray(int startCapacity){
    data = new String[startCapacity];
    size = data.length;
  }
  public SuperArray(String[] str){
    data = str;
    size = data.length;
  }
  public void clear(){
    for (int i = 0; i < size; i ++){
	    data[i] = null;
    }
  }
  public int size(){
    int sz = 0;
    for (int x = 0; x < data.length; x++){
	    if (data[x] != null){
        sz += 1;
	    }
    }
    return sz;
  }

  public boolean isEmpty(){
    if (size() == 0){
	    return true;
    }
    return false;
  }
  public boolean add(String element){
    String[] newData = new String[size + 1];
    int x = 0;
    for (; x < size(); x++){
	    newData[x] = data[x];
    }
    size += 1;
    newData[size()] = element;
    data = newData;
    return true;
  }

  public String toString() {
    String result = "[";
    if (size() >=  1){
      for (int x = 0; x < data.length-1; x++) {
        result += data[x] + ", ";
      }
      result += data[size()-1] +  "]";
    }else{
      result += "]";
    }
    return result;
  }

  public String get(int x) {
    if (x >= 0 && x < size()){
	    return data[x];
    }
    throw new IndexOutOfBoundsException();
  }

  public String set(int x, String str){
    if (x >= 0 && x < size()){
	    String temp = data[x];
	    data[x] = str;
	    return temp;
    }
    throw new IndexOutOfBoundsException();
  }

  private void resize(){
    String[] newSize = new String[2*size()];
    for (int x = 0; x < size(); x++){
	    newSize[x] = data[x];
    }
    data = newSize;
  }

  public boolean contains(String target) {
    for (int x = 0; x < size(); x++){
	    if (data[x].equals(target)){
        return true;
	    }
    }
    return false;
  }

  public int indexOf(String target){
    for (int x = 0; x < size(); x++){
	    if (data[x].equals(target)){
        return x;
	    }
    }
    return -1;
  }

  public int lastIndexOf(String target){
    for (int x = size() - 1; x > -1; x--){
	    if (data[x].equals(target)){
        return x;
	    }
    }
    return -1;
  }
  public void add(int index, String str){
    if (index < 0 || index >= data.length){
      throw new IndexOutOfBoundsException();
    }
    String[] newData = new String[size() + 1];
    for (int x = 0; x < index; x ++){
      newData[x] = data[x];
    }
    newData[index] = str;
    for (int x = index; x < size(); x ++){
      newData[x+1] = data[x];
    }
    data = newData;
  }

  public String remove(int index){
    if ( index >= 0 && index < size()){
	    String temp  = data[index]; 
	    String[] newData = new String[size() - 1];
	    for (int x = 0; x < index; x ++){
        newData[x] = data[x];
	    }
	    for (int x = index; x < size()-1; x ++){
        newData[x] = data[x+1];
	    }
	    data = newData;
	    return temp;
    }
    throw new IndexOutOfBoundsException();
  }

  public boolean remove(String str) {
    int index = indexOf(str);
    String[] newData = new String[size() - 1];
    for (int x = 0; x < index; x ++){
	    newData[x] = data[x];
    }
    for (int x = index; x < size()-1; x ++){
	    newData[x] = data[x+1];
    }
    data = newData;
    return true;
  }
       
}
