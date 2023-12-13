package za.ac.uct.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.uct.domain.Feedback;
import za.ac.uct.factory.impl.FeedbackFactory;

public class FeedbackFactoryTest {

    @Test
    public void testCreateFeedback() {
        FeedbackFactory feedbackFactory = new FeedbackFactory();
        Feedback feedback = feedbackFactory.create();
        Assertions.assertNotNull(feedback);
        Assertions.assertNotNull(feedback.getId());
    }

}
