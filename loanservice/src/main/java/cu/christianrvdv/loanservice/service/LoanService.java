package cu.christianrvdv.loanservice.service;

import cu.christianrvdv.loanservice.domain.Loan;
import cu.christianrvdv.loanservice.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public Loan createLoan(UUID userId, UUID bookId) {
        Loan loan = new Loan();
        loan.setUserId(userId);
        loan.setBookId(bookId);
        loan.setLoanDate(LocalDate.now());
        loan.setStatus("ACTIVE");
        return loanRepository.save(loan);
    }

    public Loan returnLoan(UUID loanId) {
        Loan loan = loanRepository.findById(loanId).orElse(null);
        if (loan != null) {
            loan.setReturnDate(LocalDate.now());
            loan.setStatus("RETURNED");
            return loanRepository.save(loan);
        }
        return null;
    }

    public List<Loan> getLoansByUser(UUID userId) {
        return loanRepository.findByUserId(userId);
    }

    public List<Loan> getActiveLoans() {
        return loanRepository.findByStatus("ACTIVE");
    }

    public Loan getLoanById(UUID id) {
        return loanRepository.findById(id).orElse(null);
    }
}
