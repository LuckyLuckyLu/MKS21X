import java.util.ArrayList;

public class SuperArray{
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
	// if (index < 0 || index >= data.length){
	//     //throw new IndexOutOfBoundsException();
	// }
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

    public static boolean equals(SuperArray s, ArrayList<String> a){
	if(s.size() == a.size()){
	    for(int i = 0; i < s.size(); i++){
		if(s.get(i) != a.get(i)){
		    return false;
		}
	    }
	    return true;
	}
	return false;
    }
    
    // public static void runTest01(int testID){
    // 	if(testID<0){
    // 	    System.out.println("Error in driver usage!");
    // 	    System.exit(0);
    // 	}
  
    // 	SuperArray s1 = new SuperArray();
    // 	ArrayList<String> s2 = new ArrayList<>();


	    
    // 	try{
    // 	    if(testID == 0 ){
    // 	    }
    
    // 	    if(testID == 1 ){
    // 		s1.add("0");
    // 		s2.add("0");
    // 		s1.add("1");
    // 		s2.add("1");
    // 	    }
    
    // 	    if(testID == 2 ){
      
    // 		s1.add("0");
    // 		s2.add("0");
    // 		s1.add("1");
    // 		s2.add("1");
    // 		s1.add(1,"5");
    // 		s2.add(1,"5");
    // 		s1.add(0,"6");
    // 		s2.add(0,"6");
    // 		s1.add(s1.size()-1,"4");
    // 		s2.add(s2.size()-1,"4");
    // 	    }
    
    // 	    if(testID == 3 ){
    // 		s1.add("0");
    // 		s2.add("0");
    // 		System.out.println("" + s1 + "&" + s2);
    // 		s1.add("1");
    // 		s2.add("1");
    // 		System.out.println("" + s1 + "&" + s2);
    // 		s1.add(1,"5");
    // 		s2.add(1,"5");
    // 		System.out.println("" + s1 + "&" + s2);
    // 		s1.add(0,"6");
    // 		s2.add(0,"6");
    // 		System.out.println("" + s1 + "&" + s2);
    // 		System.out.println("" + s1.size() + "&" + s2.size());

    // 		s1.add(s1.size(),"4");
    // 		s2.add(s2.size(),"4");
    // 		System.out.println("" + s1 + "&" + s2);
    // 	    }
    
    // 	    if(testID == 4 ){
    // 		s1.add(0,"0");
    // 		s2.add(0,"0");
    // 	    }
    
    // 	    if(testID == 5 ){
    // 		s1.add("1");
    // 		s2.add("1");
    // 		for(int i = 0; i < 10; i ++){
    // 		    String v = ""+(int)(Math.random()*1000);
    // 		    int in = (int)(Math.random()*s2.size());
    // 		    s1.add(in,v);
    // 		    s2.add(in,v);
    // 		}
    // 	    }
    
    // 	    if(testID == 6 ){
    // 		try{
    // 		    s1.get(0);
    // 		} catch(IndexOutOfBoundsException e){
        
    // 		}
    // 	    }
    
    // 	    if(testID == 7 ){
    // 		try{
    // 		    s1.set(0,"");
    // 		} catch(IndexOutOfBoundsException e){
        
    // 		}
    // 	    }
    
    // 	    if(testID == 8 ){
    // 		try{
    // 		    s1.add(1,"");
    // 		} catch(IndexOutOfBoundsException e){
       
    // 		}
    // 	    }
    // 	    if(testID == 9 ){
    // 		s1.add("1");
    // 		s2.add("1");
      
    // 		for(int i = 0; i < 1000;   i ++){
    // 		    String v = ""+(int)(Math.random()*1000);
    // 		    int in = (int)(Math.random()*s2.size());
    // 		    s1.add(in,v);
    // 		    s2.add(in,v);
    // 		}
    // 	    }
    
    
    // 	}catch(Exception f){
    // 	    //    s2.add("0");
    // 	    //f.printStackTrace();
    // 	}
    // 	if(equals(s1,s2)){
    // 	    System.out.println("Test "+testID+",PASS");
    // 	}else{
    // 	    System.out.println("Test "+testID+",FAIL");
    // 	    System.out.println("yours: " + s1 + "tested: " + s2);

    // 	}
    // }
    // public static void main(String[] args){
    // 	for (int x = 0; x < 10; x++){
    // 	    runTest01(x);
    // 	// SuperArray s1 = new SuperArray();
    // 	// ArrayList<String> s2 = new ArrayList<>();
    // 	// s1.add("0");
    // 	// s2.add("0");
    // 	// System.out.println("" + s1 + "&" + s2);
    // 	// s1.add("1");
    // 	// s2.add("1");
    // 	// System.out.println("" + s1 + "&" + s2);
    // 	// s1.add(1,"5");
    // 	// s2.add(1,"5");
    // 	// System.out.println("" + s1 + "&" + s2);
    // 	// s1.add(0,"6");
    // 	// s2.add(0,"6");
    // 	// System.out.println("" + s1 + "&" + s2);
    // 	// System.out.println("" + s1.size() + "&" + s2.size());

    // 	// s1.add(s1.size(),"4");
    // 	// s2.add(s2.size(),"4");
    // 	// System.out.println("" + s1 + "&" + s2);
    // 	}
    // }
}


