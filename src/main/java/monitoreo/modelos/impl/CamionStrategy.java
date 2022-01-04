package monitoreo.modelos.impl;

import monitoreo.modelos.interfaces.ITransporteStrategy;

public class CamionStrategy implements ITransporteStrategy {

    private int MaxPuntos=40;
    private double MaxPeso=2100;
    private Double[][] puntosEntregaVariado;
    private double peso=0;
    
    public Double[][] crearPuntos(Double[][] puntos) {
    
  

         puntosEntregaVariado = new  Double[][]{
            {-12.054456, -77.083491},
            {-12.053510, -77.084607},
            {-12.051269, -77.085371},
            {-12.049934, -77.076910},
            {-12.049819, -77.075715},
            {-12.049354, -77.071379},
            {-12.049451, -77.071354},
            {-12.050152, -77.071312},
            {-12.051030, -77.071231},
            {-12.051804, -77.071147},
            {-12.052032, -77.071068},
            {-12.054760, -77.070884},
            {-12.054577, -77.069197},
            {-12.057725, -77.068353},
            {-12.059279, -77.075558}
        };
        return puntosEntregaVariado;
    }
       public void AgregarPuntos(Double[][] puntos){
        if(MaxPuntos-puntosEntregaVariado.length>1){
            puntosEntregaVariado[puntosEntregaVariado.length+1][0]=puntos[0][0];
            puntosEntregaVariado[puntosEntregaVariado.length+1][1]=puntos[0][1];
            if(peso+puntos[0][2]<MaxPeso){
                System.out.println("Peso excedido para el camión");
            }else{
                peso+=puntos[0][2];
            }
        }else{
            System.out.println("Se alcanzó el límite de puntos");
        }
      
    }
}
