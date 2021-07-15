package business.concretes;

import adaptors.abstracts.ExternalServiceAdaptor;
import business.abstracts.LoginCheckService;
import entities.concretes.Users;
import simulate.DbService;

public class LoginManager implements LoginCheckService{
	DbService firstDb;
	ExternalServiceAdaptor externalServiceAdaptor;

	public LoginManager(DbService firstDb,ExternalServiceAdaptor externalServiceAdaptor) {
		this.firstDb = firstDb;
		this.externalServiceAdaptor=externalServiceAdaptor;
	}

	@Override
	public boolean LoginWithNormal(Users user) {
		if(firstDb.CheckMailForLogin(user)&&firstDb.CheckPwForLogin(user)) {
			System.out.println(user.getName()+" Ba�ar�l� bir �ekilde giri� yapt�.");
			return true;
		}
		System.out.println(user.getName()+" Giri� Ba�ar�s�z.");
		return false;
	}

	@Override
	public boolean LoginWithExternal(ExternalServiceAdaptor externalServiceAdaptor) {
		// TODO Auto-generated method stub
		if(firstDb.CheckMailForExternal(externalServiceAdaptor.getEmail())) {
			System.out.println(externalServiceAdaptor.getName()+" ba�ar�l� bir �ekilde d�� servisten giri� yapt�");
			return true;
		}
		System.out.println(externalServiceAdaptor.getName()+" sistemimize kay�tl� de�ildir. Giri� ba�ar�s�z");
		return false;
	}

}
