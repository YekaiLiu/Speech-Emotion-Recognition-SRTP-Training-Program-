package com.lyk.srtp;


import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

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


import java.io.FileOutputStream;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Locale;

 

import android.app.Activity;

import android.graphics.Bitmap;

import android.os.Bundle;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.Button;

import com.iflytek.speech.RecognizerResult;
import com.iflytek.speech.SpeechConfig.RATE;
import com.iflytek.speech.SpeechError;
import com.iflytek.ui.RecognizerDialog;
import com.iflytek.ui.RecognizerDialogListener;


import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Timer;

import android.app.Activity;
import android.content.Intent;

import android.util.Log;

import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.iflytek.speech.RecognizerResult;
import com.iflytek.speech.SpeechConfig.RATE;
import com.iflytek.speech.SpeechError;
import com.iflytek.ui.RecognizerDialog;
import com.iflytek.ui.RecognizerDialogListener;
import com.lyk. srtp.ExitApplication;
import com.lyk. srtp.HelloDemoActivity;
import com.lyk. srtp.R;
import com.lyk. srtp.ScreenShot;

/**
 * @author ��ҳ��
 * 2016-10-25 ����08:24
 */
public class SecondActivity extends Activity {
	private EditText edit1;
	private EditText edit2;
	private TextView t3;
	private TextView t5;
	private TextView t6;

	
	private long exitTime = 0;
	SimpleDateFormat   shijian   =   new   SimpleDateFormat("hh:mm"); 
	ImageView img;
	
	
	
private GraphicalView chart;  
	

	private Float addY;
	private String  addX;
	
/*
 * ������һ������������
 * ÿ��ʾһ�μ�¼ʱ��ͰѼ�¼ʱ�丳��һ�����еĴ���Ͱ
 * 
 * 
 * */	
	
	String[] xkedu = new String[5] ;//x�����ݻ���
	
	Float[] ycache = new Float[5];
	//private final static int SERISE_NR = 1; //��������
	private XYSeries series;//������յ�һ���ټ���һ��
	private XYMultipleSeriesDataset dataset1;//xy������Դ
	private XYMultipleSeriesRenderer render;
	protected static final String TAG = "ThirdActivity";
	
	private EditText editText1;
	private RecognizerDialog rd;

	
	Handler handler2;
	TextView guangzhi2;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ExitApplication.getInstance().addActivity(this);
		
		setContentView(R.layout.second);

		img = (ImageView) findViewById(R.id.imageView1);
		edit1 = (EditText) findViewById(R.id.edit1); 
		edit2 = (EditText) findViewById(R.id.edit2); 
		t3 = (TextView) findViewById(R.id.t3);//���˰���ԭ�����⴦��findViewById������setContentView֮�󣡣���

		t5 = (TextView) findViewById(R.id.t5);
		t6 = (TextView) findViewById(R.id.t6);
		String info = getIntent().getStringExtra("info");
		
		edit1.setText(info)   ; 
		
		
		LinearLayout linearLayout = (LinearLayout)findViewById(R.id.guangzhexian);
		chart = ChartFactory.getLineChartView(this, getdemodataset(), getdemorenderer());
		linearLayout.removeAllViews();//��remove��add����ʵ��ͳ��ͼ����
		linearLayout.addView(chart, new LayoutParams(LayoutParams.WRAP_CONTENT,
			LayoutParams.WRAP_CONTENT));
		

		
		
		//RecognizerDialog(Context context, String params); "appid=1234567,usr=test,pwd=12345"  usr��pwd���Ǳ�ѡ��
		//��������ʶ��dailog����appid��Ѷ�ɾ�ע���ȡ
		rd = new RecognizerDialog(this ,"appid=50e1b967");
		/*switch (v.getId()) {
		case R.id.bt_search:
			showReconigizerDialog();
			break;
		case R.id.button1:        
*/	
		
		
		//ExitApplication.getInstance().exit();
	}
	
	
	 public void onClick(View v)
 {
		 switch (v.getId()){
		 
		 
		
		 
		 
		 
		
		
		 case R.id.bu2://1����,2��ŭ3ƽ��4����5����  
		     {		
		    	 
		    	 if(edit1.getText().toString() == null ||edit1.getText().toString().length() <= 0) 
		     {
		    		 t3.setText("����û�гɹ�¼��Ŷ������������¼��");
		    		 edit1.setText(""); 
		    		 edit2.setText(""); 
				    	break;
                    		     
		     }
		     
		    	 
		    	 
		     else{ 	 if(t6.getText()=="0")
		    	
		    	 {t3.setText("���Ѿ�����������������ʶ���ˣ���Ҫ����ʶ�������¼���µ�����������������");
		    	 edit1.setText("");
		    	 edit2.setText("");
		    	 break;
		    	 }  
		     else{
		    	//1����
		    	 if(
		    			    isContain(edit1.getText().toString(),"����") == true  ||
		    			 isContain(edit1.getText().toString(),"̫��") == true     ||
		    			 isContain(edit1.getText().toString(),"����") == true     ||
		    			 isContain(edit1.getText().toString(),"�ܺ�") == true     ||
		    			 isContain(edit1.getText().toString(),"û����") == true     ||
		    			 isContain(edit1.getText().toString(),"̫��") == true     ||
		    			 isContain(edit1.getText().toString(),"��") == true     ||
		    			 isContain(edit1.getText().toString(),"�õĺ�") == true     ||
		    			isContain(edit1.getText().toString(),"����") == true     ||
		    			 isContain(edit1.getText().toString(),"����") == true     ||
		    			 isContain(edit1.getText().toString(),"����") == true     ||
		    			 isContain(edit1.getText().toString(),"�Ҹ�") == true     ||
		    			 isContain(edit1.getText().toString(),"ok") == true     ||
		    			 isContain(edit1.getText().toString(),"��") == true     
		   )
		    	{edit2.setText("����") ;
		    	t3.setText("���������ڽ������������������ֿ��ֵ����飡");
		    			
		    			t5.setText("1");
		    			updatechart();
		    			t6.setText("0")			;  
		    			
		    	break;}
		    	 
		    	 //2��ŭ
		    	 if(
		    			    isContain(edit1.getText().toString(),"��") == true  ||
		    			 isContain(edit1.getText().toString(),"nnd") == true     ||
		    			 isContain(edit1.getText().toString(),"tmd") == true     ||
		    			 isContain(edit1.getText().toString(),"��") == true     ||
		    			 isContain(edit1.getText().toString(),"��") == true     ||
		    			 isContain(edit1.getText().toString(),"��") == true     ||
		    					 isContain(edit1.getText().toString(),"*") == true     ||
		    							 isContain(edit1.getText().toString(),"����") == true     ||
		    									 isContain(edit1.getText().toString(),"�˰�") == true     ||
		    							 isContain(edit1.getText().toString(),"˭") == true     ||
		    									 isContain(edit1.getText().toString(),"shit") == true ||
		    											 isContain(edit1.getText().toString(),"��") == true ||
		    			 isContain(edit1.getText().toString(),"��") == true     ||
		    					 isContain(edit1.getText().toString(),"fuck") == true     ||
				    					 isContain(edit1.getText().toString(),"��") == true     ||
				    							 isContain(edit1.getText().toString(),"�̳�") == true     ||
				    									 isContain(edit1.getText().toString(),"s") == true     ||		
				    							 isContain(edit1.getText().toString(),"����") == true     ||
				    									 isContain(edit1.getText().toString(),"��") == true     ||	
		    			isContain(edit1.getText().toString(),"��") == true     ||
		    			 isContain(edit1.getText().toString(),"������") == true     ||
		    			 isContain(edit1.getText().toString(),"û��") == true     ||
		    			 isContain(edit1.getText().toString(),"����") == true     ||
		    					 isContain(edit1.getText().toString(),"����") == true     ||
		    			 isContain(edit1.getText().toString(),"��ŭ") == true     ||
		    					 isContain(edit1.getText().toString(),"��Ҫ") == true     ||
				    			 isContain(edit1.getText().toString(),"��") == true     ||
						    			 isContain(edit1.getText().toString(),"��") == true     ||
								    			 isContain(edit1.getText().toString(),"��") == true     ||
								    					 isContain(edit1.getText().toString(),"��") == true     ||
								    							 isContain(edit1.getText().toString(),"ƨ") == true     ||
								    									 isContain(edit1.getText().toString(),"��Ͱ") == true     ||
								    											 isContain(edit1.getText().toString(),"����") == true     ||
								    													 isContain(edit1.getText().toString(),"��") == true     ||
								    											 isContain(edit1.getText().toString(),"����") == true     ||
								    									 isContain(edit1.getText().toString(),"����") == true     ||
						    			 isContain(edit1.getText().toString(),"��") == true     ||
		    			isContain(edit1.getText().toString(),"��") == true     ||
		    					isContain(edit1.getText().toString(),"��") == true     ||
		    					isContain(edit1.getText().toString(),"��ˬ") == true     ||
		    							isContain(edit1.getText().toString(),"��") == true     ||
		    									isContain(edit1.getText().toString(),"��") == true     ||
		    											isContain(edit1.getText().toString(),"!") == true     ||
		    												
		    			    			 
		    			 isContain(edit1.getText().toString(),"��") == true     
		   )
		    	{edit2.setText("��ŭ") ;
		    	t3.setText("�����ڷ�ŭʱҲ������Լ�ʹ����࣬���Ǳ���Ҫ��ϸ��������Լ��ķ�ŭ�Ƿ��ܴ���ʲô�Լ���ŭ�Ĳ�����������濼�����Լ��侲���������������Լ�����");
		   
		    	t5.setText("2");
		    	
		    	updatechart();
		    	t6.setText("0")			;  
		    	break;}
		    	 
		    	 //3ƽ��
		    	 if(
		    			    isContain(edit1.getText().toString(),"�õ�") == true  ||
		    			    		isContain(edit1.getText().toString(),"��") == true  ||
		    			 isContain(edit1.getText().toString(),"ûʲô") == true     ||
		    			 isContain(edit1.getText().toString(),"���") == true     ||
		    					 isContain(edit1.getText().toString(),"û��") == true     ||
		    			 isContain(edit1.getText().toString(),"��������") == true     ||
		    			 isContain(edit1.getText().toString(),"�պ�") == true     ||
		    			 isContain(edit1.getText().toString(),"Ҳ��") == true     ||
		    			 isContain(edit1.getText().toString(),"��") == true     ||
		    			 isContain(edit1.getText().toString(),"Ŷ") == true     ||
		    					 isContain(edit1.getText().toString(),"����") == true     ||
		    							 isContain(edit1.getText().toString(),"��!") == true     ||
		    									 isContain(edit1.getText().toString(),"!") == true     ||
		    											 isContain(edit1.getText().toString(),"��") == true     ||
		    					 isContain(edit1.getText().toString(),"����") == true     ||
		    							 isContain(edit1.getText().toString(),"����") == true     ||
		    									 isContain(edit1.getText().toString(),"�˰�") == true     ||
		    											 isContain(edit1.getText().toString(),"��!") == true     ||
		    													 isContain(edit1.getText().toString(),"����") == true     ||
		    							 isContain(edit1.getText().toString(),"����") == true     ||
		    									 isContain(edit1.getText().toString(),"����!") == true     ||
		    											 isContain(edit1.getText().toString(),"��") == true     ||
		    													 isContain(edit1.getText().toString(),"��!") == true     ||
		    			
		    			 isContain(edit1.getText().toString(),"ƽ��") == true     
		   )
		    	{edit2.setText("ƽ��") ;
		    	t3.setText("ƽ������̬�����ڽ�������������������ƽ�������飡");
		  
		    	t5.setText("0");
		    	updatechart();
		    	t6.setText("0")			;  
		    
		    	break;}
		    	 
		    	 
		    	 //4����
		    	 if(
		    			  isContain(edit1.getText().toString(),"��") == true  ||
		    			    isContain(edit1.getText().toString(),"��") == true  ||
		    			    		 isContain(edit1.getText().toString(),"i") == true  ||
		    			    		isContain(edit1.getText().toString(),"��ѽ") == true  ||
		    			    				isContain(edit1.getText().toString(),"��ѽ") == true  ||
		    			
		    			 isContain(edit1.getText().toString(),"û�뵽") == true     ||
		    			 isContain(edit1.getText().toString(),"��") == true     ||
		    					 isContain(edit1.getText().toString(),"����") == true     ||
		    							 isContain(edit1.getText().toString(),"û�а취") == true     ||
		    									 isContain(edit1.getText().toString(),"���") == true     ||
		    					 isContain(edit1.getText().toString(),"��") == true     ||
		    			 isContain(edit1.getText().toString(),"��") == true     
		   )
		    	{edit2.setText("����") ;
		    	t3.setText("�����ǶԽ��������ģ���������ȥ���ߣ��˶�һ�£�����˯һ���ɡ���");
		    	
		    	t5.setText("-1");
		    	updatechart();
		    	t6.setText("0")			;  
		    	break;}
		    	 
		    	 //5����  
		    	 if(
		    			    isContain(edit1.getText().toString(),"����") == true  ||
		    			 isContain(edit1.getText().toString(),"��") == true     ||
		    			 isContain(edit1.getText().toString(),"����") == true     ||
		    					 isContain(edit1.getText().toString(),"��ô�찡") == true     ||
		    			 isContain(edit1.getText().toString(),"��") == true     ||
		    					 isContain(edit1.getText().toString(),"��ô��") == true     ||
		    							 isContain(edit1.getText().toString(),"����") == true     ||
		    									 isContain(edit1.getText().toString(),"�군") == true     ||
		    					 isContain(edit1.getText().toString(),"��") == true     ||
		    							 isContain(edit1.getText().toString(),"�����ô��") == true     ||
		    									 isContain(edit1.getText().toString(),"������") == true     ||
		    									 isContain(edit1.getText().toString(),"����") == true     ||
		    			 isContain(edit1.getText().toString(),"����") == true     
		   )
		    	{edit2.setText("����") ;
		    	t3.setText("�����ǶԽ��������ģ���������Ҫ����ˣ���ȥ���ߣ��˶�һ�£����߿�����Ӱ�����Լ��ѡ���");
		    
		    	t5.setText("-2");
		    	updatechart();
		    	t6.setText("0")			;  
		    	break;}
		    	 
		    	 
		    	 
		    	  if(edit1.getText().toString() == null ||edit1.getText().toString().length() <= 0)
		    	 {
		    		 
		    		 t3.setText("����û�гɹ�¼��Ŷ������������¼��");
		    		 edit1.setText(""); 
		    		 edit2.setText(""); 
				    	break;
		    	 }
		    	 
		    	 if(0==0)
		    	 {edit2.setText("ƽ��") ;
			    	t3.setText("ƽ������̬�����ڽ�������������������ƽ�������飡");
			    	t5.setText("0");
			    	updatechart();
			    	
			    	t6.setText("0")			;  
			    	break;}
		    		 
		     }
		     }
		     }
		   
		 
		     
		 case R.id.button1:
		 { 
			 
			
			 
			 
			 showReconigizerDialog();
				t5.setText("")			;//!!!
			 
			 
			 
			 
			 
			 
			 /*Intent intent = new Intent(this,HelloDemoActivity.class);
		   startActivity(intent);
		   */
			 
			 
			 
			 break;}
		     
		     
		     
		   
		 case R.id.b2:
		 { Intent intent = new Intent(this,MainActivity.class);
		   startActivity(intent);
		   break;}
		 
		 
		 
		 
		 case R.id.but2:
		 {
			 String filePath = Environment.getExternalStorageDirectory() + "/DCIM/"
						+ "SpeechEmotionRecognitionlyk.png";
				ScreenShot.shoot(this, new File(filePath));
				//img.setVisibility(View.VISIBLE);
				img.setImageBitmap(getLoacalBitmap(filePath));
			
				//TimerTask task = new TimerTask(){
					//  public void run(){
						//img.setVisibility(View.INVISIBLE);
				//	  }
					//};
				//	Timer timer = new Timer();
					//timer.schedule(task, 2000);
					Toast.makeText(this, "��м�¼�ѱ�����DCIM/SpeechEmotionRecognitionlyk.png" ,Toast.LENGTH_SHORT).show();
			 
		 break;
		 }

			   

			   
		     
		     
		     
		 default:
				break;
		 
	
		 }

		
		 
  }
	 
	 
	 
	 public static boolean isContain(String s1,String s2) {

		 return s1.contains(s2);

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
	        Toast.makeText(this, "�ٰ�һ���˳�����", Toast.LENGTH_SHORT).show();  
	        exitTime = System.currentTimeMillis();  
	      } else {  ExitApplication.getInstance().exit();
	    	
	      }  
	    }  

	    private void updatechart() 
		{
			//�жϵ�ǰ�㼯�е����ж��ٵ㣬��Ϊ��Ļ�ܹ�ֻ������5�������Ե���������5ʱ��������Զ��5
			int length=series.getItemCount();
			int a=length;
			if(length>5){
				length=5;
			}
			/*try {
				if(guangzhi2.getText().toString()!=null){
					addY = Float.valueOf(guangzhi2.getText().toString());//Ҫ��Ҫ�ж���˵
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}*/
			addX=shijian.format(new java.util.Date());
			
			
			
			
			
			 
			
			 
			 
			 
			
			
		
				
				if(t5.getText()=="-2")
			
				{       addY =(float)-2;}
				
				else {
					if(t5.getText()=="-1")
						 {addY =(float)-2;}
					else{
						if(t5.getText()=="0")
							
						 {addY =(float)0;}
						else{	if(t5.getText()=="1")
							 {addY =(float)1;}
						else{if(t5.getText()=="2")
						 {addY =(float)2;}
							
							
							
							
							
						}
							
						}
						
						
					}
			
				
				
				
				
				
				
				
				
				
				}
			
			
			
			
			
			
			
			
			
			
			
			
			
			//�Ƴ����ݼ��оɵĵ㼯
			dataset1.removeSeries(series);
			if(a<5)//�����ݼ��в���������ʱ��ֱ����Ӿͺã���Ϊ��ʼ����ʱ��ֻ��һ���㣬����ǰ���θ��µ�ʱ��ֱ�����
			{
				series.add(a+1, addY);//��һ����������ڼ����㣬Ҫ����������еĵ�һ��������Ӧ
				render.addXTextLabel(a+1, addX);
				xkedu[a]=addX;
			}
			else //�����������Ҫȥ��xcache��0�����ɡ�1����.....
			{
				//���ɵĵ㼯��x��y����ֵȡ��������backup�У������������ƽ�Ƶ�Ч��
				for(int i =0 ;i<length-1;i++){
					ycache[i]=(float) series.getY(i+1);
					xkedu[i]=xkedu[i+1];
				}
				
				//�㼯����գ�Ϊ�������µĵ㼯��׼��
				series.clear();
				 //���²����ĵ����ȼ��뵽�㼯�У�Ȼ����ѭ�����н�����任���һϵ�е㶼���¼��뵽�㼯��
				
				for(int k =0 ;k<length-1;k++){
					series.add(k+1, ycache[k]);
					render.addXTextLabel(k+1, xkedu[k]);
				}
				xkedu[4]=addX;
				series.add(5, addY);
				render.addXTextLabel(5, addX);
			}	 
			//�����ݼ�������µĵ㼯
			dataset1.addSeries(series);
			 //��ͼ���£�û����һ�������߲�����ֶ�̬
			chart.invalidate();
		}        //update...end

	  

		
	    
	    
	    
	    
	    private XYMultipleSeriesRenderer getdemorenderer() {
			// TODO Auto-generated method stub
			render = new XYMultipleSeriesRenderer();
			render.setChartTitle("���ָ���仯����(��ʾʱ��hh:ss��Ӧ�û��ڱ���ʱ��hh��ss��ʱ�����ָ��)");
			render.setChartTitleTextSize(20);//��������ͼ��������ֵĴ�С
			render.setAxisTitleTextSize(16);//������������ֵĴ�С
			render.setAxesColor(Color.BLACK);
			render.setXTitle("ʱ��");
			render.setYTitle("���ָ��");
			
			render.setLabelsTextSize(8);//������̶����ֵĴ�С
			render.setLabelsColor(Color.BLACK);
			render.setXLabelsColor(Color.BLACK);
			render.setYLabelsColor(0, Color.BLACK);
			render.setLegendTextSize(30);//����ͼ�����ִ�С  
			//render.setShowLegend(false);//��ʾ����ʾ���������ã��ǳ�����
			
			XYSeriesRenderer r = new XYSeriesRenderer();//������ɫ�͵�����
			r.setColor(Color.RED);
			r.setPointStyle(PointStyle.CIRCLE);
			r.setFillPoints(true);
			r.setChartValuesSpacing(3);
			
			render.addSeriesRenderer(r);
			render.setYLabelsAlign(Align.RIGHT);//�̶�ֵ����ڿ̶ȵ�λ��
			render.setShowGrid(true);//��ʾ����
			render.setYAxisMax(2.5);//����y��ķ�Χ
			render.setYAxisMin(-2.5);
			render.setYLabels(5);//��5�ȷ�
			
			
			render.setInScroll(true);
			render.setLabelsTextSize(20);
			render.setLabelsColor(Color.BLACK);
			//render.getSeriesRendererAt(0).setDisplayChartValues(true); //��ʾ�����ϵ����ֵ
			render.setPanEnabled(false,false);//��ֹ������϶�
			render.setPointSize(5f);//���õ�Ĵ�С(ͼ����ʾ�ĵ�Ĵ�С��ͼ���е�Ĵ�С���ᱻ����)
			render.setMargins(new int[]{20,30,90,10}); //����ͼ�����ܵ�����
			render.setMarginsColor(Color.WHITE);
			render.setXLabels(0);// ȡ��X���������zjk,ֻ���Լ�����������ǲ���Ϊ��ֵ
			

			
			return render;
		}
		
		private XYMultipleSeriesDataset getdemodataset() {
			// TODO Auto-generated method stub
			 dataset1=new XYMultipleSeriesDataset();//xy������Դ
			series = new XYSeries("���ָ����-2��-1��0��1��2�ֱ����" +
					"���֣����ˣ�ƽ�������ˣ���ŭ ");//���������ʾ�����õģ��Բ���ʾ������render����
			//�����൱�ڳ�ʼ������ʼ��������������ݣ���Ϊ���������ӵ�һ�����ݵĻ���
			//������ʹ��һ�����ݺͶ�ʱ���и��µĵڶ������ݵ�ʱ������Ϊ���룬���������������
			//�������һ�θ���������ݣ������Ļ��൱�ڿ�ʼ��ʱ��Ͱ��������ȫ���ӽ�ȥ�ˣ��������ݵ�ʱ���ǲ�׼ȷ���߼����Ϊ����
			//for(int i=0;i<5;i++)
			//series.add(1, Math.random()*10);//������date�������ͣ��������漴���ȴ�����
				
			
			 dataset1.addSeries(series);
			return dataset1;
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
					edit1.setText(sb.toString())     ;         //!!!!!!
		
					  if(edit1.getText().toString() == null ||edit1.getText().toString().length() <= 0)
				    	 {;}
					  else{
					t6.setText("1")			;   //��������������������������������������������%����
					  }
					
					
					
					
					
					//yeyeyeyeye!
				}
			});
			
			edit1.setText(""); 
			edit2.setText(""); 
			t3.setText("");
			rd.show();
			//editText1.setText(txt_result.getText().toString()); 
			//editText1.setText("ahah"); 	
		}

		
		
		
		public static Bitmap getLoacalBitmap(String url) {
			try {
				FileInputStream fis = new FileInputStream(url);
				return BitmapFactory.decodeStream(fis); // /����ת��ΪBitmapͼƬ

			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		
		
	}
	    
	    
	    
	    


