package soursoft.secuenciauno.co.soursoft;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.design.widget.TabLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.maps.MapFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ActivityMain extends Activity {

    FragmentManager fragmentManager;
    EditText etSearch;
    ImageButton ibtnSearch;


    public ArrayList<Client> listClients = new ArrayList<>();

//    MapFragment fragmentMap;

    FragmentCategoria fragmentCategoria = new FragmentCategoria();
    FragmentMapa fragmentMapa = new FragmentMapa();
    FragmentListCategoria fragmentListCategoria = new FragmentListCategoria();
    FragmentClient fragmentClient = new FragmentClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibtnSearch = (ImageButton)findViewById(R.id.ibtn_search);
        etSearch = (EditText)findViewById(R.id.et_search);
//        fragmentMap = MapFragment.newInstance();

        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        fragmentTransaction.add(R.id.rl_app_bar_main, fragmentCategoria);
        fragmentTransaction.add(R.id.rl_app_bar_main, fragmentMapa);
//        fragmentTransaction.add(R.id.rl_app_bar_main, fragmentMap);
        fragmentTransaction.add(R.id.rl_app_bar_main, fragmentListCategoria);
        fragmentTransaction.add(R.id.rl_app_bar_main, fragmentClient);

        fragmentTransaction.show(fragmentCategoria);
        fragmentTransaction.hide(fragmentMapa);
//        fragmentTransaction.hide(fragmentMap);
        fragmentTransaction.hide(fragmentListCategoria);
        fragmentTransaction.hide(fragmentClient);

        fragmentTransaction.commit();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.appbartabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setText("Categorias"));
        tabLayout.addTab(tabLayout.newTab().setText("Mapa"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0) {
                    goToFragment(fragmentMapa, fragmentCategoria);
                }else{
                    if(fragmentCategoria.isVisible())
                        goToFragment(fragmentCategoria, fragmentMapa);
                    else if(fragmentListCategoria.isVisible())
                        goToFragment(fragmentListCategoria, fragmentMapa);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void goToFragment(Fragment hide, Fragment show) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.show(show);
        fragmentTransaction.hide(hide);
        fragmentTransaction.commit();
    }

    public void changeCategory(String categoria){
        fragmentListCategoria.tvCategoria.setText(categoria);
//        fragmentListCategoria.listClients = listClients;
        goToFragment(fragmentCategoria, fragmentListCategoria);
    }

    public void changeClient(String client){
        fragmentClient.tvClientName.setText(client);
        goToFragment(fragmentListCategoria, fragmentClient);
    }


    @Override
    public void onBackPressed() {
        if (fragmentListCategoria.isVisible()) {
            goToFragment(fragmentListCategoria, fragmentCategoria);
            return;
        }else if (fragmentClient.isVisible()) {
            goToFragment(fragmentClient, fragmentCategoria);
            return;
        }
        finish();
    }


}
