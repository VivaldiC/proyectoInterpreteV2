/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.util.ArrayList;

/**
 *
 * @author VIVALDI
 */
class Sintactico {
    ArrayList<Tokens> nl;
    int cont = 0;
    ventana11 nv;

    public Sintactico() {
    }
    
    Sintactico(ArrayList<Tokens> tokens){
        nl = tokens;
    }
    
    public void siguienteStament(){
        Sintactico ns = new Sintactico(nl);
            String token = nl.get(cont).getToken();
            switch (token){
                case "MAIN_KEYWORD":
                    break;
                case "DENTERO_KEYWORD":
                    verificarEntero();
                    break;
                case "DCONDICION_KEYWORD":
                    break;
                case "DMIENTRAS_KEYWORD":
                    break;
                case "ELSE_KEYWORD":
                    break;
                case "DCADENA_KEYWORD":
                    break;
                case "DFLOTANTE_KEYWORD":
                    break;
                case "DIMPRIMIR_KEYWORD":
                    break;
                case "DPAQUETE_KEYWORD":
                    break;
                case "PUBLICO_KEYWORD":
                    break;
                case "PRIVADO_KEYWORD":
                    break;
                case "SEMICOLON":
                    break;
                case "COMMA":
                    break;
                case "OPEN_BRACKET":
                    break;
                case "CLOSE_BRACKET":
                    break;
                case "OPEN_PARENTHESIS":
                    break;
                case "CLOSE_PARENTHESIS":
                    break;
                case "EQUAL":
                    break;
                case "DIFFERENT":
                    break;
                case "GREATER_EQUAL":
                    break;
                case "LESSER_EQUAL":
                    break;
                case "ATTRIBUTION":
                    break;
                case "GREATER":
                    break;
                case "LESSER":
                    break;
                case "ADDITION":
                    break;
                case "SUBTRACTION":
                    break;
                case "MULTIPLICATION":
                    break;
                case "DIVISION":
                    break;
                case "STRING":
                    break;
                case "NUMBER":
                    break;
                case "IDENTIFIER":
                    break;
                default:
                    break;
            }
    }
    
    public void verificarStatement(){
        
    }
    public void verificarWhile(){
        
    }
     public void verificarFor(){
        
    }
    public void verificarIf(){
        
    }
    
    public boolean verificarVariable(){
        if ( nl.get(cont).getLexema().matches("\\w+")){
            cont++;
            siguienteStament();
            return true;
        }
        else{
            nv.escribirEnPanel("Nombre de variable no encontrada o no cumple con reglas");
            return false;
        }
    }
    public void verificarEntero(){
        if ( nl.get(cont).getLexema() == "dEntero"){
            cont++;
            if (verificarVariable()){
                if (nl.get(cont).getToken() == "ATTRIBUTION"){
                    cont++;
                    if (verificarVariable()){
                        if (nl.get(cont).getToken() == "SEMICOLON"){
                            cont++;
                            siguienteStament();
                        }
                        else{
                            nv.escribirEnPanel("Hace falta cerrar el staiment");
                        }
                    }
                }
                else if (nl.get(cont).getToken() == "SEMICOLON"){
                            cont++;
                            siguienteStament();
                        }
                        else{
                            nv.escribirEnPanel("Hace falta un ; o declarar variable");
                        }
            }
        }
        else{
            nv.escribirEnPanel("Error en linea NL: No es un valor valido");
        }
    }
    public void verificarCadena(){
        
    }
     public void verificarFlotante(){
        
    }
    public void verificarImprimir(){
        
    }
     public void verificarMain(){
        
    }
    public void verificarElse(){
        
    }
     public void verificarPaquete(){
        
    }
    public void verificarPublic(){
        
    }
     public void verificarPrivado(){
        
    }
    public void verificarTerm(){
        
    }
     public void verificarExpresion(){
        
    }
    public void verificarOp(){
        
    }
}
