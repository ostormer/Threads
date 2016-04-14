class SortTrad extends Thread{
    private String[] array;
    private Monitor mon;

    SortTrad(String[] arr, Monitor monitor){
        array = arr;
        mon = monitor;
    }

    public void run(){
        for(int i = 0; i < array.length-1; i++){
            if(array[i].compareTo(array[i+1]) > 0){
                String temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                i = -1;
            }
        }
        //Debug!"#¤%&/()=?`=)(/&EWQETUIO)RE%&DV`"
        for(String s : array){
            System.out.println(s);
        }
        System.out.println(" ");

        boolean harJobb = mon.putInn(array);


        while(harJobb){
            ToArrayer to = null;
            if(mon.erFull()){
                to = mon.hentTo();
            }
            else{
                continue;
            }

            String[] sendDenne = flett(to.arr1, to.arr2);

            for(String s : sendDenne){
                System.out.println(s);
            }
            System.out.println(" ");

            harJobb = mon.putInn(sendDenne);
        }
        System.out.println("en traad er ferdig");
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
            else if(arr1[a].compareTo(arr2[b]) > 0){
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
