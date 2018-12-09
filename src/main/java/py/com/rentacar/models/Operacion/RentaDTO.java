package py.com.rentacar.models.Operacion;

import java.util.List;

public class RentaDTO {

    private Renta renta;
    private List<DetalleRenta> inserted;
    private List<DetalleRenta> deleted;

    public Renta getRenta() {
        return renta;
    }

    public void setRenta(Renta renta) {
        this.renta = renta;
    }

    public List<DetalleRenta> getInserted() {
        return inserted;
    }

    public void setInserted(List<DetalleRenta> inserted) {
        this.inserted = inserted;
    }

    public List<DetalleRenta> getDeleted() {
        return deleted;
    }

    public void setDeleted(List<DetalleRenta> deleted) {
        this.deleted = deleted;
    }
}
