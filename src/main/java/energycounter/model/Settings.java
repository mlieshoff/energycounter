package energycounter.model;



import java.sql.*;

import javax.persistence.*;

import org.metawidget.inspector.annotation.*;

@Entity
public class Settings {

    @Id
    private int id;

    private double taxes;
    private double basePrice;
    private Date since;
    @UiLarge
    private String description;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getTaxes() {
        return taxes;
    }
    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }
    public double getBasePrice() {
        return basePrice;
    }
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
    public Date getSince() {
        return since;
    }
    public void setSince(Date since) {
        this.since = since;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(basePrice);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + id;
        result = prime * result + ((since == null) ? 0 : since.hashCode());
        temp = Double.doubleToLongBits(taxes);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Settings other = (Settings) obj;
        if (Double.doubleToLongBits(basePrice) != Double.doubleToLongBits(other.basePrice))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id != other.id)
            return false;
        if (since == null) {
            if (other.since != null)
                return false;
        } else if (!since.equals(other.since))
            return false;
        if (Double.doubleToLongBits(taxes) != Double.doubleToLongBits(other.taxes))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Settings [basePrice=" + basePrice + ", description=" + description + ", id="
                + id + ", since=" + since + ", taxes=" + taxes + "]";
    }


}

