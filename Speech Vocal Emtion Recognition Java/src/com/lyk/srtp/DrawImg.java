package com.lyk.srtp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class DrawImg extends View {

	public DrawImg(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public DrawImg(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public DrawImg(Context context) {
		super(context);
	}
	
	// �����ı�
	private void drawTxtView(Canvas canvas,String drawTxt) {
		Paint txtPaint = new Paint();
		txtPaint.setColor(Color.BLUE);
		// �����ı�λ��
		txtPaint.setTextAlign(Align.LEFT);
		// �����ı���С
		txtPaint.setTextSize(38);
		// ���û��ʵľ��Ч�� true��ʾ�޾�� false ��֮
		txtPaint.setAntiAlias(true);
		txtPaint.setTypeface(Typeface.MONOSPACE);
		// ��ȻҲ��������Ϊ"ʵ��"(Paint.Style.FILL), "����"(Paint.Style.STROKE)
//		txtPaint.setStyle(Paint.Style.STROKE);
		// ���á����ġ������Ŀ��
//		txtPaint.setStrokeWidth(5);
		// xĬ����drawTxt����ַ����������Ļ��λ�ã����������setTextAlign(Paint.Align.CENTER);�Ǿ����ַ������ģ�y��ָ������ַ�baseline����Ļ�ϵ�λ�á� 
		canvas.drawText(drawTxt, 16, 80, txtPaint);
	}
	
	
	private void drawCircleView(Canvas canvas,float cx,float xy,boolean isSx,int color) {
		Paint circlePaint = new Paint();
		circlePaint.setColor(color);
		if (isSx) {
			circlePaint.setStyle(Paint.Style.FILL);
		}else {
			circlePaint.setStyle(Paint.Style.STROKE);
		}
//		circlePaint.setStrokeCap(Cap.ROUND);
		/**
		 * ���� �� ��������
		 * 1.��ʼ�˵��X���ꡣ
		 * 2.��ʼ�˵��Y���ꡣ
		 * 3.��ֱ����
		 * 5.����ֱ����ʹ�õĻ��ʡ�
		 */
		canvas.drawCircle(cx, xy, 10, circlePaint);
	}
	
	// �����߶�
	private void drawSlash(Canvas canvas,float startX,float startY,float stopX,float stopY) {
		Paint paint = new Paint();
		paint.setColor(Color.GRAY);
		// �����߿�
		paint.setStrokeWidth(5f);
		/**
		 * ���� �� ��������
		 * 1.��ʼ�˵��X���ꡣ
		 * 2.��ʼ�˵��Y���ꡣ
		 * 3.��ֹ�˵��X���ꡣ
		 * 4.��ֹ�˵��Y���ꡣ
		 * 5.����ֱ����ʹ�õĻ��ʡ�
		 */
		canvas.drawLine(startX, startY, stopX, stopY, paint);
	}
	
	private void drawText(Canvas canvas,String str,float x,float y) {
		Paint paint = new Paint();
		paint.setColor(Color.DKGRAY);
		paint.setTextSize(28);
		/**
		 * ���ı� �� ��������
		 * 1.�ı�X�����ָ����
		 * 2.�ı�Y�����ָ�߶�
		 * 3.����ֱ����ʹ�õĻ��ʡ�
		 */
		canvas.drawText(str, x, y, paint);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		drawTxtView(canvas, "���״̬��¼��");
		drawCircleView(canvas,100,210, true,Color.CYAN);
		drawSlash(canvas,107,215,230,260);
		drawCircleView(canvas,230,260, true,Color.BLUE);
		drawSlash(canvas,238,260,420,170);
		drawCircleView(canvas,420,170, true,Color.GREEN);
		drawSlash(canvas,427,170,610,210);
		drawCircleView(canvas,610,210, true,Color.RED);
		drawSlash(canvas,50,290,680,290);
		drawText(canvas, "ƽ��", 50, 180);
		drawText(canvas, "��ǰ��", 50, 330);
		drawText(canvas, " ����", 200, 220);
		drawText(canvas, " ǰ��", 180, 330);
		drawText(canvas, " ����", 370, 140);
		drawText(canvas, " ����", 370, 330);
		drawText(canvas, " ��ŭ", 570, 170);
		drawText(canvas, "����", 570, 330);
	}
	

}
