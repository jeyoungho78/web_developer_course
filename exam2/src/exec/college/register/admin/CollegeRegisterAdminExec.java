package exec.college.register.admin;

import data.college.register.admin.StudentData;
import logic.college.register.admin.CollegeRegisterAdminLogic;

public class CollegeRegisterAdminExec {
	
	public static void main(String[] args) {
		
		String student1 = "È«±æµ¿^60^90^70";
		String student2 = "Çã±Õ^90^80^60";
		String student3 = "ÀÌ¼ø½Å^70^50^95";
		
		String[] stArr1 = student1.split("\\^");
		String[] stArr2 = student2.split("\\^");
		String[] stArr3 = student3.split("\\^");
		
		StudentData objSd1 = new StudentData();
		StudentData objSd2 = new StudentData();
		StudentData objSd3 = new StudentData();
		
		objSd1.setName(stArr1[0]);
		objSd1.setKorScore(Integer.valueOf(stArr1[1]));
		objSd1.setEngScore(Integer.valueOf(stArr1[2]));
		objSd1.setMathScore(Integer.valueOf(stArr1[3]));

		objSd2.setName(stArr2[0]);
		objSd2.setKorScore(Integer.valueOf(stArr2[1]));
		objSd2.setEngScore(Integer.valueOf(stArr2[2]));
		objSd2.setMathScore(Integer.valueOf(stArr2[3]));
		
		objSd3.setName(stArr3[0]);
		objSd3.setKorScore(Integer.valueOf(stArr3[1]));
		objSd3.setEngScore(Integer.valueOf(stArr3[2]));
		objSd3.setMathScore(Integer.valueOf(stArr3[3]));
		
		StudentData[] sdArr = {objSd1, objSd2, objSd3};
		
		StudentData objSds = new StudentData();
		objSds.setStudentArray(sdArr);
		
		CollegeRegisterAdminLogic crl = new CollegeRegisterAdminLogic(objSds);
		crl.printBestScore();
		crl.printGrade();
	}

}
