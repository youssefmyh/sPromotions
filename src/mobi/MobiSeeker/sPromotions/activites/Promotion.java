package mobi.MobiSeeker.sPromotions.activites;

import mobi.MobiSeeker.sPromotions.R;
import mobi.MobiSeeker.sPromotions.data.Entry;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Promotion extends Fragment {
	TextView entryTitle = null;
	TextView entrySummary = null;
	ImageView entryImage = null;
	Entry entryFromIntent = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.promotion, container, false);

		this.entryTitle = (TextView) rootView
				.findViewById(R.id.promotion_title);
		this.entrySummary = (TextView) rootView
				.findViewById(R.id.promotion_text);
		this.entryImage = (ImageView) rootView
				.findViewById(R.id.promotion_image);

		this.getEntryFromIntent();
		return rootView;
	}

	private void getEntryFromIntent() {
		Intent intent = getActivity().getIntent();
		Entry entry = (Entry) intent.getSerializableExtra("entry");
		if (entry == null) {
			return;
		}

		this.entryFromIntent = entry;

		this.entryTitle.setText(entry.getTitle());
		this.entrySummary.setText(entry.getText());
		String imageUrl = entry.getImagePath();
		if (imageUrl.isEmpty() || imageUrl == null) {
			return;
		}
		try{
		this.entryImage.setImageURI(Uri.parse(entry.getImagePath()));
		}catch(Exception ee){ee.printStackTrace();}
		
	}

	void goHome() {
		Context context = getActivity().getBaseContext();
		Intent intent = new Intent(Promotions.View_local_Promotions_Action);
		context.sendBroadcast(intent);
	}
	
	
}
