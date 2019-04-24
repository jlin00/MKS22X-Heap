public class MyHeap{
  /*
  - size  is the number of elements in the data array.
  - push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided thatchild is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
  - precondition: index is between 0 and size-1 inclusive
  - precondition: size is between 0 and data.length-1 inclusive.
  */
  private static void pushDown(int[] data, int size, int index){
    boolean sorted = false; //keeps track of whether any more swaps need to be made
    while (!sorted){ //while array is not sorted
      int idx_a = index * 2 + 1; //left child
      int idx_b = index * 2 + 2; //right child

      if (idx_a >= size && idx_b >= size) sorted = true; //if childless, terminate loop
      else{ //else either has only left child, or has both children
        int max = Math.max(data[index], data[idx_a]); //finds max between parent and left child
        if (idx_b < size) max = Math.max(max, data[idx_b]); //finds max between previous maximum and right child, if it exists

        int temp = data[index]; //temporary storage for data[index], to be used for swaps
        if (max == data[index]) sorted = true; //if parent is bigger than children, terminate loop
        else{ //if parent is not bigger than children, perform swaps
          if (max == data[idx_a]){ //if left child is the biggest
            data[index] = data[idx_a]; //swap
            data[idx_a] = temp;
            index = idx_a; //replace index
          }
          else{ //if right child is the biggest
            data[index] = data[idx_b]; //swap
            data[idx_b] = temp;
            index = idx_b; //replace index
          }
        }
      }
    }
  }

  /*
  - push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
  - precondition: index is between 0 and data.length-1 inclusive.
  */
  private static void pushUp(int[] data, int index){
    boolean sorted = false; //keeps track of whether child is in the right place (i.e. less than parent)
    while (!sorted){ //while not in the right place
      if (index == 0) sorted = true; //if no parent, then terminate loop
      else{
        int idx_parent = (index - 1) / 2;//parent
        int temp = data[index]; //temporary storage for data[index], to be used for swap
        if (temp > data[idx_parent]){ //if child is greater than parent, perform swap
          data[index] = data[idx_parent]; //swap
          data[idx_parent] = temp;
          index = idx_parent; //replace index
        }
        else sorted = true; //if child is less than or equal to parent, terminate loop
      }
    }
  }

  /*
  - convert the array into a valid heap. [ should be O(n) ]
  */
  public static void heapify(int[] data){
    int row = (int)(Math.log(data.length)/Math.log(2)); //takes the log base 2 of the data length, outputs index of second to last row of heap
    for (int i = (int)Math.pow(2, row) - 2; i >= 0; i--){ //starting the right most child on the second to last row of the heap
      pushDown(data, data.length, i); //push down children
    }
  }

  /*
  - sort the array by converting it into a heap then removing the largest value n-1 times. [ should be O(nlogn) ]
  */
  public static void heapsort(int[] data){

  }

  public static void main(String[] args){

  }

}
