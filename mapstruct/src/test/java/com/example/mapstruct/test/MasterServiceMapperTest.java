package com.example.mapstruct.test;

import com.example.mapstruct.MapstructApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = MapstructApplication.class)
class MasterServiceMapperTest {

    @Test
    void toSlaveTest(){
        // given
        List<Slave> expected = new ArrayList<>(List.of(
                getSlave("name1", "context1"),
                getSlave("name2", "context2")));

        Master master = Master.builder()
                .id(1L)
                .entryList(new ArrayList<>(List.of(
                        getEntry("name1", "context1"),
                        getEntry("name2", "context2"))))
                .build();

        // when
        List<Slave> result = MasterServiceMapper.INSTANCE.toSlave(master.getEntryList());

        // then
        assertEquals(2, result.size());
        System.out.println(result);
    }

    private static Slave getSlave(String name1, String context1) {
        return Slave.builder()
                .name(name1)
                .context(context1)
                .build();
    }

    private static Master.Entry getEntry(String name1, String context1) {
        return Master.Entry.builder()
                .name(name1)
                .context(context1)
                .build();
    }
}