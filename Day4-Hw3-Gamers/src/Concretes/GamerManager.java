package Concretes;

import java.util.Scanner;

import Abstracts.GamerManagerService;
import Adaptors.DbServiceAdaptors;
import Entities.Gamers;
import Entities.Games;
import Simulating.EDevletCheckSimulation;

public class GamerManager implements GamerManagerService{
	DbServiceAdaptors dbserviceadaptors;
	EDevletCheckSimulation edevletchecksimulation;
	CampaignManager campaignmanager;



	public GamerManager(DbServiceAdaptors dbserviceadaptors,EDevletCheckSimulation Edevletchecksimulation) {
		/* its dependency injection */
		this.dbserviceadaptors=dbserviceadaptors;
		this.edevletchecksimulation=Edevletchecksimulation;
	}
	public GamerManager(DbServiceAdaptors dbserviceadaptors,EDevletCheckSimulation Edevletchecksimulation,CampaignManager Campaignmanager) {
		/* its dependency injection */
		this.dbserviceadaptors=dbserviceadaptors;
		this.edevletchecksimulation=Edevletchecksimulation;
		this.campaignmanager=Campaignmanager;
	}
	
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void Save(Gamers gamer,String mail,String pw) throws Exception {
		if(edevletchecksimulation.CheckGamers(gamer))
		dbserviceadaptors.Save(gamer);
		System.out.println(dbserviceadaptors.TurnGamer(mail, pw).getName()+" kay�t edildi");
	}



	@Override
	public void UpdateEmail(Gamers gamer) {
		System.out.println("L�tfen yeni email adresinizi giriniz");
		String NewEmail;
		NewEmail=sc.nextLine();
		gamer.setEmail(NewEmail);
		dbserviceadaptors.Save(gamer);
		System.out.println("Yeni Email adresiniz "+NewEmail+" olarak g�ncellendi.");
		
		
		
		
	}

	@Override
	public void UpdatePw(Gamers gamer) {
		// TODO Auto-generated method stub
		System.out.println("L�tfen yeni password'�n�z� giriniz");
		String Newpw;
		Newpw=sc.nextLine();
		gamer.setPw(Newpw);
		dbserviceadaptors.Save(gamer);
		System.out.println("Yeni password'�n�z "+Newpw+" olarak g�ncellendi.");
		
	}

	@Override
	public void UpdateDateOfBirth(Gamers gamer) {
		// TODO Auto-generated method stub
		System.out.println("L�tfen yeni do�um g�n�n�z� giriniz");
		int NewDateOfBirth;
		NewDateOfBirth=sc.nextInt();
		sc.nextLine();
		gamer.setDateOfBirth(NewDateOfBirth);
		dbserviceadaptors.Save(gamer);
		System.out.println("Yeni do�um g�n�n�z "+NewDateOfBirth+" olarak g�ncellendi.");
		
	}

	@Override
	public void DepositMoney(Gamers gamer) {
		// TODO Auto-generated method stub
		System.out.println("L�tfen yat�raca��n�z para miktar�n� giriniz");
		int newDepositMoney;
		newDepositMoney=sc.nextInt();
		sc.nextLine();
		gamer.setWalletBalance(gamer.getWalletBalance()+newDepositMoney);
		dbserviceadaptors.Save(gamer);
		System.out.println("Yeni bakiyeniz "+gamer.getWalletBalance()+" olarak g�ncellendi.");
		
	}



	@Override
	public void DeleteAccount(String email,String pw) {
		dbserviceadaptors.DeleteAccount(email, pw);
		
	}



	@Override
	public void BuyGame(Games Game, Gamers Gamer) {
		Gamer.setWalletBalance(Gamer.getWalletBalance()-(Game.getPrice()*campaignmanager.MakeCampaign(0.8)));
		System.out.println("Oyun satin al�nd�.Yeni Bakiye="+Gamer.getWalletBalance());
		
	}



	

}
