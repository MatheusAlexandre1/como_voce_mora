package br.com.como_voce_mora.ui.sustainablehabits;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.SustainableHabitsAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransportationReasonFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.rbBrushMyTeeth)
    CustomRadioButton rbBrushMyTeeth;
    @BindView(R.id.rbDishes)
    CustomRadioButton rbDishes;
    @BindView(R.id.rbWashMachineCapacity)
    CustomRadioButton rbWashMachineCapacity;
    @BindView(R.id.rbWashMachineReuse)
    CustomRadioButton rbWashMachineReuse;
    @BindView(R.id.rbQuickShowers)
    CustomRadioButton rbQuickShowers;
    @BindView(R.id.rbFewDevices)
    CustomRadioButton rbFewDevices;
    @BindView(R.id.rbOthers)
    CustomRadioButton rbOthers;
    @BindView(R.id.rbNew)
    CustomRadioButton rbNew;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;

    SustainableHabitsAnswer sustainableHabitsAnswer = SustainableHabitsAnswer.TRANSPORTATION_REASON;
    AnswerRequest answerRequest;

    public static TransportationReasonFragment newInstance() {
        return new TransportationReasonFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_transportation_reason;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ResearchFlow.addAnswer(answerRequest, this);
            ((AboutYouActivity) requireActivity()).addFragment(SustainableHabitsEndFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.HABITS);
        rbBrushMyTeeth.setOnCheckedChangeListener(this);
        rbDishes.setOnCheckedChangeListener(this);
        rbWashMachineCapacity.setOnCheckedChangeListener(this);
        rbWashMachineReuse.setOnCheckedChangeListener(this);
        rbQuickShowers.setOnCheckedChangeListener(this);
        rbFewDevices.setOnCheckedChangeListener(this);
        rbOthers.setOnCheckedChangeListener(this);
        rbNew.setOnCheckedChangeListener(this);
        mTvQuestion.setText(sustainableHabitsAnswer.getQuestion());
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            setAnswer(buttonView.getText().toString());

            switch (buttonView.getId()) {
                case R.id.rbBrushMyTeeth:
                    rbBrushMyTeeth.setChecked(true);
                    rbDishes.setChecked(false);
                    rbWashMachineCapacity.setChecked(false);
                    rbWashMachineReuse.setChecked(false);
                    rbQuickShowers.setChecked(false);
                    rbFewDevices.setChecked(false);
                    rbOthers.setChecked(false);
                    rbNew.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbDishes:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(true);
                    rbWashMachineCapacity.setChecked(false);
                    rbWashMachineReuse.setChecked(false);
                    rbQuickShowers.setChecked(false);
                    rbFewDevices.setChecked(false);
                    rbOthers.setChecked(false);
                    rbNew.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbWashMachineCapacity:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(false);
                    rbWashMachineCapacity.setChecked(true);
                    rbWashMachineReuse.setChecked(false);
                    rbQuickShowers.setChecked(false);
                    rbFewDevices.setChecked(false);
                    rbOthers.setChecked(false);
                    rbNew.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbWashMachineReuse:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(false);
                    rbWashMachineCapacity.setChecked(false);
                    rbWashMachineReuse.setChecked(true);
                    rbQuickShowers.setChecked(false);
                    rbFewDevices.setChecked(false);
                    rbOthers.setChecked(false);
                    rbNew.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbQuickShowers:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(false);
                    rbWashMachineCapacity.setChecked(false);
                    rbWashMachineReuse.setChecked(false);
                    rbQuickShowers.setChecked(true);
                    rbFewDevices.setChecked(false);
                    rbOthers.setChecked(false);
                    rbNew.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbFewDevices:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(false);
                    rbWashMachineCapacity.setChecked(false);
                    rbWashMachineReuse.setChecked(false);
                    rbQuickShowers.setChecked(false);
                    rbFewDevices.setChecked(true);
                    rbOthers.setChecked(false);
                    rbNew.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbOther:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(false);
                    rbWashMachineCapacity.setChecked(false);
                    rbWashMachineReuse.setChecked(false);
                    rbQuickShowers.setChecked(false);
                    rbFewDevices.setChecked(false);
                    rbOthers.setChecked(true);
                    rbNew.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbNew:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(false);
                    rbWashMachineCapacity.setChecked(false);
                    rbWashMachineReuse.setChecked(false);
                    rbQuickShowers.setChecked(false);
                    rbFewDevices.setChecked(false);
                    rbOthers.setChecked(true);
                    rbNew.setChecked(true);

                    updateViews();
                    break;
            }
        }
    }

    private void updateViews() {
        rbBrushMyTeeth.updateView();
        rbDishes.updateView();
        rbWashMachineCapacity.updateView();
        rbWashMachineReuse.updateView();
        rbQuickShowers.updateView();
        rbFewDevices.updateView();
        rbOthers.updateView();
        rbNew.updateView();
    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(sustainableHabitsAnswer.getQuestion(), sustainableHabitsAnswer.getQuestionPartId(), text);
    }
}
