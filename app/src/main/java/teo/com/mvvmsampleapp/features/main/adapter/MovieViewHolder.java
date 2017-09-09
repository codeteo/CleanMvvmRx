package teo.com.mvvmsampleapp.features.main.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import teo.com.mvvmsampleapp.Constants;
import teo.com.mvvmsampleapp.R;

/**
 * View holder for the movie item.
 */

public class MovieViewHolder extends BaseViewHolder<MovieViewModel> {

    @BindView(R.id.tv_title) TextView tvTitle;
    @BindView(R.id.tv_overview) TextView tvOverview;
    @BindView(R.id.iv_movie_image) ImageView ivPoster;

    private final Context context;

    MovieViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        context = itemView.getContext();
    }

    /** binds the view to the model(data) **/
    @Override
    public void setViewModel(MovieViewModel viewModel) {
        tvTitle.setText(viewModel.getTitle());
        tvOverview.setText(viewModel.getOverview());

        Picasso.with(context)
                .load(Constants.appendImageUrl(viewModel.getImageUrl()))
                .fit()
                .centerCrop()
                .into(ivPoster);

    }

}
