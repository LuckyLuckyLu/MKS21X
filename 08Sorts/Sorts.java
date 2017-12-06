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
	for (int i = 0; i < data.length; i++){
	    if(
	       ){}
	}
    }
}
