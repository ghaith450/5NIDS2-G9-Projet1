package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.ExtendWith;
import org.mockito.InjectMocks;
import java.util.Date;
import java.util.Optional;

import tn.esprit.spring.repositories.ISubscriptionRepository;
import tn.esprit.spring.services.SubscriptionServicesImpl;
import tn.esprit.spring.entities.Subscription;



@SpringBootTest
@ExtendWith(MockitoExtension.class)
class GestionStationSkiApplicationTests {

    @Mock
    ISubscriptionRepository subscriptionRepository;

    @InjectMocks
    SubscriptionServicesImpl subscriptionService;

    Subscription sub = new Subscription(2.0, new Date(), new Date(), 55.0, TypeSubcription.ANNUAL);

    @Test
    public void testRetrieveSub() {
        Mockito.when(subscriptionRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(sub));
        Subscription sub1 = subscriptionService.retrieveSubscriptionById("1");
        Assertions.assertNotNull(sub1);
    }
}
