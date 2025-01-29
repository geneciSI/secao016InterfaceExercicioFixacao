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
		double basicCota = contract.getTotalValue() / months;
		for (int i = 1; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			double interest = onlinePaymentService.interest(basicCota,i);
			double fee = onlinePaymentService.paymentFee(basicCota+interest);
			double quota = basicCota +interest + fee;
			contract.getInstallments().add(new Installment(dueDate, quota));
		}
	}

}
