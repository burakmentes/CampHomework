package GamerMain;

import java.util.Random;
import java.util.Scanner;

import Adaptors.DbServiceAdaptors;
import Concretes.CampaignManager;
import Concretes.GamerManager;
import Entities.Gamers;
import Entities.Games;
import Simulating.EDevletCheckSimulation;

public class Program {	

	public static void main(String[] args) throws Exception {
		GamerManager gamermanager=new GamerManager(new DbServiceAdaptors(),new EDevletCheckSimulation(),new CampaignManager());
		//GamerManager gamermanager=new GamerManager(new DbServiceAdaptors(),new EDevletCheckSimulation(),new CampaignManager());
		DbServiceAdaptors dbserviceadaptors=new DbServiceAdaptors();
		
		int i=1;
		while(i>0) {
			System.out.println("\n"
					+ "Bura��n oyun d�nyas�na ho�geldiniz.\n"
					+ "L�tfen se�im yap�n�z.");
		
			String menu="1-)Ana Men�\n"
					+"2-)Kay�t ol\n"
					+ "3-)��k��"
					;
			
			
			System.out.println(menu);
			Scanner scanner=new Scanner(System.in);
			int secim;
			secim=scanner.nextInt();
			scanner.nextLine();
			
		
		switch(secim){
		
		case 1:
				int k=2;
				while(k>1) {
					
					String mail;
					String pw;			
				
				System.out.println("\n"
						+ "Yapmak istedi�iniz operasyonu se�iniz \n"
						+ "11-)mail g�ncelle \n"
						+ "22-)bakiye g�ncelle\n"
						+ "33-)hesab� sil\n"
						+ "44-)oyun sat�n al\n");
				int secimcase1=scanner.nextInt();
				scanner.nextLine();
				switch(secimcase1) {
				case 11:
					System.out.println("Bu a�amada kullan�c� giri�i yapman�z gerekmektedir."
							+ "l�tfen �u anki mail adresinizi giriniz");
					mail=scanner.nextLine();
					System.out.println("l�tfen �u anki �ifrenizi giriniz");
					pw=scanner.nextLine();
				gamermanager.UpdateEmail(dbserviceadaptors.TurnGamer(mail, pw));
				break;
			case 22:
				System.out.println("Bu a�amada  kullan�c� giri�i yapman�z gerekmektedir."
						+ "l�tfen �u anki mail adresinizi giriniz");
				mail=scanner.nextLine();
				System.out.println("l�tfen �u anki �ifrenizi giriniz");
				pw=scanner.nextLine();
				gamermanager.DepositMoney(dbserviceadaptors.TurnGamer(mail, pw));
				break;
			case 33:
				System.out.println("Bu a�amada  kullan�c� giri�i yapman�z gerekmektedir."
						+ "l�tfen �u anki mail adresinizi giriniz");
				mail=scanner.nextLine();
				System.out.println("l�tfen �u anki �ifrenizi giriniz");
				pw=scanner.nextLine();
				gamermanager.DeleteAccount(mail, pw);
				break;
			case 44:
				System.out.println("Bu a�amada  kullan�c� giri�i yapman�z gerekmektedir."
						+ "l�tfen �u anki mail adresinizi giriniz");
				mail=scanner.nextLine();
				System.out.println("l�tfen �u anki �ifrenizi giriniz");
				pw=scanner.nextLine();				
				gamermanager.BuyGame(new Games("Age Of Empires",50), dbserviceadaptors.TurnGamer(mail, pw));
				break;
				}
				}
				
			
//			else throw new Exception("yanl�� email password");
			
			
			//public Gamers(String email, String pw, String tcNo, String name, int dateOfBirth, int walletBalance) 
		case 2:
				System.out.println("Email adresinizi giriniz.");
				String email=scanner.nextLine(); 
				System.out.println("password�n�z� giriniz.");
				String pw2=scanner.nextLine();
				System.out.println("tcNo'nuzu giriniz.");
				String tcNo=scanner.nextLine();
				System.out.println("isminizi giriniz.");
				String name=scanner.nextLine();
				System.out.println("Do�um y�l�n�z� giriniz.");
				int dateOfBirth=scanner.nextInt();
				scanner.nextLine();
				System.out.println("Yat�rmak istedi�iniz miktar� giriniz.");
				int walletBalance=scanner.nextInt();
				scanner.nextLine();
				
				Gamers gamer=new Gamers(email,pw2,tcNo,name,dateOfBirth,walletBalance);				
				
				gamermanager.Save(gamer,email,pw2);
				/* continue anahtar kelimesi d�ng�de ba�a d�ner, break ise d�ng�den ��kar */
				break;
		case 3:
			System.out.println("��k�� yap�l�yor.Yine bekleriz.");
			break;
			
			default:
			System.out.println("Yanl�� se�im yapt�n�z.");
			
			
		}
		
	
		
		
		
	}

}
}
