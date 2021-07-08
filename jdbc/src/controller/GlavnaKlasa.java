package controller;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.FakultetLogic;
import metode.CommonMethods;
import model.Student;
import service.Service;

public class GlavnaKlasa {

	public static void main(String[] args) {
		
		Service service = new Service ();
		
		service.posaljiPozdrav();
		
		String ime = "Petar";
		String prezime="petrovic 2";
		int index = 843;
		int smer= 2;
		int drzavu = 1;
		int ispiti= 6;
		String imeDrzave= "Kanada";
		
		
		Student student = service.setujStudenta(ime,prezime,index,drzavu,smer,ispiti);
		
		
		
		
		service.unesiStudentaUbazu (student);
		service.unesiDrzavuUbazu(imeDrzave);
	}

}



