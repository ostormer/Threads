class SortTrad extends Thread{
    private String[] arr1;
    private String[] arr2;

    SortTrad(String[] arr){
        arr1 = arr;
    }

    public void run(){
        String[] sortert = new String[arr1.length];
        String min = arr1[0];
        for(int i = 0; i < arr1.length-1; i++){
            if(arr1[i].compareTo(arr1[i+1]) == 1){
                int temp = arr1[i];
                arr1[i] = arr[i+1];
                arri[i+1] = temp;
                i = -1;
            }
        }
        monitor.taImot();
        monitor.hentTo();
    }

    public String[] flett(String[] arr1, String[] arr2){

    }

}
