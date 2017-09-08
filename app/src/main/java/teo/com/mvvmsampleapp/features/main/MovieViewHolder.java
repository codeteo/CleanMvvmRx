package teo.com.mvvmsampleapp.features.main;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import teo.com.mvvmsampleapp.R;
import teo.com.mvvmsampleapp.features.main.adapter.BaseViewHolder;

/**
 * View holder for the movie item
 */

public class MovieViewHolder extends BaseViewHolder<MovieViewModel> {

    @BindView(R.id.tv_title) TextView tvTitle;
    @BindView(R.id.tv_overview) TextView tvOverview;

    public MovieViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    /** binds the view to the model(data) **/
    @Override
    public void setViewModel(MovieViewModel viewModel) {
        tvTitle.setText(viewModel.getTitle());
        tvOverview.setText(viewModel.getOverview());
    }

}
