package com.lyk.srtp;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import com.lyk. srtp.R;

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

@SuppressLint({ "HandlerLeak", "SimpleDateFormat" })
public class MainActivity extends Activity {
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
	SimpleDateFormat   shijian   =   new   SimpleDateFormat("hh:mm:ss"); 

	Handler handler2;
	TextView guangzhi2;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guangzhao);  

		
		//��������ͼ
		LinearLayout linearLayout = (LinearLayout)findViewById(R.id.guangzhexian);
		chart = ChartFactory.getLineChartView(this, getdemodataset(), getdemorenderer());
		linearLayout.removeAllViews();//��remove��add����ʵ��ͳ��ͼ����
		linearLayout.addView(chart, new LayoutParams(LayoutParams.WRAP_CONTENT,
			LayoutParams.WRAP_CONTENT));
	
		
  }//oncreate����
	
	//��������ͼ
	 public void onClick(View v)
	 {updatechart();}
	 
	 
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
		
		addY = (float)(Math.random()*10);
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
		render.setChartTitle("���ָ���仯����");
		render.setChartTitleTextSize(20);//��������ͼ��������ֵĴ�С
		render.setAxisTitleTextSize(16);//������������ֵĴ�С
		render.setAxesColor(Color.BLACK);
		render.setXTitle("ʱ��");
		render.setYTitle("���ָ��");
		
		render.setLabelsTextSize(16);//������̶����ֵĴ�С
		render.setLabelsColor(Color.BLACK);
		render.setXLabelsColor(Color.BLACK);
		render.setYLabelsColor(0, Color.BLACK);
		render.setLegendTextSize(15);//����ͼ�����ִ�С  
		//render.setShowLegend(false);//��ʾ����ʾ���������ã��ǳ�����
		
		XYSeriesRenderer r = new XYSeriesRenderer();//������ɫ�͵�����
		r.setColor(Color.RED);
		r.setPointStyle(PointStyle.CIRCLE);
		r.setFillPoints(true);
		r.setChartValuesSpacing(3);
		
		render.addSeriesRenderer(r);
		render.setYLabelsAlign(Align.RIGHT);//�̶�ֵ����ڿ̶ȵ�λ��
		render.setShowGrid(true);//��ʾ����
		render.setYAxisMax(12);//����y��ķ�Χ
		render.setYAxisMin(-2);
		render.setYLabels(7);//���ߵȷ�
		
		
		render.setInScroll(true);
		render.setLabelsTextSize(14);
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
		series = new XYSeries("���ָ�� ");//���������ʾ�����õģ��Բ���ʾ������render����
		//�����൱�ڳ�ʼ������ʼ��������������ݣ���Ϊ���������ӵ�һ�����ݵĻ���
		//������ʹ��һ�����ݺͶ�ʱ���и��µĵڶ������ݵ�ʱ������Ϊ���룬���������������
		//�������һ�θ���������ݣ������Ļ��൱�ڿ�ʼ��ʱ��Ͱ��������ȫ���ӽ�ȥ�ˣ��������ݵ�ʱ���ǲ�׼ȷ���߼����Ϊ����
		//for(int i=0;i<5;i++)
		//series.add(1, Math.random()*10);//������date�������ͣ��������漴���ȴ�����
			
		
		 dataset1.addSeries(series);
		return dataset1;
	}
	
	
}
