import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class GraphUnknownException extends Exception implements ProgramDebugInformation{
	
//	#Wyj¹tek odpowiedzialny za przechwytywanie niespodziewanych zachowan programu
//	#Te zachowania musi wypisac to pliku "ErrorLogs.txt", do dalszego debuowania.
//	#Implementuje on interfejs który go do tego zmusza, tak samo jak ewentualne przysz³e wyj¹tki.
	
	public GraphUnknownException(String errorMessage, Throwable err){
		StringWriter errors = new StringWriter();
		err.printStackTrace(new PrintWriter(errors));
		
		WriteDebugInformationToFile(errorMessage + errors.toString());
	}
	
	@Override
	public void WriteDebugInformationToFile(String errorText) {
		
		try{
			File yourFile = new File(ProgramDebugInformation.filename);
			yourFile.createNewFile();
			FileWriter fW = new FileWriter(yourFile);
			PrintWriter printWriter = new PrintWriter(fW);
				
		    printWriter.print(errorText);
		    printWriter.close();
		    fW.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
		
	}
}
