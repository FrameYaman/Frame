package br.com.report;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import br.com.report.exception.ReportException;

public class ReportManager {
	
		
	private static HashMap <String, List<Path>> pathMap;
	private static HashMap <String, List<String>> reportMap;
	private static Path pathToSave;
		
	static {
		pathMap = new HashMap <String, List<Path>>();
		reportMap = new HashMap <String, List<String>>(); 
		pathToSave = Paths.get("C:\\Evidences\\Execucao_" + formatDate("yyyyMMddhhmmss", new Date()) + "/");
		try {
			Files.createDirectories(pathToSave);
		} catch (IOException e) {
			throw new ReportException(e);
		}
	}
	
	/**
	 * Construtor privado. N?o ? necess?rio iniciar a classe para utiliza-la
	 */
	private ReportManager () {
	}
	
	/**
	 * Recebe um objeto Path referente ao arquivo, 
	 * move ele para o diret?rio do teste e mant?m o novo Path relaciado ao teste executado.
	 * Caso j? exista um arquivo com o mesmo nome no diret?rio de destino, ent?o ele ser? sbrescrito.
	 * 
	 * @param path
	 * @throws IOException
	 */
	public static void addEvidence (Path path) throws IOException {
		addEvidence(path, false);
	}
	
	/**
	 * Recebe um objeto Path referente ao arquivo,
	 * copy / move ele para o diret?rio do teste e mant?m o novo Path relaciado ao teste executado.
	 * Caso j? exista um arquivo com o mesmo nome no diret?rio de destino, ent?o ele ser? sbrescrito.
	 * @param path - caminho do arquivo para adicionar a pasta de evidencia.
	 * @param copyFile <b>True</b> : copia o arquivo para a pasta de evidencia.
	 * <b>False</b> :  move o arquivo para a pasta de evidencia. 
	 * @throws IOException
	 */
	public static void addEvidence (Path path, boolean copyFile) throws IOException {
		String testName = getTestName ();
		Path fullPath = Paths.get(pathToSave + "/" + testName + "/" + path.getFileName() );
		
		if (!pathMap.containsKey(testName)) {
			pathMap.put(testName, new ArrayList <Path> ());
		}
		try {	
			if (!Files.exists(fullPath)) {
				Files.createDirectories(fullPath.getParent());
			}
			if(copyFile){
				Files.copy(path,fullPath, StandardCopyOption.REPLACE_EXISTING);
			}
			else{
				Files.move(path,fullPath, StandardCopyOption.REPLACE_EXISTING);
			}
			pathMap.get(testName).add(fullPath);
		}
		catch (IOException e ) {
			throw new ReportException("Falha ao mover o arquivo de " + path.toString() + " para " + fullPath + " -----\n" + e.getMessage());
		}		
	}
		
	/**
	 * Retorna uma lista de Path que cont?m os endere?os 
	 * para as evid?ncias relacionadas ao caso de teste que est? sendo executado.
	 * 
	 * @return List<Path>  Lista de Path contendo endere?o das evid?ncias
	 */
	public static List <Path> getEvidences () {
		String testName = getTestName();
		return pathMap.get(testName);
	}
		
	/**
	 * Retorna uma lista de Path que cont?m os endere?os 
	 * para as evid?ncias relacionadas ao caso de teste recebido por par?metro
	 * 
	 * @return List<Path>  Lista de Path contendo endere?o das evid?ncias
	 */
	public static List <Path> getEvidences (String testName) {
		return pathMap.get(testName);
	}
			
	/**
	 * Obtem o nome teste que est? sendo executado
	 * 
	 * @return Retorno o nome do metodo de teste que est? sendo executado.
	 */
	private static String getTestName () {
		return Thread.currentThread().getName();
	}
	
	/**
	 * Adiciona a lista de texto padr?o do Report para ser utilizado no metodo getTextReport.
	 * @param text
	 */
	public static void addTextReport(String text){
		String testName = getTestName ();	
		if (!reportMap.containsKey(testName)) {
			reportMap.put(testName, new ArrayList <String> ());
		}
		reportMap.get(testName).add(text);
	}
	
	/**
	 * Retorna a lista de textos padr?es adicionando pelo metodo addTextReport e limpa a lista referente ao testName Informado. 
	 * @param testName
	 * @return
	 */
	public static List<String> getTextReport(String testName){
		List<String> listTextReport = new ArrayList <String> ();
		try{
			if (reportMap.containsKey(testName)) {
				int i = 0;
				for(String text : reportMap.get(testName)){
					listTextReport.add((i==0)?text:"\n"+text);
					i++;
				}
			}
			reportMap.get(testName).clear();
			return listTextReport;
		}
		catch(Exception e){
			return listTextReport;
		}
	}

	/**
	 * Metodo para limpar a Lista que contem os textos padr?es adicionados pelo addTextReport.
	 * @param testName
	 */
	public static void clearTextReport(String testName){
		if(reportMap.containsKey(testName)){
			reportMap.get(testName).clear();
		}
	}
	
	/**
	 * Recebe uma String indicando o formato da data que se espera e um objeto
	 * do tipo Date. A fun??o converte o objeto Date para uma String no formato
	 * recebido
	 * 
	 * @param format
	 *            String com o formato esperado para data
	 * @param date
	 *            objeto Date com a data que deseja formatar
	 * @return Retorna String com a data formatada
	 */
	public static String formatDate(String format, Date date) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

}
