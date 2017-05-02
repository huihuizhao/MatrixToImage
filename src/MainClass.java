import java.io.IOException;

public class MainClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String filePath = "C:/Users/zhaohuihui/workspace/MatrixToImage/MatrixData01.txt";
		String filedir = "C:/Users/zhaohuihui/workspace/MatrixToImage/profileImage01.jpg";

		String[][] MatrixArray = ReadData.readTxtFile(filePath);
		// double[][] dblMatrixArray1 = new double[10][10];
		double[][] dblMatrixArray = new double[100][100];
		for (int i = 0; i < MatrixArray.length; i++) {
			for (int j = 0; j < MatrixArray[0].length; j++) {
				dblMatrixArray[i][j] = Double.valueOf(MatrixArray[i][j])*100;
			}
		}

		SaveMatrixImage.createMatrixImage(dblMatrixArray, filedir);

	}

}
