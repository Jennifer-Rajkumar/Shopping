package exercise.model;

import java.util.ListResourceBundle;
public class Dictionary_ta extends ListResourceBundle {

	Object dictionary[][]= {
		{"login","உள்நுழைய"},
		{"register","பதிவு"},
		{"Session expired","அமர்வு காலாவதியானது! நீண்ட நேரமாக செயலற்ற நிலை!"},
		{"uname","பயனர் பெயர்"},
		{"upass","கடவுச்சொல்"},
		{"submit","சமர்ப்பிக்க"}
	};
	
	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return dictionary;
	}
}
