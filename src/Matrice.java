public class Matrice {

    int n;
    int m;
    int modulo;

    public Matrice(int n, int m, int modulo){
        // The matrix size n and m must be between 0 and modulo - 1
        if(n >= modulo || m >= modulo ||
            n < 0 || m < 0)
        {
            throw new RuntimeException("The matrix size (n and m) must be between 0 and modulo - 1");
        }

        this.n = n;
        this.m = m;
        this.modulo = modulo;

        randomPopulate();
    }

    private void randomPopulate(){
        /*
        for (int row = 0; row < this.n; ++row) {
            for(int col = 0; col < this.m; ++row){

            }
        }
        */
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
