/**
 *
 * @author Ernesto
 */
    public class CalculadorMatricesOptimo implements ICalculadorMatricesOptimo{

    int[][] W;
    int[][] P;
    int[][] R;

    /**
     *
     * @param cantElem
     * @param FrecExito
     * @param FrecNoExito
     */
    @Override
    public void encontrarOptimo(int cantElem, int[] FrecExito, int[] FrecNoExito) {
        int i, j, k, kraiz, h;
        int min, PesoSubArboles;

       
        /* Paso 1, para h = 0, 
            wii = bii y pii = wii
            y completar la matriz W:  wij = wij-1+ aj + bj 
       
        completa las sentencias necesarias   
        */
        for (i = 0; i <= cantElem; i++) {
            W[i][i] = FrecNoExito[i];
            P[i][i] = W[i][i];
        }

        for (i = 0; i < cantElem; i++) {
            for (j = i+1; j <= cantElem; j++) {
                W[i][j] = W[i][j-1] + FrecExito[j] + FrecNoExito[j]; 
     y       }
        }
        
        /* Paso 2,  para h = 1 
            pij = wij + pii + pjj 
            
            completa las sentencias necesarias
        */
        for(i = 0; i < cantElem; i++) {
            j = i+1;
            this.P[i][j] = this.W[i][j] + this.P[i][i] + this.P[j][j];
            this.R[i][j] = j;
        }
       
        /* Paso 3   para h = 2 hasta h = N
            completa las sentencias necesarias 
        */
        kraiz = 0;
        PesoSubArboles= 0;
        for(h = 2; h < cantElem; h++) {
            for(i=0; i<cantElem-h+1; i++) {
                j = i+h;
                min = Integer.MAX_VALUE;
                for(k = i+1; k <=j; k++) {
                    PesoSubArboles = P[i][k-1]+P[k][j];
                    if(PesoSubArboles <= min){
                        min = valor;
                        kraiz = k;
                    }
                }
                P[i][j] = min + W[i][j];
                R[i][j] = kraiz;
            }
        }
    }

    public CalculadorMatricesOptimo(int cantElem) {
        crearMatrices(cantElem);
    }

    private void crearMatrices(int cantElem) {
        W = new int[cantElem+1][cantElem+1];
        P = new int[cantElem+1][cantElem+1];
        R = new int[cantElem+1][cantElem+1];
    }

    @Override
    public void armarArbolBinario(int i, int j, String[] Claves, TArbolBB elArbolBB) {
        int unaRaiz;
        TElementoAB unNodo;
        if (i<j) {
            unaRaiz = R[i][j];
            unNodo = new TElementoAB(Claves[unaRaiz], unaRaiz);
            elArbolBB.insertar(unNodo);
            armarArbolBinario(i, unaRaiz-1, Claves, elArbolBB);
            armarArbolBinario(unaRaiz, j, Claves, elArbolBB);
        }
    }

   
}
