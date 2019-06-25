 package com.cyclicsoft.chhagolnaiyaacademy;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.cyclicsoft.chhagolnaiyaacademy.fragment.MainFragment;
import com.cyclicsoft.chhagolnaiyaacademy.fragment.RegisterFragment;


 public class MainActivity extends AppCompatActivity {

     private Context mContext;
     private LayoutInflater inflater;
     private PopupWindow mPopupWindow;
     private View mLinearLayout;
     private ImageButton mImageButton;
     Fragment fragment;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView toolbarText = findViewById(R.id.toolbar_text);
        Toolbar toolbar = findViewById(R.id.toolbar);
        if(toolbarText!=null && toolbar!=null) {
            toolbarText.setText(getTitle());
            setSupportActionBar(toolbar);
        }

        mContext = getApplicationContext();
        // Initialize a new instance of LayoutInflater service
        inflater = (LayoutInflater) mContext
                .getSystemService(LAYOUT_INFLATER_SERVICE);
        mLinearLayout = findViewById(R.id.root_layout);
        mImageButton = findViewById(R.id.button_menu);
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMennuPopup();
            }
        });
         // Check that the activity is using the layout version with
         // the fragment_container FrameLayout
         if (findViewById(R.id.fragment_container) != null) {

             // However, if we're being restored from a previous state,
             // then we don't need to do anything and should return or else
             // we could end up with overlapping fragments.
             if (savedInstanceState != null) {
                 return;
             }

             // Create a new Fragment to be placed in the activity layout
              fragment = new MainFragment();

             // In case this activity was started with special instructions from an
             // Intent, pass the Intent's extras to the fragment as arguments
             fragment.setArguments(getIntent().getExtras());

             // Add the fragment to the 'fragment_container' FrameLayout
             getSupportFragmentManager().beginTransaction()
                     .add(R.id.fragment_container, fragment).commit();
         }



    }





     private void showMennuPopup() {


         // Inflate the custom layout/view
         View popupView = inflater.inflate(R.layout.popup_menu, null);

         /*
                    public PopupWindow (View contentView, int width, int height)
                        Create a new non focusable popup window which can display the contentView.
                        The dimension of the window must be passed to this constructor.

                        The popup does not provide any background. This should be handled by
                        the content view.

                    Parameters
                        contentView : the popup's content
                        width : the popup's width
                        height : the popup's height
                */
         // Initialize a new instance of popup window
         mPopupWindow = new PopupWindow(
                 popupView,
                 ViewGroup.LayoutParams.WRAP_CONTENT,
                 ViewGroup.LayoutParams.MATCH_PARENT
         );

         mPopupWindow.setAnimationStyle(R.style.popup_window_animation);
         mPopupWindow.setFocusable(true);
         mPopupWindow.update();

         // Set an elevation value for popup window

             mPopupWindow.setElevation(5.0f);

         // Get a reference for the custom view close button
         ImageView closeButton =  popupView.findViewById(R.id.button_backspace);

         // Set a click listener for the popup window close button
         closeButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 // Dismiss the popup window
                 mPopupWindow.dismiss();
             }
         });
         final LinearLayout registerButton = popupView.findViewById(R.id.layout_register);
         registerButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 goToFragment(registerButton);
                 mPopupWindow.dismiss();
             }
         });



        /*
                    public void showAtLocation (View parent, int gravity, int x, int y)
                        Display the content view in a popup window at the specified location. If the
                        popup window cannot fit on screen, it will be clipped.
                        Learn WindowManager.LayoutParams for more information on how gravity and the x
                        and y parameters are related. Specifying a gravity of NO_GRAVITY is similar
                        to specifying Gravity.LEFT | Gravity.TOP.

                    Parameters
                        parent : a parent view to get the getWindowToken() token from
                        gravity : the gravity which controls the placement of the popup window
                        x : the popup's x location offset
                        y : the popup's y location offset
                */
         // Finally, show the popup window at the center location of root relative layout
         mPopupWindow.showAtLocation(mLinearLayout, Gravity.LEFT, 0, 0);
     }

     private void goToFragment(View view) {
         switch (view.getId()){
             case R.id.layout_register:
                 fragment = new RegisterFragment();

                 FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                 // Replace whatever is in the fragment_container view with this fragment,
                 // and add the transaction to the back stack so the user can navigate back
                 transaction.replace(R.id.fragment_container, fragment);
                 transaction.addToBackStack(null);
                 // Commit the transaction
                 transaction.commit();

         }

     }
 }
