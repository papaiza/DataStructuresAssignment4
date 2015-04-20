package A4Q1;
import java.util.*;

/**
 *
 * Provides two static methods for sorting Integer arrays (heapSort and mergeSort)
 * @author Anton Sitkovets
 */
public class YorkArrays {

    /* Sorts the input array of Integers a using HeapSort.  Result is returned in a.
     * Makes use of java.util.PriorityQueue.  
       Sorting is NOT in place - PriorityQueue allocates a separate heap-based priority queue. 
       Not a stable sort, in general.  
       Throws a null pointer exception if the input array is null.  */
    public static void heapSort(Integer[] a) throws NullPointerException {
    	if(a == null)
    		throw new NullPointerException("Input array is null");
    	
    	int size = a.length;
    	PriorityQueue<Integer> sortedHeap = new PriorityQueue<Integer>(size);
    	for( int i = 0; i < size ; i++){
    		if(a[i] == null){
    			continue;
    		}else{
        		sortedHeap.offer(a[i]);
    		}
    	}
    	for (int j = 0 ; j < size ; j++){
    		if (a[j] != null){
    			a[j] = sortedHeap.poll();
    		}
    	}
       
    }
    
    /* Sorts the input array of Integers a using mergeSort and returns result.
     * Sorting is stable.
       Throws a null pointer exception if the input array is null. */
    public static Integer[] mergeSort(Integer[] a)  throws NullPointerException {
        return(mergeSort(a, 0, a.length-1));
    }
    
    /* Sorts the input subarray of Integers a[p...q] using MergeSort and returns result.
     * Sorting is stable.
     */
    private static Integer[] mergeSort(Integer[] a, int p, int q) {
    	
    	if(a == null){
    		throw new NullPointerException("Input array is null");
    	}else if (q - p > 1){
        	
    		int mid = (q- p)/2;
        	
        	Integer[] subArray1 = new Integer[mid];
    		Integer[] subArray2 = new Integer[a.length - mid];
    		
    		subArray1 = Arrays.copyOf(a, mid);
    		subArray2 = Arrays.copyOfRange(a, mid, a.length);
        	
        	subArray1 = mergeSort(subArray1, 0, subArray1.length);
        	subArray2 = mergeSort(subArray2, 0, subArray2.length);
        	return merge(subArray1, subArray2);
        }else{
        	return a;
        }
    	
    	
    }
    
    /* Merges two sorted arrays of Integers into a single sorted array.  Given two
     * equal elements, one in a and one in b, the element in a precedes the element in b.
     */
    private static Integer[] merge(Integer[] a, Integer[] b) {
        int i = 0, j = 0, k = 0;
        Integer[] mergedArray = new Integer[a.length + b.length];
        
        try{
        	while (i < a.length && j < b.length){
            	if(a[i] <= b[j]){
            		mergedArray[k] = a[i];
            		i++; 
            	}else{
            		mergedArray[k] = b[j];
            		j++; 
            	}
            	k++;
            }
        }catch(NullPointerException e){
        	if(a[i] == null){
                i++;
            }else{
            	j++;
            }

        }
        
        while(i < a.length){
        	mergedArray[k] = a[i];
    		i++; k++;
        }
        while (j < b.length){
        	mergedArray[k] = b[j];
    		j++; k++;
        }
        return mergedArray;
    }
}