package comhs.fundationdev.hairstyle.exeption;

/**
 * Created by lucas on 04/02/16.
 */
@SuppressWarnings("serial")
public class UpdateExeption extends GenercicException {

	public UpdateExeption(String msg){
		super.message = msg;
	}
	
}
