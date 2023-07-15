package org.rmmcosta.work;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectMapperTest {
    @Test
    void twoCarsWithSameColorAndTypeAreTheSameCar() {
        assertEquals(new Car("Black", "BMW"), new Car("Black", "BMW"));
    }

    @Test
    void objectMapperWorksOk() throws JsonProcessingException {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = objectMapper.readValue(json, Car.class);
        assertEquals(car, new Car("Black", "BMW"));
    }

    private record Car(String color, String type) {
    }
}