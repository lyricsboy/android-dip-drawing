package com.bignerdranch.android.dipdrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;

public class ScaledDrawingView extends View {

	private float mScaleFactor;
	private Matrix mDensityScalingMatrix;

	public ScaledDrawingView(Context context) {
		this(context, null);
	}

	public ScaledDrawingView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ScaledDrawingView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setScaleFactor(getResources().getDisplayMetrics().density);
		setupDensityScalingMatrix();
	}

	private void setupDensityScalingMatrix() {
		mDensityScalingMatrix = new Matrix();
		mDensityScalingMatrix.setScale(getScaleFactor(), getScaleFactor());
	}

	public float getScaleFactor() {
		return mScaleFactor;
	}

	public void setScaleFactor(float scaleFactor) {
		mScaleFactor = scaleFactor;
		setupDensityScalingMatrix();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.concat(mDensityScalingMatrix);
	}
	
	public float getScaledWidth() {
		return getWidth() / getScaleFactor();
	}
	
	public float getScaledHeight() {
		return getHeight() / getScaleFactor();
	}

}