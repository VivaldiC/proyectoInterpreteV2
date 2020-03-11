/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

/**
 *
 * @author VIVALDI
 */

public class Tokens {
    String Token;
    String Lexema;
    int Linea;
    
    public Tokens(String Token, String Lexema, int Linea){
        this.Token = Token;
        this.Lexema = Lexema;
        this.Linea = Linea;
    }

    Tokens() {
        
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public String getLexema() {
        return Lexema;
    }

    public void setLexema(String Lexema) {
        this.Lexema = Lexema;
    }

    public int getLinea() {
        return Linea;
    }

    public void setLinea(int Linea) {
        this.Linea = Linea;
    }
    
}
