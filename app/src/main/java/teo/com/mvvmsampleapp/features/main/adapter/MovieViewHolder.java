package teo.com.mvvmsampleapp.features.main.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import butterknife.BindView;
import butterknife.ButterKnife;
import teo.com.mvvmsampleapp.Constants;
import teo.com.mvvmsampleapp.R;

/**
 * View holder for the movie item.
 */
@SuppressWarnings("FieldCanBeLocal")
public class MovieViewHolder extends BaseViewHolder<MovieViewModel> {

    @BindView(R.id.tv_movie_title) TextView tvTitle;
    @BindView(R.id.iv_movie_image) ImageView ivPoster;

    private final Context context;

    // Needs a strong reference so it won't be garbage collected
    private Target target;

    MovieViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        context = itemView.getContext();
    }

    /** binds the view to the model(data) **/
    @Override
    public void setViewModel(MovieViewModel viewModel) {
        tvTitle.setText(viewModel.getTitle());

        target = getTarget();

        Picasso.with(context)
                .load(Constants.appendImageUrl(viewModel.getImageUrl()))
                .into(target);

    }

    private Target getTarget() {
        return new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                ivPoster.setImageBitmap(bitmap);

                Palette.from(bitmap)
                        .generate(palette -> {
                            Palette.Swatch swatch = palette.getVibrantSwatch();
                            int textColor = Color.WHITE;
                            if (swatch != null) {
                                textColor = swatch.getRgb();
                            }
                            tvTitle.setTextColor(textColor);
                        });
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };
    }

}
