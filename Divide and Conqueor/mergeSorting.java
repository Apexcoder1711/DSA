class mergeSorting{

    public static void mergeSort(int arr[] , int si , int ei){

        int mid = si + (ei-si)/2;  //mid = (si+ei)/2
        if(si >= ei){
            return;
        }

        mergeSort(arr, si, mid); //for left part
        mergeSort(arr, mid+1, ei); //right part

        merge(arr, si , mid, ei);
    }

    public static void merge(int arr[] , int si , int mid , int ei){
        int temp[] = new int[ei-si+1];
        int i= si;
        int j=mid+1;
        int k=0;

        while(i <= mid && j<= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }


        //for left over element for 1st sorted part 
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        //for right over element for 2nd sorted part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }


        //copy array temp to original

        for(int idx=si, z=0 ; z<temp.length ; idx++ , z++){
            arr[idx] = temp[z];
        }
    }

    public static void printArr(int arr[]){
        for(int i=0; i<arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        System.out.println("hi");
        int arr[] = {2,5,3,7,4,1,2,3};

        mergeSort(arr , 0 , arr.length-1);
        printArr(arr);
    }
}