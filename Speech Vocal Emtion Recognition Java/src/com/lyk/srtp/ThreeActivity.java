package com.lyk.srtp;

import com.lyk. srtp.DrawImg;
import com.lyk. srtp.R;

import android.app.Activity;
import android.os.Bundle;

public class ThreeActivity extends Activity{

	
	@Override

	protected void onCreate(Bundle saveInstanceState)
	{
	super.onCreate(saveInstanceState);
	setContentView(R.layout.three);
	
	DrawImg img = new DrawImg(this);
	setContentView(img);

}
}