package soursoft.secuenciauno.co.soursoft;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AdapterListCategoria extends BaseAdapter {

    String [] result;
    Context context;
    int [] imageId;
    private LayoutInflater inflater=null;
    View view;
    Holder holder;

    public AdapterListCategoria(Context mainActivity, String[] prgmNameList/*, int[] prgmImages*/) {
        result=prgmNameList;
        context=mainActivity;
        //imageId=prgmImages;
        this.inflater = LayoutInflater.from(context);
        holder=new Holder();
//        inflater = ( LayoutInflater )context.
//                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class Holder
    {
        TextView tvClientDescription;
        TextView tvClientName;
        ImageView ivClientLogo;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(view == null){
            view = inflater.inflate(R.layout.adapter_list_categoria, null);

        }

        holder.tvClientName=(TextView) view.findViewById(R.id.tv_client_name);
        holder.tvClientName.setText(result[position]);

        holder.tvClientDescription=(TextView) view.findViewById(R.id.tv_client_description);
        holder.tvClientDescription.setText("Descripción" + result[position]);

        holder.ivClientLogo=(ImageView) view.findViewById(R.id.iv_client_logo);
//        holder.ivClientLogo.setImageResource(imageId[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
