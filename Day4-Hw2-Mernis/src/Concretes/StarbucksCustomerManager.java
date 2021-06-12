package Concretes;

import Abtracts.BaseCustomerManager;
import Abtracts.CustomerCheckService;
import Entities.Customer;



public class StarbucksCustomerManager extends BaseCustomerManager{
	private CustomerCheckService customerCheckService;
	 //Dependency �njection yapt�k
	
	public StarbucksCustomerManager(CustomerCheckService customerCheckService) {
		this.customerCheckService=customerCheckService;			
	}

	
	

	@Override
	public void Save(Customer customer) throws Exception {
		// TODO Auto-genersated method stub
		if(customerCheckService.CheckIfItRealPerson(customer)) {
			super.Save(customer);
		}
		else
			System.out.println("Do�rulama hatal�."+customer.getFirstName()+customer.getLastName()+"'in Kayd� ger�ekle�tirilemedi.");;
		
	}
	

}
