
public class Quiz1 {

	public static void main(String[] args) {
		//#1
		String[][] cityDeptList = null;  

		//#2
		cityDeptList = new String[3][];

		//#3
		cityDeptList[0] = new String[2];
		cityDeptList[1] = new String[1];
		cityDeptList[2] = new String[3];

		//#4
		cityDeptList[0][0] = "Police Department";
		cityDeptList[0][1] = "Fire Department";

		cityDeptList[1][0] = "Urban Development Department";

		cityDeptList[2][0] = "Police Department";
		cityDeptList[2][1] = "Fire Department";
		cityDeptList[2][2] = "Urban Development Department";

		//#5
		for(int row = 0; row < cityDeptList.length; row ++) {
			System.out.print("City " + row + ": ");
			for(int col = 0; col < cityDeptList[row].length; col++) {
				System.out.print(cityDeptList[row][col]);
				if(col != cityDeptList[row].length - 1)
					System.out.print(", ");
			}
			System.out.println();
		}

		//extra credit
		int row = 0;
		for(String[] city : cityDeptList) {
			System.out.print("City " + row + ": ");
			for(String dept : city) {
				System.out.print(dept);
				if(!dept.equals(city[city.length - 1])) 
					System.out.print(", ");
			}
			System.out.println();
			row++;
		}

	}

}
