package com.youknowwho.firstjava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.youknowwho.firstjava.databinding.FragmentFirstBinding;

import java.util.Locale;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private int count = 0;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnRand.setOnClickListener(
                view1 -> NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment));
        binding.btnToast.setOnClickListener(
                view1 -> Toast.makeText(
                                getActivity(), R.string.toast_txt, Toast.LENGTH_LONG)
                        .show());
        binding.btnCount.setOnClickListener(
                view1 -> binding.textviewFirst.setText(
                        String.format(Locale.getDefault(), "%d", count++)));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
