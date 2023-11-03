package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Assertions;
import java.time.LocalDate;
import java.util.Optional;

import tn.esprit.spring.repositories.ISubscriptionRepository;
import tn.esprit.spring.services.SubscriptionServicesImpl;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.TypeSubscription;

@SpringBootTest
@ExtendWith({MockitoExtension.class, SpringExtension.class})
class GestionStationSkiApplicationTests {

    @Mock
    ISubscriptionRepository subscriptionRepository;

    @InjectMocks
    SubscriptionServicesImpl subscriptionService;

Subscription sub = new Subscription(2L, LocalDate.now(), LocalDate.now(), 55.0f, TypeSubscription.ANNUAL);

@Test
public void testRetrieveSub() {
    Mockito.when(subscriptionRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(sub));
    Subscription sub1 = subscriptionService.retrieveSubscriptionById(1L);
    Assertions.assertNotNull(sub1);
}

}
