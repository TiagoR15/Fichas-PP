/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp_fp06.PizzaRestaurant;

import java.util.Arrays;
import java.util.Date;
import pp_fp06.PizzaRestaurant.enums.IngOrigem;

/**
 *
 * @author tiago
 */
public class Ementa {
    /**
     * MAX_PIZZAS varivel que define o numero maximo de pizzas de uma ementa
     * dataInicio data de inicio da ementa
     * dataFim data final da ementa
     * pizzas vetor de pizzas da ementa
     * numberOfPizzas numero de pizzas presentes na ementa
     * valida atributo que determina se a ementa é valida ou nao
     */
    private final int MAX_PIZZAS = 10;
    private Date dataInicio;
    private Date dataFim;
    private Pizza[] pizzas;
    private int numberOfPizzas = 0;
    private boolean valida;
    
    /**
     * 
     * @param dataFim data final da ementa
     * dataInicio é inicializada com a data de criação da ementa
     * A ementa não é valida por pre-definição
     */
    public Ementa(Date dataFim) {
        this.dataFim = dataFim;
        this.dataInicio =  new Date(System.currentTimeMillis());
        this.pizzas = new Pizza[MAX_PIZZAS];
        this.valida = false;
    }

    public Pizza[] getPizzas() {
        return pizzas;
    }

    public void setPizzas(Pizza[] pizzas) {
        this.pizzas = pizzas;
    }

    public int getNumberOfPizzas() {
        return numberOfPizzas;
    }

    public void setNumberOfPizzas(int numberOfPizzas) {
        this.numberOfPizzas = numberOfPizzas;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public boolean isValida() {
        return valida;
    }
    
    /**
     * Este metodo adiciona uma pizza à ementa
     * @param pizza pizza para adicionar à ementa
     */
    public void addPizza(Pizza pizza){
        if(this.numberOfPizzas < MAX_PIZZAS){
            this.pizzas[numberOfPizzas] = pizza;
            this.numberOfPizzas++;
        }
        else{
            System.out.println("ja nao cabe mais gordo!");
        }
    }
    
    /**
     * Este metodo remove uma pizza da ementa
     * @param id Id da pizza a remover
     * @pos é inicializada a -1
     * primeiro for vai percorrer o vetor das pizzas da ementa
     * primeiro if vai verificar se o id da pizza na posição i é igual ao id recebido
     * caso seja, a variavel pos vai guardar o indice i
     * segundo for vai percorrer o vetor das pizzas da ementa e vai passar a pizza na posição j+1 para a posição j, até ao fim do vetor
     * a ultima posição do vetor passa a null
     * o numero de pizzas é decrementado
     */
    public void removePizza(int id){
        int pos = -1;
        for(int i=0; i<this.numberOfPizzas; i++){
            if(this.pizzas[i].getId() == id){
                pos = i;
            }
        }
        for(int j=pos; j<this.numberOfPizzas; j++){
            this.pizzas[j] = this.pizzas[j+1];
        }
        this.pizzas[this.numberOfPizzas] = null;
        this.numberOfPizzas--;
    }
    
    /**
     * Este método vai verificar se a ementa é válida ou não, e caso seja o atributo válida passa a true
     * @contAnimal - contador que vai guardar o numero de ingredientes de origem animal de cada pizza
     * primeiro for vai percorrer o vetor de pizzas da ementa
     * segundo for vai percorrer os ingredientes de cada pizza
     * primeiro if vai verificar se a origem do ingrediente na posição j da pizza na posição i, é animal
     * se for de origem animal, incrementa a variavel contAnimal
     * segundo if vai verificar se o contAnimal for igual a 0, entao é porque existe uma pizza vegetariana, validando a ementa
     * @contAnimal volta a 0
     */
    public void validaEmenta(){
        int contAnimal = 0;
        for(int i=0; i<this.numberOfPizzas; i++){
            for(int j=0; j<this.pizzas[i].getNumberOfIngredients(); j++){
                if(this.pizzas[i].getIngredients()[j].getOrigem() == IngOrigem.Animal){
                    contAnimal++;
                }
            }
            if(contAnimal == 0){
                this.valida = true;
            }
            contAnimal = 0;
        }
    }
    
    /**
     * metodo toString() vai imprimir todos os dados da ementa na tela
     * @return uma string com todas as informações da ementa
     */
    @Override
    public String toString() {
        String s = "";
        s+="Data inicial: " + this.getDataInicio() + "\n";
        s+="Data Final: " + this.getDataFim() + "\n";
        s+="Nº de pizzas: " + this.getNumberOfPizzas() + "\n";
        for(int i=0; i<numberOfPizzas; i++){
            s+="Pizza: " + pizzas[i].toString();
        }
        return s;
    }
    
}
