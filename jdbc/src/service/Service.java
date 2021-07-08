package service;

import dao.FakultetLogic;
import metode.CommonMethods;
import model.Student;

public class Service {

	FakultetLogic logic = new FakultetLogic();
	CommonMethods common = new CommonMethods();
	
	
	public void unesiStudentaUbazu(Student student) {
	
		logic.unesiStudenta(student);
	}


	public void unesiDrzavuUbazu(String imeDrzave) {
			logic.unesiDrzavu(imeDrzave);
		
	}


	public void posaljiPozdrav() {
		
		common.pozdrav();
		
	}


	public Student setujStudenta(String ime, String prezime, int index, int drzavu, int smer, int ispiti) {
		
		return common.setStudent(ime, prezime, index, drzavu, smer, ispiti);
		
	}
	
	
}
