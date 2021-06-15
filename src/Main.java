public class Main {

  /**
    * @param args
    */
  public static void main(String[] args) {

    String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/palabras2.txt");
    int cantElementos = lineas.length;

    CalculadorMatricesOptimo calculadorABO = new CalculadorMatricesOptimo(cantElementos);

    int[] frecExito = new int[cantElementos + 1];
    int[] frecNoExito = new int[cantElementos + 1];
    String[] claves = new String[cantElementos + 1];
    
    // cargar FRECUENCIAS DE BUSQUEDAS EXITOSAS
    int i = 0;
    while (i < cantElementos) {
      String [] datos = lineas[i].split(" ");
      frecExito[i+1] = Integer.parseInt(datos[1]);
      frecExito[i+1] = Integer.parseInt(datos[1]);
      claves[i+1] = datos[0];
      i++;
    }
    
    
    // PALABRAS 1
    String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("src/nopalabras2.txt");
    int cantElementos2 = lineas2.length;
    // int[] frecNoExito = new int[cantElementos2];
    int h = 0;
    // cargar FRECUENCIAS DE BUSQUEDAS NO EXITOSAS
    while(h <= cantElementos) {
      frecNoExito[h] = Integer.parseInt(lineas2[h]);
      h++;
    }
    Sstem.out.ptri: frecExiton{

    }
    System.out.println(frecExito);
    System.out.println(frecNoExito);
    System.out.println(claves);
    
    /*
    calculadorABO.encontrarOptimo(cantElementos, frecExito, frecNoExito);

    // IMPRIMIR RAIZ A PARTIR DE MATRIZ R
    System.out.println("Raíz: " + calculadorABO.R[0][cantElementos]);
    
    // MOSTRAR MATRIZ R
    System.out.println("Matriz R: ");
    Util.imprimirMatriz(calculadorABO.R);
    
      // MOSTRAR MATRIZ P
    System.out.println("Matriz P: ");
    Util.imprimirMatriz(calculadorABO.P);
    
      // MOSTRAR MATRIZ W
    System.out.println("Matriz W: ");
    Util.imprimirMatriz(calculadorABO.W);

    // IMPRIMIR COSTO DEL ARBOL OPTIMO A PARTIR DE VALOR DE LA MATRIZ P
    //
    System.out.println("Costo del árbol: " + calculadorABO.P[0][cantElementos]);
    
    // AHORA ARMAR EL ARBOL BINARIO DE BUSQUEDA CORRESPONDIENTE
    TArbolBB elABO = new TArbolBB();

    calculadorABO.armarArbolBinario(0, cantElementos, claves, elABO);
    
    
    // MOSTRAR PREORDEN DEL ARBOL BB RESULTANTE
    System.out.println("Preorden: ");
    Lista<String> listaPre = elABO.preOrden();
    Nodo<String> actual = listaPre.getPrimero();
    
    while (actual != null) {
      System.out.println(actual.getEtiqueta());
      actual = actual.getSiguiente();
    }
    
    // COMPROBAR EL COSTO HALLADO EN LA MATRIZ P CON LA EJECUCION DEL METODO DE CALCULAR COSTO DEL ARBOL
    System.out.println("costo del arbol iterando: " + elABO.calcularCosto(frecExito, frecNoExito));

  */
  }
}


