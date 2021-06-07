
public interface ProgramDebugInformation {
	
//	#Interfejs ktory zmusza do zaimplementowania metody do wypisywania przechwyconych wyj¹tków do pliku tekstowego
//	#te wyjatki to niespodziewane bledy, ich przechwycenie i zapisanie do pliku pomoze pozniej zrozumiec bledy programu.
	
	static final String filename ="ErrorLogs.txt";
	
	public void WriteDebugInformationToFile(String errorText);
}
