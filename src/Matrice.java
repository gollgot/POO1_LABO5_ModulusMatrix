public class Matrice {

    private int n;
    private int m;
    private int modulus;
    private int[][] content;

    public Matrice(int n, int m, int modulus) {
        testModulus(modulus);
        testMatrixDimension(n,m);

        this.n = n;
        this.m = m;
        this.modulus = modulus;
        this.content = new int[n][m];

        randomPopulate();
    }

    public Matrice(int[][] values, int modulus) {
        testModulus(modulus);
        testMatrixDimension(values.length,values[0].length);

        // Test if each matrix rows have the same length
        int rowLength = values[0].length;
        for (int[] row : values) {
            if(rowLength != row.length){
                throw new RuntimeException("All the matrix rows must have the same length");
            }
        }

        // Test if each matrix values are between 0 and modulus - 1
        for(int row = 0; row < values.length; ++row){
            for(int col = 0; col < values[row].length; ++col){
                if(values[row][col] < 0 || values[row][col] > (modulus-1)){
                    throw new RuntimeException("All the matrix values must be between 0 and modulus - 1");
                }
            }
        }

        this.n = values.length;
        this.m = values[0].length;
        this.modulus = modulus;
        this.content = values;
    }


    private void randomPopulate(){
        int max = modulus - 1;
        int min = 0;
        int range = max - min + 1;

        for (int row = 0; row < this.n; ++row) {
            for(int col = 0; col < this.m; ++col){
                content[row][col] = (int)(Math.random() * range) + min;
            }
        }
    }

    public Matrice add(Matrice other) {
        return doOperation(other, new Addition());
    }

    public Matrice sub(Matrice other) {
        return doOperation(other, new Subtraction());
    }
    
    public Matrice multiply(Matrice other) {
        return doOperation(other, new Multiplication());
    }

    @Override
    public String toString() {
        String str = "";
        for (int row = 0; row < this.n; ++row) {
            for(int col = 0; col < this.m; ++col){
                str += content[row][col];
            }
            str += "\n";
        }

        return str;
    }

    private void testModulus(int modulus){
        // The matrix values must be between 0 and modulus - 1, so we cannot have a modulus of 0
        if (modulus == 0) {
            throw new RuntimeException("We cannot have a modulus of 0 because the matrix values must be between 0 and modulus - 1");
        }
    }

    private void testMatrixDimension(int n, int m) {
        if(n == 0 || m == 0){
            throw new RuntimeException("Matrix cannot be void");
        }
    }

    private Matrice doOperation(Matrice other, Operation operation){
        if (this.modulus != other.modulus) {
            throw new RuntimeException("Both matrix must have the same modulus");
        }

        int maxN = Math.max(this.n, other.n);
        int maxM = Math.max(this.m, other.m);

        Matrice sum = new Matrice(maxN, maxM, this.modulus);

        for (int row = 0; row < maxN; ++row) {
            for(int col = 0; col < maxM; ++col){
                // Complete with 0 value if matrix have not the same rows or columns
                int op1 = row >= this.n || col >= this.m ? 0 : this.content[row][col];
                int op2 = row >= other.n || col >= other.m ? 0 : other.content[row][col];
                int operationResult = operation.calculate(op1, op2);
                // We used Math.floorMod instead of % to have the good result with negative numbers
                sum.content[row][col] = Math.floorMod(operationResult,sum.modulus);
            }
        }

        return sum;
    }
}
