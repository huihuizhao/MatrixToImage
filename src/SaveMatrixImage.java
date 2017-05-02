
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class SaveMatrixImage {
 
	public static void createMatrixImage(double[][] matrix, String filedir) throws IOException {
//		filedir="C:/Users/zhaohuihui/workspace/MatrixToImage/profileImage01.jpeg";
		int cx = matrix.length;
		int cy = matrix[0].length;
		// �����θ߿�
		// int cz = 10;
		// // ����ͼ�Ŀ��
		// int width = cx * cz;
		// // ����ͼ�ĸ߶�
		// int height = cy * cz;

		OutputStream output = new FileOutputStream(new File(filedir));
 
		BufferedImage bufferedImage = new BufferedImage(cx, cy, BufferedImage.TYPE_INT_RGB);
		double maxValue=0;
		double minValue=100;
		for (int i = 0; i < cx; i++) {
			for (int j = 0; j < cy; j++) {
				if (matrix[i][j] > maxValue) {
					maxValue = matrix[i][j];
				}
				if (matrix[i][j] < minValue) {
					minValue = matrix[i][j];
				}
			}
		}
		int r = 255;
		int g = 255;
		int b = 255;
		for (int i = 0; i < cx; i++) {
			for (int j = cy - 1; j >= 0; j--) {
				// int valueColor = (int) ((16777216) * (matrix[i][j] -
				// minValue) / (maxValue - minValue));
				double value = 255 * (matrix[i][j] - minValue) / (maxValue - minValue);
				if (value >= 0 && value < 85) {
					r = (int) 0;
					g = (int) value*3;
					b = (int) 255;
				} else if (value >= 85 && value < 170) {
					r = (int) (value-85)*3;
					g = (int) 255;
					b = (int) (170-value)*3;
				} else if (value >= 170 && value <=255) {
					r = (int) 255;
					g = 255-(int) (value-170)*3;
					b = (int) 0;
				}

				int rgb = ((r << 16) | (g << 8) | b) & 0xffffff;
				bufferedImage.setRGB(i, j, rgb);// ��������
			}
		}

		bufferedImage.flush();
		// ����ļ�
		ImageIO.write(bufferedImage, "jpeg", output);
	}
	
	
	

}