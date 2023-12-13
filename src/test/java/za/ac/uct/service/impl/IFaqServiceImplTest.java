package za.ac.uct.service.impl;
/*
package za.ac.uct.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.uct.domain.Faq;
import za.ac.uct.factory.impl.FaqFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class IFaqServiceImplTest {
    @Autowired
    private IFaqServiceImpl iFaqService;

    private static Faq faq1 = FaqFactory.createFaq(
            "How can I rent a event?",
            "To rent a event, you can visit our website or mobile app, select the event you want, choose the RSVP dates, and complete the booking process.",
            LocalDateTime.now(), LocalDateTime.now());
    private static Faq faq2 = FaqFactory.createFaq(
            "Can I choose a specific event model?",
            "Yes, you can choose a specific event model based on availability. Make sure to select the desired event during the booking process.",
            LocalDateTime.now(), LocalDateTime.now());
    private static Faq faq3 = FaqFactory.createFaq(
            "What are the available payment methods?",
            "We accept major credit and debit eventds for payment. You can also choose to pay on arrival for some bookings.",
            LocalDateTime.now(), LocalDateTime.now());
    private static Faq faq4 = FaqFactory.createFaq(
            "Is there an age requirement for renting a event?",
            "Yes, the minimum age requirement for renting a event is 21 years old. Additional fees may apply for drivers under 25.",
            LocalDateTime.now(), LocalDateTime.now());
    private static Faq faq5 = FaqFactory.createFaq(
            "Do you offer insurance options for RSVPs?",
            "Yes, we offer various insurance options to provide you with coverage during your RSVP period. You can select the desired coverage during the booking process.",
            LocalDateTime.now(), LocalDateTime.now());
    private static Faq faq6 = FaqFactory.createFaq(
            "What if I need to extend my RSVP period?",
            "If you need to extend your RSVP period, please contact our customer support team as soon as possible. Additional charges may apply.",
            LocalDateTime.now(), LocalDateTime.now());
    private static Faq faq7 = FaqFactory.createFaq(
            "What happens if the event breaks down during my RSVP?",
            "In the event of a breakdown, please contact our 24/7 roadside assistance. They will provide you with the necessary support and instructions.",
            LocalDateTime.now(), LocalDateTime.now());
    private static Faq faq8 = FaqFactory.createFaq(
            "Can I pick up the event at one location and return it to another?",
            "Yes, we offer one-way RSVPs, allowing you to pick up the event at one location and return it to another. Additional fees may apply.",
            LocalDateTime.now(), LocalDateTime.now());
    private static Faq faq9 = FaqFactory.createFaq(
            "What is your cancellation policy?", "Our cancellation policy allows for free cancellations up to 24 hours before your reservation starts. After that, a cancellation fee may apply.",
            LocalDateTime.now(), LocalDateTime.now());
    private static Faq faq10 = FaqFactory.createFaq(
            "Can I modify my reservation details after booking?", "Yes, you can modify your reservation details such as RSVP dates and event selection. Simply log in to your account and go to the 'My Reservations' section.",
            LocalDateTime.now(), LocalDateTime.now());
    private static Faq testCase0 = FaqFactory.createFaq(
            "test case?",
            "answer",
            LocalDateTime.now(), LocalDateTime.now());

    @Test
    void a_create() {
        Faq created1 = iFaqService.create(faq1);
        System.out.println("Created 1: " + created1);
        Assertions.assertNotNull(created1);

        Faq created2 = iFaqService.create(faq2);
        System.out.println("Created 2: " + created2);
        Assertions.assertNotNull(created2);

        Faq created3 = iFaqService.create(faq3);
        System.out.println("Created 3: " + created3);
        Assertions.assertNotNull(created3);

        Faq created4 = iFaqService.create(faq4);
        System.out.println("Created 4: " + created4);
        Assertions.assertNotNull(created4);

        Faq created5 = iFaqService.create(faq5);
        System.out.println("Created 5: " + created5);
        Assertions.assertNotNull(created5);

        Faq created6 = iFaqService.create(faq6);
        System.out.println("Created 6: " + created6);
        Assertions.assertNotNull(created6);

        Faq created7 = iFaqService.create(faq7);
        System.out.println("Created 7: " + created7);
        Assertions.assertNotNull(created7);

        Faq created8 = iFaqService.create(faq8);
        System.out.println("Created 8: " + created8);
        Assertions.assertNotNull(created8);

        Faq created9 = iFaqService.create(faq9);
        System.out.println("Created 9: " + created9);
        Assertions.assertNotNull(created9);

        Faq created10 = iFaqService.create(faq10);
        System.out.println("Created 10: " + created10);
        Assertions.assertNotNull(created10);

        Faq test = iFaqService.create(testCase0);
        System.out.println("test case 1: " + test);
        Assertions.assertNotNull(test);

        Assertions.assertNotSame(created1, created2);
        Assertions.assertNotSame(created3, created4);
        Assertions.assertNotSame(created5, created6);
        Assertions.assertNotSame(created7, created8);
        Assertions.assertNotSame(created9, created10);
    }

    @Test
    void b_read() {
        Faq readTest = iFaqService.read(testCase0.getId());
        System.out.println("Read test: " + readTest);
        Assertions.assertNotNull(readTest);
    }

    @Test
    void c_update() {
        Faq updatedTest = new Faq.Builder().copy(testCase0)
                .setQuestion("Updated question")
                .setUpdatedAt(LocalDateTime.now())
                .build();
        System.out.println("Updated: " + iFaqService.update(updatedTest));
        Assertions.assertNotSame(updatedTest.getQuestion(), testCase0.getQuestion());
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        ArrayList<Faq> faqList = iFaqService.getAll();
        for (Faq faq: faqList) {
            System.out.println(faq);
        }
    }

    @Test
    void e_delete() {
        System.out.println(iFaqService.read(testCase0.getId()));
        boolean success = iFaqService.delete(testCase0.getId());
        Assertions.assertTrue(success);
        System.out.println("Deleted: " + success);
    }
}*/
