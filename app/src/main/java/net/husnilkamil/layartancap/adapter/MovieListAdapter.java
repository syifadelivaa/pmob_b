package net.husnilkamil.layartancap.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.husnilkamil.layartancap.R;
import net.husnilkamil.layartancap.model.MovieItem;

import java.util.ArrayList;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieHolder> {

    ArrayList<MovieItem> daftarFilm = new ArrayList<>();
    OnMovieItemClicked clickHandler;

    public void setDaftarFilm(ArrayList<MovieItem> films){
        //daftarFilm.clear();
        daftarFilm = films;
        notifyDataSetChanged();
    }

    public void setClickHandler(OnMovieItemClicked clickHandler) {
        this.clickHandler = clickHandler;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.movie_row, viewGroup, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int i) {
        MovieItem movieItem = daftarFilm.get(i);
        movieHolder.textTitle.setText(movieItem.getTitle());
        movieHolder.textRating.setText(
                String.valueOf(movieItem.getVote_average())
        );

        movieHolder.imagePoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickHandler.movieItemClicked();
            }
        });
    }

    @Override
    public int getItemCount() {
        if(daftarFilm != null){
            return daftarFilm.size();
        }
        return 0;
    }


    //View Holder untuk Movie

    public class MovieHolder extends RecyclerView.ViewHolder{

        ImageView imagePoster;
        TextView textTitle;
        TextView textRating;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            imagePoster = itemView.findViewById(R.id.text_release_date);
            textTitle = itemView.findViewById(R.id.text_title);
            textRating = itemView.findViewById(R.id.text_rating);
        }
    }

    public interface OnMovieItemClicked{
        void movieItemClicked();
    }
}
