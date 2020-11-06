package edu.northeastern.cs5500.delivery.model.Driver;

import edu.northeastern.cs5500.delivery.model.Model;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class Driver implements Model {
    private ObjectId id;
    private String name;
    private String phoneNum;
    private Car car;

    public Driver(String name) {
        this.name = name;
    }

    @Override
    public ObjectId getId() {
        return null;
    }

    @Override
    public void setId(ObjectId id) {}
}
