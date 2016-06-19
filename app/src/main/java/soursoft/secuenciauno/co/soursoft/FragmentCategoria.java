package soursoft.secuenciauno.co.soursoft;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCategoria extends Fragment {

    Button btnCat1;
    Button btnCat2;
    Button btnCat3;
    Button btnCat4;
    Button btnCat5;
    Button btnCat6;
    View view;


    public FragmentCategoria() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view == null) {
            view = inflater.inflate(R.layout.fragment_categoria, container, false);
            btnCat1 = (Button) view.findViewById(R.id.btn_cat1);
            btnCat2 = (Button) view.findViewById(R.id.btn_cat2);
            btnCat3 = (Button) view.findViewById(R.id.btn_cat3);
            btnCat4 = (Button) view.findViewById(R.id.btn_cat4);
            btnCat5 = (Button) view.findViewById(R.id.btn_cat5);
            btnCat6 = (Button) view.findViewById(R.id.btn_cat6);
        }

        btnCat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ActivityMain)getActivity()).changeCategory("categoria01");
            }
        });

        btnCat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ActivityMain)getActivity()).changeCategory("categoria02");
            }
        });

        btnCat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ActivityMain)getActivity()).changeCategory("categoria03");
            }
        });

        btnCat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ActivityMain)getActivity()).changeCategory("categoria04");
            }
        });

        btnCat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ActivityMain)getActivity()).changeCategory("categoria05");
            }
        });

        btnCat6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ActivityMain)getActivity()).changeCategory("categoria06");
            }
        });
        return view;
    }


}
