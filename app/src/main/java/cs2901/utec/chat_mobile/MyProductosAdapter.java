package cs2901.utec.chat_mobile;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MyProductosAdapter extends RecyclerView.Adapter<MyProductosAdapter.ViewHolder> {

    public JSONArray elements;
    private Context mContext;

    public MyProductosAdapter(JSONArray elements, Context mContext) {
        this.elements = elements;
        this.mContext = mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView friendLine;
        TextView myLine;
        RelativeLayout container;

        public ViewHolder(View itemView) {
            super(itemView);
            friendLine = itemView.findViewById(R.id.element_view_friend_line);
            myLine = itemView.findViewById(R.id.element_view_me_line);
            container = itemView.findViewById(R.id.element_view_container);
        }
    }

    @NonNull
    @Override
    public MyProductosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                parent.getContext()).inflate(
                R.layout.producto, parent, false
        );
        return new MyProductosAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyProductosAdapter.ViewHolder holder, int position) {
        try{
            final JSONObject element = elements.getJSONObject(position);
            final String nombre = element.getString("nombre");
            final String codigo = element.getString("codigo");
            final String marca = element.getString("marca");
            final String cantidad = element.getString("cantidad");
            final String precio = element.getString("precio");
            holder.myLine.setText(nombre);

            holder.container.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent goToMessage = new Intent(mContext, DetallesActivity.class);
                    goToMessage.putExtra("nombre", nombre);
                    goToMessage.putExtra("codigo",codigo);
                    goToMessage.putExtra("marca",marca);
                    goToMessage.putExtra("cantidad", cantidad);
                    goToMessage.putExtra("precio",precio);
                    mContext.startActivity(goToMessage);
                }
            });


        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return elements.length();
    }
}