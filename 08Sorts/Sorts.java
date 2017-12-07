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
    public static void insertionSortWithoutSwap(int[] data){
	for (int index = 1; index < data.length; index++){
	    int j = index;
	    int FINAL = data[j];
	    while (j > 0 && FINAL < data[j-1]){
		data[j] = data[j-1];
		j = j-1;
	    }
	    data[j] = FINAL;
	}
    }  
}
