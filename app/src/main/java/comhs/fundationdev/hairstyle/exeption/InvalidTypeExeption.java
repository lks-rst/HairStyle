package comhs.fundationdev.hairstyle.exeption;

/**
 * Created by lucas on 04/02/16.
 */
@SuppressWarnings("serial")
public class InvalidTypeExeption extends GenercicException {

	public InvalidTypeExeption(String msg){
		super.message = msg;
	}
	
}
