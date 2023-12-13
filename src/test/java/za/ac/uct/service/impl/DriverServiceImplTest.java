package za.ac.uct.service.impl;
/*
package za.ac.uct.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.uct.domain.Driver;
import za.ac.uct.factory.impl.DriverFactory;
import za.ac.uct.service.IDriverService;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class DriverServiceImplTest {
    @Autowired
    private IDriverService service;
    private static Driver driver = DriverFactory.createDriver("Sanelisiwe","Hlazo","10");
    @Test
    void a_create() {
        Driver created = service.create(driver);
        assertEquals(driver.getId(),created.getId());
        System.out.println("Created: "+created);

    }

    @Test
    void b_read() {
        Driver read = service.read(driver.getId());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Test
    void c_update() {
        Driver newDriver = new Driver.Builder().copy(driver).setFirstName("Silu").build();
        Driver updated = service.update(newDriver);
        assertEquals(newDriver.getFirstName(),updated.getFirstName());
        System.out.println("Updated: "+updated);
    }

    @Test
    @Disabled
    void e_delete() {

    }

    @Test
    void d_getAll() {
        System.out.println("Get All: ");
        System.out.println(service.getAll());
    }
}*/
