package comhs.fundationdev.hairstyle.exeption;

/**
 * Created by lucas on 04/02/16.
 */
@SuppressWarnings("serial")
public class DataExeption extends GenercicException{

	public DataExeption(String msg){
		super.message = msg;
	}
	
}
