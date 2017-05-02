
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class ReadData {

	public static String[][] readTxtFile(String filePath) {
		try {

			// filePath="C:/Users/zhaohuihui/workspace/MatrixToImage/MatrixData01.txt";
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// ���ǵ������ʽ
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				// int n = 0;//
				// bufferedReader.mark((int) file.length());
				// while ((lineTxt = bufferedReader.readLine()) != null) {
				// if (!lineTxt.startsWith("*") && !lineTxt.startsWith("#")) {
				// n++;
				// }
				// }

				String[][] ValueMatrix = new String[10][10];
				// read.close();

				// read = new InputStreamReader(new FileInputStream(file),
				// encoding);// ���ǵ������ʽ
				// bufferedReader = new BufferedReader(read);
//				int i = 0;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (!lineTxt.startsWith("*") && !lineTxt.startsWith("#")) {
						String[] lineValues = lineTxt.trim().split("\\s+");// �Զ���ո�ָ�
						int vL = lineValues.length;
						for (int s = 0; s < vL; s++) {

							for (int i = 0; i < ValueMatrix.length; i++) {
								for (int j = 0; j < ValueMatrix[0].length; j++) {
									ValueMatrix[i][j] = lineValues[i*10+j];
								}
							}

						}

						System.out.println(lineTxt);
//						i++;

					}

				}
				read.close();
				return ValueMatrix;

			} else {
				System.out.println("");
			}

		} catch (

		Exception e) {
			System.out.println("");
			e.printStackTrace();
		}
		return null;

	}

}
