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
 * @author 刘页恺
 * 2016-10-25 上午08:24
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
 * 现在下一步我想做的是
 * 每显示一次记录时间就把记录时间赋给一个类中的储存桶
 * 
 * 
 * */	
	
	String[] xkedu = new String[5] ;//x轴数据缓冲
	
	Float[] ycache = new Float[5];
	//private final static int SERISE_NR = 1; //曲线数量
	private XYSeries series;//用来清空第一个再加下一个
	private XYMultipleSeriesDataset dataset1;//xy轴数据源
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
		t3 = (TextView) findViewById(R.id.t3);//搞了半天原来问题处在findViewById必须在setContentView之后！！！

		t5 = (TextView) findViewById(R.id.t5);
		t6 = (TextView) findViewById(R.id.t6);
		String info = getIntent().getStringExtra("info");
		
		edit1.setText(info)   ; 
		
		
		LinearLayout linearLayout = (LinearLayout)findViewById(R.id.guangzhexian);
		chart = ChartFactory.getLineChartView(this, getdemodataset(), getdemorenderer());
		linearLayout.removeAllViews();//先remove再add可以实现统计图更新
		linearLayout.addView(chart, new LayoutParams(LayoutParams.WRAP_CONTENT,
			LayoutParams.WRAP_CONTENT));
		

		
		
		//RecognizerDialog(Context context, String params); "appid=1234567,usr=test,pwd=12345"  usr、pwd不是必选的
		//创建语音识别dailog对象，appid到讯飞就注册获取
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
		 
		 
		
		 
		 
		 
		
		
		 case R.id.bu2://1高兴,2愤怒3平静4悲伤5惊恐  
		     {		
		    	 
		    	 if(edit1.getText().toString() == null ||edit1.getText().toString().length() <= 0) 
		     {
		    		 t3.setText("您还没有成功录音哦。。请点击重新录音");
		    		 edit1.setText(""); 
		    		 edit2.setText(""); 
				    	break;
                    		     
		     }
		     
		    	 
		    	 
		     else{ 	 if(t6.getText()=="0")
		    	
		    	 {t3.setText("您已经对这段语音进行情感识别了，想要继续识别情感请录制新的语音。。。。。。");
		    	 edit1.setText("");
		    	 edit2.setText("");
		    	 break;
		    	 }  
		     else{
		    	//1高兴
		    	 if(
		    			    isContain(edit1.getText().toString(),"哈哈") == true  ||
		    			 isContain(edit1.getText().toString(),"太棒") == true     ||
		    			 isContain(edit1.getText().toString(),"不错") == true     ||
		    			 isContain(edit1.getText().toString(),"很好") == true     ||
		    			 isContain(edit1.getText().toString(),"没问题") == true     ||
		    			 isContain(edit1.getText().toString(),"太好") == true     ||
		    			 isContain(edit1.getText().toString(),"棒") == true     ||
		    			 isContain(edit1.getText().toString(),"好的很") == true     ||
		    			isContain(edit1.getText().toString(),"高兴") == true     ||
		    			 isContain(edit1.getText().toString(),"开心") == true     ||
		    			 isContain(edit1.getText().toString(),"快乐") == true     ||
		    			 isContain(edit1.getText().toString(),"幸福") == true     ||
		    			 isContain(edit1.getText().toString(),"ok") == true     ||
		    			 isContain(edit1.getText().toString(),"嘻") == true     
		   )
		    	{edit2.setText("高兴") ;
		    	t3.setText("快乐有助于健康，建议您继续保持快乐的心情！");
		    			
		    			t5.setText("1");
		    			updatechart();
		    			t6.setText("0")			;  
		    			
		    	break;}
		    	 
		    	 //2愤怒
		    	 if(
		    			    isContain(edit1.getText().toString(),"操") == true  ||
		    			 isContain(edit1.getText().toString(),"nnd") == true     ||
		    			 isContain(edit1.getText().toString(),"tmd") == true     ||
		    			 isContain(edit1.getText().toString(),"日") == true     ||
		    			 isContain(edit1.getText().toString(),"逼") == true     ||
		    			 isContain(edit1.getText().toString(),"滚") == true     ||
		    					 isContain(edit1.getText().toString(),"*") == true     ||
		    							 isContain(edit1.getText().toString(),"了吗") == true     ||
		    									 isContain(edit1.getText().toString(),"了啊") == true     ||
		    							 isContain(edit1.getText().toString(),"谁") == true     ||
		    									 isContain(edit1.getText().toString(),"shit") == true ||
		    											 isContain(edit1.getText().toString(),"疼") == true ||
		    			 isContain(edit1.getText().toString(),"死") == true     ||
		    					 isContain(edit1.getText().toString(),"fuck") == true     ||
				    					 isContain(edit1.getText().toString(),"碧") == true     ||
				    							 isContain(edit1.getText().toString(),"碧池") == true     ||
				    									 isContain(edit1.getText().toString(),"s") == true     ||		
				    							 isContain(edit1.getText().toString(),"鸡巴") == true     ||
				    									 isContain(edit1.getText().toString(),"特") == true     ||	
		    			isContain(edit1.getText().toString(),"扯") == true     ||
		    			 isContain(edit1.getText().toString(),"不可能") == true     ||
		    			 isContain(edit1.getText().toString(),"没门") == true     ||
		    			 isContain(edit1.getText().toString(),"生气") == true     ||
		    					 isContain(edit1.getText().toString(),"讨厌") == true     ||
		    			 isContain(edit1.getText().toString(),"愤怒") == true     ||
		    					 isContain(edit1.getText().toString(),"不要") == true     ||
				    			 isContain(edit1.getText().toString(),"猪") == true     ||
						    			 isContain(edit1.getText().toString(),"狗") == true     ||
								    			 isContain(edit1.getText().toString(),"混") == true     ||
								    					 isContain(edit1.getText().toString(),"球") == true     ||
								    							 isContain(edit1.getText().toString(),"屁") == true     ||
								    									 isContain(edit1.getText().toString(),"饭桶") == true     ||
								    											 isContain(edit1.getText().toString(),"废物") == true     ||
								    													 isContain(edit1.getText().toString(),"鸟") == true     ||
								    											 isContain(edit1.getText().toString(),"过分") == true     ||
								    									 isContain(edit1.getText().toString(),"气死") == true     ||
						    			 isContain(edit1.getText().toString(),"娘") == true     ||
		    			isContain(edit1.getText().toString(),"妈") == true     ||
		    					isContain(edit1.getText().toString(),"啦") == true     ||
		    					isContain(edit1.getText().toString(),"不爽") == true     ||
		    							isContain(edit1.getText().toString(),"烦") == true     ||
		    									isContain(edit1.getText().toString(),"！") == true     ||
		    											isContain(edit1.getText().toString(),"!") == true     ||
		    												
		    			    			 
		    			 isContain(edit1.getText().toString(),"惹") == true     
		   )
		    	{edit2.setText("愤怒") ;
		    	t3.setText("我们在愤怒时也许会让自己痛快许多，但是必须要仔细分析清楚自己的愤怒是否能带来什么以及愤怒的不良后果，认真考虑让自己冷静下来，才能升华自己！！");
		   
		    	t5.setText("2");
		    	
		    	updatechart();
		    	t6.setText("0")			;  
		    	break;}
		    	 
		    	 //3平静
		    	 if(
		    			    isContain(edit1.getText().toString(),"好的") == true  ||
		    			    		isContain(edit1.getText().toString(),"呵") == true  ||
		    			 isContain(edit1.getText().toString(),"没什么") == true     ||
		    			 isContain(edit1.getText().toString(),"你好") == true     ||
		    					 isContain(edit1.getText().toString(),"没事") == true     ||
		    			 isContain(edit1.getText().toString(),"就这样吧") == true     ||
		    			 isContain(edit1.getText().toString(),"凑合") == true     ||
		    			 isContain(edit1.getText().toString(),"也好") == true     ||
		    			 isContain(edit1.getText().toString(),"嗯") == true     ||
		    			 isContain(edit1.getText().toString(),"哦") == true     ||
		    					 isContain(edit1.getText().toString(),"啦！") == true     ||
		    							 isContain(edit1.getText().toString(),"啦!") == true     ||
		    									 isContain(edit1.getText().toString(),"!") == true     ||
		    											 isContain(edit1.getText().toString(),"！") == true     ||
		    					 isContain(edit1.getText().toString(),"放心") == true     ||
		    							 isContain(edit1.getText().toString(),"啊！") == true     ||
		    									 isContain(edit1.getText().toString(),"了啊") == true     ||
		    											 isContain(edit1.getText().toString(),"啊!") == true     ||
		    													 isContain(edit1.getText().toString(),"了吗！") == true     ||
		    							 isContain(edit1.getText().toString(),"还好") == true     ||
		    									 isContain(edit1.getText().toString(),"了吗!") == true     ||
		    											 isContain(edit1.getText().toString(),"吗！") == true     ||
		    													 isContain(edit1.getText().toString(),"吗!") == true     ||
		    			
		    			 isContain(edit1.getText().toString(),"平静") == true     
		   )
		    	{edit2.setText("平静") ;
		    	t3.setText("平静的心态有助于健康，建议您继续保持平静的心情！");
		  
		    	t5.setText("0");
		    	updatechart();
		    	t6.setText("0")			;  
		    
		    	break;}
		    	 
		    	 
		    	 //4悲伤
		    	 if(
		    			  isContain(edit1.getText().toString(),"爱") == true  ||
		    			    isContain(edit1.getText().toString(),"唉") == true  ||
		    			    		 isContain(edit1.getText().toString(),"i") == true  ||
		    			    		isContain(edit1.getText().toString(),"哎呀") == true  ||
		    			    				isContain(edit1.getText().toString(),"唉呀") == true  ||
		    			
		    			 isContain(edit1.getText().toString(),"没想到") == true     ||
		    			 isContain(edit1.getText().toString(),"完") == true     ||
		    					 isContain(edit1.getText().toString(),"不好") == true     ||
		    							 isContain(edit1.getText().toString(),"没有办法") == true     ||
		    									 isContain(edit1.getText().toString(),"后悔") == true     ||
		    					 isContain(edit1.getText().toString(),"伤") == true     ||
		    			 isContain(edit1.getText().toString(),"悲") == true     
		   )
		    	{edit2.setText("悲伤") ;
		    	t3.setText("悲伤是对健康不利的！建议您出去走走，运动一下，或者睡一觉吧。。");
		    	
		    	t5.setText("-1");
		    	updatechart();
		    	t6.setText("0")			;  
		    	break;}
		    	 
		    	 //5惊恐  
		    	 if(
		    			    isContain(edit1.getText().toString(),"可怕") == true  ||
		    			 isContain(edit1.getText().toString(),"吓") == true     ||
		    			 isContain(edit1.getText().toString(),"害怕") == true     ||
		    					 isContain(edit1.getText().toString(),"怎么办啊") == true     ||
		    			 isContain(edit1.getText().toString(),"怕") == true     ||
		    					 isContain(edit1.getText().toString(),"怎么办") == true     ||
		    							 isContain(edit1.getText().toString(),"完了") == true     ||
		    									 isContain(edit1.getText().toString(),"完蛋") == true     ||
		    					 isContain(edit1.getText().toString(),"啊") == true     ||
		    							 isContain(edit1.getText().toString(),"这可怎么办") == true     ||
		    									 isContain(edit1.getText().toString(),"不会是") == true     ||
		    									 isContain(edit1.getText().toString(),"算了") == true     ||
		    			 isContain(edit1.getText().toString(),"救命") == true     
		   )
		    	{edit2.setText("惊恐") ;
		    	t3.setText("惊恐是对健康不利的！建议您不要想多了，出去走走，运动一下，或者看场电影放松自己把。。");
		    
		    	t5.setText("-2");
		    	updatechart();
		    	t6.setText("0")			;  
		    	break;}
		    	 
		    	 
		    	 
		    	  if(edit1.getText().toString() == null ||edit1.getText().toString().length() <= 0)
		    	 {
		    		 
		    		 t3.setText("您还没有成功录音哦。。请点击重新录音");
		    		 edit1.setText(""); 
		    		 edit2.setText(""); 
				    	break;
		    	 }
		    	 
		    	 if(0==0)
		    	 {edit2.setText("平静") ;
			    	t3.setText("平静的心态有助于健康，建议您继续保持平静的心情！");
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
					Toast.makeText(this, "情感记录已保存在DCIM/SpeechEmotionRecognitionlyk.png" ,Toast.LENGTH_SHORT).show();
			 
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
	     * 退出程序 
	     */  
	    private void exitApp() {  
	      // 判断2次点击事件时间  
	      if ((System.currentTimeMillis() - exitTime) > 2000) {  
	        Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();  
	        exitTime = System.currentTimeMillis();  
	      } else {  ExitApplication.getInstance().exit();
	    	
	      }  
	    }  

	    private void updatechart() 
		{
			//判断当前点集中到底有多少点，因为屏幕总共只能容纳5个，所以当点数超过5时，长度永远是5
			int length=series.getItemCount();
			int a=length;
			if(length>5){
				length=5;
			}
			/*try {
				if(guangzhi2.getText().toString()!=null){
					addY = Float.valueOf(guangzhi2.getText().toString());//要不要判断再说
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
			
			
			
			
			
			
			
			
			
			
			
			
			
			//移除数据集中旧的点集
			dataset1.removeSeries(series);
			if(a<5)//当数据集中不够五个点的时候直接添加就好，因为初始化的时候只有一个点，所以前几次更新的时候直接添加
			{
				series.add(a+1, addY);//第一个参数代表第几个点，要与下面语句中的第一个参数对应
				render.addXTextLabel(a+1, addX);
				xkedu[a]=addX;
			}
			else //超过了五个点要去除xcache【0】换成【1】的.....
			{
				//将旧的点集中x和y的数值取出来放入backup中，造成曲线向左平移的效果
				for(int i =0 ;i<length-1;i++){
					ycache[i]=(float) series.getY(i+1);
					xkedu[i]=xkedu[i+1];
				}
				
				//点集先清空，为了做成新的点集而准备
				series.clear();
				 //将新产生的点首先加入到点集中，然后在循环体中将坐标变换后的一系列点都重新加入到点集中
				
				for(int k =0 ;k<length-1;k++){
					series.add(k+1, ycache[k]);
					render.addXTextLabel(k+1, xkedu[k]);
				}
				xkedu[4]=addX;
				series.add(5, addY);
				render.addXTextLabel(5, addX);
			}	 
			//在数据集中添加新的点集
			dataset1.addSeries(series);
			 //视图更新，没有这一步，曲线不会呈现动态
			chart.invalidate();
		}        //update...end

	  

		
	    
	    
	    
	    
	    private XYMultipleSeriesRenderer getdemorenderer() {
			// TODO Auto-generated method stub
			render = new XYMultipleSeriesRenderer();
			render.setChartTitle("情感指数变化曲线(显示时间hh:ss对应用户在北京时间hh点ss分时的情感指数)");
			render.setChartTitleTextSize(20);//设置整个图表标题文字的大小
			render.setAxisTitleTextSize(16);//设置轴标题文字的大小
			render.setAxesColor(Color.BLACK);
			render.setXTitle("时间");
			render.setYTitle("情感指数");
			
			render.setLabelsTextSize(8);//设置轴刻度文字的大小
			render.setLabelsColor(Color.BLACK);
			render.setXLabelsColor(Color.BLACK);
			render.setYLabelsColor(0, Color.BLACK);
			render.setLegendTextSize(30);//设置图例文字大小  
			//render.setShowLegend(false);//显示不显示在这里设置，非常完美
			
			XYSeriesRenderer r = new XYSeriesRenderer();//设置颜色和点类型
			r.setColor(Color.RED);
			r.setPointStyle(PointStyle.CIRCLE);
			r.setFillPoints(true);
			r.setChartValuesSpacing(3);
			
			render.addSeriesRenderer(r);
			render.setYLabelsAlign(Align.RIGHT);//刻度值相对于刻度的位置
			render.setShowGrid(true);//显示网格
			render.setYAxisMax(2.5);//设置y轴的范围
			render.setYAxisMin(-2.5);
			render.setYLabels(5);//分5等份
			
			
			render.setInScroll(true);
			render.setLabelsTextSize(20);
			render.setLabelsColor(Color.BLACK);
			//render.getSeriesRendererAt(0).setDisplayChartValues(true); //显示折线上点的数值
			render.setPanEnabled(false,false);//禁止报表的拖动
			render.setPointSize(5f);//设置点的大小(图上显示的点的大小和图例中点的大小都会被设置)
			render.setMargins(new int[]{20,30,90,10}); //设置图形四周的留白
			render.setMarginsColor(Color.WHITE);
			render.setXLabels(0);// 取消X坐标的数字zjk,只有自己定义横坐标是才设为此值
			

			
			return render;
		}
		
		private XYMultipleSeriesDataset getdemodataset() {
			// TODO Auto-generated method stub
			 dataset1=new XYMultipleSeriesDataset();//xy轴数据源
			series = new XYSeries("情感指数：-2，-1，0，1，2分别代表" +
					"惊恐，悲伤，平静，高兴，愤怒 ");//这个事是显示多条用的，显不显示在上面render设置
			//这里相当于初始化，初始化中无需添加数据，因为如果这里添加第一个数据的话，
			//很容易使第一个数据和定时器中更新的第二个数据的时间间隔不为两秒，所以下面语句屏蔽
			//这里可以一次更新五个数据，这样的话相当于开始的时候就把五个数据全部加进去了，但是数据的时间是不准确或者间隔不为二的
			//for(int i=0;i<5;i++)
			//series.add(1, Math.random()*10);//横坐标date数据类型，纵坐标随即数等待更新
				
			
			 dataset1.addSeries(series);
			return dataset1;
		}
		
		
		
		private void showReconigizerDialog() {
			
			
			rd.setEngine("sms", null, null);
			
			
			rd.setSampleRate(RATE.rate16k);
			
			final StringBuilder sb = new StringBuilder();
			Log.i(TAG, "识别准备开始.............");
			
			//设置识别后的回调结果
			rd.setListener(new RecognizerDialogListener() {
				@Override
				public void onResults(ArrayList<RecognizerResult> result, boolean isLast) {
					for (RecognizerResult recognizerResult : result) {
						sb.append(recognizerResult.text);
						Log.i(TAG, "识别一条结果为::"+recognizerResult.text);
					}
				}
				@Override
				public void onEnd(SpeechError error) {
					Log.i(TAG, "识别完成.............");
					edit1.setText(sb.toString())     ;         //!!!!!!
		
					  if(edit1.getText().toString() == null ||edit1.getText().toString().length() <= 0)
				    	 {;}
					  else{
					t6.setText("1")			;   //！！！！！！！！！！！！！！！！！！！！……%……
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
				return BitmapFactory.decodeStream(fis); // /把流转化为Bitmap图片

			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		
		
	}
	    
	    
	    
	    


