package uz.pdp.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pcmarket.entity.PaymentCustomer;
import uz.pdp.pcmarket.payload.ApiResponse;
import uz.pdp.pcmarket.payload.PaymentCustomerDto;
import uz.pdp.pcmarket.service.PaymentCustomerService;

import java.util.List;

@RestController
@RequestMapping("/paymentCustomer")
public class PaymentCustomerController {
    @Autowired
    PaymentCustomerService paymentCustomerService;

    @PreAuthorize(value = "hasAuthority('READ')")
    @GetMapping
    public List<PaymentCustomer> getPaymentCustomers(){return paymentCustomerService.getPaymentCustomers();}

    @PreAuthorize(value = "hasAuthority('READ1')")
    @GetMapping("/{id}")
    public PaymentCustomer getPaymentCustomer(@PathVariable Integer id){return paymentCustomerService.getPaymentCustomerById(id);}

    @PreAuthorize(value = "hasAuthority('CREATE')")
    @PostMapping
    public ResponseEntity<ApiResponse> addPaymentCustomer(@RequestBody PaymentCustomerDto paymentCustomerDto){
        ApiResponse apiResponse = paymentCustomerService.addPaymentCustomer(paymentCustomerDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PreAuthorize(value = "hasAuthority('UPDATE')")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editPaymentCustomer(@RequestBody PaymentCustomerDto paymentCustomerDto,
                                                @PathVariable Integer id){
        ApiResponse apiResponse = paymentCustomerService.editPaymentCustomer(paymentCustomerDto, id);
        return ResponseEntity.status(apiResponse.isStatus()?202:409).body(apiResponse);
    }

    @PreAuthorize(value = "hasAuthority('DELETE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePaymentCustomer(@PathVariable Integer id){
        ApiResponse apiResponse = paymentCustomerService.deletePaymentCustomer(id);
        return ResponseEntity.status(apiResponse.isStatus()?202:409).body(apiResponse);
    }
}
