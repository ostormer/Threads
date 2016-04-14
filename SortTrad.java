class SortTrad extends Thread{
    private String[] arr1;
    private String[] arr2;
    private Monitor mon;

    SortTrad(String[] arr, monitor){
        arr1 = arr;
        mon = monitor;
    }

    public void run();
        for(int i = 0; i < arr1.length-1; i++){
            if(arr1[i].compareTo(arr1[i+1]) == 1){
                String temp = arr1[i];
                arr1[i] = arr1[i+1];
                arr1[i+1] = temp;
                i = -1;
            }
        }
        mon.putInn(arr1);

        boolean harJobb = true;

        while(harJobb){
            ToArrayer to = mon.hentTo();
            String[] sendDenne = flett(to.arr1, to.arr2);

            mon.putInn(sendDenne);
        }
    }

    public String[] flett(String[] arr1, String[] arr2){
        String[] flettet = new String[arr1.length + arr2.length];
        int a = 0;
        int b = 0;
        for(int i = 0; i < flettet.length; i++){
            if(a >= arr1.length){
                flettet[i] = arr2[b];
                b++;
            }
            else if(b >= arr2.length){
                flettet[i] = arr1[a];
                a++;
            }
            else if(arr1[a].compareTo(arr2[b]) == 1){
                flettet[i] = arr2[b];
                b++;
            }
            else{
                flettet[i] = arr1[a];
                a++;
            }
        }

        return flettet;
    }

}
