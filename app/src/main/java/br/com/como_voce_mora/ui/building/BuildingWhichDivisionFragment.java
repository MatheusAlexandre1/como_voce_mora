package br.com.como_voce_mora.ui.building;

import android.view.View;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class BuildingWhichDivisionFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.csvMuro)
    CustomSelectedView csvMuro;
    @BindView(R.id.csvViva)
    CustomSelectedView csvViva;
    @BindView(R.id.csvGrade)
    CustomSelectedView csvGrade;
    @BindView(R.id.csvNone)
    CustomSelectedView csvNone;


    public static BuildingWhichDivisionFragment newInstance() {
        return new BuildingWhichDivisionFragment();
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BUILDING);
    }

    @OnClick({R.id.csvViva, R.id.csvMuro, R.id.csvGrade, R.id.csvNone})
    public void onCheckedChanged(View view) {
        switch (view.getId()) {
            case R.id.csvViva:
                csvMuro.setChecked(true);
                csvViva.setChecked(false);
                csvGrade.setChecked(false);
                csvNone.setChecked(false);
                break;
            case R.id.csvMuro:
                csvMuro.setChecked(false);
                csvViva.setChecked(true);
                csvGrade.setChecked(false);
                csvNone.setChecked(false);
                break;
            case R.id.csvGrade:
                csvMuro.setChecked(false);
                csvViva.setChecked(false);
                csvGrade.setChecked(true);
                csvNone.setChecked(false);
                break;
            case R.id.csvNone:
                csvMuro.setChecked(false);
                csvViva.setChecked(false);
                csvGrade.setChecked(false);
                csvNone.setChecked(true);
                break;

        }
    }


    @Override
    public int getResLayout() {
        return R.layout.fragment_building_which_division;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(BuildingSplashFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
