
public interface ProgramDebugInformation {
	
//	#Interfejs ktory zmusza do zaimplementowania metody do wypisywania przechwyconych wyj�tk�w do pliku tekstowego
	
	static final String filename ="ErrorLogs.txt";
	
	public void WriteDebugInformationToFile(String errorText);
}
