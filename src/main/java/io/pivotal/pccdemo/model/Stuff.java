package io.pivotal.pccdemo.model;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.annotation.Region;

import java.io.Serializable;

@Region("Stuff")
@Data
public class Stuff implements Serializable {

    @Id
    private String stuffId;

    private String field;
}
