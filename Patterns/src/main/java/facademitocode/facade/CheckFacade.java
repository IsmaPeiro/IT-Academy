package facademitocode.facade;

import facademitocode.api.AvionAPI;
import facademitocode.api.HotelAPI;

public class CheckFacade {
    private AvionAPI avionAPI;
    private HotelAPI hotalAPI;
    
    public CheckFacade () {
        avionAPI=new AvionAPI();
        hotalAPI=new HotelAPI();
    }
    
    public void buscar(String fechaIda, String fechaVuelta, String origen, String destino) {
        avionAPI.buscarVuelos(fechaIda, fechaVuelta, origen, destino);
        hotalAPI.buscarHoteles(fechaIda, fechaVuelta, origen, destino);
    }
}
