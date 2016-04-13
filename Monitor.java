

class Monitor {
  private String[] arr1;
  private String[] arr2;

  synchronized void putInn(String[] arr){
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
    }
    else{
      arr2 = arr;
    }

  }//github

  synchronized ToArrayer hentTo(){
    /*while(arr1 == null || arr2 == null){

    }*/
    String[] temp1 = arr1;
    String[] temp2 = arr2;
    arr1 = null;
    arr2 = null;
    notify();
    return new ToArrayer(temp1, temp2);

  }
}
