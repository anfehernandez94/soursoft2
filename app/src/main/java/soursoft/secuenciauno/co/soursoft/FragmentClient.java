package soursoft.secuenciauno.co.soursoft;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class FragmentClient extends Fragment {

    final int PERMISSION_GRANTED_CALL_PHONE = 1;
    View view;
    ImageSwitcher imsClientPhoto;
    TextView tvClientName;
    Spinner spClientPhone;
    TextView tvClientAddress;
    ImageButton imbtnCallClient;
    int flagImage = 1;

    public FragmentClient() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.fragment_client, container, false);
            imsClientPhoto = (ImageSwitcher) view.findViewById(R.id.ims_client_photo);
            tvClientName = (TextView) view.findViewById(R.id.tv_client_name);
            spClientPhone = (Spinner) view.findViewById(R.id.sp_client_phone);
            tvClientAddress = (TextView) view.findViewById(R.id.tv_client_address);
            imbtnCallClient = (ImageButton) view.findViewById(R.id.imbtn_call_client);
        }

        imsClientPhoto.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getActivity());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                return myView;
            }
        });

        imsClientPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flagImage == 1) {
                    imsClientPhoto.setImageResource(R.drawable.ic_client_photo_01);
                    flagImage = 2;
                }
                else {
                    imsClientPhoto.setImageResource(R.drawable.ic_client_photo_02);
                    flagImage = 1;
                }
            }
        });

        String[] phoneNumbers = {"3002485495", "0345680199", "3147338897", "3147383565"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_singlechoice, phoneNumbers);
        spClientPhone.setAdapter(adapter);

        imbtnCallClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)) {
                        callPhone();
                    }else {
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, PERMISSION_GRANTED_CALL_PHONE);
                    }
                } catch (ActivityNotFoundException activityException) {
                    Toast.makeText(getActivity(), "No se pudo realizar la llamada", Toast.LENGTH_SHORT).show();
                }catch (Exception ex) {
                    Toast.makeText(getActivity(),ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        imsClientPhoto.setImageResource(R.drawable.ic_client_photo_02);
        flagImage = 1;
        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_GRANTED_CALL_PHONE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    private void callPhone(){
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+spClientPhone.getSelectedItem().toString()));
        startActivity(callIntent);
    }
}
