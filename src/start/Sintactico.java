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
    int numerolinea = 0;
    String mensaje;

    public Sintactico() {
    }
    
    Sintactico(ArrayList<Tokens> tokens){
        nl = tokens;
    }
    
    public void siguienteStament(){
            if (cont < nl.size()) {
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
                case "SALTOLINEA":
                    verificarSaltoDeLinea();
                default:
                    break;
            }
        }else{
                mensaje("Sin mas datos que analizar, codigo bien hecho");
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
        if (cont < nl.size()){
            String aux = nl.get(cont).getLexema();   
            if ( aux.matches("^[^\\d].*") && "IDENTIFIER".equals(nl.get(cont).getToken())){
                cont++;
                return true;
            }
            else{
                return false; 
                }
        }else{
            return false;
        }
    }
    public void verificarEntero(){
        if ("dEntero".equals(nl.get(cont).getLexema())) {
            cont++;
            if (verificarVariable()) {
                if (verificarAtribucion()) {
                    cont++;
                    if (verificarNumero()) {
                        if (verificarSemicolon()) {
                            cont++;
                            siguienteStament();
                        } else{
                            mensaje("Hace falta cerrar el Statement con ;");
                        }
                    } else if (verificarSemicolon()){
                        mensaje("Hace falta asignar asignar un numero a la variable");
                    } else if(verificarIdentificador() || verificarString()){
                        mensaje("El tipo de dato no es entero");
                    }
                    else{
                        mensaje("Expresion incorrecta hace falta numero");
                    }
                }
                else if (verificarSemicolon()) {
                    cont++;
                    siguienteStament();
                }
                else if ("NUMBER".equals(nl.get(cont).getToken())){
                    mensaje("Hace falta el simbolo = para asignar valor");
                }
                else if (verificarIdentificador()){
                    mensaje("Valor incorrecto el la declaracion, el valor necesita ser un entero");
                }
                else{
                    mensaje("Hace falta cerrar el staiment con ;");
                }
            }else if (verificarSemicolon()) {
                mensaje("Hace falta un identificador");
            }  
            else{
                mensaje("Nombre de identificador no valido");
            }
        }
    }
    public boolean verificarIdentificador(){
        if (cont < nl.size()){
            if ("IDENTIFIER".equals(nl.get(cont).getToken())){
                return true;
            } else{
                return false;
            }
        }else{
            return false;
        }
    }
    public boolean verificarSemicolon(){
        if (cont < nl.size()){
            if ("SEMICOLON".equals(nl.get(cont).getToken())){
                return true;
            } else{
                return false;
            }
        }else{
            return false;
        }
    }
    public boolean verificarString(){
        if (cont < nl.size()){
            if ("STRING".equals(nl.get(cont).getToken())){
                return true;
            } else{
                return false;
            }
        }else{
            return false;
        }
    }
    public boolean verificarAtribucion(){
        if (cont < nl.size()){
            if ("ATTRIBUTION".equals(nl.get(cont).getToken())){
                return true;
            } else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    
    public void verificarCadena(){
        if (nl.get(cont).getLexema().matches("\"[^\"]+\"")) {
            cont++;
            siguienteStament();
        }
        else{
            mensaje("No es una cadena");
        }
        
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
         if ("dPaquete".equals(nl.get(cont).getLexema())) {
             cont++;
             if (verificarVariable()) {
                 if ("SEMICOLON".equals(nl.get(cont).getLexema())) {
                     cont++;
                     siguienteStament();
                 }
                 else{
                     mensaje("Hace falta cerrar el statement");
                 }
             }
         }
    }
    public void verificarPublic(){
        
    }
     public void verificarPrivado(){
        
    }
    public void verificarTerm(){
        
    }
    public void mensaje(String txt){
        System.out.println(txt);
        mensaje = txt;
    }
    public boolean verificarNumero(){
        if ("NUMBER".equals(nl.get(cont).getToken())){
            cont++;
            return true;
        }else{
            return false;
        }
    }
     public void verificarExpresion(){
        
    }
    public void verificarOp(){
        
    }

    public void verificarSaltoDeLinea() {
        if (nl.get(cont).getLexema().matches("\\n")){
            numerolinea++;
            cont++;
            verificarStatement();
        }
    }
    
    public void imprimir(){
            for (int  i = 0;  i < nl.size();  i++) {
            System.out.println("----- Token: " +  nl.get(i).getToken() + " Lexema: " + nl.get(i).getLexema() + " Linea: " + i +"  -------" + "Numero Linea: "+ numerolinea+ "\n");
        }
    }
    
    public void reiniciarContador(){
        cont=0;
    }
    public String getMensaje(){
        return mensaje;
    }
}
