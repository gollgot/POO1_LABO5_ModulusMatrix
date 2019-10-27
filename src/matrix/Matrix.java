/*
 * Fichier  : Matrix.java
 * Auteurs  : Dessaules Loïc, Kayoumi Doran
 * But      : Classe permettant de modéliser une Matrice. Nous allons pouvoir créer des Matrices, les afficher ou en faire
 *            des opérations arithmétiques.
 * Date     : 26.10.2019
 */

package matrix;

public class Matrix {

    private int n;
    private int m;
    private int modulus;
    private int[][] content;

    // TODO : Vu que testModulus et testMatrixDimension peuvent throws une RuntimeException, est-ce que les constructeurs doivent aussi @throws RuntimeException ??


    /**
     * Matrix constructor that will create a N x M Matrix, contains random values between 0 and modulus-1
     *
     * @param n The row size
     * @param m The column size
     * @param modulus The modulus
     */
    public Matrix(int n, int m, int modulus) {
        testModulus(modulus);
        testMatrixDimension(n,m);

        this.n = n;
        this.m = m;
        this.modulus = modulus;
        this.content = new int[n][m];

        randomPopulate();
    }

    /**
     * Matrix constructor that will create a Matrix contains values (between 0 and modulus-1) passed in parameter
     *
     * @param values The values (as int[][]) that will be contains into the Matrix
     * @param modulus The modulus
     */
    public Matrix(int[][] values, int modulus) {
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

    /**
     * Populate the Matrix with values between 0 and modulus-1
     */
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

    /**
     * Addition of the current Matrix and the Matrix in parameter. The addition will be component by component and the
     * result will be modulus N (modulus passed into the constructor)
     *
     * @param other The Matrix that we'll add to the current one
     *
     * @return A new Matrix that is the result of the addition
     */
    public Matrix add(Matrix other) {
        return doOperation(other, new Addition());
    }

    /**
     * Subtraction of the current Matrix and the Matrix in parameter. The subtraction will be component by component
     * and the result will be modulus N (modulus passed into the constructor)
     * @param other The Matrix that will be subtract to the current one
     * @return A new Matrix that is the result of the subtraction
     */
    public Matrix sub(Matrix other) {
        return doOperation(other, new Subtraction());
    }

    /**
     * Multiplication of the current Matrix and the Matrix in parameter. The multiplication will be component by
     * component and the result will be modulus N (modulus passed into the constructor)
     *
     * @param other The Matrix that we'll multiply to the current one
     *
     * @return A new Matrix that is the result of the multiplication
     */
    public Matrix multiply(Matrix other) {
        return doOperation(other, new Multiplication());
    }

    /**
     * Representation of the current Matrix
     * @return The string that represents the current Matrix
     */
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

    /**
     * Test a modulus. It cannot be 0 or minus because of the matrix values that must be between 0 and modulus-1
     *
     * @param modulus The modulus
     *
     * @throws RuntimeException if the modulus is 0 or minus
     */
    private void testModulus(int modulus){
        // The matrix values must be between 0 and modulus - 1, so we cannot have a modulus of 0
        if (modulus <= 0) {
            throw new RuntimeException("We cannot have a modulus of 0 because the matrix values must be between 0 and modulus - 1");
        }
    }

    /**
     * Test the matrix dimension. We cannot have void or negative dimensions
     *
     * @param n The row size of the Matrix
     * @param m The column size of the Matrix
     *
     * @throws RuntimeException if the one or more matrix dimension is 0 or negative
     */
    private void testMatrixDimension(int n, int m) {
        if(n <= 0 || m <= 0){
            throw new RuntimeException("Matrix dimension cannot be void or negative");
        }
    }

    /**
     * Perform an arithmetic operation
     *
     * @param other The second Matrix that will be used with the current one to do the arithmetic operation
     * @param operation The arithmetic operation that we'll apply to the current and other Matrix
     * @return A new Matrix that will be the result of the operation
     *
     * @throws RuntimeException if both Matrix have not the same modulus
     */
    private Matrix doOperation(Matrix other, Operation operation){
        // Both modulus must be the same
        if (this.modulus != other.modulus) {
            throw new RuntimeException("Both matrix must have the same modulus");
        }

        int maxN = Math.max(this.n, other.n);
        int maxM = Math.max(this.m, other.m);

        Matrix result = new Matrix(maxN, maxM, this.modulus);

        // Do the arithmetic operation component by component
        for (int row = 0; row < maxN; ++row) {
            for(int col = 0; col < maxM; ++col){
                // Complete with 0 value if matrix have not the same rows or columns size
                int op1 = row >= this.n || col >= this.m ? 0 : this.content[row][col];
                int op2 = row >= other.n || col >= other.m ? 0 : other.content[row][col];
                int operationResult = operation.calculate(op1, op2);
                // We used Math.floorMod instead of % to have the good result with negative numbers
                result.content[row][col] = Math.floorMod(operationResult,result.modulus);
            }
        }

        return result;
    }
}
