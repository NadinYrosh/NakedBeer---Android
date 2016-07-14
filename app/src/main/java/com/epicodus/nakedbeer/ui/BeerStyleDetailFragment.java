package com.epicodus.nakedbeer.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.nakedbeer.R;
import com.epicodus.nakedbeer.models.BeerStyle;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BeerStyleDetailFragment extends Fragment {
    @Bind(R.id.styleNameTextView) TextView mStyleName;
    @Bind(R.id.sendTextView) TextView mSend;
    @Bind(R.id.saveButton) TextView mSaveButton;
    @Bind(R.id. descriptionTextView) TextView mDescription;

    private BeerStyle  mBeerStyle;

//    private OnFragmentInteractionListener mListener;

    public BeerStyleDetailFragment() {}

    public static BeerStyleDetailFragment newInstance(BeerStyle beerStyle) {
        BeerStyleDetailFragment styleFragment = new BeerStyleDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("beerStyle", Parcels.wrap(beerStyle));
        styleFragment.setArguments(args);
        return styleFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBeerStyle = Parcels.unwrap(getArguments().getParcelable("beerStyle"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.beer_style_fragment_detail_fragment, container, false);
        ButterKnife.bind(this, view);
        mStyleName.setText(mBeerStyle.getStyleName());
        mDescription.setText(mBeerStyle.getDescription());

        return view;
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
