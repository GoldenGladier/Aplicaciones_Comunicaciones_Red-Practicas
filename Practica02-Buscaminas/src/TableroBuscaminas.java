
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Omar
 */
public class TableroBuscaminas {
    public Casilla [][] casillas;
    int numFilas;
    int numColumnas;
    int numMinas;
    
    int numCasillasAbiertas;
    boolean juegoTerminado;
    
    private Consumer <List<Casilla>> eventoPartidaPerdida;
    private Consumer <List<Casilla>> eventoPartidaGanada;
    private Consumer<Casilla> eventoCasillaAbierta;

    public TableroBuscaminas(int numFilas, int numColumnas, int numMinas) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.numMinas = numMinas;
        
        inicializarCasillas();
    }
    
    public void inicializarCasillas(){
        casillas = new Casilla[this.numFilas][this.numColumnas];
        for(int i = 0; i < casillas.length; i++){
            for(int j = 0; j < casillas[i].length; j++){
                casillas[i][j] = new Casilla(i, j);
            }
        }
        
        generarMinas();
    }
    
    private void generarMinas(){
        int minasGeneradas = 0;
        while(minasGeneradas != numMinas){
            int posTempFila = (int)(Math.random() * casillas.length);
            int posTempColumna = (int)(Math.random() * casillas[0].length);
            
            if(!casillas[posTempFila][posTempColumna].isMina()){
                casillas[posTempFila][posTempColumna].setMina(true);
                minasGeneradas++;
            }
        }
        actualizarNumeroMinasAlrededor();
    }
    
    public void imprimirTablero(){
        for(int i = 0; i < casillas.length; i++){
            for(int j = 0; j < casillas[i].length; j++){
                System.out.print(casillas[i][j].isMina()?" * ":" 0 ");
            }
            System.out.println("");
        }
    }
    
    private void imprimirPistas(){
        for(int i = 0; i < casillas.length; i++){
            for(int j = 0; j < casillas[i].length; j++){
                System.out.print(casillas[i][j].getNumMinasAlrededor());
            }
            System.out.println("");
        }
    }    
    
    public void actualizarNumeroMinasAlrededor() {
        for(int i = 0; i < casillas.length; i++){
            for(int j = 0; j < casillas[i].length; j++){
                if(casillas[i][j].isMina()){
                    List<Casilla> casillasAlrededor = obtenerCasillasAlrededor(i, j);
                    casillasAlrededor.forEach((c) -> c.incrementarNumeroMinasAlrededor());
                }
            }
        }        
    }
    
    public List<Casilla> obtenerCasillasAlrededor(int posFila, int posColumna){
        List<Casilla> listaCasillas = new LinkedList<>();
        for(int i = 0; i < 8; i++){
            int temPosFila = posFila;
            int temPosColumna = posColumna;
            switch(i){
                case 0: temPosFila--; break; // Arriba
                case 1: temPosFila--; temPosColumna++; break; // Arriba derecha
                case 2: temPosColumna++; break; // Derecha
                case 3: temPosColumna++; temPosFila++; break; // Derecha abajo
                case 4: temPosFila++; break; // Abajo
                case 5: temPosFila++; temPosColumna--; break; // Abajo izquierda
                case 6: temPosColumna--; break; // Izquierda
                case 7: temPosFila--; temPosColumna--; break; // Arriba
            }
            
            if(temPosFila >= 0 && temPosFila < this.casillas.length
                    && temPosColumna >= 0 && temPosColumna < this.casillas[0].length){
                listaCasillas.add(this.casillas[temPosFila][temPosColumna]);                
            }
        }
        return listaCasillas;
    }
    
    List<Casilla> obtenerCasillasConMinas(){
        List<Casilla> casillasMinas = new LinkedList<>();
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j].isMina()) {
                    casillasMinas.add(casillas[i][j]);
                }
            }
        }  
        return casillasMinas;
    }
    
    public void seleccionarCasilla(int posFila, int posColumna){
        eventoCasillaAbierta.accept(this.casillas[posFila][posColumna]);
        if(this.casillas[posFila][posColumna].isMina()){
            eventoPartidaPerdida.accept(obtenerCasillasConMinas());
        }
        else if(this.casillas[posFila][posColumna].getNumMinasAlrededor() == 0){
            marcarCasillaAbierta(posFila, posColumna);
            
            List <Casilla> casillasAlrededor = obtenerCasillasAlrededor(posFila, posColumna);
            for(Casilla casilla : casillasAlrededor){
                if(!casilla.isAbierta()){
                    //casilla.setAbierta(true);
                    seleccionarCasilla(casilla.getPosFila(), casilla.getPosColumna());                    
                }
            }
        }
        else{
            marcarCasillaAbierta(posFila, posColumna);
        }
        if(partidaGanada()){
            eventoPartidaGanada.accept(obtenerCasillasConMinas());
        }
    }
    
    void marcarCasillaAbierta(int posFila, int posColumna){
        if(!this.casillas[posFila][posColumna].isAbierta()){
            numCasillasAbiertas++;
            this.casillas[posFila][posColumna].setAbierta(true);
        }
    }
    
    boolean partidaGanada() {
        System.out.println("Casillas abiertas: " + numCasillasAbiertas);
        return (numCasillasAbiertas >= (numFilas*numColumnas)-numMinas);
    }
    
    
    
    public static void main(String[] args) {
        TableroBuscaminas tablero = new TableroBuscaminas(6, 6, 5);
        tablero.imprimirTablero();
        System.out.println("--------------------------------------");
        tablero.imprimirPistas();
    }

    public Consumer <List<Casilla>> getEventoPartidaPerdida() {
        return eventoPartidaPerdida;
    }

    public void setEventoPartidaPerdida(Consumer <List<Casilla>> eventoPartidaPerdida) {
        this.eventoPartidaPerdida = eventoPartidaPerdida;
    }    

    public Consumer<Casilla> getEventoCasillaAbierta() {
        return eventoCasillaAbierta;
    }

    public void setEventoCasillaAbierta(Consumer<Casilla> eventoCasillaAbierta) {
        this.eventoCasillaAbierta = eventoCasillaAbierta;
    }

    public void setEventoPartidaGanada(Consumer <List<Casilla>> eventoPartidaGanada) {
        this.eventoPartidaGanada = eventoPartidaGanada;
    }
    
    
}
