import java.util.Arrays;

public class Sorts{
  public static String name(){
    return "09.Lu.Andrew";
  }
  private static void swap(int[]ary,int a, int b){
    int c =ary[a];
    ary[a] = ary[b];
    ary[b] = c;
  }
  public static void selectionSort(int[] data){
    for (int i = 0; i < data.length; i++){
      int index = i;
      int Min = data[i];
      int location = i;
      for (int j = i+1; j < data.length; j++){
        if (Min > data[j]){
          Min = data[j];
          location = j;
        }
      }
      swap(data,index,location);
    }
  }
  public static void insertionSort(int[] data){
    for (int i = 1; i < data.length; i++){
      int j = i;
      while (j > 0 && data[j] < data[j-1]){
	  swap(data,j,j-1);
	  j -= 1;
      }
    }
  }
  public static void main(String[]args){
	// testing selectionSort
	//int[] a = new int[5];
	//for (int i = 0; i < a.length; i++){
	//    a[i] = (int)(Math.random()*100);
	//}
	//System.out.println(Arrays.toString(a)); //[64, 25, 12, 22, 11]
	//System.out.println(isSorted(a)); //false
	//selectionSort(a); 
	//System.out.println(Arrays.toString(a)); //[11, 12, 22, 25, 64]
	//System.out.println(isSorted(a)); //true

	// testing bogoSort
	//int[] randish = new int[5];
	//for (int i = 0; i < randish.length; i++){
	//    randish[i] = (int)(Math.random()*100);
	//}
	//System.out.println(Arrays.toString(randish));
	//bogoSort(randish);
	//System.out.println(Arrays.toString(randish));

	// testing insertionSort
	int[] ary = new int[5];
	for (int i = 0; i < ary.length; i++){
	    ary[i] = (int)(Math.random()*100);
	}
	System.out.println(Arrays.toString(ary));
	insertionSort(ary);
	System.out.println(Arrays.toString(ary));

	

    }
  
}
