public static int[] randomizeArrayList(int[] myCard){
        Random rgen = new Random();
        for (int i=0; i<ArrayList.length; i++) {
        int randomPosition = rgen.nextInt(ArrayList.length);
        int temp = ArrayList[i];
        ArrayList[i] = ArrayList[randomPosition];
        ArrayList[randomPosition] = temp;
        }
        return ArrayList;
    }
