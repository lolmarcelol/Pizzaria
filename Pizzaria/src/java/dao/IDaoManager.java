package dao;

import java.util.ArrayList;

public interface IDaoManager 
{
    void iniciar();
    void encerrar();
    void confirmarTransação();
    void abortarTransação();
    IngredienteDao getIngredienteDao();
    PizzaDao getPizzaDao();
    ClienteDao getClienteDao();
    
}