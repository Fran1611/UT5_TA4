public class TElementoAB<T> implements IElementoAB<T> {

    private final Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private final T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    public TElementoAB getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB getHijoDer() {
        return hijoDer;
    }

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(TElementoAB unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public TElementoAB buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    /**
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
     */
    @Override
    public String inOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().inOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().inOrden());
        }

        return tempStr.toString();
    }

    /**
     * @return recorrida en preOrden del subArbol que cuelga del elemento actual
     */
    public String preOrden() {
        StringBuilder tempStr = new StringBuilder();
        tempStr.append(imprimir());
        if (hijoIzq != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoIzq().preOrden());
        }
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().preOrden());
        }
        return tempStr.toString();
    }

    /**
     * @return recorrida en postOrden del subArbol que cuelga del elemento
     * actual
     */
    @Override
    public String postOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        if (hijoDer != null) {
            tempStr.append(getHijoDer().postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        return tempStr.toString();
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    public T getDatos() {
        return datos;
    }

    public void setHijoIzq(TElementoAB elemento) {
        this.hijoIzq = elemento;

    }

    public void setHijoDer(TElementoAB elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }

        if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = hijoDer.eliminar(unaEtiqueta);

            }
            return this;
        }

        return quitaElNodo();
    }

    private TElementoAB quitaElNodo() {
        if (hijoIzq == null) {
            return hijoDer;
        }

        if (hijoDer == null) {
            return hijoIzq;
        }

        TElementoAB elHijo = hijoIzq;
        TElementoAB elPadre = this;

        while (elHijo.getHijoDer() != null) {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }

        if (elPadre != this) {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(hijoIzq);
        }

        elHijo.setHijoDer(hijoDer);
        return elHijo;
    }

   
 
    
 
    @Override
    public void inOrden(Lista<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);

        }
        unaLista.insertar(new Nodo<T>(this.etiqueta,this.getDatos()));
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }

    }
    @Override
      public void preOrden(Lista<T> unaLista) {
        unaLista.insertar(new Nodo<T>(this.etiqueta,this.getDatos()));
        if (hijoIzq != null) {
            hijoIzq.preOrden(unaLista);
        }

        if (hijoDer != null) {
            hijoDer.preOrden(unaLista);
        }

    }

    
    @Override
    public void postOrden(Lista<T> unaLista) {

        if (hijoIzq != null) {
            hijoIzq.postOrden(unaLista);
        }

        if (hijoDer != null) {
            hijoDer.postOrden(unaLista);
        }
        unaLista.insertar(new Nodo<T>(this.etiqueta,this.getDatos()));
    }

    @Override
    public int calcularCosto(int[] frecExito, int[] frecNoExito, int[] indiceFE, int[] indiceFNE, int nivel) {
        int res= 0;
        if(this.hijoIzq != null){
            res = res + this.hijoIzq.calcularCosto(frecExito, frecNoExito, indiceFE, indiceFNE, nivel + 1);
        } else{
            res = res + frecNoExito[indiceFNE[0]]*(nivel+1);
            indiceFNE[0] = indiceFNE[0] + 1;
        }
        res = res + frecExito[indiceFE[0]]*nivel;
        indiceFE[0]=indiceFE[0]+1;
        if(this.hijoDer != null){
            res += hijoDer.calcularCosto(frecExito, frecNoExito, indiceFE, indiceFNE, nivel + 1);
        } else{
            res += frecNoExito[indiceFNE[0]] * (nivel +1);
            indiceFNE[0] = indiceFNE[0] + 1;    
        }
        return res;
        
    }
}
