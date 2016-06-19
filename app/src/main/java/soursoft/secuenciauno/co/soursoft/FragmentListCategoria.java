package soursoft.secuenciauno.co.soursoft;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListCategoria extends Fragment {

    TextView tvCategoria;
    private ListView lvClient;
    private Context context;
    private View view;


    //public static int [] prgmImages={R.drawable.images,R.drawable.images1,R.drawable.images2,R.drawable.images3,R.drawable.images4,R.drawable.images5,R.drawable.images6,R.drawable.images7,R.drawable.images8};
    public static String [] listClients={"Cliente01","Cliente02","Cliente03","Cliente04","Cliente05","Cliente06","Cliente07","Cliente08","Cliente09"};

    public FragmentListCategoria() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.fragment_list_categoria, container, false);

            context=getActivity();
            tvCategoria = (TextView)view.findViewById(R.id.tv_categoria);
            lvClient=(ListView) view.findViewById(R.id.lv_client);
        }
        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        fillListCategoria();
    }

    private void fillListCategoria(){
//        AdapterListCategoria adapter = new AdapterListCategoria(getActivity(), listClients/*,prgmImages*/);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getActivity(), R.layout.adapter_list_categoria, R.id.tv_client_name,listClients);
        lvClient.setAdapter(adapter1);
        adapter1.notifyDataSetChanged();
        lvClient.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String  itemValue    = (String) lvClient.getItemAtPosition(position);
                ((ActivityMain)getActivity()).changeClient(itemValue);

//                Toast.makeText(getActivity(), "Position :"+position+"  ListItem : " +itemValue , Toast.LENGTH_LONG).show();
            }
        });
    }

}
