package services;

import java.time.LocalDate;

import entitiess.Contract;
import entitiess.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService() {}
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }
	public void processContract(Contract contract, int months) {
		contract.getInstallments().add(new Installment(LocalDate.of(2025,1,28), 206.04));
		contract.getInstallments().add(new Installment(LocalDate.of(2025,2,28), 208.08));
		
	}

}
