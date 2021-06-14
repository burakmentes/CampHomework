package Entities;

import java.util.List;

import Abstracts.Entity;

/*1. Oyuncular�n sisteme kay�t olabilece�i, bilgilerini g�ncelleyebilece�i, kay�tlar�n� silebilece�i bir ortam� simule ediniz. 
 * M��teri bilgilerinin do�rulu�unu e-devlet sistemlerini kullanarak do�rulama yapmak istiyoruz. 
(E-devlet sistemlerinde do�rulama TcNo, Ad, Soyad, Do�umY�l� bilgileriyle yap�l�r. Bunu yapacak servisi simule etmeniz yeterlidir.) (Loglama gibi)

2.Oyun sat��� yap�labilecek sat�� ortam�n� simule ediniz.( Yap�lan sat��lar oyuncu ile ili�kilendirilmelidir. Oyuncunun parametre olarak metotta olmas�n� kastediyorum.)

3.Sisteme yeni kampanya giri�i, kampanyan�n silinmesi ve g�ncellenmesi imkanlar�n� simule ediniz.
(Kampanya Manager sat�n almada  parametre olarak g�nderilsin)

4. Sat��larda kampanya entegrasyonunu simule ediniz.*/

public class Gamers implements Entity{
	private String Email;
	private String Pw;
	private String TcNo;
	private String Name;
	private int DateOfBirth;
	private double WalletBalance;
	
	public Gamers(String email, String pw, String tcNo, String name, int dateOfBirth, double walletBalance) {
		super();
		Email = email;
		Pw = pw;
		TcNo = tcNo;
		Name = name;
		DateOfBirth = dateOfBirth;
		WalletBalance = walletBalance;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPw() {
		return Pw;
	}
	public void setPw(String pw) {
		Pw = pw;
	}
	public String getTcNo() {
		return TcNo;
	}
	public void setTcNo(String tcNo) {
		TcNo = tcNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(int dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public double getWalletBalance() {
		return WalletBalance;
	}
	public void setWalletBalance(double walletBalance) {
		WalletBalance = walletBalance;
	}

	

}
