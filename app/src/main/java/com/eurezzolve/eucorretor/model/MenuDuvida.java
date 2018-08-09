/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 22:00
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.model;



public class MenuDuvida {
    String itemMenu;
    int idTema;

    public MenuDuvida(String itemMenu, int idTema) {
        this.itemMenu = itemMenu;
        this.idTema = idTema;
    }

    public MenuDuvida() {
    }

    public String getItemMenu() {
        return itemMenu;
    }

    public void setItemMenu(String itemMenu) {
        this.itemMenu = itemMenu;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }
}
