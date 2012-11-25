package energycounter.model;



import java.sql.*;

import javax.persistence.*;

import org.metawidget.inspector.annotation.*;

@Entity
public class Meter {

    @Id
    private int id;
    private double meter;
    private Date date;
    private Counter counter;
    @UiLarge
    private String description;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getMeter() {
        return meter;
    }
    public void setMeter(double meter) {
        this.meter = meter;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
    public Counter getCounter() {
        return counter;
    }
    public void setCounter(Counter counter) {
        this.counter = counter;
    }


}

