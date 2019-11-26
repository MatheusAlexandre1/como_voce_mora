package br.com.como_voce_mora.ui.building;

import android.os.Bundle;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class BuildingAspectesFragment extends BaseFragment {

    @BindView(R.id.progressBar)
    HowYouLiveProgressBar progressBar;

    public static BuildingAspectesFragment newInstance() {

        Bundle args = new Bundle();

        BuildingAspectesFragment fragment = new BuildingAspectesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_building_aspects;
    }

    @Override
    public void init() {
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ATUAL_RESIDENCE);
        super.init();
    }

    @OnClick(R.id.btNext)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(HowYouThinkAboutAspectesFragment.newInstance());
        }
    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
