/*
 * Fichier  : Operation.java
 * Auteurs  : Dessaules Loïc, Kayoumi Doran
 * But      : Classe modélisant une operation arithmétique de manière générale. Elle est donc abstraite et possède une
 *            méthode calculate qui devra être implémentée dans chaque classe qui hérite de celle-ci.
 * Details  : La classe et la méthode ont une visibilité package afin de restreindre sont utilisation aux seules classes
 *            qui en ont besoin.
 * Date     : 26.10.2019
 */

package matrix;

abstract class Operation {
    /**
     * Abstract method that will represent a specific calculation.
     * @param op1 The first operand
     * @param op2 The second operand
     * @return The result of the calculation
     */
    abstract int calculate(int op1, int op2);
}
