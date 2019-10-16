package io.pivotal.pccdemo.dao;

import io.pivotal.pccdemo.model.Stuff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext
public class StuffDaoTest {

    @Autowired
    private StuffDao target;

    @Test
    public void writeTest() {
        Stuff stuff = new Stuff();
        stuff.setStuffId("1");
        stuff.setField("one");

        target.save(stuff);

        Optional<Stuff> result = target.findById("1");

        assertTrue(result.isPresent());
        assertEquals(stuff.getField(), result.get().getField());
    }
}
