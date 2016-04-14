class Monitor {
    private String[] arr1;
    private String[] arr2;
    private int antOrd;

    Monitor(int a){
        antOrd = a;
    }

    synchronized boolean putInn(String[] arr){
        while(arr1 != null && arr2 != null){
            try{
                wait();
            }
            catch(InterruptedException e){
                System.exit(0);
            }
        }
        if(arr1 == null){
            arr1 = arr;
            return true;
        }
        else{
            arr2 = arr;
            return false;
        }

    }

    synchronized ToArrayer hentTo(){
        String[] temp1 = arr1;
        String[] temp2 = arr2;
        arr1 = null;
        arr2 = null;
        notify();
        return new ToArrayer(temp1, temp2);
    }

    public boolean erFull(){
        if(arr1 != null && arr2 != null){
            return true;
        }
        else return false;
    }
}
