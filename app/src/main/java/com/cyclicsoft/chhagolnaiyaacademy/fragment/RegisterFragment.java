package com.cyclicsoft.chhagolnaiyaacademy.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.cyclicsoft.chhagolnaiyaacademy.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegisterFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private TextView saveButton, cancelButton;

    private EditText mETName, mETFathersName, mETMothersName, mETEmail, mETPhone, mEtPAddress, mEtNID, mEtSSC, mEtUniversity, mEtProfess, mEtPrAdd;

    public RegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Fields initialization
        initUi(view);

        cancelButton.setOnClickListener(this);
        saveButton.setOnClickListener(this);
    }


    private void initUi(View view) {
        //Buttons
        saveButton = view.findViewById(R.id.tv_button_register_save);
        cancelButton = view.findViewById(R.id.tv_button_register_cancel);

        //Fields
        mETName = view.findViewById(R.id.profile_name_fragment_register);
        mETFathersName = view.findViewById(R.id.fathers_name_fragment_register);
        mETMothersName = view.findViewById(R.id.mothers_name_fragment_register);
        mETEmail = view.findViewById(R.id.user_email_fragment_register);
        mEtNID = view.findViewById(R.id.user_nid_fragment_register);
        mETPhone = view.findViewById(R.id.user_phone_fragment_register);
        mEtPAddress = view.findViewById(R.id.present_address_fragment_register);
        mEtSSC = view.findViewById(R.id.ssc_batch_fragment_register);
        mEtUniversity = view.findViewById(R.id.user_university_fragment_register);
        mEtPrAdd = view.findViewById(R.id.present_address_fragment_register);
        mEtProfess = view.findViewById(R.id.user_profession_fragment_register);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_button_register_save:
                saveDataToFirebase();
                break;
            case R.id.tv_button_register_cancel:
                getActivity().onBackPressed();
                break;


        }
    }

    private void saveDataToFirebase() {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
