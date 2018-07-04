package com.eurezzolve.eucorretor.model;

/**
 * Created by viana_2 on 04/07/2018.
 */

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
