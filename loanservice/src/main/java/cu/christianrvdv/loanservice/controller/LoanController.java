package cu.christianrvdv.loanservice.controller;

import cu.christianrvdv.loanservice.domain.Loan;
import cu.christianrvdv.loanservice.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@CrossOrigin (origins = "*")
@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Loan createLoan(
            @RequestParam UUID userId,
            @RequestParam UUID bookId
    ) {
        return loanService.createLoan(userId, bookId);
    }

    @PutMapping("/{loanId}/return")
    public Loan returnLoan(@PathVariable UUID loanId) {
        return loanService.returnLoan(loanId);
    }

    @GetMapping("/user/{userId}")
    public List<Loan> getLoansByUser(@PathVariable UUID userId) {
        return loanService.getLoansByUser(userId);
    }

    @GetMapping("/active")
    public List<Loan> getActiveLoans() {
        return loanService.getActiveLoans();
    }

    @GetMapping("/{loanId}")
    public Loan getLoanById(@PathVariable UUID loanId) {
        return loanService.getLoanById(loanId);
    }
}