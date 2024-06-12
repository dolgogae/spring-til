package com.sihun.proxy.springproxy;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class DataEntity {

    @Id
    private String id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<String> otherEntities;
}
