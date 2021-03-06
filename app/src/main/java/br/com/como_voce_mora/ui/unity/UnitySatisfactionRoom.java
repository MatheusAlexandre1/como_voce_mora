package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.custom.VolumeHorizontal;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class UnitySatisfactionRoom extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.volume1)
    VolumeHorizontal vhSize;
    @BindView(R.id.volume2)
    VolumeHorizontal vhDivision;
    @BindView(R.id.volume3)
    VolumeHorizontal vhQuality;
    @BindView(R.id.volume4)
    VolumeHorizontal vhClean;
    @BindView(R.id.volume5)
    VolumeHorizontal vhAdaptation;
    @BindView(R.id.volume6)
    VolumeHorizontal vhPrivacy;


    private List<AnswerRequest> answerRequests = new ArrayList<>();
    private UnityAnswer satisfaction = UnityAnswer.CHARACTERISTICS_SATISFACTION;
    private UnityAnswer size = UnityAnswer.SIZE_SATISFACTION;
    private UnityAnswer division = UnityAnswer.EASE_OF_FURNISHINGS;
    private UnityAnswer quality = UnityAnswer.TEMPERATURE;
    private UnityAnswer clean = UnityAnswer.NATURAL_VENTILATION;
    private UnityAnswer adaptation = UnityAnswer.NATURAL_ILUMINATION;
    private UnityAnswer privacy = UnityAnswer.NOISE_LEVEL;
    private List<String> texts = new ArrayList<>();

    public static UnitySatisfactionRoom newInstance() {

        Bundle args = new Bundle();

        UnitySatisfactionRoom fragment = new UnitySatisfactionRoom();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_satisfaction_room;
    }

    @Override
    public void init() {
        tvQuestion.setText(satisfaction.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.GROUP);
        texts.add("Muito Ruim");
        texts.add("Ruim");
        texts.add("Regular");
        texts.add("Bom");
        texts.add("Muito Bom");

        vhSize.setMax(texts.size() - 1);
        vhDivision.setMax(texts.size() - 1);
        vhQuality.setMax(texts.size() - 1);
        vhClean.setMax(texts.size() - 1);
        vhAdaptation.setMax(texts.size() - 1);
        vhPrivacy.setMax(texts.size() - 1);
        initVolumes();
    }

    private void initVolumes() {
        vhSize.setListener(position -> {
            vhSize.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(size.getQuestion(), size.getQuestionPartId(), texts.get(position)));
        });
        vhDivision.setListener(position -> {
            vhDivision.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(division.getQuestion(), division.getQuestionPartId(), texts.get(position)));
        });
        vhQuality.setListener(position -> {
            vhQuality.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(quality.getQuestion(), quality.getQuestionPartId(), texts.get(position)));
        });
        vhClean.setListener(position -> {
            vhClean.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(clean.getQuestion(), clean.getQuestionPartId(), texts.get(position)));
        });
        vhAdaptation.setListener(position -> {
            vhAdaptation.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(adaptation.getQuestion(), adaptation.getQuestionPartId(), texts.get(position)));
        });
        vhPrivacy.setListener(position -> {
            vhPrivacy.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(privacy.getQuestion(), privacy.getQuestionPartId(), texts.get(position)));
        });
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            setAnswers();
            ((AboutYouActivity) getActivity()).addFragment(UnityReformFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    private void setAnswers() {
        for (AnswerRequest r : answerRequests) {
            ResearchFlow.addAnswer(r,this);
        }
    }
}
