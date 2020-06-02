package sulotion;

public class findLength {
    public int findLength(int[] A, int[] B) {
        int max=0;

        int[][] sum=new int[A.length+1][B.length+1];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(A[i]==B[j]){
                    sum[i][j]=sum[i+1][j+1]+1;
                    if(max<sum[i][j]) max=sum[i][j];
                }

            }

        }return max;

    }
}

