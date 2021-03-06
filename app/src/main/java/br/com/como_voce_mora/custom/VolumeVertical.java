package br.com.como_voce_mora.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import br.com.como_voce_mora.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class VolumeVertical extends RelativeLayout implements View.OnTouchListener {
    @BindView(R.id.rl_root_view)
    ConstraintLayout mRlRootView;
    @BindView(R.id.tv_min)
    TextView mTvMin;
    @BindView(R.id.tv_max)
    TextView mTvMax;
    @BindView(R.id.view_circle)
    View mViewCircle;
    @BindView(R.id.view_line_fake)
    View mViewLineFake;
    @BindView(R.id.view_line)
    View mViewLine;

    private float mMinRange;
    private float mMaxRange;
    private float mHeightRange;
    private int mMax;

    private OnListener mListener;

    public VolumeVertical(Context context) {
        super(context);

        init(context, null);
    }

    public VolumeVertical(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View view = inflate(getContext(), R.layout.layout_volume_vertical, this);
        ButterKnife.bind(view, this);

        mViewLineFake.setOnTouchListener(this);
        mViewCircle.setY(mViewLineFake.getY());

        mViewLineFake.post(() -> {
            mMinRange = mViewLineFake.getY();
            mMaxRange = mViewLineFake.getHeight() + mViewLineFake.getY() - mViewCircle.getHeight();
            mHeightRange = mMaxRange - mMinRange;
        });

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomVolume, 0, 0);
        int background = typedArray.getColor(R.styleable.CustomVolume_backgroundVolume, getResources().getColor(R.color.colorPrimary));
        int lineColor = typedArray.getColor(R.styleable.CustomVolume_lineColorVolume, getResources().getColor(R.color.colorBlack));
        int textColor = typedArray.getColor(R.styleable.CustomVolume_textColorVolume, getResources().getColor(R.color.colorBlack));
        int resCircleSelected = typedArray.getResourceId(R.styleable.CustomVolume_circleSelectedVolume, R.drawable.bg_circle_volume);
        String textMin = getResources().getString(typedArray.getResourceId(R.styleable.CustomVolume_textMin, R.string.a));
        String textMax = getResources().getString(typedArray.getResourceId(R.styleable.CustomVolume_textMax, R.string.z));

        mRlRootView.setBackgroundColor(background);
        mViewLine.setBackgroundColor(lineColor);
        mTvMin.setTextColor(textColor);
        mTvMax.setTextColor(textColor);
        mViewCircle.setBackgroundResource(resCircleSelected);

        mTvMin.setText(textMin);
        mTvMax.setText(textMax);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int y = (int) (motionEvent.getY() + mViewLineFake.getY());

        if (y < mMinRange) {
            y = (int) mMinRange;
        }

        if (y > mMaxRange) {
            y = (int) mMaxRange;
        }

        if (y >= mMinRange && y <= mMaxRange) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_MOVE:
                    mViewCircle.setY(y);
                    updatePosition(y);
                    break;
            }
        }

        return true;
    }

    private void updatePosition(int y) {
        y = (int) (y - mMinRange);
        int position = Math.round((y / mHeightRange) * mMax);

        if (mListener != null) {
            mListener.positionVolume(position);
        }
    }

    public void setMax(int max) {
        mMax = max;
    }

    public void setListener(OnListener listener) {
        mListener = listener;
    }

    public interface OnListener {
        void positionVolume(int position);
    }
}