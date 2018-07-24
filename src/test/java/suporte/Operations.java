package suporte;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import cucumber.api.java.After;
 
public class Operations {
	/**
	 * Criação de pasta
	 * 
	 * @author felipe.lourenco
	 */
	
	public void criarDiretorio() {
        try {
            File diretorio = new File("FrameYaman\\target");
            diretorio.mkdir();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio");
            System.out.println(ex);
        }
    
	}
	/**
	 * Captura um screenshot com numero rotativo dentro da evidência
	 * 
	 * @author felipe.lourenco
	 * @return 
	 */
	@After
	public void screenCapture() {
		int screenshotnumber = 1;
		try {
				Robot robot = new Robot();
	            String format = "png";
	            String fileName = "Screenshot" + screenshotnumber + "." + format;
	             
	            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
	            ImageIO.write(screenFullImage, format, new File("FrameYaman\\target\\Screenshot" + fileName));
	            
	            screenshotnumber ++;
	            
	            System.out.println("Screenshot salvo!");
	        } catch (AWTException | IOException ex) {
	            System.err.println(ex);
	        }
	    }
	}