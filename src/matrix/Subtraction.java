/*
 * Fichier  : Subtraction.java
 * Auteurs  : Dessaules Loïc, Kayoumi Doran
 * But      : Classe modélisant l'opération arithmétique : soustraction. Pour se faire elle possède la méthode calculate.
 * Details  : La classe et la méthode ont une visibilité package afin de restreindre sont utilisation aux seules classes
 *            qui en ont besoin.
 * Date     : 26.10.2019
 */

package matrix;

class Subtraction extends Operation {

    /**
     * Do a subtraction between two values
     *
     * @param op1 The first operand
     * @param op2 The second operand
     * @return The result of the subtraction
     */
    @Override
    int calculate(int op1, int op2) {
        return op1 - op2;
    }

}
