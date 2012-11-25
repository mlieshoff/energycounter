package energycounter.model;

import java.util.*;

import javax.persistence.*;

import org.metawidget.inspector.annotation.*;

@Entity
public class Counter {

    @Id
    private int id;
    private String serialNumber;
    @UiLarge
    private String description;

    @OneToMany(mappedBy = "counter")
    private List<Meter> meters = new ArrayList<Meter>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @UiSection( "Data" )
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @UiSection( "Data" )
    @UiComesAfter( "serialNumber" )
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Meter> getMeters() {
        return meters;
    }

    public void setMeters(List<Meter> meters) {
        this.meters = meters;
    }

}
