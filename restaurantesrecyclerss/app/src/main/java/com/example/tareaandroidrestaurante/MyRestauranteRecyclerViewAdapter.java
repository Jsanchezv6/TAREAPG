package com.example.tareaandroidrestaurante;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {
    private Context ctx;
    private final List<Restaurante> mValues;
    private final RestauranteFragment.OnListFragmentInteractionListener mListener;

    public MyRestauranteRecyclerViewAdapter(Context context, List<Restaurante> items, RestauranteFragment.OnListFragmentInteractionListener mListener) {
        ctx = context;
        mValues = items;
        this.mListener = mListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.textViewNombre.setText(holder.mItem.getNombre_restaurante());
        holder.textViewDirreccion.setText(holder.mItem.getDireccion());
        holder.ratingBarValoracion.setRating(holder.mItem.getVolaricion_restaurante());

        Glide.with(ctx)
                .load(holder.mItem.getUrl_foto_restaurante())
                .centerCrop()
                .into(holder.imageViewFoto);

        holder.mView.setOnClickListener((v) -> {
            if (null != mListener){
                mListener.onListFragmentInteraction(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewNombre;
        public final TextView textViewDirreccion;
        public final ImageView imageViewFoto;
        public final RatingBar ratingBarValoracion;
        public Restaurante mItem;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewNombre = view.findViewById(R.id.textViewNombre);
            textViewDirreccion = view.findViewById(R.id.textViewDirreccion);
            imageViewFoto = view.findViewById(R.id.imageViewFoto);
            ratingBarValoracion = view.findViewById(R.id.ratingBarValoracion);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewDirreccion.getText() + "'";
        }
    }
}