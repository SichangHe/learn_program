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

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FirstFragment extends Fragment {
    private final Counter count = new Counter(0);
    Retrofit retrofit = new Retrofit
            .Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private FragmentFirstBinding binding;

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

        binding.btnRand.setOnClickListener(view1 -> NavHostFragment
                .findNavController(FirstFragment.this)
                .navigate(R.id.action_FirstFragment_to_SecondFragment));
        binding.btnToast.setOnClickListener(view1 -> Flowable
                .fromCallable(this::retrofitContributors)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(txt -> Toast.makeText(
                                        getActivity(), txt, Toast.LENGTH_LONG)
                                .show(),
                        System.out::println));
        binding.btnCount.setOnClickListener(view1 -> binding.textviewFirst
                .setText(
                        String.format(Locale.getDefault(), "%d", count.increment())));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /*
     * Send a GET request to GitHub for the contributors of retrofit.
     */
    private String retrofitContributors() {
        GitHubService service = retrofit.create(GitHubService.class);
        Call<List<Contributor>> call = service.listRepo("square", "retrofit");
        String txt;
        try {
            List<Contributor> contributors = call.execute().body();
            assert contributors != null;
            StringBuilder txt_build = new StringBuilder();
            for (Contributor contributor : contributors) {
                txt_build.append(contributor.login).append(" (").append(contributor.contributions).append(") ");
            }
            txt = txt_build.toString();
        } catch (IOException e) {
            txt = e.toString();
        }
        return txt;
    }
}
