package dao;

import java.util.ArrayList;

public interface IDaoManager 
{
    void iniciar();
    void encerrar();
    void confirmarTransação();
    void abortarTransação();
    AssuntoDAO getAssuntoDao();
    IngredienteDao getIngredienteDao();
    PizzaDao getPizzaDao();
}