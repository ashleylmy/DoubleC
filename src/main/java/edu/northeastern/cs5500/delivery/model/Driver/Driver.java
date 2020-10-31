package edu.northeastern.cs5500.delivery.model.Driver;

import edu.northeastern.cs5500.delivery.model.Model;
import lombok.Data;
import org.bson.types.ObjectId;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;

    @Data
    public class Driver implements Model {
        private ObjectId id;
        private String name;
        private String phoneNum;
        private Car car;
        private Double income;


        public Driver(ObjectId id, String name, String phoneNum, Car car, Double income) {
            this.id = id;
            this.name = name;
            this.phoneNum = phoneNum;
            this.car = car;
            this.income = income;
        }

        @Override
        public ObjectId getId() {
            return null;
        }

        @Override
        public void setId(ObjectId id) {

        }


    }
