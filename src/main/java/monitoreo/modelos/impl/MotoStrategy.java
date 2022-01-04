package monitoreo.modelos.impl;

import monitoreo.modelos.interfaces.ITransporteStrategy;

public class MotoStrategy implements ITransporteStrategy {

    
    private int MaxPuntos=8;
    private double MaxPeso=50;
    private Double[][] puntosEntregaVariado;
    private double peso=0;
    
    public Double[][] crearPuntos(Double[][] puntos) {

        puntosEntregaVariado = new  Double[][]{
                {-12.054456, -77.083491},
                {-12.056025, -77.081278},
                {-12.056520, -77.080370},
                {-12.057158, -77.079955},
                {-12.058076, -77.079692},
                {-12.059265, -77.079392},
                {-12.060343, -77.079129},
                {-12.059506, -77.075500},
                {-12.059249, -77.075532}
        };
        return puntosEntregaVariado;
    }
    public void AgregarPuntos(Double[][] puntos){
        if(MaxPuntos-puntosEntregaVariado.length>1){
            puntosEntregaVariado[puntosEntregaVariado.length+1][0]=puntos[0][0];
            puntosEntregaVariado[puntosEntregaVariado.length+1][1]=puntos[0][1];
            if(peso+puntos[0][2]<MaxPeso){
                System.out.println("Peso excedido para la moto");
            }else{
                peso+=puntos[0][2];
            }
        }else{
            System.out.println("Se alcanzó el límite de puntos");
        }
      
    }
}
