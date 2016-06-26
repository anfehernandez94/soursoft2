package soursoft.secuenciauno.co.soursoft;

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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class FragmentListCategoria extends Fragment {

    TextView tvCategoria;
    private ListView lvClient;
    private View view;


    //public static int [] prgmImages={R.drawable.images,R.drawable.images1,R.drawable.images2,R.drawable.images3,R.drawable.images4,R.drawable.images5,R.drawable.images6,R.drawable.images7,R.drawable.images8};
    //public static String [] listClients;//={"Cliente01","Cliente02","Cliente03","Cliente04","Cliente05","Cliente06","Cliente07","Cliente08","Cliente09"};

    public ArrayList<Client> listClients = new ArrayList<>();

    public FragmentListCategoria() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.fragment_list_categoria, container, false);

            tvCategoria = (TextView)view.findViewById(R.id.tv_categoria);
            lvClient=(ListView) view.findViewById(R.id.lv_client);
        }
        getClients();
        return view;
    }

    private void fillListCategoria(){
        String[] nameClient = new String[listClients.size()];
        for(int i = 0; i < listClients.size(); i++)
            nameClient[i] = listClients.get(i).name;


        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getActivity(), R.layout.adapter_list_categoria, R.id.tv_client_name,nameClient);
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

    private void getClients() {

        // Read from the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("client");
        myRef.addValueEventListener(valueEventListener);
    }

    private void readClients(DataSnapshot dataSnapshot) {
        listClients.clear();
        for(DataSnapshot dss: dataSnapshot.getChildren()){
//            Client client = dss.getValue(Client.class);
            Client client = new Client();
            client.id = dss.child("id").getValue().toString();
            client.name = dss.child("name").getValue().toString();
            listClients.add(client);
        }
        fillListCategoria();
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot){
            readClients(dataSnapshot);
        }

        @Override
        public void onCancelled(DatabaseError error) {}
    };

}
