package org.sid.billingproducer.Service;

import org.sid.billingproducer.Entity.Bill;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Supplier;

@Service
public class BillService {
    @Bean
    public Supplier<Bill> BillSupplier()
    {
        return () ->  new Bill(null, new Date(), Math.random() > 0.5 ? Math.random() > 0.5 ? 1L : 2L : Math.random() > 0.5 ? 3L : 4L, null, null);
    }
}
