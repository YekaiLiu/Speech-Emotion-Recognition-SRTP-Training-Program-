package com.lyk.srtp;




import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.iflytek.speech.RecognizerResult;
import com.iflytek.speech.SpeechConfig.RATE;
import com.iflytek.speech.SpeechError;
import com.iflytek.ui.RecognizerDialog;
import com.iflytek.ui.RecognizerDialogListener;
import com.lyk. srtp.ExitApplication;

/**
  @author ��ҳ��
 * 2016-10-25 ����08:24
 */


public class HelloDemoActivity extends Activity implements OnClickListener {
	protected static final String TAG = "ThirdActivity";
	private EditText txt_result;
	private EditText editText1;
	private RecognizerDialog rd;
	private long exitTime = 0;  
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ExitApplication.getInstance().addActivity(this);
		
		setContentView(R.layout.demo);
		
		findView();
		//RecognizerDialog(Context context, String params); "appid=1234567,usr=test,pwd=12345"  usr��pwd���Ǳ�ѡ��
		//��������ʶ��dailog����appid��Ѷ�ɾ�ע���ȡ
		rd = new RecognizerDialog(this ,"appid=50e1b967");
		
		

	}

	private void findView() {
		txt_result = (EditText) findViewById(R.id.txt_result);
		editText1 = (EditText) findViewById(R.id.editText1);
		findViewById(R.id.bt_search).setOnClickListener(this);
		findViewById(R.id.button1).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.bt_search:
			
			showReconigizerDialog();
			break;
		case R.id.button1:                  //!!!!!!
		{
			
			
			
			Intent intent = new Intent(this,SecondActivity.class);
		intent.putExtra("info",editText1.getText().toString().trim());
		
		
	
		   startActivity(intent);
			
		}
			
		default:
			break;
		}
	}

	
	
	  @Override  
	    public boolean dispatchKeyEvent(KeyEvent event) {  
	      if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {  
	        if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {  
	          this.exitApp();  
	        }  
	        return true;  
	      }  
	      return super.dispatchKeyEvent(event);  
	    }  
	      
	    /** 
	     * �˳����� 
	     */  
	    private void exitApp() {  
	      // �ж�2�ε���¼�ʱ��  
	      if ((System.currentTimeMillis() - exitTime) > 2000) {  
	        Toast.makeText(HelloDemoActivity.this, "�ٰ�һ���˳�����", Toast.LENGTH_SHORT).show();  
	        exitTime = System.currentTimeMillis();  
	      } else {  
	    	ExitApplication.getInstance().exit();

	      }  
	    }  

	
	
	
	
	
	private void showReconigizerDialog() {
		
		
		rd.setEngine("sms", null, null);
		
		
		rd.setSampleRate(RATE.rate16k);
		
		final StringBuilder sb = new StringBuilder();
		Log.i(TAG, "ʶ��׼����ʼ.............");
		
		//����ʶ���Ļص����
		rd.setListener(new RecognizerDialogListener() {
			@Override
			public void onResults(ArrayList<RecognizerResult> result, boolean isLast) {
				for (RecognizerResult recognizerResult : result) {
					sb.append(recognizerResult.text);
					Log.i(TAG, "ʶ��һ�����Ϊ::"+recognizerResult.text);
				}
			}
			@Override
			public void onEnd(SpeechError error) {
				Log.i(TAG, "ʶ�����.............");
				txt_result.setText(sb.toString())              //!!!!!!
				;
				editText1.setText(txt_result.getText().toString()); //yeyeyeyeye!
			}
		});
		
		txt_result.setText(""); 
		rd.show();
		//editText1.setText(txt_result.getText().toString()); 
		//editText1.setText("ahah"); 	
	}

	
}